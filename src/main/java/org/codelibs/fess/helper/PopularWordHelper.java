/*
 * Copyright 2012-2016 CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.fess.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.codelibs.core.lang.StringUtil;
import org.codelibs.fess.mylasta.direction.FessConfig;
import org.codelibs.fess.suggest.request.popularwords.PopularWordsRequestBuilder;
import org.codelibs.fess.util.ComponentUtil;
import org.codelibs.fess.util.StreamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class PopularWordHelper {
    private static final Logger logger = LoggerFactory.getLogger(PopularWordHelper.class);

    private static final char CACHE_KEY_SPLITTER = '\n';

    private Cache<String, List<String>> cache;

    private FessConfig fessConfig;

    @PostConstruct
    public void init() {
        fessConfig = ComponentUtil.getFessConfig();
        cache =
                CacheBuilder.newBuilder().maximumSize(fessConfig.getSuggestPopularWordCacheSizeAsInteger().longValue())
                        .expireAfterWrite(fessConfig.getSuggestPopularWordCacheExpireAsInteger().longValue(), TimeUnit.MINUTES).build();
    }

    public List<String> getWordList(final String seed, final String[] tags, final String[] roles, final String[] fields,
            final String[] excludes) {
        final String baseSeed = seed != null ? seed : fessConfig.getSuggestPopularWordSeed();
        final String[] baseTags = tags != null ? tags : fessConfig.getSuggestPopularWordTagsAsArray();
        final String[] baseRoles =
                roles != null ? roles : ComponentUtil.getRoleQueryHelper().build().stream().filter(s -> StringUtil.isNotBlank(s))
                        .toArray(n -> new String[n]);
        final String[] baseFields = fields != null ? fields : fessConfig.getSuggestPopularWordFieldsAsArray();
        final String[] baseExcludes = excludes != null ? excludes : fessConfig.getSuggestPopularWordExcludesAsArray();
        try {
            return cache.get(
                    getCacheKey(baseSeed, baseTags, baseRoles, baseFields, baseExcludes),
                    () -> {
                        final List<String> wordList = new ArrayList<String>();
                        final SuggestHelper suggestHelper = ComponentUtil.getSuggestHelper();
                        final PopularWordsRequestBuilder popularWordsRequestBuilder =
                                suggestHelper.suggester().popularWords()
                                        .setSize(fessConfig.getSuggestPopularWordSizeAsInteger().intValue())
                                        .setWindowSize(fessConfig.getSuggestPopularWordWindowSizeAsInteger().intValue());
                        popularWordsRequestBuilder.setSeed(baseSeed);
                        StreamUtil.of(baseTags).forEach(tag -> popularWordsRequestBuilder.addTag(tag));
                        StreamUtil.of(baseRoles).forEach(role -> popularWordsRequestBuilder.addRole(role));
                        StreamUtil.of(baseFields).forEach(field -> popularWordsRequestBuilder.addField(field));
                        StreamUtil.of(baseExcludes).forEach(exclude -> popularWordsRequestBuilder.addExcludeWord(exclude));
                        popularWordsRequestBuilder.execute().then(r -> {
                            r.getItems().stream().forEach(item -> wordList.add(item.getText()));
                        }).error(t -> logger.warn("Failed to generate popular words.", t));

                        return wordList;
                    });
        } catch (final ExecutionException e) {
            logger.warn("Failed to load popular words.", e);
        }
        return Collections.emptyList();
    }

    protected String getCacheKey(final String seed, final String[] tags, final String[] roles, final String[] fields,
            final String[] excludes) {
        final StringBuilder buf = new StringBuilder(100);
        buf.append(seed).append(CACHE_KEY_SPLITTER);
        StreamUtil.of(tags).sorted().reduce((l, r) -> l + r).ifPresent(v -> buf.append(v));
        buf.append(CACHE_KEY_SPLITTER);
        StreamUtil.of(roles).sorted().reduce((l, r) -> l + r).ifPresent(v -> buf.append(v));
        buf.append(CACHE_KEY_SPLITTER);
        StreamUtil.of(fields).sorted().reduce((l, r) -> l + r).ifPresent(v -> buf.append(v));
        buf.append(CACHE_KEY_SPLITTER);
        StreamUtil.of(excludes).sorted().reduce((l, r) -> l + r).ifPresent(v -> buf.append(v));
        return buf.toString();
    }

}
