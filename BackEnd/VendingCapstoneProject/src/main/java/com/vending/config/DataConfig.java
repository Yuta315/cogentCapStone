package com.vending.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.vending.entities.Container;
import com.vending.entities.Drink;
import com.vending.entities.Refill;
import com.vending.entities.SaleList;


@Configuration
public class DataConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		Class[] domainTypes = {Drink.class, SaleList.class, Refill.class, Container.class};
		config.exposeIdsFor(domainTypes);
	}
	
}
