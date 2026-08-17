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
package org.terasoluna.gfw.functionaltest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

/**
 * Configuration for {@link RestClient} used by the selenium tests. Defined in Java (rather than in
 * {@code seleniumContext.xml}) so that the builder chain can be extended without cramming it into
 * XML; imported into the XML context via {@code <bean class="..."/>}.
 */
@Configuration
public class RestClientConfig {

    /**
     * Configure the {@link RestClient}.
     * @return Bean of configured {@link RestClient}
     */
    @Bean("restClient")
    public RestClient restClient() {
        return RestClient.builder().requestFactory(new SimpleClientHttpRequestFactory())
                .build();
    }
}
