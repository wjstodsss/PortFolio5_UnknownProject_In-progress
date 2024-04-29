package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.ReviewVO;

public interface ReviewService {
  public void register(ReviewVO reviewVO);
  
  public ReviewVO get(Long reviewId);
  
  public boolean modify(ReviewVO reviewVO);
  
  public Boolean remove(Long reviewId);
  
  public List<ReviewVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}