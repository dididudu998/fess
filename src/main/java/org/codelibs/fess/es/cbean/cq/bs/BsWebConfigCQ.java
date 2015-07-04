package org.codelibs.fess.es.cbean.cq.bs;

import java.util.Collection;

import org.codelibs.fess.es.cbean.cq.WebConfigCQ;
import org.dbflute.cbean.ckey.ConditionKey;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;

/**
 * @author FreeGen
 */
public abstract class BsWebConfigCQ extends AbstractConditionQuery {

    @Override
    public String asTableDbName() {
        return "web_config";
    }

    @Override
    public String xgetAliasName() {
        return "web_config";
    }

    public void filtered(FilteredCall<WebConfigCQ> filteredLambda) {
        filtered(filteredLambda, null);
    }

    public void filtered(FilteredCall<WebConfigCQ> filteredLambda, ConditionOptionCall<FilteredQueryBuilder> opLambda) {
        WebConfigCQ query = new WebConfigCQ();
        filteredLambda.callback(query);
        if (!query.queryBuilderList.isEmpty()) {
            // TODO filter
            FilteredQueryBuilder builder = reqFilteredQ(query.getQuery(), null);
            if (opLambda != null) {
                opLambda.callback(builder);
            }
        }
    }

    public void bool(BoolCall<WebConfigCQ> boolLambda) {
        bool(boolLambda, null);
    }

    public void bool(BoolCall<WebConfigCQ> boolLambda, ConditionOptionCall<BoolQueryBuilder> opLambda) {
        WebConfigCQ mustQuery = new WebConfigCQ();
        WebConfigCQ shouldQuery = new WebConfigCQ();
        WebConfigCQ mustNotQuery = new WebConfigCQ();
        boolLambda.callback(mustQuery, shouldQuery, mustNotQuery);
        if (!mustQuery.queryBuilderList.isEmpty() || !shouldQuery.queryBuilderList.isEmpty() || !mustNotQuery.queryBuilderList.isEmpty()) {
            BoolQueryBuilder builder = reqBoolCQ(mustQuery.queryBuilderList, shouldQuery.queryBuilderList, mustNotQuery.queryBuilderList);
            if (opLambda != null) {
                opLambda.callback(builder);
            }
        }
    }

    public void setAvailable_Term(Boolean available) {
        setAvailable_Term(available, null);
    }

    public void setAvailable_Term(Boolean available, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("available", available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_Terms(Collection<Boolean> availableList) {
        setAvailable_MatchPhrasePrefix(availableList, null);
    }

    public void setAvailable_MatchPhrasePrefix(Collection<Boolean> availableList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("available", availableList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_InScope(Collection<Boolean> availableList) {
        setAvailable_MatchPhrasePrefix(availableList, null);
    }

    public void setAvailable_InScope(Collection<Boolean> availableList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setAvailable_MatchPhrasePrefix(availableList, opLambda);
    }

    public void setAvailable_Match(Boolean available) {
        setAvailable_Match(available, null);
    }

    public void setAvailable_Match(Boolean available, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("available", available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_MatchPhrase(Boolean available) {
        setAvailable_MatchPhrase(available, null);
    }

    public void setAvailable_MatchPhrase(Boolean available, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("available", available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_MatchPhrasePrefix(Boolean available) {
        setAvailable_MatchPhrasePrefix(available, null);
    }

    public void setAvailable_MatchPhrasePrefix(Boolean available, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("available", available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_Fuzzy(Boolean available) {
        setAvailable_Fuzzy(available, null);
    }

    public void setAvailable_Fuzzy(Boolean available, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("available", available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_GreaterThan(Boolean available) {
        setAvailable_GreaterThan(available, null);
    }

    public void setAvailable_GreaterThan(Boolean available, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("available", ConditionKey.CK_GREATER_THAN, available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_LessThan(Boolean available) {
        setAvailable_LessThan(available, null);
    }

    public void setAvailable_LessThan(Boolean available, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("available", ConditionKey.CK_LESS_THAN, available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_GreaterEqual(Boolean available) {
        setAvailable_GreaterEqual(available, null);
    }

    public void setAvailable_GreaterEqual(Boolean available, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("available", ConditionKey.CK_GREATER_EQUAL, available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setAvailable_LessEqual(Boolean available) {
        setAvailable_LessEqual(available, null);
    }

    public void setAvailable_LessEqual(Boolean available, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("available", ConditionKey.CK_LESS_EQUAL, available);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Available_Asc() {
        regOBA("available");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Available_Desc() {
        regOBD("available");
        return this;
    }

    public void setBoost_Term(Float boost) {
        setBoost_Term(boost, null);
    }

    public void setBoost_Term(Float boost, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("boost", boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_Terms(Collection<Float> boostList) {
        setBoost_MatchPhrasePrefix(boostList, null);
    }

    public void setBoost_MatchPhrasePrefix(Collection<Float> boostList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("boost", boostList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_InScope(Collection<Float> boostList) {
        setBoost_MatchPhrasePrefix(boostList, null);
    }

    public void setBoost_InScope(Collection<Float> boostList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setBoost_MatchPhrasePrefix(boostList, opLambda);
    }

    public void setBoost_Match(Float boost) {
        setBoost_Match(boost, null);
    }

    public void setBoost_Match(Float boost, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("boost", boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_MatchPhrase(Float boost) {
        setBoost_MatchPhrase(boost, null);
    }

    public void setBoost_MatchPhrase(Float boost, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("boost", boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_MatchPhrasePrefix(Float boost) {
        setBoost_MatchPhrasePrefix(boost, null);
    }

    public void setBoost_MatchPhrasePrefix(Float boost, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("boost", boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_Fuzzy(Float boost) {
        setBoost_Fuzzy(boost, null);
    }

    public void setBoost_Fuzzy(Float boost, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("boost", boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_GreaterThan(Float boost) {
        setBoost_GreaterThan(boost, null);
    }

    public void setBoost_GreaterThan(Float boost, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("boost", ConditionKey.CK_GREATER_THAN, boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_LessThan(Float boost) {
        setBoost_LessThan(boost, null);
    }

    public void setBoost_LessThan(Float boost, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("boost", ConditionKey.CK_LESS_THAN, boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_GreaterEqual(Float boost) {
        setBoost_GreaterEqual(boost, null);
    }

    public void setBoost_GreaterEqual(Float boost, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("boost", ConditionKey.CK_GREATER_EQUAL, boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setBoost_LessEqual(Float boost) {
        setBoost_LessEqual(boost, null);
    }

    public void setBoost_LessEqual(Float boost, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("boost", ConditionKey.CK_LESS_EQUAL, boost);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Boost_Asc() {
        regOBA("boost");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Boost_Desc() {
        regOBD("boost");
        return this;
    }

    public void setConfigParameter_Term(String configParameter) {
        setConfigParameter_Term(configParameter, null);
    }

    public void setConfigParameter_Term(String configParameter, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_Terms(Collection<String> configParameterList) {
        setConfigParameter_MatchPhrasePrefix(configParameterList, null);
    }

    public void setConfigParameter_MatchPhrasePrefix(Collection<String> configParameterList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("configParameter", configParameterList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_InScope(Collection<String> configParameterList) {
        setConfigParameter_MatchPhrasePrefix(configParameterList, null);
    }

    public void setConfigParameter_InScope(Collection<String> configParameterList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setConfigParameter_MatchPhrasePrefix(configParameterList, opLambda);
    }

    public void setConfigParameter_Match(String configParameter) {
        setConfigParameter_Match(configParameter, null);
    }

    public void setConfigParameter_Match(String configParameter, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_MatchPhrase(String configParameter) {
        setConfigParameter_MatchPhrase(configParameter, null);
    }

    public void setConfigParameter_MatchPhrase(String configParameter, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_MatchPhrasePrefix(String configParameter) {
        setConfigParameter_MatchPhrasePrefix(configParameter, null);
    }

    public void setConfigParameter_MatchPhrasePrefix(String configParameter, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_Fuzzy(String configParameter) {
        setConfigParameter_Fuzzy(configParameter, null);
    }

    public void setConfigParameter_Fuzzy(String configParameter, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_Prefix(String configParameter) {
        setConfigParameter_Prefix(configParameter, null);
    }

    public void setConfigParameter_Prefix(String configParameter, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("configParameter", configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_GreaterThan(String configParameter) {
        setConfigParameter_GreaterThan(configParameter, null);
    }

    public void setConfigParameter_GreaterThan(String configParameter, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("configParameter", ConditionKey.CK_GREATER_THAN, configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_LessThan(String configParameter) {
        setConfigParameter_LessThan(configParameter, null);
    }

    public void setConfigParameter_LessThan(String configParameter, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("configParameter", ConditionKey.CK_LESS_THAN, configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_GreaterEqual(String configParameter) {
        setConfigParameter_GreaterEqual(configParameter, null);
    }

    public void setConfigParameter_GreaterEqual(String configParameter, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("configParameter", ConditionKey.CK_GREATER_EQUAL, configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setConfigParameter_LessEqual(String configParameter) {
        setConfigParameter_LessEqual(configParameter, null);
    }

    public void setConfigParameter_LessEqual(String configParameter, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("configParameter", ConditionKey.CK_LESS_EQUAL, configParameter);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_ConfigParameter_Asc() {
        regOBA("configParameter");
        return this;
    }

    public BsWebConfigCQ addOrderBy_ConfigParameter_Desc() {
        regOBD("configParameter");
        return this;
    }

    public void setCreatedBy_Term(String createdBy) {
        setCreatedBy_Term(createdBy, null);
    }

    public void setCreatedBy_Term(String createdBy, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_Terms(Collection<String> createdByList) {
        setCreatedBy_MatchPhrasePrefix(createdByList, null);
    }

    public void setCreatedBy_MatchPhrasePrefix(Collection<String> createdByList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("createdBy", createdByList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_InScope(Collection<String> createdByList) {
        setCreatedBy_MatchPhrasePrefix(createdByList, null);
    }

    public void setCreatedBy_InScope(Collection<String> createdByList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setCreatedBy_MatchPhrasePrefix(createdByList, opLambda);
    }

    public void setCreatedBy_Match(String createdBy) {
        setCreatedBy_Match(createdBy, null);
    }

    public void setCreatedBy_Match(String createdBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_MatchPhrase(String createdBy) {
        setCreatedBy_MatchPhrase(createdBy, null);
    }

    public void setCreatedBy_MatchPhrase(String createdBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_MatchPhrasePrefix(String createdBy) {
        setCreatedBy_MatchPhrasePrefix(createdBy, null);
    }

    public void setCreatedBy_MatchPhrasePrefix(String createdBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_Fuzzy(String createdBy) {
        setCreatedBy_Fuzzy(createdBy, null);
    }

    public void setCreatedBy_Fuzzy(String createdBy, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_Prefix(String createdBy) {
        setCreatedBy_Prefix(createdBy, null);
    }

    public void setCreatedBy_Prefix(String createdBy, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("createdBy", createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_GreaterThan(String createdBy) {
        setCreatedBy_GreaterThan(createdBy, null);
    }

    public void setCreatedBy_GreaterThan(String createdBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdBy", ConditionKey.CK_GREATER_THAN, createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_LessThan(String createdBy) {
        setCreatedBy_LessThan(createdBy, null);
    }

    public void setCreatedBy_LessThan(String createdBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdBy", ConditionKey.CK_LESS_THAN, createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_GreaterEqual(String createdBy) {
        setCreatedBy_GreaterEqual(createdBy, null);
    }

    public void setCreatedBy_GreaterEqual(String createdBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdBy", ConditionKey.CK_GREATER_EQUAL, createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_LessEqual(String createdBy) {
        setCreatedBy_LessEqual(createdBy, null);
    }

    public void setCreatedBy_LessEqual(String createdBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdBy", ConditionKey.CK_LESS_EQUAL, createdBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_CreatedBy_Asc() {
        regOBA("createdBy");
        return this;
    }

    public BsWebConfigCQ addOrderBy_CreatedBy_Desc() {
        regOBD("createdBy");
        return this;
    }

    public void setCreatedTime_Term(Long createdTime) {
        setCreatedTime_Term(createdTime, null);
    }

    public void setCreatedTime_Term(Long createdTime, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("createdTime", createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Terms(Collection<Long> createdTimeList) {
        setCreatedTime_MatchPhrasePrefix(createdTimeList, null);
    }

    public void setCreatedTime_MatchPhrasePrefix(Collection<Long> createdTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("createdTime", createdTimeList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_InScope(Collection<Long> createdTimeList) {
        setCreatedTime_MatchPhrasePrefix(createdTimeList, null);
    }

    public void setCreatedTime_InScope(Collection<Long> createdTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setCreatedTime_MatchPhrasePrefix(createdTimeList, opLambda);
    }

    public void setCreatedTime_Match(Long createdTime) {
        setCreatedTime_Match(createdTime, null);
    }

    public void setCreatedTime_Match(Long createdTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("createdTime", createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_MatchPhrase(Long createdTime) {
        setCreatedTime_MatchPhrase(createdTime, null);
    }

    public void setCreatedTime_MatchPhrase(Long createdTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("createdTime", createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_MatchPhrasePrefix(Long createdTime) {
        setCreatedTime_MatchPhrasePrefix(createdTime, null);
    }

    public void setCreatedTime_MatchPhrasePrefix(Long createdTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("createdTime", createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Fuzzy(Long createdTime) {
        setCreatedTime_Fuzzy(createdTime, null);
    }

    public void setCreatedTime_Fuzzy(Long createdTime, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("createdTime", createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_GreaterThan(Long createdTime) {
        setCreatedTime_GreaterThan(createdTime, null);
    }

    public void setCreatedTime_GreaterThan(Long createdTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdTime", ConditionKey.CK_GREATER_THAN, createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_LessThan(Long createdTime) {
        setCreatedTime_LessThan(createdTime, null);
    }

    public void setCreatedTime_LessThan(Long createdTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdTime", ConditionKey.CK_LESS_THAN, createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_GreaterEqual(Long createdTime) {
        setCreatedTime_GreaterEqual(createdTime, null);
    }

    public void setCreatedTime_GreaterEqual(Long createdTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdTime", ConditionKey.CK_GREATER_EQUAL, createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_LessEqual(Long createdTime) {
        setCreatedTime_LessEqual(createdTime, null);
    }

    public void setCreatedTime_LessEqual(Long createdTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("createdTime", ConditionKey.CK_LESS_EQUAL, createdTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_CreatedTime_Asc() {
        regOBA("createdTime");
        return this;
    }

    public BsWebConfigCQ addOrderBy_CreatedTime_Desc() {
        regOBD("createdTime");
        return this;
    }

    public void setDepth_Term(Integer depth) {
        setDepth_Term(depth, null);
    }

    public void setDepth_Term(Integer depth, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("depth", depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_Terms(Collection<Integer> depthList) {
        setDepth_MatchPhrasePrefix(depthList, null);
    }

    public void setDepth_MatchPhrasePrefix(Collection<Integer> depthList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("depth", depthList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_InScope(Collection<Integer> depthList) {
        setDepth_MatchPhrasePrefix(depthList, null);
    }

    public void setDepth_InScope(Collection<Integer> depthList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setDepth_MatchPhrasePrefix(depthList, opLambda);
    }

    public void setDepth_Match(Integer depth) {
        setDepth_Match(depth, null);
    }

    public void setDepth_Match(Integer depth, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("depth", depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_MatchPhrase(Integer depth) {
        setDepth_MatchPhrase(depth, null);
    }

    public void setDepth_MatchPhrase(Integer depth, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("depth", depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_MatchPhrasePrefix(Integer depth) {
        setDepth_MatchPhrasePrefix(depth, null);
    }

    public void setDepth_MatchPhrasePrefix(Integer depth, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("depth", depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_Fuzzy(Integer depth) {
        setDepth_Fuzzy(depth, null);
    }

    public void setDepth_Fuzzy(Integer depth, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("depth", depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_GreaterThan(Integer depth) {
        setDepth_GreaterThan(depth, null);
    }

    public void setDepth_GreaterThan(Integer depth, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("depth", ConditionKey.CK_GREATER_THAN, depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_LessThan(Integer depth) {
        setDepth_LessThan(depth, null);
    }

    public void setDepth_LessThan(Integer depth, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("depth", ConditionKey.CK_LESS_THAN, depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_GreaterEqual(Integer depth) {
        setDepth_GreaterEqual(depth, null);
    }

    public void setDepth_GreaterEqual(Integer depth, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("depth", ConditionKey.CK_GREATER_EQUAL, depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDepth_LessEqual(Integer depth) {
        setDepth_LessEqual(depth, null);
    }

    public void setDepth_LessEqual(Integer depth, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("depth", ConditionKey.CK_LESS_EQUAL, depth);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Depth_Asc() {
        regOBA("depth");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Depth_Desc() {
        regOBD("depth");
        return this;
    }

    public void setExcludedDocUrls_Term(String excludedDocUrls) {
        setExcludedDocUrls_Term(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_Term(String excludedDocUrls, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_Terms(Collection<String> excludedDocUrlsList) {
        setExcludedDocUrls_MatchPhrasePrefix(excludedDocUrlsList, null);
    }

    public void setExcludedDocUrls_MatchPhrasePrefix(Collection<String> excludedDocUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("excludedDocUrls", excludedDocUrlsList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_InScope(Collection<String> excludedDocUrlsList) {
        setExcludedDocUrls_MatchPhrasePrefix(excludedDocUrlsList, null);
    }

    public void setExcludedDocUrls_InScope(Collection<String> excludedDocUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setExcludedDocUrls_MatchPhrasePrefix(excludedDocUrlsList, opLambda);
    }

    public void setExcludedDocUrls_Match(String excludedDocUrls) {
        setExcludedDocUrls_Match(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_Match(String excludedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_MatchPhrase(String excludedDocUrls) {
        setExcludedDocUrls_MatchPhrase(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_MatchPhrase(String excludedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_MatchPhrasePrefix(String excludedDocUrls) {
        setExcludedDocUrls_MatchPhrasePrefix(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_MatchPhrasePrefix(String excludedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_Fuzzy(String excludedDocUrls) {
        setExcludedDocUrls_Fuzzy(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_Fuzzy(String excludedDocUrls, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_Prefix(String excludedDocUrls) {
        setExcludedDocUrls_Prefix(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_Prefix(String excludedDocUrls, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("excludedDocUrls", excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_GreaterThan(String excludedDocUrls) {
        setExcludedDocUrls_GreaterThan(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_GreaterThan(String excludedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedDocUrls", ConditionKey.CK_GREATER_THAN, excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_LessThan(String excludedDocUrls) {
        setExcludedDocUrls_LessThan(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_LessThan(String excludedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedDocUrls", ConditionKey.CK_LESS_THAN, excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_GreaterEqual(String excludedDocUrls) {
        setExcludedDocUrls_GreaterEqual(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_GreaterEqual(String excludedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedDocUrls", ConditionKey.CK_GREATER_EQUAL, excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedDocUrls_LessEqual(String excludedDocUrls) {
        setExcludedDocUrls_LessEqual(excludedDocUrls, null);
    }

    public void setExcludedDocUrls_LessEqual(String excludedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedDocUrls", ConditionKey.CK_LESS_EQUAL, excludedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_ExcludedDocUrls_Asc() {
        regOBA("excludedDocUrls");
        return this;
    }

    public BsWebConfigCQ addOrderBy_ExcludedDocUrls_Desc() {
        regOBD("excludedDocUrls");
        return this;
    }

    public void setExcludedUrls_Term(String excludedUrls) {
        setExcludedUrls_Term(excludedUrls, null);
    }

    public void setExcludedUrls_Term(String excludedUrls, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_Terms(Collection<String> excludedUrlsList) {
        setExcludedUrls_MatchPhrasePrefix(excludedUrlsList, null);
    }

    public void setExcludedUrls_MatchPhrasePrefix(Collection<String> excludedUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("excludedUrls", excludedUrlsList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_InScope(Collection<String> excludedUrlsList) {
        setExcludedUrls_MatchPhrasePrefix(excludedUrlsList, null);
    }

    public void setExcludedUrls_InScope(Collection<String> excludedUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setExcludedUrls_MatchPhrasePrefix(excludedUrlsList, opLambda);
    }

    public void setExcludedUrls_Match(String excludedUrls) {
        setExcludedUrls_Match(excludedUrls, null);
    }

    public void setExcludedUrls_Match(String excludedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_MatchPhrase(String excludedUrls) {
        setExcludedUrls_MatchPhrase(excludedUrls, null);
    }

    public void setExcludedUrls_MatchPhrase(String excludedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_MatchPhrasePrefix(String excludedUrls) {
        setExcludedUrls_MatchPhrasePrefix(excludedUrls, null);
    }

    public void setExcludedUrls_MatchPhrasePrefix(String excludedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_Fuzzy(String excludedUrls) {
        setExcludedUrls_Fuzzy(excludedUrls, null);
    }

    public void setExcludedUrls_Fuzzy(String excludedUrls, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_Prefix(String excludedUrls) {
        setExcludedUrls_Prefix(excludedUrls, null);
    }

    public void setExcludedUrls_Prefix(String excludedUrls, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("excludedUrls", excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_GreaterThan(String excludedUrls) {
        setExcludedUrls_GreaterThan(excludedUrls, null);
    }

    public void setExcludedUrls_GreaterThan(String excludedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedUrls", ConditionKey.CK_GREATER_THAN, excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_LessThan(String excludedUrls) {
        setExcludedUrls_LessThan(excludedUrls, null);
    }

    public void setExcludedUrls_LessThan(String excludedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedUrls", ConditionKey.CK_LESS_THAN, excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_GreaterEqual(String excludedUrls) {
        setExcludedUrls_GreaterEqual(excludedUrls, null);
    }

    public void setExcludedUrls_GreaterEqual(String excludedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedUrls", ConditionKey.CK_GREATER_EQUAL, excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setExcludedUrls_LessEqual(String excludedUrls) {
        setExcludedUrls_LessEqual(excludedUrls, null);
    }

    public void setExcludedUrls_LessEqual(String excludedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("excludedUrls", ConditionKey.CK_LESS_EQUAL, excludedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_ExcludedUrls_Asc() {
        regOBA("excludedUrls");
        return this;
    }

    public BsWebConfigCQ addOrderBy_ExcludedUrls_Desc() {
        regOBD("excludedUrls");
        return this;
    }

    public void setId_Term(String id) {
        setId_Term(id, null);
    }

    public void setId_Term(String id, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_Terms(Collection<String> idList) {
        setId_MatchPhrasePrefix(idList, null);
    }

    public void setId_MatchPhrasePrefix(Collection<String> idList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("id", idList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_InScope(Collection<String> idList) {
        setId_MatchPhrasePrefix(idList, null);
    }

    public void setId_InScope(Collection<String> idList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setId_MatchPhrasePrefix(idList, opLambda);
    }

    public void setId_Match(String id) {
        setId_Match(id, null);
    }

    public void setId_Match(String id, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_MatchPhrase(String id) {
        setId_MatchPhrase(id, null);
    }

    public void setId_MatchPhrase(String id, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_MatchPhrasePrefix(String id) {
        setId_MatchPhrasePrefix(id, null);
    }

    public void setId_MatchPhrasePrefix(String id, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_Fuzzy(String id) {
        setId_Fuzzy(id, null);
    }

    public void setId_Fuzzy(String id, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_Prefix(String id) {
        setId_Prefix(id, null);
    }

    public void setId_Prefix(String id, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("id", id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_GreaterThan(String id) {
        setId_GreaterThan(id, null);
    }

    public void setId_GreaterThan(String id, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("id", ConditionKey.CK_GREATER_THAN, id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_LessThan(String id) {
        setId_LessThan(id, null);
    }

    public void setId_LessThan(String id, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("id", ConditionKey.CK_LESS_THAN, id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_GreaterEqual(String id) {
        setId_GreaterEqual(id, null);
    }

    public void setId_GreaterEqual(String id, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("id", ConditionKey.CK_GREATER_EQUAL, id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setId_LessEqual(String id) {
        setId_LessEqual(id, null);
    }

    public void setId_LessEqual(String id, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("id", ConditionKey.CK_LESS_EQUAL, id);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Id_Asc() {
        regOBA("id");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Id_Desc() {
        regOBD("id");
        return this;
    }

    public void setIncludedDocUrls_Term(String includedDocUrls) {
        setIncludedDocUrls_Term(includedDocUrls, null);
    }

    public void setIncludedDocUrls_Term(String includedDocUrls, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_Terms(Collection<String> includedDocUrlsList) {
        setIncludedDocUrls_MatchPhrasePrefix(includedDocUrlsList, null);
    }

    public void setIncludedDocUrls_MatchPhrasePrefix(Collection<String> includedDocUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("includedDocUrls", includedDocUrlsList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_InScope(Collection<String> includedDocUrlsList) {
        setIncludedDocUrls_MatchPhrasePrefix(includedDocUrlsList, null);
    }

    public void setIncludedDocUrls_InScope(Collection<String> includedDocUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setIncludedDocUrls_MatchPhrasePrefix(includedDocUrlsList, opLambda);
    }

    public void setIncludedDocUrls_Match(String includedDocUrls) {
        setIncludedDocUrls_Match(includedDocUrls, null);
    }

    public void setIncludedDocUrls_Match(String includedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_MatchPhrase(String includedDocUrls) {
        setIncludedDocUrls_MatchPhrase(includedDocUrls, null);
    }

    public void setIncludedDocUrls_MatchPhrase(String includedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_MatchPhrasePrefix(String includedDocUrls) {
        setIncludedDocUrls_MatchPhrasePrefix(includedDocUrls, null);
    }

    public void setIncludedDocUrls_MatchPhrasePrefix(String includedDocUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_Fuzzy(String includedDocUrls) {
        setIncludedDocUrls_Fuzzy(includedDocUrls, null);
    }

    public void setIncludedDocUrls_Fuzzy(String includedDocUrls, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_Prefix(String includedDocUrls) {
        setIncludedDocUrls_Prefix(includedDocUrls, null);
    }

    public void setIncludedDocUrls_Prefix(String includedDocUrls, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("includedDocUrls", includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_GreaterThan(String includedDocUrls) {
        setIncludedDocUrls_GreaterThan(includedDocUrls, null);
    }

    public void setIncludedDocUrls_GreaterThan(String includedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedDocUrls", ConditionKey.CK_GREATER_THAN, includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_LessThan(String includedDocUrls) {
        setIncludedDocUrls_LessThan(includedDocUrls, null);
    }

    public void setIncludedDocUrls_LessThan(String includedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedDocUrls", ConditionKey.CK_LESS_THAN, includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_GreaterEqual(String includedDocUrls) {
        setIncludedDocUrls_GreaterEqual(includedDocUrls, null);
    }

    public void setIncludedDocUrls_GreaterEqual(String includedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedDocUrls", ConditionKey.CK_GREATER_EQUAL, includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedDocUrls_LessEqual(String includedDocUrls) {
        setIncludedDocUrls_LessEqual(includedDocUrls, null);
    }

    public void setIncludedDocUrls_LessEqual(String includedDocUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedDocUrls", ConditionKey.CK_LESS_EQUAL, includedDocUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_IncludedDocUrls_Asc() {
        regOBA("includedDocUrls");
        return this;
    }

    public BsWebConfigCQ addOrderBy_IncludedDocUrls_Desc() {
        regOBD("includedDocUrls");
        return this;
    }

    public void setIncludedUrls_Term(String includedUrls) {
        setIncludedUrls_Term(includedUrls, null);
    }

    public void setIncludedUrls_Term(String includedUrls, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_Terms(Collection<String> includedUrlsList) {
        setIncludedUrls_MatchPhrasePrefix(includedUrlsList, null);
    }

    public void setIncludedUrls_MatchPhrasePrefix(Collection<String> includedUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("includedUrls", includedUrlsList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_InScope(Collection<String> includedUrlsList) {
        setIncludedUrls_MatchPhrasePrefix(includedUrlsList, null);
    }

    public void setIncludedUrls_InScope(Collection<String> includedUrlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setIncludedUrls_MatchPhrasePrefix(includedUrlsList, opLambda);
    }

    public void setIncludedUrls_Match(String includedUrls) {
        setIncludedUrls_Match(includedUrls, null);
    }

    public void setIncludedUrls_Match(String includedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_MatchPhrase(String includedUrls) {
        setIncludedUrls_MatchPhrase(includedUrls, null);
    }

    public void setIncludedUrls_MatchPhrase(String includedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_MatchPhrasePrefix(String includedUrls) {
        setIncludedUrls_MatchPhrasePrefix(includedUrls, null);
    }

    public void setIncludedUrls_MatchPhrasePrefix(String includedUrls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_Fuzzy(String includedUrls) {
        setIncludedUrls_Fuzzy(includedUrls, null);
    }

    public void setIncludedUrls_Fuzzy(String includedUrls, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_Prefix(String includedUrls) {
        setIncludedUrls_Prefix(includedUrls, null);
    }

    public void setIncludedUrls_Prefix(String includedUrls, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("includedUrls", includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_GreaterThan(String includedUrls) {
        setIncludedUrls_GreaterThan(includedUrls, null);
    }

    public void setIncludedUrls_GreaterThan(String includedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedUrls", ConditionKey.CK_GREATER_THAN, includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_LessThan(String includedUrls) {
        setIncludedUrls_LessThan(includedUrls, null);
    }

    public void setIncludedUrls_LessThan(String includedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedUrls", ConditionKey.CK_LESS_THAN, includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_GreaterEqual(String includedUrls) {
        setIncludedUrls_GreaterEqual(includedUrls, null);
    }

    public void setIncludedUrls_GreaterEqual(String includedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedUrls", ConditionKey.CK_GREATER_EQUAL, includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIncludedUrls_LessEqual(String includedUrls) {
        setIncludedUrls_LessEqual(includedUrls, null);
    }

    public void setIncludedUrls_LessEqual(String includedUrls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("includedUrls", ConditionKey.CK_LESS_EQUAL, includedUrls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_IncludedUrls_Asc() {
        regOBA("includedUrls");
        return this;
    }

    public BsWebConfigCQ addOrderBy_IncludedUrls_Desc() {
        regOBD("includedUrls");
        return this;
    }

    public void setIntervalTime_Term(Integer intervalTime) {
        setIntervalTime_Term(intervalTime, null);
    }

    public void setIntervalTime_Term(Integer intervalTime, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("intervalTime", intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_Terms(Collection<Integer> intervalTimeList) {
        setIntervalTime_MatchPhrasePrefix(intervalTimeList, null);
    }

    public void setIntervalTime_MatchPhrasePrefix(Collection<Integer> intervalTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("intervalTime", intervalTimeList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_InScope(Collection<Integer> intervalTimeList) {
        setIntervalTime_MatchPhrasePrefix(intervalTimeList, null);
    }

    public void setIntervalTime_InScope(Collection<Integer> intervalTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setIntervalTime_MatchPhrasePrefix(intervalTimeList, opLambda);
    }

    public void setIntervalTime_Match(Integer intervalTime) {
        setIntervalTime_Match(intervalTime, null);
    }

    public void setIntervalTime_Match(Integer intervalTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("intervalTime", intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_MatchPhrase(Integer intervalTime) {
        setIntervalTime_MatchPhrase(intervalTime, null);
    }

    public void setIntervalTime_MatchPhrase(Integer intervalTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("intervalTime", intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_MatchPhrasePrefix(Integer intervalTime) {
        setIntervalTime_MatchPhrasePrefix(intervalTime, null);
    }

    public void setIntervalTime_MatchPhrasePrefix(Integer intervalTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("intervalTime", intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_Fuzzy(Integer intervalTime) {
        setIntervalTime_Fuzzy(intervalTime, null);
    }

    public void setIntervalTime_Fuzzy(Integer intervalTime, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("intervalTime", intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_GreaterThan(Integer intervalTime) {
        setIntervalTime_GreaterThan(intervalTime, null);
    }

    public void setIntervalTime_GreaterThan(Integer intervalTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("intervalTime", ConditionKey.CK_GREATER_THAN, intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_LessThan(Integer intervalTime) {
        setIntervalTime_LessThan(intervalTime, null);
    }

    public void setIntervalTime_LessThan(Integer intervalTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("intervalTime", ConditionKey.CK_LESS_THAN, intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_GreaterEqual(Integer intervalTime) {
        setIntervalTime_GreaterEqual(intervalTime, null);
    }

    public void setIntervalTime_GreaterEqual(Integer intervalTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("intervalTime", ConditionKey.CK_GREATER_EQUAL, intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setIntervalTime_LessEqual(Integer intervalTime) {
        setIntervalTime_LessEqual(intervalTime, null);
    }

    public void setIntervalTime_LessEqual(Integer intervalTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("intervalTime", ConditionKey.CK_LESS_EQUAL, intervalTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_IntervalTime_Asc() {
        regOBA("intervalTime");
        return this;
    }

    public BsWebConfigCQ addOrderBy_IntervalTime_Desc() {
        regOBD("intervalTime");
        return this;
    }

    public void setMaxAccessCount_Term(Long maxAccessCount) {
        setMaxAccessCount_Term(maxAccessCount, null);
    }

    public void setMaxAccessCount_Term(Long maxAccessCount, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("maxAccessCount", maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_Terms(Collection<Long> maxAccessCountList) {
        setMaxAccessCount_MatchPhrasePrefix(maxAccessCountList, null);
    }

    public void setMaxAccessCount_MatchPhrasePrefix(Collection<Long> maxAccessCountList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("maxAccessCount", maxAccessCountList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_InScope(Collection<Long> maxAccessCountList) {
        setMaxAccessCount_MatchPhrasePrefix(maxAccessCountList, null);
    }

    public void setMaxAccessCount_InScope(Collection<Long> maxAccessCountList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setMaxAccessCount_MatchPhrasePrefix(maxAccessCountList, opLambda);
    }

    public void setMaxAccessCount_Match(Long maxAccessCount) {
        setMaxAccessCount_Match(maxAccessCount, null);
    }

    public void setMaxAccessCount_Match(Long maxAccessCount, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("maxAccessCount", maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_MatchPhrase(Long maxAccessCount) {
        setMaxAccessCount_MatchPhrase(maxAccessCount, null);
    }

    public void setMaxAccessCount_MatchPhrase(Long maxAccessCount, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("maxAccessCount", maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_MatchPhrasePrefix(Long maxAccessCount) {
        setMaxAccessCount_MatchPhrasePrefix(maxAccessCount, null);
    }

    public void setMaxAccessCount_MatchPhrasePrefix(Long maxAccessCount, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("maxAccessCount", maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_Fuzzy(Long maxAccessCount) {
        setMaxAccessCount_Fuzzy(maxAccessCount, null);
    }

    public void setMaxAccessCount_Fuzzy(Long maxAccessCount, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("maxAccessCount", maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_GreaterThan(Long maxAccessCount) {
        setMaxAccessCount_GreaterThan(maxAccessCount, null);
    }

    public void setMaxAccessCount_GreaterThan(Long maxAccessCount, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("maxAccessCount", ConditionKey.CK_GREATER_THAN, maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_LessThan(Long maxAccessCount) {
        setMaxAccessCount_LessThan(maxAccessCount, null);
    }

    public void setMaxAccessCount_LessThan(Long maxAccessCount, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("maxAccessCount", ConditionKey.CK_LESS_THAN, maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_GreaterEqual(Long maxAccessCount) {
        setMaxAccessCount_GreaterEqual(maxAccessCount, null);
    }

    public void setMaxAccessCount_GreaterEqual(Long maxAccessCount, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("maxAccessCount", ConditionKey.CK_GREATER_EQUAL, maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setMaxAccessCount_LessEqual(Long maxAccessCount) {
        setMaxAccessCount_LessEqual(maxAccessCount, null);
    }

    public void setMaxAccessCount_LessEqual(Long maxAccessCount, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("maxAccessCount", ConditionKey.CK_LESS_EQUAL, maxAccessCount);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_MaxAccessCount_Asc() {
        regOBA("maxAccessCount");
        return this;
    }

    public BsWebConfigCQ addOrderBy_MaxAccessCount_Desc() {
        regOBD("maxAccessCount");
        return this;
    }

    public void setName_Term(String name) {
        setName_Term(name, null);
    }

    public void setName_Term(String name, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_Terms(Collection<String> nameList) {
        setName_MatchPhrasePrefix(nameList, null);
    }

    public void setName_MatchPhrasePrefix(Collection<String> nameList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("name", nameList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_InScope(Collection<String> nameList) {
        setName_MatchPhrasePrefix(nameList, null);
    }

    public void setName_InScope(Collection<String> nameList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setName_MatchPhrasePrefix(nameList, opLambda);
    }

    public void setName_Match(String name) {
        setName_Match(name, null);
    }

    public void setName_Match(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_MatchPhrase(String name) {
        setName_MatchPhrase(name, null);
    }

    public void setName_MatchPhrase(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_MatchPhrasePrefix(String name) {
        setName_MatchPhrasePrefix(name, null);
    }

    public void setName_MatchPhrasePrefix(String name, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_Fuzzy(String name) {
        setName_Fuzzy(name, null);
    }

    public void setName_Fuzzy(String name, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_Prefix(String name) {
        setName_Prefix(name, null);
    }

    public void setName_Prefix(String name, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("name", name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_GreaterThan(String name) {
        setName_GreaterThan(name, null);
    }

    public void setName_GreaterThan(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("name", ConditionKey.CK_GREATER_THAN, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_LessThan(String name) {
        setName_LessThan(name, null);
    }

    public void setName_LessThan(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("name", ConditionKey.CK_LESS_THAN, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_GreaterEqual(String name) {
        setName_GreaterEqual(name, null);
    }

    public void setName_GreaterEqual(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("name", ConditionKey.CK_GREATER_EQUAL, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setName_LessEqual(String name) {
        setName_LessEqual(name, null);
    }

    public void setName_LessEqual(String name, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("name", ConditionKey.CK_LESS_EQUAL, name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Name_Asc() {
        regOBA("name");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Name_Desc() {
        regOBD("name");
        return this;
    }

    public void setNumOfThread_Term(Integer numOfThread) {
        setNumOfThread_Term(numOfThread, null);
    }

    public void setNumOfThread_Term(Integer numOfThread, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("numOfThread", numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_Terms(Collection<Integer> numOfThreadList) {
        setNumOfThread_MatchPhrasePrefix(numOfThreadList, null);
    }

    public void setNumOfThread_MatchPhrasePrefix(Collection<Integer> numOfThreadList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("numOfThread", numOfThreadList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_InScope(Collection<Integer> numOfThreadList) {
        setNumOfThread_MatchPhrasePrefix(numOfThreadList, null);
    }

    public void setNumOfThread_InScope(Collection<Integer> numOfThreadList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setNumOfThread_MatchPhrasePrefix(numOfThreadList, opLambda);
    }

    public void setNumOfThread_Match(Integer numOfThread) {
        setNumOfThread_Match(numOfThread, null);
    }

    public void setNumOfThread_Match(Integer numOfThread, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("numOfThread", numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_MatchPhrase(Integer numOfThread) {
        setNumOfThread_MatchPhrase(numOfThread, null);
    }

    public void setNumOfThread_MatchPhrase(Integer numOfThread, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("numOfThread", numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_MatchPhrasePrefix(Integer numOfThread) {
        setNumOfThread_MatchPhrasePrefix(numOfThread, null);
    }

    public void setNumOfThread_MatchPhrasePrefix(Integer numOfThread, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("numOfThread", numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_Fuzzy(Integer numOfThread) {
        setNumOfThread_Fuzzy(numOfThread, null);
    }

    public void setNumOfThread_Fuzzy(Integer numOfThread, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("numOfThread", numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_GreaterThan(Integer numOfThread) {
        setNumOfThread_GreaterThan(numOfThread, null);
    }

    public void setNumOfThread_GreaterThan(Integer numOfThread, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("numOfThread", ConditionKey.CK_GREATER_THAN, numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_LessThan(Integer numOfThread) {
        setNumOfThread_LessThan(numOfThread, null);
    }

    public void setNumOfThread_LessThan(Integer numOfThread, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("numOfThread", ConditionKey.CK_LESS_THAN, numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_GreaterEqual(Integer numOfThread) {
        setNumOfThread_GreaterEqual(numOfThread, null);
    }

    public void setNumOfThread_GreaterEqual(Integer numOfThread, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("numOfThread", ConditionKey.CK_GREATER_EQUAL, numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setNumOfThread_LessEqual(Integer numOfThread) {
        setNumOfThread_LessEqual(numOfThread, null);
    }

    public void setNumOfThread_LessEqual(Integer numOfThread, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("numOfThread", ConditionKey.CK_LESS_EQUAL, numOfThread);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_NumOfThread_Asc() {
        regOBA("numOfThread");
        return this;
    }

    public BsWebConfigCQ addOrderBy_NumOfThread_Desc() {
        regOBD("numOfThread");
        return this;
    }

    public void setSortOrder_Term(Integer sortOrder) {
        setSortOrder_Term(sortOrder, null);
    }

    public void setSortOrder_Term(Integer sortOrder, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("sortOrder", sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Terms(Collection<Integer> sortOrderList) {
        setSortOrder_MatchPhrasePrefix(sortOrderList, null);
    }

    public void setSortOrder_MatchPhrasePrefix(Collection<Integer> sortOrderList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("sortOrder", sortOrderList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_InScope(Collection<Integer> sortOrderList) {
        setSortOrder_MatchPhrasePrefix(sortOrderList, null);
    }

    public void setSortOrder_InScope(Collection<Integer> sortOrderList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setSortOrder_MatchPhrasePrefix(sortOrderList, opLambda);
    }

    public void setSortOrder_Match(Integer sortOrder) {
        setSortOrder_Match(sortOrder, null);
    }

    public void setSortOrder_Match(Integer sortOrder, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("sortOrder", sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_MatchPhrase(Integer sortOrder) {
        setSortOrder_MatchPhrase(sortOrder, null);
    }

    public void setSortOrder_MatchPhrase(Integer sortOrder, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("sortOrder", sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_MatchPhrasePrefix(Integer sortOrder) {
        setSortOrder_MatchPhrasePrefix(sortOrder, null);
    }

    public void setSortOrder_MatchPhrasePrefix(Integer sortOrder, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("sortOrder", sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Fuzzy(Integer sortOrder) {
        setSortOrder_Fuzzy(sortOrder, null);
    }

    public void setSortOrder_Fuzzy(Integer sortOrder, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("sortOrder", sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_GreaterThan(Integer sortOrder) {
        setSortOrder_GreaterThan(sortOrder, null);
    }

    public void setSortOrder_GreaterThan(Integer sortOrder, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("sortOrder", ConditionKey.CK_GREATER_THAN, sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_LessThan(Integer sortOrder) {
        setSortOrder_LessThan(sortOrder, null);
    }

    public void setSortOrder_LessThan(Integer sortOrder, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("sortOrder", ConditionKey.CK_LESS_THAN, sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_GreaterEqual(Integer sortOrder) {
        setSortOrder_GreaterEqual(sortOrder, null);
    }

    public void setSortOrder_GreaterEqual(Integer sortOrder, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("sortOrder", ConditionKey.CK_GREATER_EQUAL, sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_LessEqual(Integer sortOrder) {
        setSortOrder_LessEqual(sortOrder, null);
    }

    public void setSortOrder_LessEqual(Integer sortOrder, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("sortOrder", ConditionKey.CK_LESS_EQUAL, sortOrder);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_SortOrder_Asc() {
        regOBA("sortOrder");
        return this;
    }

    public BsWebConfigCQ addOrderBy_SortOrder_Desc() {
        regOBD("sortOrder");
        return this;
    }

    public void setUpdatedBy_Term(String updatedBy) {
        setUpdatedBy_Term(updatedBy, null);
    }

    public void setUpdatedBy_Term(String updatedBy, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_Terms(Collection<String> updatedByList) {
        setUpdatedBy_MatchPhrasePrefix(updatedByList, null);
    }

    public void setUpdatedBy_MatchPhrasePrefix(Collection<String> updatedByList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("updatedBy", updatedByList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_InScope(Collection<String> updatedByList) {
        setUpdatedBy_MatchPhrasePrefix(updatedByList, null);
    }

    public void setUpdatedBy_InScope(Collection<String> updatedByList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setUpdatedBy_MatchPhrasePrefix(updatedByList, opLambda);
    }

    public void setUpdatedBy_Match(String updatedBy) {
        setUpdatedBy_Match(updatedBy, null);
    }

    public void setUpdatedBy_Match(String updatedBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_MatchPhrase(String updatedBy) {
        setUpdatedBy_MatchPhrase(updatedBy, null);
    }

    public void setUpdatedBy_MatchPhrase(String updatedBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_MatchPhrasePrefix(String updatedBy) {
        setUpdatedBy_MatchPhrasePrefix(updatedBy, null);
    }

    public void setUpdatedBy_MatchPhrasePrefix(String updatedBy, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_Fuzzy(String updatedBy) {
        setUpdatedBy_Fuzzy(updatedBy, null);
    }

    public void setUpdatedBy_Fuzzy(String updatedBy, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_Prefix(String updatedBy) {
        setUpdatedBy_Prefix(updatedBy, null);
    }

    public void setUpdatedBy_Prefix(String updatedBy, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("updatedBy", updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_GreaterThan(String updatedBy) {
        setUpdatedBy_GreaterThan(updatedBy, null);
    }

    public void setUpdatedBy_GreaterThan(String updatedBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedBy", ConditionKey.CK_GREATER_THAN, updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_LessThan(String updatedBy) {
        setUpdatedBy_LessThan(updatedBy, null);
    }

    public void setUpdatedBy_LessThan(String updatedBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedBy", ConditionKey.CK_LESS_THAN, updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_GreaterEqual(String updatedBy) {
        setUpdatedBy_GreaterEqual(updatedBy, null);
    }

    public void setUpdatedBy_GreaterEqual(String updatedBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedBy", ConditionKey.CK_GREATER_EQUAL, updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_LessEqual(String updatedBy) {
        setUpdatedBy_LessEqual(updatedBy, null);
    }

    public void setUpdatedBy_LessEqual(String updatedBy, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedBy", ConditionKey.CK_LESS_EQUAL, updatedBy);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_UpdatedBy_Asc() {
        regOBA("updatedBy");
        return this;
    }

    public BsWebConfigCQ addOrderBy_UpdatedBy_Desc() {
        regOBD("updatedBy");
        return this;
    }

    public void setUpdatedTime_Term(Long updatedTime) {
        setUpdatedTime_Term(updatedTime, null);
    }

    public void setUpdatedTime_Term(Long updatedTime, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("updatedTime", updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Terms(Collection<Long> updatedTimeList) {
        setUpdatedTime_MatchPhrasePrefix(updatedTimeList, null);
    }

    public void setUpdatedTime_MatchPhrasePrefix(Collection<Long> updatedTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("updatedTime", updatedTimeList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_InScope(Collection<Long> updatedTimeList) {
        setUpdatedTime_MatchPhrasePrefix(updatedTimeList, null);
    }

    public void setUpdatedTime_InScope(Collection<Long> updatedTimeList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setUpdatedTime_MatchPhrasePrefix(updatedTimeList, opLambda);
    }

    public void setUpdatedTime_Match(Long updatedTime) {
        setUpdatedTime_Match(updatedTime, null);
    }

    public void setUpdatedTime_Match(Long updatedTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("updatedTime", updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_MatchPhrase(Long updatedTime) {
        setUpdatedTime_MatchPhrase(updatedTime, null);
    }

    public void setUpdatedTime_MatchPhrase(Long updatedTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("updatedTime", updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_MatchPhrasePrefix(Long updatedTime) {
        setUpdatedTime_MatchPhrasePrefix(updatedTime, null);
    }

    public void setUpdatedTime_MatchPhrasePrefix(Long updatedTime, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("updatedTime", updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Fuzzy(Long updatedTime) {
        setUpdatedTime_Fuzzy(updatedTime, null);
    }

    public void setUpdatedTime_Fuzzy(Long updatedTime, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("updatedTime", updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_GreaterThan(Long updatedTime) {
        setUpdatedTime_GreaterThan(updatedTime, null);
    }

    public void setUpdatedTime_GreaterThan(Long updatedTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedTime", ConditionKey.CK_GREATER_THAN, updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_LessThan(Long updatedTime) {
        setUpdatedTime_LessThan(updatedTime, null);
    }

    public void setUpdatedTime_LessThan(Long updatedTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedTime", ConditionKey.CK_LESS_THAN, updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_GreaterEqual(Long updatedTime) {
        setUpdatedTime_GreaterEqual(updatedTime, null);
    }

    public void setUpdatedTime_GreaterEqual(Long updatedTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedTime", ConditionKey.CK_GREATER_EQUAL, updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_LessEqual(Long updatedTime) {
        setUpdatedTime_LessEqual(updatedTime, null);
    }

    public void setUpdatedTime_LessEqual(Long updatedTime, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("updatedTime", ConditionKey.CK_LESS_EQUAL, updatedTime);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_UpdatedTime_Asc() {
        regOBA("updatedTime");
        return this;
    }

    public BsWebConfigCQ addOrderBy_UpdatedTime_Desc() {
        regOBD("updatedTime");
        return this;
    }

    public void setUrls_Term(String urls) {
        setUrls_Term(urls, null);
    }

    public void setUrls_Term(String urls, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_Terms(Collection<String> urlsList) {
        setUrls_MatchPhrasePrefix(urlsList, null);
    }

    public void setUrls_MatchPhrasePrefix(Collection<String> urlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("urls", urlsList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_InScope(Collection<String> urlsList) {
        setUrls_MatchPhrasePrefix(urlsList, null);
    }

    public void setUrls_InScope(Collection<String> urlsList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setUrls_MatchPhrasePrefix(urlsList, opLambda);
    }

    public void setUrls_Match(String urls) {
        setUrls_Match(urls, null);
    }

    public void setUrls_Match(String urls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_MatchPhrase(String urls) {
        setUrls_MatchPhrase(urls, null);
    }

    public void setUrls_MatchPhrase(String urls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_MatchPhrasePrefix(String urls) {
        setUrls_MatchPhrasePrefix(urls, null);
    }

    public void setUrls_MatchPhrasePrefix(String urls, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_Fuzzy(String urls) {
        setUrls_Fuzzy(urls, null);
    }

    public void setUrls_Fuzzy(String urls, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_Prefix(String urls) {
        setUrls_Prefix(urls, null);
    }

    public void setUrls_Prefix(String urls, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("urls", urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_GreaterThan(String urls) {
        setUrls_GreaterThan(urls, null);
    }

    public void setUrls_GreaterThan(String urls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("urls", ConditionKey.CK_GREATER_THAN, urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_LessThan(String urls) {
        setUrls_LessThan(urls, null);
    }

    public void setUrls_LessThan(String urls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("urls", ConditionKey.CK_LESS_THAN, urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_GreaterEqual(String urls) {
        setUrls_GreaterEqual(urls, null);
    }

    public void setUrls_GreaterEqual(String urls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("urls", ConditionKey.CK_GREATER_EQUAL, urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUrls_LessEqual(String urls) {
        setUrls_LessEqual(urls, null);
    }

    public void setUrls_LessEqual(String urls, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("urls", ConditionKey.CK_LESS_EQUAL, urls);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_Urls_Asc() {
        regOBA("urls");
        return this;
    }

    public BsWebConfigCQ addOrderBy_Urls_Desc() {
        regOBD("urls");
        return this;
    }

    public void setUserAgent_Term(String userAgent) {
        setUserAgent_Term(userAgent, null);
    }

    public void setUserAgent_Term(String userAgent, ConditionOptionCall<TermQueryBuilder> opLambda) {
        TermQueryBuilder builder = reqTermQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_Terms(Collection<String> userAgentList) {
        setUserAgent_MatchPhrasePrefix(userAgentList, null);
    }

    public void setUserAgent_MatchPhrasePrefix(Collection<String> userAgentList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        TermsQueryBuilder builder = reqTermsQ("userAgent", userAgentList);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_InScope(Collection<String> userAgentList) {
        setUserAgent_MatchPhrasePrefix(userAgentList, null);
    }

    public void setUserAgent_InScope(Collection<String> userAgentList, ConditionOptionCall<TermsQueryBuilder> opLambda) {
        setUserAgent_MatchPhrasePrefix(userAgentList, opLambda);
    }

    public void setUserAgent_Match(String userAgent) {
        setUserAgent_Match(userAgent, null);
    }

    public void setUserAgent_Match(String userAgent, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_MatchPhrase(String userAgent) {
        setUserAgent_MatchPhrase(userAgent, null);
    }

    public void setUserAgent_MatchPhrase(String userAgent, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhraseQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_MatchPhrasePrefix(String userAgent) {
        setUserAgent_MatchPhrasePrefix(userAgent, null);
    }

    public void setUserAgent_MatchPhrasePrefix(String userAgent, ConditionOptionCall<MatchQueryBuilder> opLambda) {
        MatchQueryBuilder builder = reqMatchPhrasePrefixQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_Fuzzy(String userAgent) {
        setUserAgent_Fuzzy(userAgent, null);
    }

    public void setUserAgent_Fuzzy(String userAgent, ConditionOptionCall<FuzzyQueryBuilder> opLambda) {
        FuzzyQueryBuilder builder = reqFuzzyQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_Prefix(String userAgent) {
        setUserAgent_Prefix(userAgent, null);
    }

    public void setUserAgent_Prefix(String userAgent, ConditionOptionCall<PrefixQueryBuilder> opLambda) {
        PrefixQueryBuilder builder = reqPrefixQ("userAgent", userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_GreaterThan(String userAgent) {
        setUserAgent_GreaterThan(userAgent, null);
    }

    public void setUserAgent_GreaterThan(String userAgent, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("userAgent", ConditionKey.CK_GREATER_THAN, userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_LessThan(String userAgent) {
        setUserAgent_LessThan(userAgent, null);
    }

    public void setUserAgent_LessThan(String userAgent, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("userAgent", ConditionKey.CK_LESS_THAN, userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_GreaterEqual(String userAgent) {
        setUserAgent_GreaterEqual(userAgent, null);
    }

    public void setUserAgent_GreaterEqual(String userAgent, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("userAgent", ConditionKey.CK_GREATER_EQUAL, userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_LessEqual(String userAgent) {
        setUserAgent_LessEqual(userAgent, null);
    }

    public void setUserAgent_LessEqual(String userAgent, ConditionOptionCall<RangeQueryBuilder> opLambda) {
        RangeQueryBuilder builder = reqRangeQ("userAgent", ConditionKey.CK_LESS_EQUAL, userAgent);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public BsWebConfigCQ addOrderBy_UserAgent_Asc() {
        regOBA("userAgent");
        return this;
    }

    public BsWebConfigCQ addOrderBy_UserAgent_Desc() {
        regOBD("userAgent");
        return this;
    }

}
