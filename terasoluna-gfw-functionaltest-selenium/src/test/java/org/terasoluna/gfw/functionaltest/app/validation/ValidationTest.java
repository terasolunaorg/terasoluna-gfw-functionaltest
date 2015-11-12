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
package org.terasoluna.gfw.functionaltest.app.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class ValidationTest extends FunctionTestSupport {

    private static final String SUCCESS = "Validation successfully!";

    public ValidationTest() {
    }

    @Test
    public void test01_01_ByteMin_valid() {
        click(By.linkText("@ByteMin Test"));

        setText(By.id("userName"), "あいう");
        click(By.id("btn_validate"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test01_02_ByteMin_invalid() {
        click(By.linkText("@ByteMin Test"));

        setText(By.id("userName"), "あいu");
        click(By.id("btn_validate"));
        assertThat(getText(By.id("userName.errors")),
                is("must be grater than or equal 6 Bytes"));
    }

    @Test
    public void test02_01_ByteMax_valid() {
        click(By.linkText("@ByteMax Test"));

        setText(By.id("userName"), "あいう");
        click(By.id("btn_validate"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test02_02_ByteMax_invalid() {
        click(By.linkText("@ByteMax Test"));

        setText(By.id("userName"), "あいうe");
        click(By.id("btn_validate"));
        assertThat(getText(By.id("userName.errors")),
                is("must be less than or equal 6 Bytes"));
    }

    @Test
    public void test03_01_Compare_valid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "100");
        click(By.id("btn_validate"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test03_02_Compare_invalid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_eq"));
        assertThat(getText(By.id("left.errors")),
                is("not match left and right"));
    }

    @Test
    public void test03_03_Compare_Operator_Equal_valid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "100");
        click(By.id("btn_eq"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test03_04_Compare_Operator_Equal_invalid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_eq"));
        assertThat(getText(By.id("left.errors")),
                is("not match left and right"));
    }

    @Test
    public void test03_05_Compare_Operator_GraterThan_valid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "99");
        click(By.id("btn_gt"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test03_06_Compare_Operator_GraterThan_invalid() {
        click(By.linkText("@Compare Test"));

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "100");
            click(By.id("btn_gt"));
            assertThat(getText(By.id("left.errors")),
                    is("not match left and right"));
        }

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "101");
            click(By.id("btn_gt"));
            assertThat(getText(By.id("left.errors")),
                    is("not match left and right"));
        }
    }

    @Test
    public void test03_07_Compare_Operator_GraterThanOrEqual_valid() {
        click(By.linkText("@Compare Test"));

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "99");
            click(By.id("btn_ge"));
            assertThat(getText(By.id("message")), is(SUCCESS));
        }

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "100");
            click(By.id("btn_ge"));
            assertThat(getText(By.id("message")), is(SUCCESS));
        }
    }

    @Test
    public void test03_08_Compare_Operator_GraterThanOrEqual_invalid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_ge"));
        assertThat(getText(By.id("left.errors")),
                is("not match left and right"));
    }

    @Test
    public void test03_09_Compare_Operator_LessThan_valid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_lt"));
        assertThat(getText(By.id("message")), is(SUCCESS));
    }

    @Test
    public void test03_10_Compare_Operator_LessThan_invalid() {
        click(By.linkText("@Compare Test"));

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "100");
            click(By.id("btn_lt"));
            assertThat(getText(By.id("left.errors")),
                    is("not match left and right"));
        }

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "99");
            click(By.id("btn_lt"));
            assertThat(getText(By.id("left.errors")),
                    is("not match left and right"));
        }
    }

    @Test
    public void test03_11_Compare_Operator_LessThanOrEqual_valid() {
        click(By.linkText("@Compare Test"));

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "101");
            click(By.id("btn_le"));
            assertThat(getText(By.id("message")), is(SUCCESS));
        }

        {
            setText(By.id("left"), "100");
            setText(By.id("right"), "100");
            click(By.id("btn_le"));
            assertThat(getText(By.id("message")), is(SUCCESS));
        }
    }

    @Test
    public void test03_12_Compare_Operator_LessThanOrEqual_invalid() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "99");
        click(By.id("btn_le"));
        assertThat(getText(By.id("left.errors")),
                is("not match left and right"));
    }

    @Test
    public void test03_13_Compare_Node_Property() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_prop"));
        assertThat(getText(By.id("left.errors")),
                is("not match left and right"));
    }

    @Test
    public void test03_14_Compare_Node_RootBean() {
        click(By.linkText("@Compare Test"));

        setText(By.id("left"), "100");
        setText(By.id("right"), "101");
        click(By.id("btn_root"));
        assertThat(getText(By.id("validationForm.errors")),
                is("not match left and right"));
    }

    private void setText(By by, CharSequence sequence) {
        assertExist(by);
        WebElement e = driver.findElement(by);
        e.clear();
        e.sendKeys(sequence);
    }

    private void click(By by) {
        assertExist(by);
        driver.findElement(by).click();
    }

    private String getText(By by) {
        assertExist(by);
        return driver.findElement(by).getText();
    }

    private void assertExist(By by) {
        assertThat(webDriverOperations.exists(by), is(true));
    }

}
