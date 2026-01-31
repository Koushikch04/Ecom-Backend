package com.koushik.Web.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
    private Date releaseDate;
    private Boolean available;
    private Integer quantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[]  imageData;
}
