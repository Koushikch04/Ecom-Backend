package com.koushik.Web.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductResponseDTO {

    private Integer id;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private String description;
    private Date releaseDate;
    private Boolean available;
    private Integer quantity;
}
