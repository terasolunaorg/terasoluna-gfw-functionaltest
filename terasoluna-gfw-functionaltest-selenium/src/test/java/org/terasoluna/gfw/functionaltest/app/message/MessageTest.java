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
package org.terasoluna.gfw.functionaltest.app.message;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class MessageTest extends FunctionTestSupport {

    public MessageTest() {
    }

    @Before
    public void setupDefaultLanguage() {
        driver.findElement(By.id("English")).click();
    }

    @Test
    public void test01_01_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_02_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]"))
                .getText(), is("Hello World!!"));
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]"))
                .getText(), is("Hello Message!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getTagName(), is("div"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_03_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("Error Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_04_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-info"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-info"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_05_01_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_05_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-warn"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warn"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_05_02_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_05_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-warn"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_06_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_06")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_07_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_07")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-danger"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-danger"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_08_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_08")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("Error Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_09_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_09")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_10_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_10")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello Terasoluna!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello Terasoluna!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_11_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_11")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello Terasoluna!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello Terasoluna!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_12_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_12")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_13_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_13")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Terasoluna !!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Terasoluna !!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_01_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_01"))
                .click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_02_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_02"))
                .click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getText(),
                is("Error Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_03_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_03"))
                .click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getText(),
                is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_04_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_04"))
                .click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]"))
                .getText(), is("Hello World!!"));
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]"))
                .getText(), is("Hello Message!!"));

        // <div> Tag class is "alert"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getTagName(),
                is("div"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_01_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_01")).click();

        // table tr td Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/table/tbody/tr/td")).getText(), is(
                        "Hello World!!"));

        // <table> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector(
                "table.alert.alert-success")).getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_02_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_02")).click();

        // p Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/p[1]"))
                .getText(), is("Hello World!!"));

        // <p> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("p.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_03_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_03")).click();

        // div Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div")).getText(),
                is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_04_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_04")).click();

        // span Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/span"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_05_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_05")).click();

        // error screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Servlet Error..."));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test04_01_panelClassSpecified() {
        driver.findElement(By.id("panelClassSpecified_04_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "label label-success"
        assertThat(driver.findElement(By.cssSelector("div.label.label-success"))
                .getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test04_02_panelClassSpecified() {
        driver.findElement(By.id("panelClassSpecified_04_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "success"
        assertThat(driver.findElement(By.cssSelector("div.success")).getText(),
                is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_01_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Warn Message!!"));

        // <div> Tag class is "alert alert-warn"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning"))
                .getText(), is("Warn Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_02_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Warn Message!!"));

        // <div> Tag class is "alert alert-warn"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning"))
                .getText(), is("Warn Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_03_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]"))
                .getText(), is("Warn Message!!"));
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-warn"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning"))
                .getTagName(), is("div"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_01_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Notice!!"));

        // <div> Tag class is "alert notice"
        assertThat(driver.findElement(By.cssSelector("div.alert.notice"))
                .getText(), is("Notice!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_02_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Error !!"));

        // <div> Tag class is "alert error"
        assertThat(driver.findElement(By.cssSelector("div.alert.error"))
                .getText(), is("Error !!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_03_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Success !!"));

        // <div> Tag class is "alert success"
        assertThat(driver.findElement(By.cssSelector("div.alert.success"))
                .getText(), is("Success !!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_04_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Info !!"));

        // <div> Tag class is "alert info"
        assertThat(driver.findElement(By.cssSelector("div.alert.info"))
                .getText(), is("Info !!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_01_outputMessage() {
        driver.findElement(By.id("outputMessage_07_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]"))
                .getText(), is("Hello World!!"));
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]"))
                .getText(), is("Hello Message!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getTagName(), is("div"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_02_outputMessage() {
        driver.findElement(By.id("outputMessage_07_02")).click();

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Servlet Error..."));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_03_outputMessage() {
        driver.findElement(By.id("Japanese")).click();
        driver.findElement(By.id("outputMessage_07_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("エラーメッセージ！！"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("エラーメッセージ！！"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_04_outputMessage() {
        driver.findElement(By.id("outputMessage_07_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("Error Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_05_outputMessage() {
        driver.findElement(By.id("outputMessage_07_05")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li"))
                .getText(), is("Hello World!!"));
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li"))
                .getText(), is("Error Message!!"));

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success"))
                .getText(), is("Hello World!!"));

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error"))
                .getText(), is("Error Message!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test08_01_styleChangeScreen() {
        driver.findElement(By.id("styleChangeScreen_08_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div")).getText(),
                is("Hello World!!"));

        // <div> Tag class is "message message-success"
        assertThat(driver.findElement(By.cssSelector(
                "div.message.message-success")).getText(), is("Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test09_01_disableHtmlEscape() {
        driver.findElement(By.id("disableHtmlEscape_09_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.id("messagesPanel")).getText(), is(
                "<div>Hello World!!</div>"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test09_02_disableHtmlEscape() {
        driver.findElement(By.id("disableHtmlEscape_09_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.id("messagesPanel")).getText(), is(
                "Hello World!!"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test10_01_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_01")).click();

        // innerElement close with </li> confirm
        assertThat(driver.getPageSource().contains(
                "<div class=\"alert alert-success\"><ul><li></li></ul></div>"),
                is(true));

        // page source
        pageSource.save(driver);
    }

    @Test
    public void test10_02_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_02")).click();

        // outerElement close with </ul> confirm
        assertThat(driver.getPageSource().contains(
                "<div class=\"alert alert-success\"><ul></ul></div>"), is(
                        true));

        // page source
        pageSource.save(driver);
    }

    @Test
    public void test10_03_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_03")).click();

        // panelElement close with </div> confirm
        assertThat(driver.getPageSource().contains(
                "<div class=\"alert alert-success\"></div>"), is(true));

        // page source
        pageSource.save(driver);
    }

}
