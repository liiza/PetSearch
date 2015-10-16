package search.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import search.driver.SearchDriver;
import search.repository.SearchService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SearchDriver searchDriver() {
        String apiKey = System.getenv("api_key");
        return new SearchDriver(apiKey);
    }

    @Bean
    public SearchService searchService(){
        return new SearchService();
    }

}
