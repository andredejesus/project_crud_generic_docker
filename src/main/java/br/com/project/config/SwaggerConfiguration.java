package br.com.project.config;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
    private final Environment environment;

    private String applicationName = "API Project Generic";

    private String appVersion = "0.0.1";

    @Autowired
    public SwaggerConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Docket api() {
       return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.basePackage("br.com.project"))
               .paths(PathSelectors.any())
               .build()
               .apiInfo(createApiInfo())
               .securitySchemes(Collections.singletonList(apiKey()));
    }

    

    private ApiInfo createApiInfo() {
        return new ApiInfo(
        	applicationName,
            null,
            appVersion,
            null,
            null,
            null,
            null,
            Collections.emptyList()
        );
    }
    
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
