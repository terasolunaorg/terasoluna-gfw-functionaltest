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
package org.terasoluna.gfw.functionaltest.app.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;
import org.terasoluna.gfw.functionaltest.config.SeleniumContextConfig;

@SpringJUnitConfig(classes = {SeleniumContextConfig.class})
public class ValidationTest extends FunctionTestSupport {

    private static final String SUCCESS = "Validation successfully!";

    public ValidationTest() {}

    @BeforeEach
    public void setUpLocale() {
        driver.findElement(By.linkText("English")).click();
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
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("must be greater than or equal to 6 bytes"));
    }

    @Test
    public void test01_03_ByteMin_invalid_ja() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.linkText("@ByteMin Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいu", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("6 バイト以上のサイズにしてください"));
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
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("must be less than or equal to 6 bytes"));
    }

    @Test
    public void test02_03_ByteMax_invalid_ja() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.linkText("@ByteMax Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいうe", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("6 バイト以下のサイズにしてください"));
    }

    @Test
    public void test03_01_ByteSize_valid() {
        driver.findElement(By.linkText("@ByteSize Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいう", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test03_02_ByteSize_invalid() {
        driver.findElement(By.linkText("@ByteSize Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいu", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("must be between 6 and 6 bytes"));

        inputFieldAccessor.overrideValue(By.id("userName"), "あいうe", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("must be between 6 and 6 bytes"));
    }

    @Test
    public void test03_03_ByteSize_invalid_ja() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.linkText("@ByteSize Test")).click();

        inputFieldAccessor.overrideValue(By.id("userName"), "あいu", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("6 から 6 バイトの間のサイズにしてください"));

        inputFieldAccessor.overrideValue(By.id("userName"), "あいうe", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("userName.errors")).getText(),
                is("6 から 6 バイトの間のサイズにしてください"));
    }

    @Test
    public void test04_01_Compare_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_validate")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test04_02_Compare_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_03_Compare_Operator_Equal_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test04_04_Compare_Operator_Equal_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_05_Compare_Operator_NotEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_ne")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test04_06_Compare_Operator_NotEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
        driver.findElement(By.id("btn_ne")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_07_Compare_Operator_GreaterThan_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
        driver.findElement(By.id("btn_gt")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test04_08_Compare_Operator_GreaterThan_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_gt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(),
                    is("invalid combination of left and right"));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
            driver.findElement(By.id("btn_gt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(),
                    is("invalid combination of left and right"));
        }
    }

    @Test
    public void test04_09_Compare_Operator_GreaterThanOrEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
            driver.findElement(By.id("btn_ge")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_ge")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
        }
    }

    @Test
    public void test04_10_Compare_Operator_GreaterThanOrEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_ge")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_11_Compare_Operator_LessThan_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_lt")).click();
        assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
    }

    @Test
    public void test04_12_Compare_Operator_LessThan_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_lt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(),
                    is("invalid combination of left and right"));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
            driver.findElement(By.id("btn_lt")).click();
            assertThat(driver.findElement(By.id("left.errors")).getText(),
                    is("invalid combination of left and right"));
        }
    }

    @Test
    public void test04_13_Compare_Operator_LessThanOrEqual_valid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
            driver.findElement(By.id("btn_le")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
        }

        {
            inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
            inputFieldAccessor.overrideValue(By.id("right"), "100", driver);
            driver.findElement(By.id("btn_le")).click();
            assertThat(driver.findElement(By.id("message")).getText(), is(SUCCESS));
        }
    }

    @Test
    public void test04_14_Compare_Operator_LessThanOrEqual_invalid() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "99", driver);
        driver.findElement(By.id("btn_le")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_15_Compare_Node_Property() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_prop")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_16_Compare_Node_RootBean() {
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_root")).click();
        assertThat(driver.findElement(By.id("validationForm.errors")).getText(),
                is("invalid combination of left and right"));
    }

    @Test
    public void test04_17_Compare_invalid_ja() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.linkText("@Compare Test")).click();

        inputFieldAccessor.overrideValue(By.id("left"), "100", driver);
        inputFieldAccessor.overrideValue(By.id("right"), "101", driver);
        driver.findElement(By.id("btn_eq")).click();
        assertThat(driver.findElement(By.id("left.errors")).getText(),
                is("正しくない left と right の組合せです"));
    }
}
