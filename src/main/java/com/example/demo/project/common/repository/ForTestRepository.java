package com.example.demo.project.common.repository;

import com.example.demo.project.common.entity.ForTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForTestRepository extends JpaRepository<ForTestEntity, Integer> {


}
