package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.FaqVO;


public interface FaqMapper {
   
	
	public List<FaqVO> getList();
	
	public void insert(FaqVO faqVO);
	
	public void insertSelectKey(FaqVO faqVO);
	
	public FaqVO read(Long faqId);
	
	public int delete(Long faqId);
	
	public int update(FaqVO faqVO);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<FaqVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}
