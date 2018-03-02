package com.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
/*@EnableCaching*/
//@ServletComponentScan
public class SpringDataJpaDemoApplication extends SpringBootServletInitializer{


   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(SpringDataJpaDemoApplication.class);
   }
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

}
