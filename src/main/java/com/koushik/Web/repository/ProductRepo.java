package com.koushik.Web.repository;

import com.koushik.Web.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
//    List<Product> SearchProduct(String name);
}
