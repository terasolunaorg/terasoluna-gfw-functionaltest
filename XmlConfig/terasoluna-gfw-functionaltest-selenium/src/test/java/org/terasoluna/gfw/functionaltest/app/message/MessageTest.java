/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

public class MessageTest extends FunctionTestSupport {

    public MessageTest() {}

    @BeforeEach
    public void setupDefaultLanguage() {
        driver.findElement(By.id("English")).click();
    }

    @Test
    public void test01_01_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_02_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]")).getText())
                .isEqualTo("Hello World!!");
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]")).getText())
                .isEqualTo("Hello Message!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getTagName())
                .isEqualTo("div");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_03_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("Error Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_04_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-info"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-info")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_05_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_05")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-warning"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_06_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_06")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_07_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_07")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-danger"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_08_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_08")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-primary"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-primary")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_09_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_09")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-secondary"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-secondary")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_10_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_10")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-light"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-light")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_11_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_11")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-dark"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-dark")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_12_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_12")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("Error Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_13_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_13")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_14_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_14")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello Terasoluna!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello Terasoluna!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_15_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_15")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello Terasoluna!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello Terasoluna!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_16_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_16")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_17_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_01_17")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Terasoluna !!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Terasoluna !!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_01_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_02_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getText())
                .isEqualTo("Error Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_03_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test02_04_messagesAttributeNameSpecified() {
        driver.findElement(By.id("messagesAttributeNameSpecified_02_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]")).getText())
                .isEqualTo("Hello World!!");
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]")).getText())
                .isEqualTo("Hello Message!!");

        // <div> Tag class is "alert"
        assertThat(driver.findElement(By.cssSelector("div.alert")).getTagName()).isEqualTo("div");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_01_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_01")).click();

        // table tr td Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td")).getText())
                .isEqualTo("Hello World!!");

        // <table> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("table.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_02_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_02")).click();

        // p Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/p[1]")).getText())
                .isEqualTo("Hello World!!");

        // <p> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("p.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_03_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_03")).click();

        // div Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_04_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_04")).click();

        // span Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/span")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_05_elementSpecified() {
        driver.findElement(By.id("elementSpecified_03_05")).click();

        // error screen
        webDriverWait.until(textToBe(By.cssSelector("h2"), "Servlet Error..."));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test04_01_panelClassSpecified() {
        driver.findElement(By.id("panelClassSpecified_04_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "label label-success"
        assertThat(driver.findElement(By.cssSelector("div.label.label-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test04_02_panelClassSpecified() {
        driver.findElement(By.id("panelClassSpecified_04_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "success"
        assertThat(driver.findElement(By.cssSelector("div.success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_01_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Warn Message!!");

        // <div> Tag class is "alert alert-warning"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning")).getText())
                .isEqualTo("Warn Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_02_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Warn Message!!");

        // <div> Tag class is "alert alert-warning"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning")).getText())
                .isEqualTo("Warn Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test05_03_messagesTypeSpecified() {
        driver.findElement(By.id("messagesTypeSpecified_05_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]")).getText())
                .isEqualTo("Warn Message!!");
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-warning"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-warning")).getTagName())
                .isEqualTo("div");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_01_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Notice!!");

        // <div> Tag class is "alert notice"
        assertThat(driver.findElement(By.cssSelector("div.alert.notice")).getText())
                .isEqualTo("Notice!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_02_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Error !!");

        // <div> Tag class is "alert error"
        assertThat(driver.findElement(By.cssSelector("div.alert.error")).getText())
                .isEqualTo("Error !!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_03_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Success !!");

        // <div> Tag class is "alert success"
        assertThat(driver.findElement(By.cssSelector("div.alert.success")).getText())
                .isEqualTo("Success !!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test06_04_customResultMessageTypeImpl() {
        driver.findElement(By.id("customResultMessageTypeImpl_06_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Info !!");

        // <div> Tag class is "alert info"
        assertThat(driver.findElement(By.cssSelector("div.alert.info")).getText())
                .isEqualTo("Info !!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_01_outputMessage() {
        driver.findElement(By.id("outputMessage_07_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[1]")).getText())
                .isEqualTo("Hello World!!");
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li[2]")).getText())
                .isEqualTo("Hello Message!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getTagName())
                .isEqualTo("div");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_02_outputMessage() {
        driver.findElement(By.id("outputMessage_07_02")).click();

        // error screen
        webDriverWait.until(textToBe(By.cssSelector("h2"), "Servlet Error..."));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_03_outputMessage() {
        driver.findElement(By.id("Japanese")).click();
        driver.findElement(By.id("outputMessage_07_03")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("エラーメッセージ！！");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("エラーメッセージ！！");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_04_outputMessage() {
        driver.findElement(By.id("outputMessage_07_04")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div/ul/li")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("Error Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test07_05_outputMessage() {
        driver.findElement(By.id("outputMessage_07_05")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li")).getText())
                .isEqualTo("Hello World!!");
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li")).getText())
                .isEqualTo("Error Message!!");

        // <div> Tag class is "alert alert-success"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-success")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "alert alert-error"
        assertThat(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())
                .isEqualTo("Error Message!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test08_01_styleChangeScreen() {
        driver.findElement(By.id("styleChangeScreen_08_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.xpath("/html/body/div/div")).getText())
                .isEqualTo("Hello World!!");

        // <div> Tag class is "message message-success"
        assertThat(driver.findElement(By.cssSelector("div.message.message-success")).getText())
                .isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test09_01_disableHtmlEscape() {
        driver.findElement(By.id("disableHtmlEscape_09_01")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.id("messagesPanel")).getText())
                .isEqualTo("<div>Hello World!!</div>");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test09_02_disableHtmlEscape() {
        driver.findElement(By.id("disableHtmlEscape_09_02")).click();

        // div ul li Tag confirm
        // Message Confirm
        assertThat(driver.findElement(By.id("messagesPanel")).getText()).isEqualTo("Hello World!!");

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test10_01_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_01")).click();

        // innerElement close with </li> confirm
        assertThat(driver.getPageSource()
                .contains("<div class=\"alert alert-success\"><ul><li></li></ul></div>"))
                        .isEqualTo(true);

        // page source
        pageSource.save(driver);
    }

    @Test
    public void test10_02_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_02")).click();

        // outerElement close with </ul> confirm
        assertThat(driver.getPageSource()
                .contains("<div class=\"alert alert-success\"><ul></ul></div>")).isEqualTo(true);

        // page source
        pageSource.save(driver);
    }

    @Test
    public void test10_03_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_10_03")).click();

        // panelElement close with </div> confirm
        assertThat(driver.getPageSource().contains("<div class=\"alert alert-success\"></div>"))
                .isEqualTo(true);

        // page source
        pageSource.save(driver);
    }

}
