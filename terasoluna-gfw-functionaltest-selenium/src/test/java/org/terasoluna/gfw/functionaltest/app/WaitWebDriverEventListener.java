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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.openqa.selenium.By;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitWebDriverEventListener extends WebDriverEventListenerAdapter {

    protected final Log logger = LogFactory.getLog(getClass());

    protected Wait<WebDriver> wait;

    protected String xTrack;

    @Value("${selenium.webDriverWait}")
    protected long webDriverWait;

    @Value("${selenium.webDriverSleepWait}")
    protected long webDriverSleepWait;

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        try {
            wait = new WebDriverWait(webDriver, webDriverWait, webDriverSleepWait);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id(
                    "xtrack"), xTrack));
        } catch (TimeoutException e) {
            logger.debug("XTrack hasn't change in default time");
        }
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals(
                        "complete"));
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        xTrack = webDriver.findElement(By.id("xtrack")).getText();
    }

}
