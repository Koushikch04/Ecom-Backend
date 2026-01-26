package com.koushik.Web.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductUpdateDTO {

    @NotNull
    private Integer id;

    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private String description;
    private Date releaseDate;
    private Boolean available;

    @Min(0)
    private Integer quantity;
}
