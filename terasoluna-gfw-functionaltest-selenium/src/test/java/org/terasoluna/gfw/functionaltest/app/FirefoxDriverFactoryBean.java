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
package org.terasoluna.gfw.functionaltest.app;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FirefoxDriverFactoryBean implements FactoryBean<FirefoxDriver> {

    @Value("${selenium.geckodriverVersion}")
    protected String geckodriverVersion;

    @Value("${selenium.proxyHttpServer}")
    protected String proxyHttpServer;

    @Value("${selenium.proxyUserName}")
    protected String userName;

    @Value("${selenium.proxyUserPassword}")
    protected String userPassword;

    @Override
    public FirefoxDriver getObject() {
        if (System.getProperty("webdriver.gecko.driver") == null) {
            FirefoxDriverManager.getInstance().version(geckodriverVersion)
                    .forceCache().proxy(proxyHttpServer).proxyUser(userName)
                    .proxyPass(userPassword).setup();
        }

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.homepage_override.mstone",
                "ignore");
        profile.setPreference("network.proxy.type", 0);
        return new FirefoxDriver(profile);
    }

    @Override
    public Class<?> getObjectType() {
        return FirefoxDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
