package com.rakuten.stock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.rakuten.stock")
@Import({HibernateConfig.class})
public class AppConfig {

}
