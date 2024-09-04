package in.rupam;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Laptop class Initialized");
    }

    public void compile(){
        System.out.println("Code compiling in Laptop");
    }
}
