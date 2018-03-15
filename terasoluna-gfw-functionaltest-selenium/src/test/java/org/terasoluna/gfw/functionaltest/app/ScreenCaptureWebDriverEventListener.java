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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Captures screen using ScreenCapture class after navigation and click on button/link Please extend the class and override the
 * behavior as per requirement
 */
public class ScreenCaptureWebDriverEventListener extends
                                                 WebDriverEventListenerAdapter {

    protected ScreenCapture screenCapture;

    public ScreenCaptureWebDriverEventListener(ScreenCapture screenCapture) {
        this.screenCapture = screenCapture;
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        // following statement is required for ensuring that every screen is captured.
        // some screens that do not have assertions or element access, need following
        // statement such that driver accesses the screen atleast once
        arg1.findElement(By.tagName("body"));
        screenCapture.save(arg1);
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        screenCapture.save(arg1);
    }

}
