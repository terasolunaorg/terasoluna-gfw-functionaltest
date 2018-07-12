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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverFactoryBean implements FactoryBean<FirefoxDriver> {

    @Value("${selenium.geckodriverVersion}")
    protected String geckodriver;

    @Value("${selenium.proxyUserName}")
    protected String userName;

    @Value("${selenium.proxyUserPassword}")
    protected String userPassword;

    @Value("${selenium.proxyHttpServer}")
    protected String httpServer;

    @Override
    public FirefoxDriver getObject() {
        WebDriverManager.firefoxdriver().version(geckodriver);
        WebDriverManager.firefoxdriver().proxyUser(userName);
        WebDriverManager.firefoxdriver().proxyPass(userPassword);
        WebDriverManager.firefoxdriver().proxy(httpServer).setup();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.homepage_override.mstone",
                "ignore");
        profile.setPreference("network.proxy.type", 0);
        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
        return new FirefoxDriver(options);
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
