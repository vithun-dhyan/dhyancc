package com.dhyan.dhyancc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dhyan.dhyancc")
@EnableScheduling
@EnableAspectJAutoProxy
public class MyApplication extends SpringBootServletInitializer
{
    /**
     * SpringBootApplication
     * @param args aggs
     */
    public static void main(final String[] args)
    {
        SpringApplication.run(MyApplication.class, args);
    }

}
