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
package org.terasoluna.gfw.functionaltest.app.download;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;
import jakarta.inject.Inject;

public class DownloadTest extends FunctionTestSupport {
    @Inject
    protected RestTemplate restTemplate;

    public DownloadTest() {
        disableSetupDefaultWebDriver();
    }

    @Test
    public void test01_01_fileDownload() throws IOException {
        ResponseEntity<byte[]> response =
                restTemplate.getForEntity(applicationContextUrl + "/download/1_1", byte[].class);
        ClassPathResource images = new ClassPathResource("/image/Duke.png");

        byte[] expected = StreamUtils.copyToByteArray(images.getInputStream());

        HttpHeaders headers = response.getHeaders();
        System.out.println("test01_01_fileDownload: X-Track=" + headers.getFirst("X-Track"));
        assertThat(headers.getFirst("Content-Disposition"))
                .isEqualTo("attachment; filename=Duke.png");

        MediaType contentType = headers.getContentType();
        assertThat(contentType.getType()).isEqualTo("image");
        assertThat(contentType.getSubtype()).isEqualTo("png");

        assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void test01_02_fileDownload() {
        ResponseEntity<String> response =
                restTemplate.getForEntity(applicationContextUrl + "/download/1_2", String.class);

        HttpHeaders headers = response.getHeaders();
        System.out.println("test01_02_fileDownload: X-Track=" + headers.getFirst("X-Track"));

        assertThat(headers.getFirst("Content-Disposition"))
                .isEqualTo("attachment; filename=framework.txt");

        MediaType contentType = headers.getContentType();
        assertThat(contentType.getType()).isEqualTo("text");
        assertThat(contentType.getSubtype()).isEqualTo("plain");
        assertThat(contentType.getParameter("charset")).isEqualToIgnoringCase("UTF-8");

        assertThat(response.getBody()).isEqualTo("Spring Framework");

    }
}
