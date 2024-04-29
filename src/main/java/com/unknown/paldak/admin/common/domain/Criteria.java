package com.unknown.paldak.admin.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
   private Integer pageNum; //페이지 번호
   
   private Integer amount; //페이지 보여줄 갯수
   
   
   public Criteria() {
	   this(1,10); //디폴트
   }
   
   public Criteria(int pageNum, int amount) {
	   this.pageNum = pageNum;   
	   this.amount = amount;   
   }
}
