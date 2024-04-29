package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.FaqVO;

public interface FaqService {
  public void register(FaqVO faqVO);
  
  public FaqVO get(Long faqId);
  
  public boolean modify(FaqVO faqVO);
  
  public Boolean remove(Long faqId);
  
  public List<FaqVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
