/*
 * Copyright (C) 2013-2016 NTT DATA Corporation
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
package org.terasoluna.gfw.functionaltest.app.logging;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class LoggingTest extends FunctionTestSupport {

    @Inject
    protected RestTemplate restTemplate;

    @Test
    public void test01_01_createDefaultXTrackMDC() {
        driver.findElement(By.id("xTrackMDCPutFilter")).click();

        // create default x-Track MDC
        driver.findElement(By.id("xTrackMDCPutFilterDefault")).click();

        // cut x-Track MDC
        String targetMdc = driver.findElement(By.id("xTrackMDC")).getText();
        String footerMdc = driver.findElement(By.cssSelector("p")).getText();
        footerMdc = footerMdc.substring(footerMdc.indexOf(":") + 1, footerMdc
                .indexOf(":") + 33);
        // check default x-Track MDC
        assertTrue(targetMdc.matches("[0-9a-zA-Z]{32}"));
        assertThat(targetMdc, is(footerMdc));
    }

    @Test
    public void test01_02_createCustomXTrackMDC() {
        driver.findElement(By.id("xTrackMDCPutFilter")).click();

        // create default x-Track MDC
        driver.findElement(By.id("xTrackMDCPutFilterCustom")).click();

        // cut x-Track MDC
        String targetMdc = driver.findElement(By.id("xTrackMDC")).getText();
        String footerMdc = driver.findElement(By.cssSelector("p")).getText();
        footerMdc = footerMdc.substring(footerMdc.indexOf(":") + 1, footerMdc
                .indexOf(":") + 33);
        // check custom x-Track MDC
        assertTrue(targetMdc.matches("[0-9a-zA-Z]{32}"));
        assertThat(targetMdc, not(footerMdc));
    }

    @Test
    public void test01_04_checkConsistencyXtrackMDCRequestToResponse() {
        // test Check consistency HTTP Request Header to Response Header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("X-Track", "12345678901234567890123456789012");
        ResponseEntity<byte[]> response = restTemplate.exchange(
                applicationContextUrl + "/logging/xTrackMDCPutFilter/1_4",
                HttpMethod.GET, new HttpEntity<byte[]>(requestHeaders),
                byte[].class);

        HttpHeaders headers = response.getHeaders();
        assertThat(headers.getFirst("X-Track"),
                is("12345678901234567890123456789012"));
    }

    @Test
    public void test01_05_checkSameTransactionXTrackMDC() {
        driver.findElement(By.id("xTrackMDCPutFilter")).click();

        // create default x-Track MDC
        driver.findElement(By.id("xTrackMDCPutFilterDefault")).click();

        // check XTrack logging same transaction
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test01_06_checkLoggingSameXtrackMDCRequestToLog() {
        driver.findElement(By.id("xTrackMDCPutFilter")).click();

        // create default x-Track MDC
        driver.findElement(By.id("xTrackMDCPutFilterDefault")).click();

        // cut x-Track MDC
        String targetMdc = driver.findElement(By.id("xTrackMDC")).getText();

        // logging same x-track MDC HTTP Request Header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("X-Track", targetMdc);
        restTemplate.exchange(applicationContextUrl
                + "/logging/xTrackMDCPutFilter/1_4", HttpMethod.GET,
                new HttpEntity<byte[]>(requestHeaders), byte[].class);

        // check XTrack logging same transaction in HTTP Request Header to logfile
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test02_01_createDefaultUserIdMDCBeforeLogin() {
        // setup
        driver.findElement(By.id("userIdMDCPutFilter")).click();
        // login -> logout
        inputFieldAccessor.overrideValue(By.id("username"), "user1", driver);
        inputFieldAccessor.overrideValue(By.id("password"), "user1", driver);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("logout")).click();

        // create default userId MDC
        driver.findElement(By.id("userIdMDCPutFilterDefault")).click();

        // check default userId MDC
        assertThat(driver.findElement(By.id("userIdMDC")).getText(),
                is("anonymousUser"));
    }

    @Test
    public void test02_02_createCustomUserIdMDCBeforeLogin() {
        // setup
        driver.findElement(By.id("userIdMDCPutFilter")).click();
        // login -> logout
        inputFieldAccessor.overrideValue(By.id("username"), "user1", driver);
        inputFieldAccessor.overrideValue(By.id("password"), "user1", driver);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("logout")).click();

        // create custom userId MDC
        driver.findElement(By.id("userIdMDCPutFilterCustom")).click();

        // check custom userId MDC
        assertThat(driver.findElement(By.id("userIdMDC")).getText(),
                is("anonymousUser"));
    }

    @Test
    public void test02_04_createCustomUserIdMDCBeforeLogin() {
        driver.findElement(By.id("userIdMDCPutFilter")).click();

        // authentication as username "user1"
        inputFieldAccessor.overrideValue(By.id("username"), "user1", driver);
        inputFieldAccessor.overrideValue(By.id("password"), "user1", driver);
        driver.findElement(By.id("btn1")).click();

        // create default userId MDC
        driver.findElement(By.id("userIdMDCPutFilterDefault")).click();

        // check default userId MDC
        assertThat(driver.findElement(By.id("userIdMDC")).getText(),
                is("user1"));
    }

    @Test
    public void test02_06_createCustomUserIdMDCBeforeLogin() {
        driver.findElement(By.id("userIdMDCPutFilter")).click();

        // authentication as username "user1"
        inputFieldAccessor.overrideValue(By.id("username"), "user1", driver);
        inputFieldAccessor.overrideValue(By.id("password"), "user1", driver);
        driver.findElement(By.id("btn1")).click();

        // Screen transition
        driver.findElement(By.linkText("terasoluna-gfw-functionaltest"))
                .click();
        driver.findElement(By.id("logging")).click();
        driver.findElement(By.id("userIdMDCPutFilter")).click();

        // create default userId MDC
        driver.findElement(By.id("userIdMDCPutFilterDefault")).click();

        // check default userId MDC
        assertThat(driver.findElement(By.id("userIdMDC")).getText(),
                is("user1"));

        // check trace logging
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test04_01_defaultTraceLoggingAsTraceLevel() {
        driver.findElement(By.id("traceLoggingInterceptor")).click();

        // access to the controller default warn handling nanos
        driver.findElement(By.id("traceLoggingDefaultAsTraceLevel")).click();

        // check trace logging
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test04_02_defaultTraceLoggingAsWarnLevel() {
        driver.findElement(By.id("traceLoggingInterceptor")).click();

        // access to the controller more than the set default warn handling nanos
        driver.findElement(By.id("traceLoggingDefaultAsWarnLevel")).click();

        // check warn logging
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test04_03_customTraceLoggingAsTraceLevel() {
        driver.findElement(By.id("traceLoggingInterceptor")).click();

        // access to the controller custom warn handling nanos
        driver.findElement(By.id("traceLoggingCustomAsTraceLevel")).click();

        // check trace logging
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }

    @Test
    public void test04_04_customTraceLoggingAsWarnLevel() {
        driver.findElement(By.id("traceLoggingInterceptor")).click();

        // access to the controller more than the set default warn handling nanos
        driver.findElement(By.id("traceLoggingCustomAsWarnLevel")).click();

        // check warn logging
        // check visually the log file
        // filename:traceLoggingInterceptorTest.log
    }
}
