package in.rupam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("autowireExample.xml");
//        Alien alien =context.getBean("Alien",Alien.class);

        //bean can be fetched with only class name as well
        Alien alien = context.getBean(Alien.class);
        alien.coding();
        System.out.println(alien.getLines());

        Alien2 alien2 = context.getBean((Alien2.class));
        alien2.coding();
    }
}
