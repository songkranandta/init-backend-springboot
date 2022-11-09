package com.example.demo.project.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_ta")
public class ProductTaEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name",nullable = false,length = 200)
    private String productName;

    @Column(name = "product_type",length = 200)
    private String productType;

    @Column(name = "product_price",nullable = false,length = 200)
    private BigDecimal productPrice;

    @Column(name = "product_weight",length = 100)
    private String productWeight;

    @Column(name = "product_brand",length = 200)
    private String productBrand;

}
