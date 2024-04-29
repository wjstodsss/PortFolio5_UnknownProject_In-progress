package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FaqVO {
  private Long faqId;
  private String faqName;
  private String faqDescription;
  private Long faqPrice;
  private Integer faqCategory;
  private String faqBrand;
  private String faqImageURL;
  private Date faqRegdate;
  private Date faqUpdateDate;
}
