package in.rupam.SprinBootLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprinBootLearnApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SprinBootLearnApplication.class, args);
		Alien alien = context.getBean(Alien.class);
		alien.code();
	}

}
