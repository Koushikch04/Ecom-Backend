package com.koushik.Web.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date releaseDate;
    private Boolean available;

    @Min(0)
    private Integer quantity;
    private String imageBase64;
    private String imageType;
}
