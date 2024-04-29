package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.MemberVO;

public interface MemberService {
  public void register(MemberVO memberVO);
  
  public MemberVO get(Long memberId);
  
  public boolean modify(MemberVO memberVO);
  
  public Boolean remove(Long memberId);
  
  public List<MemberVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
