/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
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
package org.terasoluna.gfw.functionaltest.app.redirect;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.RedirectStrategy;
import org.terasoluna.gfw.common.codelist.CodeList;

public class WhiteListRedirectStrategy implements RedirectStrategy {

    protected final Log logger = LogFactory.getLog(getClass());

    @Inject
    @Qualifier("CL_REDIRECTWHITELIST")
    CodeList redirectWhiteList;

    public void sendRedirect(HttpServletRequest request,
            HttpServletResponse response, String url) throws IOException {
        if (checkWhiteList(url)) {
            String redirectUrl = response.encodeRedirectURL(url);

            if (logger.isDebugEnabled()) {
                logger.debug("Redirecting to '" + redirectUrl + "'");
            }

            response.sendRedirect(redirectUrl);

        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, url);
        }
    }

    private boolean checkWhiteList(String url) {
        if (redirectWhiteList.asMap().containsValue(url))
            return true;
        return false;
    }

}
