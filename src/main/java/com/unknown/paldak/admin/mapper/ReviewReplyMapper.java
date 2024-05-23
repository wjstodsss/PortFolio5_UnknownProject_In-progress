package com.unknown.paldak.admin.mapper;


import com.unknown.paldak.admin.common.domain.ReplyVO;

public interface ReviewReplyMapper extends BaseMapper<ReplyVO>{
	public ReplyVO readByReviewId(Long reviewId);
	
}
