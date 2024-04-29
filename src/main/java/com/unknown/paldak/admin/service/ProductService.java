package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.ProductVO;

public interface ProductService {
  public void register(ProductVO productVO);
  
  public ProductVO get(Long productId);
  
  public boolean modify(ProductVO productVO);
  
  public Boolean remove(Long productId);
  
  public List<ProductVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
