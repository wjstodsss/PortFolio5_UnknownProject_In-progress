package com.unknown.paldak.admin.product.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.product.domain.ProductVO;

public interface ProductService {
  public void register(ProductVO board);
  
  public ProductVO get(Long bno);
  
  public boolean modify(ProductVO board);
  
  public Boolean remove(Long bno);
  
  public List<ProductVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
