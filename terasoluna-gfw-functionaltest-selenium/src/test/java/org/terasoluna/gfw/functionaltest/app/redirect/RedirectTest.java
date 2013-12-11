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
package org.terasoluna.gfw.functionaltest.app.redirect;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class RedirectTest extends FunctionTestSupport {

    @Inject
    protected WebDriver driver;

    public RedirectTest() {
    }

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(applicationContextUrl);
        driver.findElement(By.id("Redirect")).click();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_01_redirectToValidInternalLink() {

        driver.findElement(By.id("listWithInternalPath")).click();
        driver.findElement(By.id("btn1")).click();

        // confirms that login page contains redirectTo hidden element with destination to detail page
        assertThat(getRedirectValue(),
                is("/" + contextName + "/redirect/detail/user1"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        driver.findElement(By.id("btn1")).click();
        
        // confirms that transition was made to detail.jsp with the below assertions
        assertThat(driver.findElement(By.id("username")).getText(), is("user1"));
        assertThat(driver.findElement(By.id("name")).getText(), is("Tarou"));
        assertThat(driver.findElement(By.id("address")).getText(), is("Tokyo"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();

    }

    @Test
    public void test01_02_hiddenRedirectToNotDefined() {

        driver.findElement(By.id("listWithNoPath")).click();
        driver.findElement(By.id("btn1")).click();

        // confirms that login page contains redirectTo hidden tag with external link
        assertThat(getRedirectValue(), is(""));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        driver.findElement(By.id("btn1")).click();

        // confirms that transition was made to the context-root
        assertThat(driver.findElement(By.id("Redirect")).getText(),
                is("Redirect Function Test"));

    }

    @Test
    public void test01_03_redirectToExternalLink() {

        driver.findElement(By.id("listWithExternalPath")).click();
        driver.findElement(By.id("btn1")).click();

        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        
        // confirms that login page contains redirectTo hidden tag with external link
        assertThat(getRedirectValue(), is("http://www.google.com/aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();

        // confirms that 404 error occurred after login transition
        assertThat(
                driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("Page Not Found"));

    }

    @Test
    public void test01_04_targetUrlParameterChangedToGoTo() {

        driver.findElement(By.id("listWithGoTo")).click();
        driver.findElement(By.id("btn1")).click();

        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        
        // confirms that login page contains goTo hidden element with destination to detail page
        assertThat(driver.findElement(By.name("goTo")).getAttribute("value"),
                is("/" + contextName + "/redirect/detail/user1"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();

        // confirms that transition was made to detail.jsp with the below assertions
        assertThat(driver.findElement(By.id("username")).getText(), is("user1"));
        assertThat(driver.findElement(By.id("name")).getText(), is("Tarou"));
        assertThat(driver.findElement(By.id("address")).getText(), is("Tokyo"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();
    }

    @Test
    public void test01_05_redirectToValidInternalLink() {

        driver.findElement(By.id("listWithInternalPath")).click();
        driver.findElement(By.id("btn1")).click();

        // confirms that login page contains redirectTo hidden element with destination to detail page
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user1");
        assertThat(getRedirectValue(),
                is("/" + contextName + "/redirect/detail/user1"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();
        
        // error message
        assertThat(driver.findElement(By.xpath("//form[@id='command']/div/ul/li")).getText(), is("Bad credentials"));
        
        // not delete redirectTo value
        assertThat(getRedirectValue(),
                is("/" + contextName + "/redirect/detail/user1"));

        
        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        driver.findElement(By.id("btn1")).click();
        
        // confirms that transition was made to detail.jsp with the below assertions
        assertThat(driver.findElement(By.id("username")).getText(), is("user1"));
        assertThat(driver.findElement(By.id("name")).getText(), is("Tarou"));
        assertThat(driver.findElement(By.id("address")).getText(), is("Tokyo"));

        // screen capture
        screenCapture.save(driver);
        
        driver.findElement(By.id("btn1")).click();

    }
    
    
    @Test
    public void test02_01_linkInWhiteList() {

        driver.findElement(By.id("listWithLinkInWhiteList")).click();
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        driver.findElement(By.id("btn1")).click();

        // confirms that transition is made to external link
        assertThat(driver.getCurrentUrl()
                .startsWith("http://egg.nttdata.co.jp"), is(true));
    }

    @Test
    public void test02_02_linkNotInWhiteList() {

        driver.findElement(By.id("listWithLinkNotInWhiteList")).click();
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("user1");
        driver.findElement(By.id("btn1")).click();
        
        // confirms that 403 error occurred after login transition
        assertThat(
                driver.findElement(By.xpath("/html/body/div/h2")).getText(),
                is("Access Denied"));
    }
    
    private String getRedirectValue () {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('redirect').setAttribute('type', 'text');");
        return driver.findElement(By.id("redirect")).getAttribute("value");
    }
}
