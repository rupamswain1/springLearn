package in.rupam.SprinBootLearn;

import in.rupam.models.Alien;
import in.rupam.models.Laptop;
import in.rupam.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.rupam")
public class SpringBootLearnApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootLearnApplication.class, args);
		Alien alien = context.getBean(Alien.class);
		alien.code();
		LaptopService service = context.getBean(LaptopService.class);
		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop();
	}

}
