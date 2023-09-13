package com.sound.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "com.sound.kiosk")
public class SoundKioskApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SoundKioskApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder createSpringApplicationBuilder() {
		return super.createSpringApplicationBuilder();
	}
}
