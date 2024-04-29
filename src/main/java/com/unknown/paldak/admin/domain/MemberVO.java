package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
  private Long memberId;
  private String memberName;
  private String memberDescription;
  private Long memberPrice;
  private Integer memberCategory;
  private String memberBrand;
  private String memberImageURL;
  private Date memberRegdate;
  private Date memberUpdateDate;
}

