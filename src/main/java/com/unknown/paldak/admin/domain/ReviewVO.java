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
   private String reviewTitle;
   private String reviewContent;
   private String reviewImageURL;
   private String reviewWriter;
   private Date reviewRegdate;
   private Date reviewUpdateDate;
}
