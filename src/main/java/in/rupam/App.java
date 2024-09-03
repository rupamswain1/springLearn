package in.rupam;

import in.rupam.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop desktop = context.getBean(Desktop.class);
        //or we can call by bean name, by default it will be method name defined in config
        Desktop desktop2 = context.getBean("desktop",Desktop.class);
        Laptop laptop = context.getBean(Laptop.class);
        //or we can provide the name in config and use it
//        Laptop laptop = (Laptop) context.getBean("lappy");
//        Laptop laptop2 = (Laptop) context.getBean("lappy");

        Alien alien = context.getBean(Alien.class);
        alien.coding();
        //---For xml based config ---
////        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("autowireExample.xml");
////        Alien alien =context.getBean("Alien",Alien.class);
//
//        //bean can be fetched with only class name as well
//        Alien alien = context.getBean(Alien.class);
//        alien.coding();
//        System.out.println(alien.getLines());
//
//        Alien2 alien2 = context.getBean((Alien2.class));
//        alien2.coding();
    }
}
