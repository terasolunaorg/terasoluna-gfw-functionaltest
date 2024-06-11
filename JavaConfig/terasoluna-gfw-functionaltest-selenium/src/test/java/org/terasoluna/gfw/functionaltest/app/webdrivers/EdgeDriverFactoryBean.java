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

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverFactoryBean extends
                                   HeadlessWebDriverManagerFactoryBean<EdgeDriver> {

    @Override
    protected WebDriverManager getWebDriverManager() {
        return WebDriverManager.edgedriver();
    }

    @Override
    protected EdgeDriver createWebDriver() {

        EdgeOptions options = new EdgeOptions();

        if (super.headless) {
            options.addArguments("--headless=new");
        }

        return new EdgeDriver(options);
    }
}
