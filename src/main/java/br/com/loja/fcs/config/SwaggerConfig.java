package br.com.loja.fcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;


import springfox.documentation.service.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }

    private BasicAuth apiKey() {
        return new BasicAuth("basicAuth");
    }

//    private ApiKey apiKey() {
//        return new ApiKey("Token Access", "token", "header");
//    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.loja.fcs.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
//                .globalOperationParameters(
//                        Collections.singletonList(
//                                new ParameterBuilder()
//                                        .name("Authorization")
//                                        .description("Bearer token")
//                                        .modelRef(new ModelRef("string"))
//                                        .parameterType("header")
//                                        .required(false)
//                                        .build()
//                        )
//                )
                .host("localhost:8081"); // Defina a URL base da API aqui
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(
                new SecurityReference("basicAuth", authorizationScopes)
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FCS - Loja Virtual")
                .description("API endpoints")
                .version("1.0.0")
                .contact(new Contact("FCS", "http://localhost:8081/swagger-ui/index.html", "dev-team@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}