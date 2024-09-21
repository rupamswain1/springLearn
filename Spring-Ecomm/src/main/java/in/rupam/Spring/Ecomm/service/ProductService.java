package in.rupam.Spring.Ecomm.service;

import in.rupam.Spring.Ecomm.model.Product;
import in.rupam.Spring.Ecomm.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepo repo;
    public void loadProducts(ArrayList<Product> productList) {
        repo.saveAll(productList);
    }

    public List<Product> getProducts() {
        return  repo.findAll();
    }
}
