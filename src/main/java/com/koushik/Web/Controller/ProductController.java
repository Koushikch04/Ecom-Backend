package com.koushik.Web.Controller;

import com.koushik.Web.Dto.ProductCreateDTO;
import com.koushik.Web.Dto.ProductResponseDTO;
import com.koushik.Web.Dto.ProductUpdateDTO;
import com.koushik.Web.Model.Product;
import com.koushik.Web.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiPanelUI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts( @RequestParam(defaultValue = "false") boolean includeImage) {
        System.out.println("Getting products with image = " +  includeImage);
//        System.out.println(service.getProducts(includeImage).getLast().getImageBase64());
        return service.getProducts(includeImage);
    }

    @GetMapping("/product/{prodId}")
    public Optional<Product> getProduct(@PathVariable int prodId) {
        Optional<Product> prod = service.getProduct(prodId);
        return prod;
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart ProductCreateDTO product, @RequestPart MultipartFile productImage) {
        try{
            Product prod = service.addProduct(product, productImage);
            return new  ResponseEntity<>(prod, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/{prodId}")
    public void updateProduct(@RequestPart ProductUpdateDTO product, @RequestPart(required = false) MultipartFile productImage, @PathVariable int prodId) {
        try{
            System.out.println("Updating product with id = " + prodId);
            service.updateProduct(prodId, product, productImage);
        }
        catch(Exception e){
            System.out.println("Error updating product");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    @DeleteMapping("/product/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
