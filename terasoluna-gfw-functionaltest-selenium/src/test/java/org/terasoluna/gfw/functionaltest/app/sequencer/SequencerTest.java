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
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class SequencerTest extends FunctionTestSupport {

    @Test
    public void test01_01_getSequenceByInteger() {
        // Initial value is 0.

        // Get 1st sequence (NextValue By Integer)
        driver.findElement(By.id("1_1_next")).click();

        // Check page and sequence value.
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("1"));

        // Get 2nd sequence (CurrentValue By Integer)
        driver.findElement(By.id("1_1_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 3rd sequence (CurrentValue By Integer)
        driver.findElement(By.id("1_1_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 4th sequence (NextValue By Integer)
        driver.findElement(By.id("1_1_next")).click();

        // Check page and sequence
        // Sequence value is 2. (initial + 2)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("2"));

        // Get 5th sequence (NextValue By Integer)
        driver.findElement(By.id("1_1_next")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("3"));

        // Get 6th sequence (CurrentValue By Integer)
        driver.findElement(By.id("1_1_current")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("3"));

        // Get 7th sequence (NextValue By Integer)
        driver.findElement(By.id("1_1_next")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("4"));

        // Get 8th sequence (CurrentValue By Integer)
        driver.findElement(By.id("1_1_current")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("4"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_02_getSequenceByLong() {
        // Initial value is 0.

        // Get 1st sequence (NextValue By Long)
        driver.findElement(By.id("1_2_next")).click();

        // Check page and sequence value.
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("1"));

        // Get 2nd sequence (CurrentValue By Long)
        driver.findElement(By.id("1_2_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 3rd sequence (CurrentValue By Long)
        driver.findElement(By.id("1_2_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 4th sequence (NextValue By Long)
        driver.findElement(By.id("1_2_next")).click();

        // Check page and sequence
        // Sequence value is 2. (initial + 2)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("2"));

        // Get 5th sequence (NextValue By Long)
        driver.findElement(By.id("1_2_next")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("3"));

        // Get 6th sequence (CurrentValue By Long)
        driver.findElement(By.id("1_2_current")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("3"));

        // Get 7th sequence (NextValue By Integer)
        driver.findElement(By.id("1_2_next")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("4"));

        // Get 8th sequence (CurrentValue By Integer)
        driver.findElement(By.id("1_2_current")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("4"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_03_getSequenceByBigInteger() {
        // Initial value is 0.

        // Get 1st sequence (NextValue By BigInteger)
        driver.findElement(By.id("1_3_next")).click();

        // Check page and sequence value.
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("1"));

        // Get 2nd sequence (CurrentValue By BigInteger)
        driver.findElement(By.id("1_3_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 3rd sequence (CurrentValue By BigInteger)
        driver.findElement(By.id("1_3_current")).click();

        // Check page and sequence
        // Sequence value is 1.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("1"));

        // Get 4th sequence (NextValue By BigInteger)
        driver.findElement(By.id("1_3_next")).click();

        // Check page and sequence
        // Sequence value is 2. (initial + 2)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("2"));

        // Get 5th sequence (NextValue By BigInteger)
        driver.findElement(By.id("1_3_next")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("3"));

        // Get 6th sequence (CurrentValue By BigInteger)
        driver.findElement(By.id("1_3_current")).click();

        // Check page and sequence
        // Sequence value is 3. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("3"));

        // Get 7th sequence (NextValue By BigInteger)
        driver.findElement(By.id("1_3_next")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(), is("4"));

        // Get 8th sequence (CurrentValue By BigInteger)
        driver.findElement(By.id("1_3_current")).click();

        // Check page and sequence
        // Sequence value is 4. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(), is("4"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test01_04_getSequenceByString() {
        // Initial value is 0.

        // Get 1st sequence (NextValue By String)
        driver.findElement(By.id("1_4_next")).click();

        // Check page and sequence value.
        // Sequence value is 0000000001.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(),
                is("0000000001"));

        // Get 2nd sequence (CurrentValue By String)
        driver.findElement(By.id("1_4_current")).click();

        // Check page and sequence
        // Sequence value is 0000000001.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(),
                is("0000000001"));

        // Get 3rd sequence (CurrentValue By String)
        driver.findElement(By.id("1_4_current")).click();

        // Check page and sequence
        // Sequence value is 0000000001.
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(),
                is("0000000001"));

        // Get 4th sequence (NextValue By String)
        driver.findElement(By.id("1_4_next")).click();

        // Check page and sequence
        // Sequence value is 0000000002. (initial + 2)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(),
                is("0000000002"));

        // Get 5th sequence (NextValue By String)
        driver.findElement(By.id("1_4_next")).click();

        // Check page and sequence
        // Sequence value is 0000000003. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(),
                is("0000000003"));

        // Get 6th sequence (CurrentValue By String)
        driver.findElement(By.id("1_4_current")).click();

        // Check page and sequence
        // Sequence value is 0000000003. (initial + 3)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(),
                is("0000000003"));

        // Get 7th sequence (NextValue By String)
        driver.findElement(By.id("1_4_next")).click();

        // Check page and sequence
        // Sequence value is 0000000004. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET NEXT VALUE)"));
        assertThat(driver.findElement(By.id("nextval")).getText(),
                is("0000000004"));

        // Get 8th sequence (CurrentValue By String)
        driver.findElement(By.id("1_4_current")).click();

        // Check page and sequence
        // Sequence value is 0000000004. (initial + 4)
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Sequencer Function Test (GET CURRENT VALUE)"));
        assertThat(driver.findElement(By.id("currval")).getText(),
                is("0000000004"));

        // screen capture (Automatic capture conducted at the end)

    }

    @Test
    public void test02_01_getNotFoundSequence() {

        // Get NotFoundSequence (NextValue)
        driver.findElement(By.id("2_1_not_found_next")).click();

        // Check page
        assertThat(driver.findElement(By.id("exceptionTitle")).getText(),
                is("Data Access Error..."));

        // Return test target page from Error page
        driver.get(applicationContextUrl);
        driver.findElement(By.id("Sequencer")).click();

        // Get NotFoundSequence (CurrentValue)
        driver.findElement(By.id("2_1_not_found_current")).click();

        // Check page
        assertThat(driver.findElement(By.id("exceptionTitle")).getText(),
                is("Data Access Error..."));

        // screen capture (Automatic capture conducted at the end)

    }
}
