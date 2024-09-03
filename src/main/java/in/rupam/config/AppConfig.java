package in.rupam.config;

import in.rupam.Alien;
import in.rupam.Computer;
import in.rupam.Desktop;
import in.rupam.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
//    public Alien alien(@Qualifier("desktop") Computer com){
    public Alien alien(Computer com){
        Alien aObj = new Alien();
        aObj.setLines(44);
        aObj.setCom(com);
        return  aObj;
    }

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean(name = "lappy")
    @Scope("prototype")
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }

}
