package com.mentoring.mdm.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
@Setter
@Getter
public class ProductJdbc {

  @Id private String id;

  private String name;

  private String category;
}
