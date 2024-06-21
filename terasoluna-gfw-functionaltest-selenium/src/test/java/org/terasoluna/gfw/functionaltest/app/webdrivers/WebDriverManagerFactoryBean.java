/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
import org.springframework.beans.factory.FactoryBean;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class WebDriverManagerFactoryBean<T extends WebDriver>
                                                 implements FactoryBean<T> {

    protected String propertyFileLocation;

    public void setPropertyFileLocation(String propertyFileLocation) {
        this.propertyFileLocation = propertyFileLocation;
    }

    protected abstract WebDriverManager getWebDriverManager();

    protected abstract T createWebDriver();

    @Override
    public T getObject() {
        if (System.getenv("webdriver.driver") == null) {
            WebDriverManager manager = getWebDriverManager();
            if (this.propertyFileLocation != null) {
                manager.config().setProperties(this.propertyFileLocation);
            }
            manager.setup();
        }

        return createWebDriver();
    }

    @Override
    public Class<?> getObjectType() {
        return WebDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
