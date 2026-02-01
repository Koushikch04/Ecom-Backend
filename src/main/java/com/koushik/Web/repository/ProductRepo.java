package com.koushik.Web.repository;

import com.koushik.Web.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
//    List<Product> SearchProduct(String name);
}
