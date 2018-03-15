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
package org.terasoluna.gfw.functionaltest.app.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class ValidationTest extends FunctionTestSupport {

    private static final String SUCCESS = "Validation successfully!";

    public ValidationTest() {
    }

    @Test
    public void test01_01_ByteMin_valid() {
        driver.findElement(By.linkText("@ByteMin Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいう", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test01_02_ByteMin_invalid() {
        driver.findElement(By.linkText("@ByteMin Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいu", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(), is(
                "must be greater than or equal to 6 bytes"));
    }

    @Test
    public void test02_01_ByteMax_valid() {
        driver.findElement(By.linkText("@ByteMax Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいう", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test02_02_ByteMax_invalid() {
        driver.findElement(By.linkText("@ByteMax Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいうe", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(), is(
                "must be less than or equal to 6 bytes"));
    }

    @Test
    public void test03_01_Compare_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_02_Compare_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_03_Compare_Operator_Equal_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_04_Compare_Operator_Equal_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_05_Compare_Operator_NotEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_ne")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_06_Compare_Operator_NotEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_ne")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_07_Compare_Operator_GreaterThan_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
        driver.findElement(By.id("btn_gt")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_08_Compare_Operator_GreaterThan_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_gt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                    "invalid combination of left and right"));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
            driver.findElement(By.id("btn_gt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                    "invalid combination of left and right"));
        }
    }

    @Test
    public void test03_09_Compare_Operator_GreaterThanOrEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
            driver.findElement(By.id("btn_ge")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(
                    SUCCESS));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_ge")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(
                    SUCCESS));
        }
    }

    @Test
    public void test03_10_Compare_Operator_GreaterThanOrEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_ge")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_11_Compare_Operator_LessThan_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_lt")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_12_Compare_Operator_LessThan_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_lt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                    "invalid combination of left and right"));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
            driver.findElement(By.id("btn_lt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                    "invalid combination of left and right"));
        }
    }

    @Test
    public void test03_13_Compare_Operator_LessThanOrEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
            driver.findElement(By.id("btn_le")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(
                    SUCCESS));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_le")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(
                    SUCCESS));
        }
    }

    @Test
    public void test03_14_Compare_Operator_LessThanOrEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
        driver.findElement(By.id("btn_le")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_15_Compare_Node_Property() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_prop")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(), is(
                "invalid combination of left and right"));
    }

    @Test
    public void test03_16_Compare_Node_RootBean() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_root")).click();
        assertThat(driver.findElement(By.id("validationForm.errors")).getText(),
                is("invalid combination of left and right"));
    }
}
