package in.rupam.Spring.Ecomm.service;

import in.rupam.Spring.Ecomm.model.Product;
import in.rupam.Spring.Ecomm.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product updateProduct(Product product, MultipartFile imageData) throws IOException {
        product.setImageName(imageData.getOriginalFilename());
        product.setImageType(imageData.getContentType());
        product.setImageData(imageData.getBytes());
        return repo.save(product);
    }
}
