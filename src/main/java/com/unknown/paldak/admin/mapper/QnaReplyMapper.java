package com.unknown.paldak.admin.mapper;


import com.unknown.paldak.admin.common.domain.ReplyVO;

public interface QnaReplyMapper extends BaseMapper<ReplyVO>{
	public ReplyVO readByQnaId(Long qnaId);
	
}
