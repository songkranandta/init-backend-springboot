package com.example.demo.project.common.repository;

import com.example.demo.project.common.entity.ForTestEntity;
import com.example.demo.project.common.entity.ProductTaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTaRepository extends JpaRepository<ProductTaEntity, Integer> {
}
