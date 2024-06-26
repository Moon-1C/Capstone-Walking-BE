package com.walking.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walking.api.config.ApiDataSourceConfig;
import com.walking.api.config.ApiEntityConfig;
import com.walking.api.config.ApiJpaConfig;
import com.walking.data.config.DataJpaConfig;
import com.walking.data.config.HibernatePropertyMapProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@ActiveProfiles(profiles = {"test"})
@DataJpaTest(
		excludeAutoConfiguration = {
			DataSourceAutoConfiguration.class,
			DataSourceTransactionManagerAutoConfiguration.class,
			HibernateJpaAutoConfiguration.class,
		})
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(
		classes = {
			ApiDataSourceConfig.class,
			ApiEntityConfig.class,
			ApiJpaConfig.class,
			DataJpaConfig.class,
			HibernatePropertyMapProvider.class,
			ObjectMapper.class,
		})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
abstract class RepositoryTest {}
