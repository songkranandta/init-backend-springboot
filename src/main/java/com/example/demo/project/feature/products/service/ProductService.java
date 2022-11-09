package com.example.demo.project.feature.products.service;

import com.example.demo.project.common.entity.ProductTaEntity;
import com.example.demo.project.common.repository.ProductTaRepository;
import com.example.demo.project.feature.products.model.ProductModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductTaRepository productTaRepository;

    public List<ProductModel.Product> getAll(){
        List<ProductModel.Product> dataAll = new ArrayList<>();
        productTaRepository.findAll().forEach(data ->{
            ProductModel.Product resData = new ProductModel.Product();
            resData.setId(data.getId());
            resData.setProductName(data.getProductName());
            resData.setProductWeight(data.getProductWeight());
            resData.setProductPrice(data.getProductPrice());
            resData.setProductType(data.getProductType());
            resData.setProductBrand(data.getProductBrand());
            resData.setProductType(data.getProductType());
            dataAll.add(resData);
        });
        return dataAll;
    }

    public ProductTaEntity save(ProductModel.Product req){
        ProductTaEntity data = new ProductTaEntity();
        data.setProductName(req.getProductName());
        data.setProductWeight(req.getProductWeight());
        data.setProductPrice(req.getProductPrice());
        data.setProductType(req.getProductType());
        data.setProductBrand(req.getProductBrand());
        data.setProductType(req.getProductType());
        return productTaRepository.save(data);
    }

    public String  delete(ProductModel.Product req){
        productTaRepository.deleteById(req.getId());

        return "ลบสำเร็จ";
    }

    public ProductModel.Product edit(ProductModel.Product req){

        ProductTaEntity data = productTaRepository.findById(req.getId()).get();
        data.setProductName(req.getProductName());
        data.setProductWeight(req.getProductWeight());
        data.setProductPrice(req.getProductPrice());
        data.setProductType(req.getProductType());
        data.setProductBrand(req.getProductBrand());
        data.setProductType(req.getProductType());
        productTaRepository.save(data);
        return req;
    }


}
