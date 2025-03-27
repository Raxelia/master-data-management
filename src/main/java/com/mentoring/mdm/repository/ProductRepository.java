package com.mentoring.mdm.repository;

import com.mentoring.mdm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
