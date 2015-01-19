package org.terasoluna.gfw.functionaltest.domain.service.queryescape;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OracleVersionRetriever {
    @Inject
    JdbcTemplate jdbcTemplate;

    public String getVersion() {
        return jdbcTemplate
                .queryForObject(
                        "SELECT version FROM PRODUCT_COMPONENT_VERSION WHERE product LIKE 'Oracle%' AND ROWNUM <= 1",
                        String.class);
    }
}