/*
 * Copyright (C) 2013 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.csrf;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class CsrfTest extends FunctionTestSupport {

    @Inject
    protected RestTemplate restTemplate;

    private boolean acceptNextAlert = true;

    private JavascriptExecutor jse;

    @Before
    public void setUp() {
        jse = (JavascriptExecutor) driver;
    }

    @Test
    public void test01_CsrfTokenSendByForm() {
        // 1.1 Test start
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('type', 'text');");

        driver.findElement(By.id("csrf_1_1")).click();

        // Normal screen transition
        assertThat(driver.findElement(By.id("testName")).getText(),
                is("springFormNormalCsrfTokenSend_HttpMethodGet_01_01"));

        screenCapture.save(driver);

        // 1.2 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[1].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[1].value = '123456abc9876abc';");

        driver.findElement(By.id("csrf_1_2")).click();

        // Normal screen transition
        assertThat(driver.findElement(By.id("testName")).getText(),
                is("springFormAlterCsrfTokenSend_HttpMethodGet_01_02"));

        screenCapture.save(driver);

        // 1.3 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[2].setAttribute('type', 'text');");

        driver.findElement(By.id("csrf_1_3")).click();

        // Normal screen transition
        assertThat(driver.findElement(By.id("testName")).getText(),
                is("springFormNormalCsrfTokenSend_HttpMethodPost_01_03"));

        screenCapture.save(driver);

        // 1.4 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[3].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[3].value = '123456abc9876abc';");

        driver.findElement(By.id("csrf_1_4")).click();

        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));

        screenCapture.save(driver);

        try {
            restTemplate.exchange(applicationContextUrl + "/csrf/1_4",
                    HttpMethod.POST, new HttpEntity<byte[]>(new HttpHeaders()),
                    byte[].class);
            fail("error route");
        } catch (HttpClientErrorException e) {
            // HttpStatusCode 403 return
            assertThat(e.getStatusCode(), is(HttpStatus.FORBIDDEN));
        }

        // 1.5 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[4].setAttribute('type', 'text');");

        driver.findElement(By.id("csrf_1_5")).click();

        // Normal screen transition
        assertThat(driver.findElement(By.id("testName")).getText(),
                is("formNormalCsrfTokenSend_HttpMethodPost_01_05"));

        screenCapture.save(driver);

        // 1.6 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[5].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[5].value = '123456abc9876abc';");

        driver.findElement(By.id("csrf_1_6")).click();

        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));

        screenCapture.save(driver);

        try {
            restTemplate.exchange(applicationContextUrl + "/csrf/1_6",
                    HttpMethod.POST, new HttpEntity<byte[]>(new HttpHeaders()),
                    byte[].class);
            fail("error route");
        } catch (HttpClientErrorException e) {
            // HttpStatusCode 403 return
            assertThat(e.getStatusCode(), is(HttpStatus.FORBIDDEN));
        }
    }

    @Test
    public void test02_CsrfTokenSendByHead() {
        // 2.1 Test start
        driver.findElement(By.id("csrf_2_1")).click();
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.2 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_2")).click();

        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('content', '123456abc9876abc');");

        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.3 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_3")).click();
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.4 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_4")).click();

        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('content', '123456abc9876abc');");

        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 403 return
        assertThat(closeAlertAndGetItsText(), is("403"));
        screenCapture.save(driver);

        // 2.5 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_5")).click();

        jse.executeScript("document.getElementsByName('_csrf')[1].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[1].value = '123456abc9876abc';");
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);
        
        // 2.6 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_6")).click();
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.7 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_7")).click();

        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('content', '123456abc9876abc');");

        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 403 return
        assertThat(closeAlertAndGetItsText(), is("403"));
        screenCapture.save(driver);
        
        // 2.8 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_8")).click();
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.9 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_9")).click();

        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('content', '123456abc9876abc');");

        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 403 return
        assertThat(closeAlertAndGetItsText(), is("403"));
        screenCapture.save(driver);
        
        // 2.10 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_10")).click();
        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 200 return
        assertThat(closeAlertAndGetItsText(), is("200"));
        screenCapture.save(driver);

        // 2.11 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_2_11")).click();

        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('content', '123456abc9876abc');");

        driver.findElement(By.id("ajaxButton")).click();

        // HttpStatusCode 403 return
        assertThat(closeAlertAndGetItsText(), is("403"));
    }

    @Test
    public void test03_CsrfTokenSendByForm_MultiPart() {

        ClassPathResource images = new ClassPathResource("/image/Duke.png");
        String imagePath = "";
        try {
            imagePath = images.getFile().getAbsolutePath();
        } catch (IOException e) {
            fail(e.toString());
        }
        
        // 3.1 Test start
        driver.findElement(By.id("csrf_3_1")).click();
        driver.findElement(By.id("springFormFileBtn")).sendKeys(imagePath);
        
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('type', 'text');");
        
        driver.findElement(By.id("springFormSubmitBtn")).click();
        
        // upload finish
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("CSRF Test"));
        screenCapture.save(driver);
        
        // 3.2 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_3_2")).click();
        driver.findElement(By.id("springFormFileBtn")).sendKeys(imagePath);
        
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[0].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[0].value = '123456abc9876abc';");

        driver.findElement(By.id("springFormSubmitBtn")).click();
        
        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));
        screenCapture.save(driver);
        
        // 3.3 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_3_3")).click();
        driver.findElement(By.id("formFileBtn")).sendKeys(imagePath);
        
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[1].setAttribute('type', 'text');");
        
        driver.findElement(By.id("formSubmitBtn")).click();
        
        // upload finish
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("CSRF Test"));
        screenCapture.save(driver);
        
        // 3.4 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_3_4")).click();
        driver.findElement(By.id("formFileBtn")).sendKeys(imagePath);
        
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[1].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[1].value = '123456abc9876abc';");

        driver.findElement(By.id("formSubmitBtn")).click();
        
        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));
        screenCapture.save(driver);
        
        // 3.5 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_3_5")).click();
        driver.findElement(By.id("queryFileBtn")).sendKeys(imagePath);
        
        driver.findElement(By.id("querySubmitBtn")).click();
        
        // upload finish
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("CSRF Test"));
        screenCapture.save(driver);
        
        // 3.6 Test start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        driver.findElement(By.id("csrf_3_6")).click();
        driver.findElement(By.id("queryFileBtn")).sendKeys(imagePath);
        
        // CsrfToken setting check
        String alterUrI = "/" + contextName + "/csrf/fileUpload?_csrf=123456789abcdef9876";
        jse.executeScript("document.getElementById('queryFileForm').setAttribute('action', '" + alterUrI + "');");

        driver.findElement(By.id("querySubmitBtn")).click();
        
        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));
    }

    @Test
    public void test04_CsrfCustomFunction() {

        // 4.1 Test Start
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[6].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[6].value = '123456abc9876abc';");

        driver.findElement(By.id("csrf_4_1")).click();
        
        // Access Denied Screen 
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("Access Denied"));
        screenCapture.save(driver);
        
        try {
            restTemplate.exchange(applicationContextUrl + "/csrf/errorPageNotSet/4_1",
                    HttpMethod.POST, new HttpEntity<byte[]>(new HttpHeaders()),
                    byte[].class);
            fail("error route");
        } catch (HttpClientErrorException e) {
            // HttpStatusCode 403 return
            assertThat(e.getStatusCode(), is(HttpStatus.FORBIDDEN));
        }
        
        // 4.2 Test Start
        driver.get(applicationContextUrl);
        driver.findElement(By.id("CSRF")).click();
        
        // CsrfToken setting check
        jse.executeScript("document.getElementsByName('_csrf')[7].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_csrf')[7].value = '123456abc9876abc';");

        driver.findElement(By.id("csrf_4_2")).click();
        
        // CSRFToken Not Match
        assertThat(driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("CSRF Attack Token Detected"));
        screenCapture.save(driver);
        
        try {
            restTemplate.exchange(applicationContextUrl + "/csrf/notAcceptable/4_2",
                    HttpMethod.POST, new HttpEntity<byte[]>(new HttpHeaders()),
                    byte[].class);
            fail("error route");
        } catch (HttpClientErrorException e) {
            // HttpStatusCode 406 return
            assertThat(e.getStatusCode(), is(HttpStatus.NOT_ACCEPTABLE));
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
