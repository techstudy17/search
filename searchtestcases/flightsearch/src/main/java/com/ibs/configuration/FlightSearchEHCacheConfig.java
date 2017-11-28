package com.ibs.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
/**
 * 
 * @author Sumya
 *
 */
@Configuration
@EnableCaching
@ComponentScan({ "com.ibs.xmlparsandehcache" })
public class FlightSearchEHCacheConfig {

	/**
	 * Returns a EhCacheCacheManager.
	 *
	 * @return EhCacheCacheManager
	 */
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	/**
	 * Returns a EhCacheManagerFactoryBean.
	 *
	 * @return EhCacheManagerFactoryBean
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
		factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factory.setShared(true);
		return factory;
	}
}