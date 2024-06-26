package com.walking.batch.config;

import static com.walking.batch.config.BatchConfig.BEAN_NAME_PREFIX;
import static com.walking.batch.config.BatchConfig.PROPERTY_PREFIX;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchPropertyConfig {

	public static final String PROPERTY_BEAN_NAME = BEAN_NAME_PREFIX + "Properties";

	@Bean(name = PROPERTY_BEAN_NAME)
	@ConfigurationProperties(prefix = PROPERTY_PREFIX)
	public BatchProperties batchProperties() {
		return new BatchProperties();
	}
}
