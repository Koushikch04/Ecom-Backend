package com.koushik.Web.Service;

import com.koushik.Web.Dto.ProductCreateDTO;
import com.koushik.Web.Dto.ProductResponseDTO;
import com.koushik.Web.Dto.ProductUpdateDTO;
import com.koushik.Web.Model.Product;
import com.koushik.Web.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<ProductResponseDTO> getProducts() {
        return getProducts(false); // default = false
    }

    public List<ProductResponseDTO> getProducts(boolean includeImage) {
        List<Product> products =  repo.findAll();
        return products.stream().map(product -> {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setId(product.getId());
            productResponseDTO.setName(product.getName());
            productResponseDTO.setDescription(product.getDescription());
            productResponseDTO.setPrice(product.getPrice());
            productResponseDTO.setQuantity(product.getQuantity());
            productResponseDTO.setBrand(product.getBrand());
            productResponseDTO.setCategory(product.getCategory());
            productResponseDTO.setAvailable(product.getAvailable());
            System.out.println("Getting product with id = " + product.getId());
            System.out.println("Include image = " + includeImage);
            if(includeImage && product.getImageData() != null) {
                System.out.println("Getting image");
                productResponseDTO.setImageType(product.getImageType());
//                System.out.println("Image data is : " + Arrays.toString(product.getImageData()));
                productResponseDTO.setImageBase64(
                        Base64.getEncoder().encodeToString(product.getImageData())
                );
            }
            return productResponseDTO;
        }).toList();
    }

    public Optional<Product> getProduct(int prodId) {
        return repo.findById(prodId);
    }

    public Product addProduct(ProductCreateDTO product, MultipartFile productImage) throws IOException {

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
        prod.setImageData(productImage.getBytes());
        repo.save(prod);
        return prod;
    }

    public void updateProduct(int prodId, ProductUpdateDTO dto, MultipartFile productImage) throws IOException {

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

        if(productImage != null && !productImage.isEmpty()){
            System.out.println("Setting image data");
            prod.setImageData(productImage.getBytes());
        }

        System.out.println(dto.getImageBase64());

        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }

    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }
}
