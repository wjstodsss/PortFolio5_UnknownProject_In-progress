package com.unknown.ecommerce.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
  private Long productId;
  private String productName;
  private String productDescription;
  private Long productPrice;
  private Integer productCategory;
  private String productBrand;
  private String productImageURL;
  private Date productRegdate;
  private Date productUpdateDate;
}
