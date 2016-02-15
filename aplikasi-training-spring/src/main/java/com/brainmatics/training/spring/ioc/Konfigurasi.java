package com.brainmatics.training.spring.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(
	basePackages="com.brainmatics.training.spring.ioc"
)
@PropertySource("classpath:koneksi.properties")
public class Konfigurasi {
	
	@Value("${host}")
	private String dbHost;
	@Value("${port}")
	private Integer dbPort;
	@Value("${db}")
	private String dbName;
	@Value("${username}")
	private String dbUser;
	@Value("${password}")
	private String dbPass;
	
	@Bean
	public KoneksiDatabase getKoneksi(){
		KoneksiDatabase koneksi = new KoneksiDatabase();
		koneksi.setHost(dbHost);
		koneksi.setPort(dbPort);
		koneksi.setNamaDatabase(dbName);
		koneksi.setUsername(dbUser);
		koneksi.setPassword(dbPass);
		return koneksi;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
