package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.ReviewVO;


public interface ReviewMapper {
   
	
	public List<ReviewVO> getList();
	
	public void insert(ReviewVO reviewVO);
	
	public void insertSelectKey(ReviewVO reviewVO);
	
	public ReviewVO read(Long reviewId);
	
	public int delete(Long reviewId);
	
	public int update(ReviewVO reviewVO);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<ReviewVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}