package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.QnaVO;


public interface QnaMapper {
   
	
	public List<QnaVO> getList();
	
	public void insert(QnaVO qnaVO);
	
	public void insertSelectKey(QnaVO qnaVO);
	
	public QnaVO read(Long qnaId);
	
	public int delete(Long qnaId);
	
	public int update(QnaVO qnaVO);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<QnaVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}