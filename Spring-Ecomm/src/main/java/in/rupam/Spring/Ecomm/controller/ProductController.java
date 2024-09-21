package in.rupam.Spring.Ecomm.controller;

import in.rupam.Spring.Ecomm.model.Product;
import in.rupam.Spring.Ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private ProductService service;

    public ProductService getService() {
        return service;
    }
    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/load")
    public ResponseEntity<String> loadProducts(){
        ArrayList<Product> productList = new ArrayList<>() {{
            add(new Product(1, "Smartphone", "Latest model with advanced features", "TechBrand", new BigDecimal("699.99"), "Electronics", new Date(123, 6, 15), true, 50));
            add(new Product(2, "Laptop", "High performance laptop for gaming", "GamerBrand", new BigDecimal("1299.99"), "Electronics", new Date(123, 5, 10), true, 30));
            add(new Product(3, "Coffee Maker", "Brews the best coffee", "HomeBrand", new BigDecimal("99.99"), "Home Appliances", new Date(123, 7, 5), true, 20));
            add(new Product(4, "Bluetooth Headphones", "Noise-canceling wireless headphones", "AudioBrand", new BigDecimal("199.99"), "Audio", new Date(123, 8, 20), true, 15));
            add(new Product(5, "Smartwatch", "Tracks your fitness and health metrics", "WearableBrand", new BigDecimal("249.99"), "Wearables", new Date(123, 4, 25), true, 40));
        }};
        service.loadProducts(productList);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
      return new ResponseEntity(service.getProducts(), HttpStatus.OK);
    }

}
