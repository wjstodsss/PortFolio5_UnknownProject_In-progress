package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.MemberVO;


public interface MemberMapper {
   
	
	public List<MemberVO> getList();
	
	public void insert(MemberVO memberVO);
	
	public void insertSelectKey(MemberVO memberVO);
	
	public MemberVO read(Long memberId);
	
	public int delete(Long memberId);
	
	public int update(MemberVO memberVO);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<MemberVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}
