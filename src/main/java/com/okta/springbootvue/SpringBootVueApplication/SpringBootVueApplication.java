package src.main.java.com.okta.springbootvue.SpringBootVueApplication; 

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication  
public class SpringBootVueApplication {  
  
    public static void main(String[] args) {  
      SpringApplication.run(SpringBootVueApplication.class, args);  
    }  

    //Add test data into the in-memory database - USERS
    /*@Bean  
    ApplicationRunner init(UserRepository repository) {  
        return args -> {  
            Stream.of("Brent", "Ifeoma", "Kylie", "Larry").forEach(name -> {  
                    User user = new User();  
                    user.setFirstName(name);  
                    repository.save(user);  
            });  
            repository.findAll().forEach(System.out::println);  
        };  
    }  */
    
  //Add test data into the in-memory database - ELECTIONS
   /*@Bean  
    ApplicationRunner init(ElectionRepository repository) {  
        return args -> {  
            Stream.of("ONE", "TWO", "THREE", "FOUR").forEach(title -> {  
                    Election election = new Election();  
                    election.setTitle(title);  
                    repository.save(election);  
            });  
            repository.findAll().forEach(System.out::println);  
        };  
    }*/ 

    // Fix the CORS errors
    @Bean
    public FilterRegistrationBean simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); 
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("http://localhost:8080")); 
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*"));  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    }   
}
