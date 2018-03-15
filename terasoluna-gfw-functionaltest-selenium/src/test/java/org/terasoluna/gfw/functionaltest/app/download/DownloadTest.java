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
package org.terasoluna.gfw.functionaltest.app.download;

import java.io.IOException;

import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.text.IsEqualIgnoringCase.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class DownloadTest extends FunctionTestSupport {
    @Inject
    protected RestTemplate restTemplate;

    public DownloadTest() {
        disableSetupDefaultWebDriver();
    }

    @Test
    public void test01_01_fileDownload() throws IOException {
        ResponseEntity<byte[]> response = restTemplate.getForEntity(
                applicationContextUrl + "/download/1_1", byte[].class);
        ClassPathResource images = new ClassPathResource("/image/Duke.png");

        byte[] expected = StreamUtils.copyToByteArray(images.getInputStream());

        HttpHeaders headers = response.getHeaders();
        System.out.println("test01_01_fileDownload: X-Track=" + headers
                .getFirst("X-Track"));
        assertThat(headers.getFirst("Content-Disposition"), is(
                "attachment; filename=Duke.png"));

        MediaType contentType = headers.getContentType();
        assertThat(contentType.getType(), is("image"));
        assertThat(contentType.getSubtype(), is("png"));

        assertThat(response.getBody(), is(expected));
    }

    @Test
    public void test01_02_fileDownload() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                applicationContextUrl + "/download/1_2", String.class);

        HttpHeaders headers = response.getHeaders();
        System.out.println("test01_02_fileDownload: X-Track=" + headers
                .getFirst("X-Track"));

        assertThat(headers.getFirst("Content-Disposition"), is(
                "attachment; filename=framework.txt"));

        MediaType contentType = headers.getContentType();
        assertThat(contentType.getType(), is("text"));
        assertThat(contentType.getSubtype(), is("plain"));
        assertThat(contentType.getParameter("charset"), equalToIgnoringCase(
                "UTF-8"));

        assertThat(response.getBody(), is("Spring Framework"));

    }
}
