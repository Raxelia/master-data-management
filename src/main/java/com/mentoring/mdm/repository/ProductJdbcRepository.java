package com.mentoring.mdm.repository;

import com.mentoring.mdm.model.ProductJdbc;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductJdbcRepository extends CrudRepository<ProductJdbc, String> {
  List<ProductJdbc> findByName(String name);
}
