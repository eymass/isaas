package com.isaas.isaas.Configurations;

import com.google.common.base.Predicates;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;
import java.util.regex.Pattern;


@EnableAutoConfiguration
@Configuration
@EnableSwagger2
@PropertySources({
        @PropertySource(value="classpath:application.properties"),
        @PropertySource(value = "file:${conf.home}/application.properties", ignoreResourceNotFound = true)
})
public class IsaasConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/security/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }

        };
    }

    @Bean
    public Docket productApi() {
        Pattern paths = Pattern.compile("^api.*\\/$");
        com.google.common.base.Predicate p = Predicates.contains(paths);

        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("com.isaas.isaas.Controllers"))
                .paths(Predicates.alwaysTrue())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void getProperty(String name) {
        env.getProperty(name);
    }
}
