package search;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import search.conf.ApplicationConfiguration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(ApplicationConfiguration.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        System.out.println("Hello world");



    }
}
