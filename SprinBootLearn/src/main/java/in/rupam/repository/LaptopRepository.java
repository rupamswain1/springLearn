package in.rupam.repository;

import in.rupam.models.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(){
        System.out.println("Saved to Database");
    }
}
