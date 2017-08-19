package com.saldivar.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Main spring boot class.
 * 
 * @author saldivar
 *
 */
@SpringBootApplication
@ImportResource("applicationContext.xml")
public class SpringbootQuartzJobStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuartzJobStoreApplication.class, args);
	}
}
