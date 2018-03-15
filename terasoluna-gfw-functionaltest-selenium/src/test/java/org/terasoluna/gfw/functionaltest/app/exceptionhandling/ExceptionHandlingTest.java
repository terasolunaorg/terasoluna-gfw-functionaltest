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
package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class ExceptionHandlingTest extends FunctionTestSupport {

    @Inject
    protected RestTemplate restTemplate;

    public ExceptionHandlingTest() {
    }

    @Test
    public void test01_01_requestControllerHandling() {
        driver.findElement(By.id("requestControllerHandling_01_01")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is("Error"));

    }

    @Test
    public void test01_02_requestControllerHandling() {
        driver.findElement(By.id("requestControllerHandling_01_02")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=info, list=\\[ResultMessage \\[code=i.gt.me.0004, args=\\[\\], text=null\\]\\]\\]",
                "INFO", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=info, list=\\[ResultMessage \\[code=i.gt.me.0004, args=\\[\\], text=null\\]\\]\\]",
                "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "Info !!"));

    }

    @Test
    public void test02_01_useCaseControllerHandling() {

        driver.findElement(By.id("useCaseControllerHandling_02_01")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_1 Continue", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_1 Continue", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null, "2_1 Continue*", "..*ContinueException..*"), is(1L));
    }

    @Test
    public void test02_02_useCaseControllerHandling() {

        driver.findElement(By.id("useCaseControllerHandling_02_02")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_2 Ok", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_2 Ok", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "2_2 Ok"));

    }

    @Test
    public void test02_03_useCaseControllerHandling() {

        driver.findElement(By.id("useCaseControllerHandling_02_03")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_3 Multiple Choices", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_3 Multiple Choices", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "2_3 Multiple Choices"));
    }

    @Test
    public void test02_04_useCaseControllerHandling() {

        driver.findElement(By.id("useCaseControllerHandling_02_04")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_4 Conflict", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_4 Conflict", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "2_4 Conflict"));

    }

    @Test
    public void test02_05_useCaseControllerHandling() {

        driver.findElement(By.id("useCaseControllerHandling_02_05")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_5 ignore logging", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(0L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 2_5 ignore logging", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(0L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "2_5 ignore logging"));

    }

    @Test
    public void test03_01_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_01")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[i.xx.xxx\\] 3_1 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[i.xx.xxx\\] 3_1 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "i.xx.xxx"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionhandling/3_1", String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("i.xx.xxx"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }
    }

    @Test
    public void test03_02_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_02")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.xxx\\] 3_2 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.xxx\\] 3_2 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "w.xx.xxx"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionhandling/3_2", String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("w.xx.xxx"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }
    }

    @Test
    public void test03_03_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_03")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_3 SystemException", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_3 SystemException", "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.xxx"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionHandlingChangeDefaultStatusCode/exceptionhandling/3_3",
                    String.class);
        } catch (HttpClientErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("e.xx.xxx"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("400"));
        }
    }

    @Test
    public void test03_04_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_04")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_4 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_4 SystemException", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.xxx"));

    }

    @Test
    public void test03_05_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_05")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=null, args=\\[\\], text=w.yy.yyy\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=null, args=\\[\\], text=w.yy.yyy\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.9999"));
        // Response Code assert
        assertThat(driver.findElement(By.xpath(
                "//div[@id='messagesPanel']/div/ul/li")).getText(), is(
                        "w.yy.yyy"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionhandling/3_5", String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("e.xx.9999"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }

    }

    @Test
    public void test03_06_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_06")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=null, args=\\[\\], text=w.yy.yyy\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=null, args=\\[\\], text=w.yy.yyy\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.9999"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionHandlingIgnoreResultMessages/exceptionhandling/3_6",
                    String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("e.xx.9999"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }
    }

    @Test
    public void test03_07_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_07")).click();

        assertThat(driver.getTitle(), is("Page Not Found"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0001\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=i.xx.xxx\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0001\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=i.xx.xxx\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "w.xx.0001"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionhandling/3_7", String.class);
        } catch (HttpClientErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("w.xx.0001"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("404"));
        }
    }

    @Test
    public void test03_08_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_08")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] e.cc.ccc", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] e.cc.ccc", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.9999"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionHandlingChangeAttribute/exceptionhandling/3_8",
                    String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Error-Code").get(0)
                    .toString(), is("e.xx.9999"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }
    }

    @Test
    public void test03_09_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_09")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_9 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.xxx\\] 3_9 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.xxx"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionHandlingChangeAttribute/exceptionhandling/3_9",
                    String.class);
        } catch (HttpServerErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Error-Code").get(0)
                    .toString(), is("e.xx.xxx"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("500"));
        }
    }

    @Test
    public void test03_10_servletFrameworkHandling() {

        driver.findElement(By.id("servletFrameworkHandling_03_10")).click();

        assertThat(driver.getTitle(), is("Transaction Token Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[i.xx.0010\\] Invalid Transaction Token Exception !!!",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[i.xx.0010\\] Invalid Transaction Token Exception !!!",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // Error Code assert
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "i.xx.0010"));

        // screen capture
        screenCapture.save(driver);

        try {
            restTemplate.getForEntity(applicationContextUrl
                    + "/exceptionhandling/3_10", String.class);
        } catch (HttpClientErrorException e) {
            // Response Header Error Code assert
            assertThat(e.getResponseHeaders().get("X-Exception-Code").get(0)
                    .toString(), is("i.xx.0010"));
            // Response Code assert
            assertThat(e.getStatusCode().toString(), is("409"));
        }
    }

    @Test
    public void test04_01_webApplicationHandling() {

        driver.findElement(By.id("webApplicationHandling_04_01")).click();

        assertThat(driver.getTitle(), is("Servlet Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] Request processing failed; .*", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] Request processing failed; .*", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Servlet Error..."));

    }

    @Test
    public void test04_02_webApplicationHandling() {

        driver.findElement(By.id("webApplicationHandling_04_02")).click();

        assertThat(driver.getTitle(), is("Servlet Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] Handler dispatch failed; nested exception is java.lang.AssertionError",
                "ERROR", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] Handler dispatch failed; nested exception is java.lang.AssertionError",
                "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Servlet Error..."));

    }

    @Test
    public void test04_03_webApplicationHandling() {

        driver.findElement(By.id("webApplicationHandling_04_03")).click();

        assertThat(driver.getTitle(), is(""));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0011\\] 4_3 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0011\\] 4_3 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "UnHandled System Error!!"));

    }

    @Test
    public void test04_04_webApplicationHandling() {

        driver.findElement(By.id("webApplicationHandling_04_04")).click();

        assertThat(driver.getTitle(), is(""));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 4_4 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] 4_4 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "UnHandled System Error!!"));

    }

    @Test
    public void test05_01_exceptionLoggerVariation() {

        driver.findElement(By.id("exceptionLoggerVariation_05_01")).click();

        assertThat(driver.getTitle(), is(""));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=n.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "INFO", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=n.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "UnHandled System Error!!"));
    }

    @Test
    public void test05_02_exceptionLoggerVariation() {

        driver.findElement(By.id("exceptionLoggerVariation_05_02")).click();

        assertThat(driver.getTitle(), is(""));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=a.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=a.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "UnHandled System Error!!"));

    }

    @Test
    public void test05_03_exceptionLoggerVariation() {

        driver.findElement(By.id("exceptionLoggerVariation_05_03")).click();

        assertThat(driver.getTitle(), is(""));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=d.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "ERROR", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\] ResultMessages \\[type=warning, list=\\[ResultMessage \\[code=d.cc.0000, args=\\[Error\\], text=null\\]\\]\\]",
                "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "UnHandled System Error!!"));

    }

    @Test
    public void test05_04_exceptionLoggerVariation() {
        driver.findElement(By.id("exceptionLoggerVariation_05_04")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.00.9999\\] DEFAULT ERROR", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.00.9999\\] DEFAULT ERROR", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "System Error..."));

    }

    @Test
    public void test05_05_exceptionLoggerVariation() {
        driver.findElement(By.id("exceptionLoggerVariation_05_05")).click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\]\\[5_5 Error \\]", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[e.xx.9999\\]\\[5_5 Error \\]", "INFO",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is(
                "5_5 Error"));

    }

    @Test
    public void test05_06_exceptionLoggerVariation() {
        driver.findElement(By.id("exceptionLoggerVariation_05_06")).click();

        assertThat(driver.getTitle(), is("System Error"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0001\\] 5_6 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger"), is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0001\\] 5_6 Error", "ERROR",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "System Error..."));

    }

    @Test
    public void test06_01_exceptionOccuresInSharedService() {
        driver.findElement(By.id("exceptionOccuresInSharedService_06_01"))
                .click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(1L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(1L));

        // output error message
        assertThat(driver.findElement(By.xpath("//li")).getText(), is("Error"));

    }

    @Test
    public void test06_02_exceptionOccuresInSharedService() {
        driver.findElement(By.id("exceptionOccuresInSharedService_06_02"))
                .click();

        assertThat(driver.getTitle(), is("terasoluna-gfw-functionaltest"));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN", "org.terasoluna.gfw.common.exception.ExceptionLogger"),
                is(0L));
        assertThat(dbLogProvider.countContainsMessageAndLevelsAndLogger(
                "\\[w.xx.0002\\] ResultMessages \\[type=error, list=\\[ResultMessage \\[code=null, args=\\[\\], text=Error\\]\\]\\]",
                "WARN",
                "org.terasoluna.gfw.common.exception.ExceptionLogger.Monitoring"),
                is(0L));

        // no exception
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Exception Handling Test"));

    }
}
