package com.koushik.Web.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String category;
    private String brand;
    private BigDecimal price;

    @Column(length = 1000)
    private String description;

    private Date releaseDate;
    private Boolean available;
    private Integer quantity;
}
