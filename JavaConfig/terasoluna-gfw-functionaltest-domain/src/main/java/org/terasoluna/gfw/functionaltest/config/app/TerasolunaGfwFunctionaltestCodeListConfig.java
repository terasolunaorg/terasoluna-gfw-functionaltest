/*
 * Copyright(c) 2023 NTT Corporation.
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
package org.terasoluna.gfw.functionaltest.config.app;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.terasoluna.gfw.common.codelist.CodeList;
import org.terasoluna.gfw.common.codelist.EnumCodeList;
import org.terasoluna.gfw.common.codelist.JdbcCodeList;
import org.terasoluna.gfw.common.codelist.NumberRangeCodeList;
import org.terasoluna.gfw.common.codelist.ReloadableCodeList;
import org.terasoluna.gfw.common.codelist.SimpleMapCodeList;
import org.terasoluna.gfw.common.codelist.i18n.SimpleI18nCodeList;
import org.terasoluna.gfw.common.codelist.i18n.SimpleReloadableI18nCodeList;
import org.terasoluna.gfw.functionaltest.domain.common.datetime.MonthOfYear;

import jakarta.inject.Inject;

/**
 * Bean definition regarding CodeLists.
 */
@Configuration
public class TerasolunaGfwFunctionaltestCodeListConfig {

    /**
     * JDBC fetchSize property.
     */
    @Value("${codelist.jdbc.fetchSize:1000}")
    private Integer fetchSize;

    /**
     * Whitelisted URLs
     */
    @Value("${app.redirect.allowed.externalUrl}")
    private String externalUrl;

    /**
     * Bean of DataSource
     */
    @Inject
    private DataSource dataSource;

    /**
     * Configure {@link JdbcTemplate} bean.
     * @return Bean of configured {@link JdbcTemplate}
     */
    @Bean("jdbcTemplateForCodeList")
    public JdbcTemplate jdbcTemplateForCodeList() {
        JdbcTemplate bean = new JdbcTemplate();
        bean.setDataSource(dataSource);
        bean.setFetchSize(fetchSize);
        return bean;
    }

    /**
     * Common processing of {@link JdbcCodeList}.
     * @return Bean of configured {@link JdbcCodeList}
     */
    private JdbcCodeList abstractJdbcCodeList() {
        JdbcCodeList bean = new JdbcCodeList();
        bean.setJdbcTemplate(jdbcTemplateForCodeList());
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST01_01")
    public SimpleMapCodeList clCodeList01_01() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "label1");
        codeMap.put("key2", "label2");
        codeMap.put("key3", "label3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST01_02")
    public SimpleMapCodeList clCodeList01_02() {
        return new SimpleMapCodeList();
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("CL_CODELIST02_01")
    public NumberRangeCodeList clCodeList02_01() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(1);
        bean.setTo(5);
        return bean;
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("CL_CODELIST02_02")
    public NumberRangeCodeList clCodeList02_02() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(5);
        bean.setTo(1);
        return bean;
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("CL_CODELIST02_03")
    public NumberRangeCodeList clCodeList02_03() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(5);
        bean.setTo(1);
        bean.setInterval(3);
        return bean;
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("CL_CODELIST02_04")
    public NumberRangeCodeList clCodeList02_04() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(5);
        bean.setTo(1);
        bean.setInterval(3);
        bean.setLabelFormat("%02d");
        bean.setValueFormat("%03d");
        return bean;
    }

    /**
     * Configure {@link JdbcCodeList} bean.
     * @return Bean of configured {@link JdbcCodeList}
     */
    @Bean("CL_CODELIST_ITEM1")
    @DependsOn({ "dataSourceInitializer" })
    public JdbcCodeList clCodeListItem1() {
        JdbcCodeList jdbcCodeList = abstractJdbcCodeList();
        jdbcCodeList.setQuerySql("select code, label from item1 ORDER BY code");
        jdbcCodeList.setValueColumn("code");
        jdbcCodeList.setLabelColumn("label");
        return jdbcCodeList;
    }

    /**
     * Configure {@link JdbcCodeList} bean.
     * @return Bean of configured {@link JdbcCodeList}
     */
    @Bean("CL_CODELIST_ITEM2")
    @DependsOn({ "dataSourceInitializer" })
    public JdbcCodeList clCodeListItem2() {
        JdbcCodeList jdbcCodeList = abstractJdbcCodeList();
        jdbcCodeList.setQuerySql("select code, label from item2 ORDER BY code");
        jdbcCodeList.setValueColumn("code");
        jdbcCodeList.setLabelColumn("label");
        return jdbcCodeList;
    }

    /**
     * Configure {@link JdbcCodeList} bean.
     * @return Bean of configured {@link JdbcCodeList}
     */
    @Bean("CODELIST_WRONG_ITEM")
    @DependsOn({ "dataSourceInitializer" })
    public JdbcCodeList codeListWrongItem() {
        JdbcCodeList jdbcCodeList = abstractJdbcCodeList();
        jdbcCodeList.setLazyInit(true);
        jdbcCodeList.setQuerySql(
                "select code, label_wrong from item2 ORDER BY code");
        jdbcCodeList.setValueColumn("code");
        jdbcCodeList.setLabelColumn("label");
        return jdbcCodeList;
    }

    /**
     * Configure {@link SimpleI18nCodeList} bean.
     * @return Bean of configured {@link SimpleI18nCodeList}
     */
    @Bean("CL_CODELIST06_01")
    public SimpleI18nCodeList clCodeList06_01() {
        Map<Locale, Map<String, String>> rowsMap = new LinkedHashMap<Locale, Map<String, String>>();
        Map<String, String> enCodeMap = new LinkedHashMap<String, String>();
        enCodeMap.put("key1", "label1");
        enCodeMap.put("key2", "label2");
        enCodeMap.put("key3", "label3");
        Map<String, String> jaCodeMap = new LinkedHashMap<String, String>();
        jaCodeMap.put("key1", "ラベル1");
        jaCodeMap.put("key2", "ラベル2");
        jaCodeMap.put("key3", "ラベル3");

        rowsMap.put(Locale.ENGLISH, enCodeMap);
        rowsMap.put(Locale.JAPANESE, jaCodeMap);
        SimpleI18nCodeList bean = new SimpleI18nCodeList();
        bean.setRows(rowsMap);
        bean.setFallbackTo(Locale.ENGLISH);
        return bean;
    }

    /**
     * Configure {@link SimpleI18nCodeList} bean.
     * @return Bean of configured {@link SimpleI18nCodeList}
     */
    @Bean("CL_CODELIST06_02")
    public SimpleI18nCodeList clCodeList06_02() {
        Map<Locale, CodeList> rowsMap = new LinkedHashMap<Locale, CodeList>();
        rowsMap.put(Locale.ENGLISH, clCodeList06_02_En());
        rowsMap.put(Locale.JAPANESE, clCodeList06_02_Ja());
        SimpleI18nCodeList bean = new SimpleI18nCodeList();
        bean.setRowsByCodeList(rowsMap);
        bean.setFallbackTo(Locale.ENGLISH);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST06_02_EN")
    public SimpleMapCodeList clCodeList06_02_En() {
        Map<String, String> enCodeMap = new LinkedHashMap<String, String>();
        enCodeMap.put("key1", "label1");
        enCodeMap.put("key2", "label2");
        enCodeMap.put("key3", "label3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(enCodeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST06_02_JA")
    public SimpleMapCodeList clCodeList06_02_Ja() {
        Map<String, String> jaCodeMap = new LinkedHashMap<String, String>();
        jaCodeMap.put("key1", "ラベル1");
        jaCodeMap.put("key2", "ラベル2");
        jaCodeMap.put("key3", "ラベル3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(jaCodeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleI18nCodeList} bean.
     * @return Bean of configured {@link SimpleI18nCodeList}
     */
    @Bean("CL_CODELIST06_03")
    public SimpleI18nCodeList clCodeList06_03() {
        Map<String, Map<Locale, String>> columnsMap = new LinkedHashMap<String, Map<Locale, String>>();
        Map<Locale, String> key1Map = new LinkedHashMap<Locale, String>();
        key1Map.put(Locale.ENGLISH, "label1");
        key1Map.put(Locale.JAPANESE, "ラベル1");
        Map<Locale, String> key2Map = new LinkedHashMap<Locale, String>();
        key2Map.put(Locale.ENGLISH, "label2");
        key2Map.put(Locale.JAPANESE, "ラベル2");
        Map<Locale, String> key3Map = new LinkedHashMap<Locale, String>();
        key3Map.put(Locale.ENGLISH, "label3");
        key3Map.put(Locale.JAPANESE, "ラベル3");

        columnsMap.put("key1", key1Map);
        columnsMap.put("key2", key2Map);
        columnsMap.put("key3", key3Map);
        SimpleI18nCodeList bean = new SimpleI18nCodeList();
        bean.setColumns(columnsMap);
        bean.setFallbackTo(Locale.ENGLISH);
        return bean;
    }

    /**
     * Configure {@link SimpleI18nCodeList} bean.
     * @return Bean of configured {@link SimpleI18nCodeList}
     */
    @Bean("CL_CODELIST11_01")
    public SimpleI18nCodeList clCodeList11_01() {
        Map<Locale, Map<String, String>> rowsMap = new LinkedHashMap<Locale, Map<String, String>>();
        Map<String, String> enCodeMap = new LinkedHashMap<String, String>();
        enCodeMap.put("key1", "label1");
        enCodeMap.put("key2", "label2");
        enCodeMap.put("key3", "label3");
        Map<String, String> jaCodeMap = new LinkedHashMap<String, String>();
        jaCodeMap.put("key1", "ラベル1");
        jaCodeMap.put("key2", "ラベル2");
        jaCodeMap.put("key3", "ラベル3");
        Map<String, String> frCodeMap = new LinkedHashMap<String, String>();
        frCodeMap.put("key1", "étiquette un");
        frCodeMap.put("key2", "étiquette deux");
        frCodeMap.put("key3", "étiquette trois");
        Map<String, String> fr_caCodeMap = new LinkedHashMap<String, String>();
        fr_caCodeMap.put("key1", "étiquette1");
        fr_caCodeMap.put("key2", "étiquette2");
        fr_caCodeMap.put("key3", "étiquette3");

        rowsMap.put(Locale.ENGLISH, enCodeMap);
        rowsMap.put(Locale.JAPANESE, jaCodeMap);
        rowsMap.put(Locale.FRENCH, frCodeMap);
        rowsMap.put(Locale.CANADA_FRENCH, fr_caCodeMap);
        SimpleI18nCodeList bean = new SimpleI18nCodeList();
        bean.setRows(rowsMap);
        bean.setFallbackTo(Locale.JAPANESE);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("SAMPLE_CODELIST")
    public SimpleMapCodeList sampleCodeList() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "ラベル1");
        codeMap.put("key2", "ラベル2");
        codeMap.put("key3", "ラベル3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("SAMPLE_MUTIPLE_CODELIST")
    public SimpleMapCodeList sampleMutipleCodeList() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "ラベル1");
        codeMap.put("key4", "ラベル4");
        codeMap.put("key5", "ラベル5");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CHARACTER_CODELIST")
    public SimpleMapCodeList characterCodeList() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("a", "character1");
        codeMap.put("b", "character2");
        codeMap.put("c", "character3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleReloadableI18nCodeList} bean.
     * @return Bean of configured {@link SimpleReloadableI18nCodeList}
     */
    @Bean("CL_CODELIST12_01")
    @DependsOn({ "dataSourceInitializer" })
    public SimpleReloadableI18nCodeList clCodeList12_01() {
        Map<Locale, ReloadableCodeList> rowsMap = new LinkedHashMap<Locale, ReloadableCodeList>();
        rowsMap.put(Locale.ENGLISH, clCodeListItem3_En());
        rowsMap.put(Locale.JAPANESE, clCodeListItem3_Ja());
        SimpleReloadableI18nCodeList bean = new SimpleReloadableI18nCodeList();
        bean.setRowsByCodeList(rowsMap);
        bean.setFallbackTo(Locale.ENGLISH);
        return bean;
    }

    /**
     * Configure {@link JdbcCodeList} bean.
     * @return Bean of configured {@link JdbcCodeList}
     */
    @Bean("CL_CODELIST_ITEM3_EN")
    @DependsOn({ "dataSourceInitializer" })
    public JdbcCodeList clCodeListItem3_En() {
        JdbcCodeList jdbcCodeList = abstractJdbcCodeList();
        jdbcCodeList.setQuerySql(
                "select code, label_en from item3 ORDER BY code");
        jdbcCodeList.setValueColumn("code");
        jdbcCodeList.setLabelColumn("label_en");
        return jdbcCodeList;
    }

    /**
     * Configure {@link JdbcCodeList} bean.
     * @return Bean of configured {@link JdbcCodeList}
     */
    @Bean("CL_CODELIST_ITEM3_JA")
    @DependsOn({ "dataSourceInitializer" })
    public JdbcCodeList clCodeListItem3_Ja() {
        JdbcCodeList jdbcCodeList = abstractJdbcCodeList();
        jdbcCodeList.setQuerySql(
                "select code, label_ja from item3 ORDER BY code");
        jdbcCodeList.setValueColumn("code");
        jdbcCodeList.setLabelColumn("label_ja");
        return jdbcCodeList;
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("NUMBER_CODELIST")
    public NumberRangeCodeList numberCodeList() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(1);
        bean.setTo(5);
        return bean;
    }

    /**
     * Configure {@link NumberRangeCodeList} bean.
     * @return Bean of configured {@link NumberRangeCodeList}
     */
    @Bean("NUMBER_FORMATTED_CODELIST")
    public NumberRangeCodeList numberFormattedCodeList() {
        NumberRangeCodeList bean = new NumberRangeCodeList();
        bean.setFrom(1);
        bean.setTo(5);
        bean.setValueFormat("%02d");
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("NOPATTERN_CODELIST")
    public SimpleMapCodeList nopatternCodeList() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "label1");
        codeMap.put("key2", "label2");
        codeMap.put("key3", "label3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_REDIRECTWHITELIST")
    public SimpleMapCodeList clRedirectWhiteList() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("1", "http://www.google.com");
        codeMap.put("2", externalUrl);
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link EnumCodeList} bean.
     * @return Bean of configured {@link EnumCodeList}
     */
    @Bean("CL_MONTH_OF_YEAR")
    public EnumCodeList clMonthOfYear() {
        EnumCodeList enumCodeList = new EnumCodeList(MonthOfYear.class);
        return enumCodeList;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST10_01")
    public SimpleMapCodeList clCodeList10_01() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "label1");
        codeMap.put("key2", "label2");
        codeMap.put("key3", "label3");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }

    /**
     * Configure {@link SimpleMapCodeList} bean.
     * @return Bean of configured {@link SimpleMapCodeList}
     */
    @Bean("CL_CODELIST08_08")
    public SimpleMapCodeList clCodeList08_08() {
        Map<String, String> codeMap = new LinkedHashMap<String, String>();
        codeMap.put("key1", "label1");
        codeMap.put("key2", "label2");
        SimpleMapCodeList bean = new SimpleMapCodeList();
        bean.setMap(codeMap);
        return bean;
    }
}
