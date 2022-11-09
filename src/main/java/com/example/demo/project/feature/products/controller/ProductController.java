package com.example.demo.project.feature.products.controller;

import com.example.demo.project.common.entity.ProductTaEntity;
import com.example.demo.project.feature.products.model.ProductModel;
import com.example.demo.project.feature.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductModel.Product>>getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<ProductTaEntity>save(@RequestBody ProductModel.Product req){
        return ResponseEntity.ok(productService.save(req));
    }

    @PostMapping("/delete")
    public ResponseEntity<String>delete(@RequestBody ProductModel.Product req){
        return ResponseEntity.ok(productService.delete(req));
    }

    @PostMapping("/update")
    public ResponseEntity<?>update(@RequestBody ProductModel.Product req){
        return ResponseEntity.ok(productService.edit(req));
    }
}
