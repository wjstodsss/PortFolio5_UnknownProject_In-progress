package com.unknown.paldak.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.common.domain.ReplyVO;
import com.unknown.paldak.admin.mapper.ReviewReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReviewReplyServiceImpl implements BaseService<ReplyVO>{
    
	@Autowired
	private ReviewReplyMapper mapper;

	@Override
	public void register(ReplyVO replyVO) {
		System.out.println("222222222222222222222222");
		if(replyVO.getReply() != null && replyVO.getReply().length()!=0) {
			replyVO.setAnswer('Y');
		}
		log.info("register... " + replyVO);
		mapper.insertSelectKey(replyVO);
		
	}

	@Override
	public ReplyVO get(Long replyId) {
		log.info("get..." + replyId);	
		return mapper.read(replyId);
	}

	@Override
	public boolean modify(ReplyVO replyVO) {
		return mapper.update(replyVO)==1;
	}

	@Override
	public Boolean remove(Long replyId) {
		log.info("remove ... " + replyId);
		return mapper.delete(replyId)==1;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri) {
		System.out.println(cri+"reply");
		return mapper.getList();
	}
	
	@Override
	public List<ReplyVO> getDescList(Criteria cri) {
		System.out.println(cri);
		return mapper.getDescListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	public ReplyVO getByReviewId(Long reviewId) {
		return mapper.readByReviewId(reviewId);
	}
	
	
}