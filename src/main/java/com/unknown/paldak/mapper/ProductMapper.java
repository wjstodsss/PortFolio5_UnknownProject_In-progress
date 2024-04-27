package com.unknown.paldak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.unknown.paldak.domain.Criteria;
import com.unknown.paldak.domain.ProductVO;

public interface ProductMapper {
   
	
	public List<ProductVO> getList();
	
	public void insert(ProductVO board);
	
	public void insertSelectKey(ProductVO board);
	
	public ProductVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(ProductVO board);
	
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
