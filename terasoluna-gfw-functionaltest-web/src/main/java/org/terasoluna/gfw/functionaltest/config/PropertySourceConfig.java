package org.terasoluna.gfw.functionaltest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Class that registers the value defined in application-env.properties of each profile in environment.
 * <p>
 * Passes application server information to WebDriver through JSP so that asserts can be changed for each application server.
 * </p>
 */
@Configuration
@PropertySource("classpath:/META-INF/spring/application-env.properties")
public class PropertySourceConfig {
}
