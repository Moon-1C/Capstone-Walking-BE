package com.walking.api.repository.config;

import com.walking.api.repository.config.jpa.HibernatePropertyMapProvider;
import com.walking.data.DataConfig;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@RequiredArgsConstructor
@Import(ApiRepositoryConfig.class)
public class ApiRepositoryEntityConfig {
	public static final String ENTITY_MANAGER_FACTORY_NAME =
			ApiRepositoryConfig.BEAN_NAME_PREFIX + "EntityManagerFactory";
	private static final String PERSIST_UNIT =
			ApiRepositoryConfig.BEAN_NAME_PREFIX + "PersistenceUnit";

	private final HibernatePropertyMapProvider hibernatePropertyMapProvider;

	@Bean(name = ENTITY_MANAGER_FACTORY_NAME)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			EntityManagerFactoryBuilder builder,
			ConfigurableListableBeanFactory beanFactory) {

		LocalContainerEntityManagerFactoryBean build =
				builder
						.dataSource(dataSource)
						.properties(hibernatePropertyMapProvider.get())
						.persistenceUnit(PERSIST_UNIT)
						.packages(DataConfig.BASE_PACKAGE)
						.build();
		build
				.getJpaPropertyMap()
				.put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));

		return build;
	}
}
