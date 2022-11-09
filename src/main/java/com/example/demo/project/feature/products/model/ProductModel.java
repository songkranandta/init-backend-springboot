package com.example.demo.project.feature.products.model;

import lombok.*;

import java.math.BigDecimal;

public class ProductModel {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Product{
        private int id;
        private String productName;
        private String productType;
        private BigDecimal productPrice;
        private String productWeight;
        private String productBrand;
    }
}
