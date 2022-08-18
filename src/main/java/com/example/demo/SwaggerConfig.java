package com.example.demo;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Contact;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@OpenAPIDefinition(info = @Info(title = "Peopelsphere API", version = "2.0", description = "Peopelsphere Information"))
public class SwaggerConfig {
	
   @Bean
   public Docket api() {
	   return new Docket(DocumentationType.SWAGGER_2)
               .select()
.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
               .paths(PathSelectors.any())
               .build().apiInfo(apiInfo());
   }
   private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Peopleshpere project")
				.description("Created by Peopleshpere developpers")
				.version("1.0")
				.termsOfServiceUrl("http://Peopleshpere.pro/")
				.build();
	}
  
}
   
