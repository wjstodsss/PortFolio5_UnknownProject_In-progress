package com.unknown.paldak.admin.mapper;


import com.unknown.paldak.admin.domain.ReviewReplyVO;

public interface ReviewReplyMapper extends BaseMapper<ReviewReplyVO>{
	public ReviewReplyVO readByReviewId(Long reviewId);
	
}
