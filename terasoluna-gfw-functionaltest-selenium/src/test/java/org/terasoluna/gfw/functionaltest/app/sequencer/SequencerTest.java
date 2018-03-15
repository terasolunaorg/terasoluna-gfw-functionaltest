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
package org.terasoluna.gfw.functionaltest.app.sequencer;

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
public class SequencerTest extends FunctionTestSupport {

    @Test
    public void test01_01_getSequenceByInteger() {
        // Initial value is 0.

        // Display Same Transaction.
        driver.findElement(By.id("1_1_same_transaction")).click();

        // Check page
        assertThat(driver.findElement(By.id("1_next_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("2_current_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("3_current_value2")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("4_next_value2")).getText(), is(
                "2"));

        assertThat(driver.findElement(By.id("5_next_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("6_current_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("7_next_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("8_current_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("mode")).getText(), is("Integer"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_02_getSequenceByLong() {
        // Initial value is 0.

        // Display Same Transaction.
        driver.findElement(By.id("1_2_same_transaction")).click();

        // Check page
        assertThat(driver.findElement(By.id("1_next_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("2_current_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("3_current_value2")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("4_next_value2")).getText(), is(
                "2"));

        assertThat(driver.findElement(By.id("5_next_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("6_current_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("7_next_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("8_current_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("mode")).getText(), is("Long"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_03_getSequenceByBigInteger() {
        // Initial value is 0.

        // Display SmaeTransaction.
        driver.findElement(By.id("1_3_same_transaction")).click();

        // Check page
        assertThat(driver.findElement(By.id("1_next_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("2_current_value1")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("3_current_value2")).getText(), is(
                "1"));

        assertThat(driver.findElement(By.id("4_next_value2")).getText(), is(
                "2"));

        assertThat(driver.findElement(By.id("5_next_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("6_current_value3")).getText(), is(
                "3"));

        assertThat(driver.findElement(By.id("7_next_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("8_current_value4")).getText(), is(
                "4"));

        assertThat(driver.findElement(By.id("mode")).getText(), is(
                "BigInteger"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_04_getSequenceByString() {
        // Initial value is 0.

        // Display SameTransaction.
        driver.findElement(By.id("1_4_same_transaction")).click();

        // Check page
        assertThat(driver.findElement(By.id("1_next_value1")).getText(), is(
                "0000000001"));

        assertThat(driver.findElement(By.id("2_current_value1")).getText(), is(
                "0000000001"));

        assertThat(driver.findElement(By.id("3_current_value2")).getText(), is(
                "0000000001"));

        assertThat(driver.findElement(By.id("4_next_value2")).getText(), is(
                "0000000002"));

        assertThat(driver.findElement(By.id("5_next_value3")).getText(), is(
                "0000000003"));

        assertThat(driver.findElement(By.id("6_current_value3")).getText(), is(
                "0000000003"));

        assertThat(driver.findElement(By.id("7_next_value4")).getText(), is(
                "0000000004"));

        assertThat(driver.findElement(By.id("8_current_value4")).getText(), is(
                "0000000004"));

        assertThat(driver.findElement(By.id("mode")).getText(), is("String"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test02_01_getNotFoundSequence() {

        // Get NotFoundSequence (NextValue)
        driver.findElement(By.id("2_1_not_found_next")).click();

        // Check page
        assertThat(driver.findElement(By.id("exceptionTitle")).getText(), is(
                "Data Access Error..."));

        // Return test target page from Error page
        driver.get(applicationContextUrl);
        driver.findElement(By.id("Sequencer")).click();

        // Get NotFoundSequence (CurrentValue)
        driver.findElement(By.id("2_1_not_found_current")).click();

        // Check page
        assertThat(driver.findElement(By.id("exceptionTitle")).getText(), is(
                "Data Access Error..."));

        // screen capture (Automatic capture conducted at the end)

    }

}
