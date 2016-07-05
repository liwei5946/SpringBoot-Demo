package com.cloudwide.didaoa.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@Configuration
public class SitemeshConfig {
	@Bean
	public Filter sitemeshFilter(){
		return new SiteMeshFilter();
	}
}
