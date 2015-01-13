/*
 * Copyright (C) 2013-2014 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.queryescape;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.model.VersionInfo;
import org.terasoluna.gfw.functionaltest.domain.service.queryescape.VersionInfoService;

@Component
public class QueryEscapeHelper {

    protected final Log logger = LogFactory.getLog(getClass());

    @Inject
    @Named("versionInfoMyBatisService")
    VersionInfoService versionInfoService;

    @Inject
    SqlSessionFactory sqlSessionFactory;

    public void bindToModel(String searchPattern, List<Todo> todoList,
            Model model) {
        model.addAttribute("searchPattern", searchPattern);
        model.addAttribute("hitNumber", todoList.size());
        model.addAttribute("todoList", todoList);
    }

    public boolean isNeedFullWidthToLikeEscapeForOracle() {
        String databaseId = sqlSessionFactory.getConfiguration()
                .getDatabaseId();

        if (logger.isDebugEnabled()) {
            logger.debug("databaseId= '" + databaseId + "'");
        }

        if ("oracle".equals(databaseId)) {

            List<VersionInfo> versionInfoList = versionInfoService.findAll();

            Pattern pattern = Pattern
                    .compile("\\d+\\.\\d+\\.\\d+");

            for (VersionInfo versionInfo : versionInfoList) {

                if (logger.isDebugEnabled()) {
                    logger.debug("versionInfo.getBanner()= '"
                            + versionInfo.getBanner() + "'");
                }

                Matcher m = pattern.matcher(versionInfo.getBanner());
                if (m.find()) {
                    String oracleVersionStr = m.group();
                    int compareResult = compareVersion(oracleVersionStr, "11.2");
                    if (compareResult >= 0) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("isNeedFullWidthToLikeEscapeForOracle()= true");
                        }
                        return true;
                    }
                }
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("isNeedFullWidthToLikeEscapeForOracle()= false");
        }

        return false;
    }

    public int compareVersion(String destStr, String srcStr) {

        if (logger.isDebugEnabled()) {
            logger.debug("compareVersion() Start destStr= '" + destStr
                    + "' ,src= '" + srcStr + "'");
        }

        String[] destStrArray = destStr.split("\\.");
        String[] srcStrArray = srcStr.split("\\.");

        int max = destStrArray.length >= srcStrArray.length ? destStrArray.length
                : srcStrArray.length;

        for (int i = 0; i < max; i++) {

            String dest = i < destStrArray.length ? destStrArray[i] : "";
            String src = i < srcStrArray.length ? srcStrArray[i] : "";

            int compareResult = dest.compareTo(src);

            if (compareResult != 0) {

                if (logger.isDebugEnabled()) {
                    logger.debug("compareVersion() End return= '"
                            + compareResult + "'");
                }
                return compareResult;
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("compareVersion() End return= '0'");
        }

        return 0;
    }

}
