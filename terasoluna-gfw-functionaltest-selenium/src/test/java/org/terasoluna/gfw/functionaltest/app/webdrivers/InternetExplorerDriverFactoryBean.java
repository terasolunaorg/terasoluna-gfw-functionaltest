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
package org.terasoluna.gfw.functionaltest.app.webdrivers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.FactoryBean;

public class InternetExplorerDriverFactoryBean implements
                                               FactoryBean<InternetExplorerDriver> {

    @Override
    public InternetExplorerDriver getObject() {
        return new InternetExplorerDriver();
    }

    @Override
    public Class<?> getObjectType() {
        return InternetExplorerDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
