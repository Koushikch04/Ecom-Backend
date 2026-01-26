package com.koushik.Web.Service;

import com.koushik.Web.Dto.ProductCreateDTO;
import com.koushik.Web.Model.Product;
import com.koushik.Web.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;


//    private final List<Product> products = new ArrayList<>(
//            Arrays.asList(
//                    new Product(101, "Iphone", 5000),
//                    new Product(102, "Android", 5000)
//            )
//    );

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Optional<Product> getProduct(int prodId) {
        return repo.findById(prodId);
    }

    public void addProduct(ProductCreateDTO product) {

        System.out.println("Saving product: " + product );
        Product prod =  new Product();
        prod.setName(product.getName());
        prod.setCategory(product.getCategory());
        prod.setBrand(product.getBrand());
        prod.setPrice(product.getPrice());
        prod.setDescription(product.getDescription());
        prod.setAvailable(product.getAvailable());
        prod.setQuantity(product.getQuantity());
        prod.setReleaseDate(product.getReleaseDate());
        repo.save(prod);
    }

    public void updateProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
