/*
 * Copyright(c) 2025 NTT DATA Group Corporation.
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
package org.terasoluna.gfw.functionaltest.app.webdrivers;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

public abstract class HeadlessWebDriverManagerFactoryBean<T extends WebDriver>
        extends WebDriverManagerFactoryBean<T> implements InitializingBean {

    protected boolean headless = true;

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Prioritize startup arguments
        String headlessProperty = System.getProperty("selenium.headless");
        if (StringUtils.hasLength(headlessProperty)) {
            this.headless = Boolean.valueOf(headlessProperty);
        }
    }
}
