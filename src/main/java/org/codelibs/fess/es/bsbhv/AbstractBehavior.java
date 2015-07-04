package org.codelibs.fess.es.bsbhv;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codelibs.fess.es.bsentity.AbstractEntity;
import org.codelibs.fess.es.bsentity.AbstractEntity.DocMeta;
import org.codelibs.fess.es.bsentity.AbstractEntity.RequestOptionCall;
import org.codelibs.fess.es.cbean.bs.AbstractConditionBean;
import org.codelibs.fess.es.cbean.result.EsPagingResultBean;
import org.dbflute.Entity;
import org.dbflute.bhv.AbstractBehaviorWritable;
import org.dbflute.bhv.writable.DeleteOption;
import org.dbflute.bhv.writable.InsertOption;
import org.dbflute.bhv.writable.UpdateOption;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.exception.IllegalBehaviorStateException;
import org.elasticsearch.action.count.CountRequestBuilder;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHits;

public abstract class AbstractBehavior<ENTITY extends Entity, CB extends ConditionBean> extends AbstractBehaviorWritable<ENTITY, CB> {

    @Resource
    protected Client client;

    protected abstract String asIndexEsName();

    protected abstract <RESULT extends ENTITY> RESULT createEntity(Map<String, Object> source, Class<? extends RESULT> entityType);

    @Override
    protected int delegateSelectCountUniquely(ConditionBean cb) {
        // TODO check response and cast problem
        CountRequestBuilder builder = client.prepareCount(asIndexEsName()).setTypes(asTableDbName());
        return (int) ((AbstractConditionBean) cb).build(builder).execute().actionGet().getCount();
    }

    protected <RESULT extends ENTITY> List<RESULT> delegateSelectList(ConditionBean cb, Class<? extends RESULT> entityType) {
        // TODO check response
        SearchRequestBuilder builder = client.prepareSearch(asIndexEsName()).setTypes(asTableDbName());
        if (cb.isFetchScopeEffective()) {
            builder.setFrom(cb.getFetchStartIndex());
            builder.setSize(cb.getFetchSize());
        }
        ((AbstractConditionBean) cb).request().build(builder);
        SearchResponse response = ((AbstractConditionBean) cb).build(builder).execute().actionGet();

        EsPagingResultBean<RESULT> list = new EsPagingResultBean<>();
        SearchHits searchHits = response.getHits();
        searchHits.forEach(hit -> {
            Map<String, Object> source = hit.getSource();
            RESULT entity = createEntity(source, entityType);
            DocMeta docMeta = ((AbstractEntity) entity).asDocMeta();
            docMeta.id(hit.getId());
            docMeta.version(hit.getVersion());
            list.add(entity);
        });

        list.setAllRecordCount((int) searchHits.totalHits());
        list.setPageSize(cb.getFetchSize());
        list.setCurrentPageNumber(cb.getFetchPageNumber());

        list.setTook(response.getTookInMillis());
        list.setTotalShards(response.getTotalShards());
        list.setSuccessfulShards(response.getSuccessfulShards());
        list.setFailedShards(response.getFailedShards());
        // TODO others

        return list;
    }

    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + asTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    @Override
    protected <RESULT extends Entity> ListResultBean<RESULT> createListResultBean(ConditionBean cb, List<RESULT> selectedList) {
        if (selectedList instanceof EsPagingResultBean) {
            return (ListResultBean<RESULT>) selectedList;
        }
        throw new IllegalBehaviorStateException("selectedList is not EsPagingResultBean.");
    }

    @Override
    protected int delegateInsert(Entity entity, InsertOption<? extends ConditionBean> option) {
        AbstractEntity esEntity = (AbstractEntity) entity;
        IndexRequestBuilder builder = client.prepareIndex(asIndexEsName(), asTableDbName()).setSource(esEntity.toSource());
        RequestOptionCall<IndexRequestBuilder> indexOption = esEntity.asDocMeta().indexOption();
        if (indexOption != null) {
            indexOption.callback(builder);
        }
        IndexResponse response = builder.execute().actionGet();
        esEntity.asDocMeta().id(response.getId());
        return response.isCreated() ? 1 : 0;
    }

    @Override
    protected int delegateUpdate(Entity entity, UpdateOption<? extends ConditionBean> option) {
        AbstractEntity esEntity = (AbstractEntity) entity;
        IndexRequestBuilder builder =
                client.prepareIndex(asIndexEsName(), asTableDbName(), esEntity.asDocMeta().id()).setSource(esEntity.toSource());
        RequestOptionCall<IndexRequestBuilder> indexOption = esEntity.asDocMeta().indexOption();
        if (indexOption != null) {
            indexOption.callback(builder);
        }
        Long version = esEntity.asDocMeta().version();
        if (version != null && version.longValue() != -1) {
            builder.setVersion(version);
        }
        IndexResponse response = builder.execute().actionGet();
        return 1;
    }

    @Override
    protected int delegateDelete(Entity entity, DeleteOption<? extends ConditionBean> option) {
        AbstractEntity esEntity = (AbstractEntity) entity;
        DeleteRequestBuilder builder = client.prepareDelete(asIndexEsName(), asTableDbName(), esEntity.asDocMeta().id());
        RequestOptionCall<DeleteRequestBuilder> deleteOption = esEntity.asDocMeta().deleteOption();
        if (deleteOption != null) {
            deleteOption.callback(builder);
        }
        DeleteResponse response = builder.execute().actionGet();
        return response.isFound() ? 1 : 0;
    }

}
