package com.isaas.isaas;

import com.isaas.isaas.Configurations.SecurityConfig;
import com.isaas.isaas.Entities.CRUD.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackageClasses= {CustomerRepo.class})
@ComponentScan(basePackages = {
		"com.isaas.isaas.Controllers",
		"com.isaas.isaas.DAO",
		"com.isaas.isaas.Entities",
		"com.isaas.isaas.Services",
		"com.isaas.isaas.IServices",
		"com.isaas.isaas.Exceptions",
		"com.isaas.isaas.Middleware",
		"com.isaas.isaas.Entities.Reflection",
		"com.isaas.isaas.ISDK"}, basePackageClasses = SecurityConfig.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")

public class IsaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaasApplication.class, args);
	}
}
