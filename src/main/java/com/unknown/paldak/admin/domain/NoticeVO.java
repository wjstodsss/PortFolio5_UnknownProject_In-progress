package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
  private Long noticeId;
  private String noticeName;
  private String noticeDescription;
  private Long noticePrice;
  private Integer noticeCategory;
  private String noticeBrand;
  private String noticeImageURL;
  private Date noticeRegdate;
  private Date noticeUpdateDate;
}

