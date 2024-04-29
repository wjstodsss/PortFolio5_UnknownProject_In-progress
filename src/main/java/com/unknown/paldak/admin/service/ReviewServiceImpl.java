package com.unknown.paldak.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.ReviewVO;
import com.unknown.paldak.admin.mapper.ReviewMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    
	@Autowired
	private ReviewMapper mapper;

	@Override
	public void register(ReviewVO reviewVO) {
		log.info("register... " + reviewVO);
		mapper.insertSelectKey(reviewVO);
		
	}

	@Override
	public ReviewVO get(Long reviewId) {
		log.info("get..." + reviewId);	
		return mapper.read(reviewId);
	}

	@Override
	public boolean modify(ReviewVO reviewVO) {
		return mapper.update(reviewVO)==1;
	}

	@Override
	public Boolean remove(Long reviewId) {
		log.info("remove ... " + reviewId);
		return mapper.delete(reviewId)==1;
	}

	@Override
	public List<ReviewVO> getList(Criteria cri) {
		System.out.println(cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}
