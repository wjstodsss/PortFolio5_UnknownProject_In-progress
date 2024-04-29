package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.QnaVO;

public interface QnaService {
  public void register(QnaVO qnaVO);
  
  public QnaVO get(Long qnaId);
  
  public boolean modify(QnaVO qnaVO);
  
  public Boolean remove(Long qnaId);
  
  public List<QnaVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}