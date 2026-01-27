package com.koushik.Web.Service;

import com.koushik.Web.Dto.ProductCreateDTO;
import com.koushik.Web.Dto.ProductUpdateDTO;
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

    public void updateProduct(int prodId, ProductUpdateDTO dto) {

        System.out.println("Updating product: " + prodId);
        Product prod = repo.findById(prodId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("Updating product: " + prod);

        if (dto.getName() != null)
            prod.setName(dto.getName());

        if (dto.getCategory() != null)
            prod.setCategory(dto.getCategory());

        if (dto.getBrand() != null)
            prod.setBrand(dto.getBrand());

        if (dto.getPrice() != null)
            prod.setPrice(dto.getPrice());

        if (dto.getDescription() != null)
            prod.setDescription(dto.getDescription());

        if (dto.getReleaseDate() != null)
            prod.setReleaseDate(dto.getReleaseDate());

        if (dto.getAvailable() != null)
            prod.setAvailable(dto.getAvailable());

        if (dto.getQuantity() != null)
            prod.setQuantity(dto.getQuantity());

        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
