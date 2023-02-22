package com.mongo.multitenancy.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongo.multitenancy.util.TenantFilter;

@Configuration
public class WebConfig {
	
	  @Bean
	  public FilterRegistrationBean<TenantFilter> tenantFilter() {
	    FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
	    registrationBean.setFilter(new TenantFilter());
	    registrationBean.addUrlPatterns("/api/v1/users/*");
	    return registrationBean;
	  }

}
