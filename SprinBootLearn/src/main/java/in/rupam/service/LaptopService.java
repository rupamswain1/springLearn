package in.rupam.service;

import in.rupam.models.Laptop;
import in.rupam.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private LaptopRepository repo;

    public LaptopRepository getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(LaptopRepository repo) {
        this.repo = repo;
    }

    public void addLaptop(){
        repo.save();
    }

    public boolean isGoodForProgramming(Laptop lap){
        return true;
    }
}
