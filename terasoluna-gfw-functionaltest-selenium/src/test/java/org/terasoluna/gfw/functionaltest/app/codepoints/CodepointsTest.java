/*
 * Copyright (C) 2013-2016 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.codepoints;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class CodepointsTest extends FunctionTestSupport {

	@Test
	public void codePointsTest_01() {

        driver.findElement(By.id("codepoints01")).click();
		
		String instanceCheck = driver.findElement(By.id("instanceCheck")).getText();
        String containsAll = driver.findElement(By.id("containsAll")).getText();

        assertThat(instanceCheck, is("true"));
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_02() {

		driver.findElement(By.id("codepoints02")).click();
		
		String containsAll = driver.findElement(By.id("containsAll")).getText();

        assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_03() {

		driver.findElement(By.id("codepoints03")).click();

        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_04() {

		driver.findElement(By.id("codepoints04")).click();
		
		String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}
	
	@Test
	public void codePointsTest_05() {

		driver.findElement(By.id("codepoints05")).click();

        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}
	
	@Test
	public void codePointsTest_06() {

		driver.findElement(By.id("codepoints06")).click();
		
		String containsAll = driver.findElement(By.id("containsAll")).getText();

        assertThat(containsAll, is("true"));
	}
	
	@Test
	public void codePointsTest_07() {

		driver.findElement(By.id("codepoints07")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}
	
	@Test
	public void codePointsTest_08() {

		driver.findElement(By.id("codepoints08")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_09() {

		driver.findElement(By.id("codepoints09")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_10() {

		driver.findElement(By.id("codepoints10")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_11() {

		driver.findElement(By.id("codepoints11")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("true"));
	}

	@Test
	public void codePointsTest_12() {

		driver.findElement(By.id("codepoints12")).click();
		
        String containsAll = driver.findElement(By.id("containsAll")).getText();
		
		assertThat(containsAll, is("false"));
	}

	@Test
	public void codePointsTest_13() {

		driver.findElement(By.id("codepoints13")).click();
		
        String codepoints = driver.findElement(By.id("codepoints")).getText();
		
		assertThat(Integer.parseInt(codepoints), is(CodePoints.NOT_FOUND));
	}

	@Test
	public void codePointsTest_14() {

		driver.findElement(By.id("codepoints14")).click();
		
        String codepoints = driver.findElement(By.id("codepoints")).getText();
		
		assertThat(Integer.parseInt(codepoints), is(0x0061));
	}

	@Test
	public void codePointsTest_15() {

		driver.findElement(By.id("codepoints15")).click();
		
        String codepoints = driver.findElement(By.id("codepoints")).getText();
		
		assertThat(Integer.parseInt(codepoints), is(0x0061));
	}

	@Test
	public void codePointsTest_16() {

		driver.findElement(By.id("codepoints16")).click();
		
        String codepoints = driver.findElement(By.id("codepoints")).getText();
		
		assertThat(Integer.parseInt(codepoints), is(0x0061));
	}

	@Test
	public void codePointsTest_17() {

		driver.findElement(By.id("codepoints17")).click();
		
        String size = driver.findElement(By.id("size")).getText();
		
		assertThat(Integer.parseInt(size), is(0));
	}

	@Test
	public void codePointsTest_18() {

		driver.findElement(By.id("codepoints18")).click();
		
        String size = driver.findElement(By.id("size")).getText();
        String contains1 = driver.findElement(By.id("contains1")).getText();
		
		assertThat(Integer.parseInt(size), is(1));
		assertThat(contains1, is("true"));
	}

	@Test
	public void codePointsTest_19() {

		driver.findElement(By.id("codepoints19")).click();
		
        String size = driver.findElement(By.id("size")).getText();
        String contains1 = driver.findElement(By.id("contains1")).getText();
        String contains2 = driver.findElement(By.id("contains2")).getText();
		
		assertThat(Integer.parseInt(size), is(2));
		assertThat(contains1, is("true"));
		assertThat(contains2, is("true"));
	}

}
