package in.rupam;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer {
    public Desktop(){
    System.out.println("Desktop initialized");
    }
    public void compile(){
        System.out.println("Compiling from Desktop");
    }
}
