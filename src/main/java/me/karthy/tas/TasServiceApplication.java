package me.karthy.tas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"me.karthy.tas","io.oneclicklabs.transaction.logging"})
public class TasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasServiceApplication.class, args);
	}
}
