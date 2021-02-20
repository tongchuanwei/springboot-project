package com.hello.way.project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 2018/12/3
 *
 * @author way
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    private boolean swaggerShow = true;

    @Bean
    public Docket createRestfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hello.way.project.web.controller"))
                .paths(PathSelectors.any())
                .build()
//                .globalOperationParameters(pars)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标准项目APIs")
                .contact(new Contact("sl", "", ""))
                .version("1.1")
                .license("http://springfox.github.io/springfox/docs/current/")
                .licenseUrl("http://springfox.github.io/springfox/docs/current/")
                .description("API描述")
                .build();
    }


}