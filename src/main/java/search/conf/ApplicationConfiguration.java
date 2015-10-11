package search.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import search.driver.SearchDriver;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SearchDriver searchDriver() {
        String apiKey = System.getenv("api_key");
        return new SearchDriver(apiKey);
    }


}
