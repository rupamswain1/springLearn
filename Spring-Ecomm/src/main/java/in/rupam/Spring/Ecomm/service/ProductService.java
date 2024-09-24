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

    public Product addOrUpdateProduct(Product product, MultipartFile imageData) throws IOException {
        product.setImageName(imageData.getOriginalFilename());
        product.setImageType(imageData.getContentType());
        product.setImageData(imageData.getBytes());
        return repo.save(product);
    }

    public byte[] getProductImage(int productId) {
        Product product = repo.findById(productId).orElse(new Product());
        return product.getImageData();
    }

    public boolean deleteProduct(int id) {
        Product product = repo.findById(id).orElse(null);
        if(product != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
