package com.unknown.paldak.admin.common.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
    private Long replyId;
    private Long reviewId;
    private Long qnaId;
    private Long replyTypeId;
    private String reply;
    private String replyer;
    private Date replyDate;
    private Date replyUpdateDate;
    private Character answer;
}