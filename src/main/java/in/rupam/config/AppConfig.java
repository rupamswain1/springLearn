package in.rupam.config;

import in.rupam.Desktop;
import in.rupam.Laptop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean(name = "lappy")
    public Laptop laptop(){
        return new Laptop();
    }

}
