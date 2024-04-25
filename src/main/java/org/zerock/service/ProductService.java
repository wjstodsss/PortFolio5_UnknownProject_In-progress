package org.zerock.service;

import java.util.List;

import org.zerock.domain.ProductVO;
import org.zerock.domain.Criteria;

public interface ProductService {
  public void register(ProductVO board);
  
  public ProductVO get(Long bno);
  
  public boolean modify(ProductVO board);
  
  public Boolean remove(Long bno);
  
  public List<ProductVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
