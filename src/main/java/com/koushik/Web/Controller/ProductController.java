package com.koushik.Web.Controller;

import com.koushik.Web.Dto.ProductCreateDTO;
import com.koushik.Web.Dto.ProductUpdateDTO;
import com.koushik.Web.Model.Product;
import com.koushik.Web.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{prodId}")
    public Optional<Product> getProduct(@PathVariable int prodId) {
        Optional<Product> prod = service.getProduct(prodId);
        System.out.println("Hello");
        System.out.println(prod);
        return prod;
    }

    @PostMapping("/product")
    public void addProduct(@Valid @RequestBody ProductCreateDTO product){
        service.addProduct(product);
    }

    @PutMapping("/product/{prodId}")
    public void updateProduct(@RequestBody ProductUpdateDTO product, @PathVariable int prodId) {
        System.out.println("updateProduct");
        System.out.println(product);
        service.updateProduct(prodId, product);
    }

    @DeleteMapping("/product/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
