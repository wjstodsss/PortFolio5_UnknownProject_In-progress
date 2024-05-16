package com.unknown.paldak.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private int memberId;
    private String memberPw;
    private String memberName;
    private String memberMail;
    private String memberAddr1;
    private String memberAddr2;
    private String memberAddr3;
    private int adminCk;
    private Date regDate;
    private int money;
    private int point;
    private int memberPhone;
}

