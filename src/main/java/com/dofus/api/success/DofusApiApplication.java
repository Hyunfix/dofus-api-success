package com.dofus.api.success;

import com.dofus.api.config.CustomRestTemplateCustomizer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
@ComponentScan("com.dofus.api")
@OpenAPIDefinition(info = @Info(title = "DOFUS API", version = "1.0", description =  "documentation pour les api dofus"))
public class DofusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofusApiApplication.class, args);
	}


	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
		return new CustomRestTemplateCustomizer();
	}

	@Bean
	@DependsOn(value = {"customRestTemplateCustomizer"})
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder(customRestTemplateCustomizer());
	}

}
