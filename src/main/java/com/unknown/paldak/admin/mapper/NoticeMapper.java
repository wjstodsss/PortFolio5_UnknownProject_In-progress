package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.NoticeVO;


public interface NoticeMapper {
   
	
	public List<NoticeVO> getList();
	
	public void insert(NoticeVO noticeVO);
	
	public void insertSelectKey(NoticeVO noticeVO);
	
	public NoticeVO read(Long noticeId);
	
	public int delete(Long noticeId);
	
	public int update(NoticeVO noticeVO);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<NoticeVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}
