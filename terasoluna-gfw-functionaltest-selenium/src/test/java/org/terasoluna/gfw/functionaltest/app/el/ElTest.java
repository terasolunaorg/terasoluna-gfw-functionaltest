/*
 * Copyright (C) 2013-2015 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.el;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class ElTest extends FunctionTestSupport {

    private boolean acceptNextAlert = true;

    @Test
    public void test01_XSS_Measures() {

        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "<script>alert(\"XSS Attack\")</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_01 Test
        // It is an error if the dialog alert has gone out
        assertThat(driver.findElement(By.id("xssOutput")).getText(),
                is("<script>alert(\"XSS Attack\")</script>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "<script>alert('XSS Attack')</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_02 Test
        // It is an error if the dialog alert has gone out
        assertThat(driver.findElement(By.id("xssOutput")).getText(),
                is("<script>alert('XSS Attack')</script>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "Spring Framework", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_03 Test
        assertThat(driver.findElement(By.id("xssOutput")).getText(),
                is("Spring Framework"));
    }

    @Test
    public void test02_URL_Encoding() {

        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "http://localhost:8080/spring?hl=ja&tab=Tw#hl=ja&q=あいうえお",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_01 Test
        assertThat(
                driver.findElement(By.id("urlOutput")).getText(),
                is("http://localhost:8080/spring?hl%3Dja%26tab%3DTw%23hl%3Dja%26q%3D%E3%81%82%E3%81%84%E3%81%86%E3%81%88%E3%81%8A"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "http://localhost:8080/spring", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_02 Test
        assertThat(driver.findElement(By.id("urlOutput")).getText(),
                is("http://localhost:8080/spring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "TEST[]#+=&TEST", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_03 Test
        assertThat(driver.findElement(By.id("urlOutput")).getText(),
                is("TEST%5B%5D%23%2B%3D%26TEST"));
    }

    @Test
    public void test03_New_Line() throws IOException {

        driver.findElement(By.id("03")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "Spring\nmvc\nspring mvc", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 03_01 Test
        WebElement newLineOutput = driver.findElement(By.id("newLineOutput"));
        BufferedReader newLineOutputTextReader = new BufferedReader(new StringReader(
                newLineOutput.getText()));
        try {
            assertThat(newLineOutputTextReader.readLine(), is("Spring"));
            assertThat(newLineOutputTextReader.readLine(), is("mvc"));
            assertThat(newLineOutputTextReader.readLine(), is("spring mvc"));
            assertThat(newLineOutputTextReader.readLine(), nullValue());
        } finally {
            newLineOutputTextReader.close();
        }
        assertThat(newLineOutput.findElements(By.tagName("br")).size(), is(2));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("03")).click();

        inputFieldAccessor.overrideValue(By.id("text-output"), "Spring_Mvc",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 03_02 Test
        assertThat(driver.getPageSource().contains("Spring_Mvc"), is(true));
    }

    @Test
    public void test04_Cut_String() {

        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSpringS", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_01 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(),
                is("SpringSpringSpringSpringSpring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSprin", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_02 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(),
                is("SpringSpringSpringSpringSprin"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSpring", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_03 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(),
                is("SpringSpringSpringSpringSpring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "スプリングエムブイシー（ＳＰＲＩＮＧ　ＭＶＣ）、スプリングセキュリティー", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_04 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(),
                is("スプリングエムブイシー（ＳＰＲＩＮＧ　ＭＶＣ）、スプリングセ"));
    }

    @Test
    public void test05_URL_Link() {

        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789http://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_01 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(),
                is("123456789http://example.com/tour/ 01234567890"));
        // output link
        assertThat(driver.findElement(By.linkText("http://example.com/tour/"))
                .getText(), is("http://example.com/tour/"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789https://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_02 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(),
                is("123456789https://example.com/tour/ 01234567890"));
        // output link
        assertThat(driver.findElement(By.linkText("https://example.com/tour/"))
                .getText(), is("https://example.com/tour/"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("05_04")).click();
        inputFieldAccessor.overrideValue(By.id("text-outputQueryParam"),
                "tera&1", driver);
        driver.findElement(By.id("btn-output")).click();
        
        // output 05_04 Test
        assertThat(driver.findElement(By.id("linkUOutput")).getText(),
                is("http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"));
        // output link
        assertThat(driver.findElement(By.linkText("http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"))
                .getText(), is("http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"));
        // inheriting of query Test
        driver.findElement(By.id("linkUOutput")).findElement(
                By.linkText("http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261")).click();
    }

    @Test(expected = NoSuchElementException.class)
    public void test05_URL_NO_Link() {

        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789ttps://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_03 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(),
                is("123456789ttps://example.com/tour/ 01234567890"));

        try {
            // No link
            driver.findElement(By.linkText("ttps://example.com/tour/"));
            fail("error route");
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    @Test
    public void test06_Query_Display() {

        driver.findElement(By.id("06_01-02")).click();

        // output 06_01-02 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("Date=Tue%20Oct%2001%2000:00:00%20JST%202013&String=Spring&int=100"));
        assertThat(
                driver.findElement(By.id("noAndQueryOutput")).getText(),
                is("%26String=framework&Long=100&boolean=true&DateTime=10/1/13%2012:00%20AM"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "hoge", driver);
        new Select(driver.findElement(By.id("main")))
                .selectByVisibleText("YES");
        inputFieldAccessor.overrideValue(By.id("age"), "10", driver);
        inputFieldAccessor.overrideValue(By.id("dateOfBirth"), "2000-01-01", driver);
        new Select(driver.findElement(By.id("countries")))
                .selectByVisibleText("JA");
        driver.findElement(By.id("btn-output")).click();

        // output 06_03 Test
        assertThat(
                driver.findElement(
                        By.xpath("//a[contains(@href, '?page=1&size=10&age=10&countries=JA&dateOfBirth=2000-01-01&main=true&name=hoge')]"))
                        .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();
        driver.findElement(By.id("btn-output")).click();

        // output 06_04 Test
        assertThat(
                driver.findElement(
                        By.xpath("//a[contains(@href, '?page=1&size=10&age=0&countries=&dateOfBirth=&main=false&name=')]"))
                        .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"),
                "<script>alert('XSS Attack')</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_05 Test
        assertThat(
                driver.findElement(
                        By.xpath("//a[contains(@href, \"?page=1&size=10&age=0&countries=&dateOfBirth=&main=false&name=%253Cscript%253Ealert('XSS%2520Attack')%253C/script%253E\")]"))
                        .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "あいうえお", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_06 Test
        assertThat(
                driver.findElement(
                        By.xpath("//a[contains(@href, '?page=1&size=10&age=0&countries=&dateOfBirth=&main=false&name=%25E3%2581%2582%25E3%2581%2584%25E3%2581%2586%25E3%2581%2588%25E3%2581%258A')]"))
                        .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_07")).click();

        // output 06_07 Test
        assertThat(driver.findElement(By.id("queryOutput")).getText(), is(""));
        
        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();
        
        inputFieldAccessor.overrideValue(By.id("name"), "TEST[]#+=&TEST", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_08 Test
        assertThat(
                driver.findElement(
                        By.xpath("//a[contains(@href, '?page=1&size=10&age=0&countries=&dateOfBirth=&main=false&name=TEST%255B%255D%2523%252B%253D%2526TEST')]"))
                        .getText(), is("2"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_09")).click();
        driver.findElement(By.id("NestedJavaBean")).click();

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_09")).click();
        driver.findElement(By.id("NestedJavaBean")).click();

        // output 06_09 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("criteria.age=20&criteria.name=yamada&rememberCriteria=true"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_10")).click();
        driver.findElement(By.id("ListOfJavaBean")).click();

        // output 06_10 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("criteria%5B0%5D.age=20&criteria%5B0%5D.name=yamada&criteria%5B1%5D.age=50&criteria%5B1%5D.name=tanaka&operator=AND"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_11")).click();
        driver.findElement(By.id("SimpleJavaBeanAndListOfJavaBean")).click();

        // output 06_11 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("criteria.age=30&criteria.name=suzuki&users%5B0%5D.age=20&users%5B0%5D.name=yamada&users%5B1%5D.age=50&users%5B1%5D.name=tanaka"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_12")).click();
        driver.findElement(By.id("MapOfJavaBean")).click();

        // output 06_12 Test
        assertThat(driver.findElement(By.id("queryOutput")).getText(),
                is("etc%5Baaa%5D=111&etc%5Bbbb%5D=222&etc%5Bccc%5D=333"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_13")).click();
        driver.findElement(By.id("DateTimeFormat")).click();

        // output 06_13 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("date=2015-04-01&item.date=2015-05-01&item.localDate=2015-07-10&localDate=2015-06-10"));

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_14")).click();
        driver.findElement(By.id("Array")).click();

        // output 06_14 Test
        assertThat(
                driver.findElement(By.id("queryOutput")).getText(),
                is("array1%5B0%5D=1&array1%5B1%5D=2&array1%5B2%5D=3&array2%5B0%5D=1.1&array2%5B1%5D=1.2&array3%5B0%5D=4&array3%5B1%5D=5&array3%5B2%5D=6&array4%5B0%5D=a&array4%5B1%5D=b&array4%5B2%5D=c&item.array1%5B0%5D=11&item.array1%5B1%5D=12&item.array1%5B2%5D=13&item.array2%5B0%5D=11.1&item.array2%5B1%5D=11.2&item.array3%5B0%5D=14&item.array3%5B1%5D=15&item.array3%5B2%5D=16&item.array4%5B0%5D=d&item.array4%5B1%5D=e&item.array4%5B2%5D=f"));
    }

    @Test
    public void test07_JavaScript_XSS_Measures() {
        driver.findElement(By.id("07_01")).click();
        driver.findElement(By.id("write")).click();

        // output 07_01 Test
        assertThat(
                driver.findElement(By.id("message")).getText(),
                is("<script></script><script>alert('XSS Attack');</script></script> <h2>JavaScript XSS Measures f:js()</h2>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("07_02")).click();
        driver.findElement(By.id("write")).click();

        // output 07_02 Test
        assertThat(
                driver.findElement(By.id("message")).getText(),
                is("<script></script><script>alert(\"XSS Attack\");</script></script> <h2>JavaScript XSS Measures f:js()</h2>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("07_03")).click();
        driver.findElement(By.id("write")).click();

        // output 07_03 Test
        assertThat(
                driver.findElement(By.id("message")).getText(),
                is("<script>Spring Framework</script> <h2>JavaScript XSS Measures f:js()</h2>"));

    }

    @Test
    public void test08_EventHandler_XSS_Measures() {
        driver.findElement(By.id("08_01")).click();
        driver.findElement(By.id("write")).click();

        // output 08_01 Test
        assertThat(closeAlertAndGetItsText(),
                is("input ');alert('XSS Attack');// . )"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("08_02")).click();
        driver.findElement(By.id("write")).click();

        // output 08_02 Test
        assertThat(closeAlertAndGetItsText(),
                is("input ');alert(\"XSS Attack\");// . )"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("08_03")).click();
        driver.findElement(By.id("write")).click();

        // output 08_03 Test
        assertThat(closeAlertAndGetItsText(), is("input Spring Framework"));

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
