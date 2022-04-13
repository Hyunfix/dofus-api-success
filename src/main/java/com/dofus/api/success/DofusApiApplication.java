package com.dofus.api.success;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dofus.api")
@OpenAPIDefinition(info = @Info(title = "DOFUS API", version = "1.0", description =  "documentation pour les api dofus"))
public class DofusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofusApiApplication.class, args);
	}

}
