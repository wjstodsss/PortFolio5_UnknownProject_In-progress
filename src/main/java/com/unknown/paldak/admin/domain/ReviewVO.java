package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
  private Long reviewId;
  private String reviewName;
  private String reviewDescription;
  private Long reviewPrice;
  private Integer reviewCategory;
  private String reviewBrand;
  private String reviewImageURL;
  private Date reviewRegdate;
  private Date reviewUpdateDate;
}