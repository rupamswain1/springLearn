package in.rupam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {
    @Value("21")
    private int lines;

    private Computer com;

    public int getLines() {
        return lines;
    }

    public Computer getLaptop() {
        return com;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }
    @Autowired
//    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

//    @ConstructorProperties({"line","computer"})
//    public Alien(int lines, Computer com) {
//        this.lines = lines;
//        this.com = com;
//    }

    public void coding(){
        System.out.println("Coding..."+this.lines+" lines");
        com.compile();
    }
}
