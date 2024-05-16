package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaVO {
  private Long qnaId;
  private String qnaName;
  private String qnaDescription;
  private Long qnaPrice;
  private Integer qnaCategory;
  private String qnaBrand;
  private String qnaImageURL;
  private Date qnaRegdate;
  private Date qnaUpdateDate;
}