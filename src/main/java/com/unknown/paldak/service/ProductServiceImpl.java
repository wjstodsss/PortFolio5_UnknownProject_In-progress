package com.unknown.paldak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.domain.Criteria;
import com.unknown.paldak.domain.ProductVO;
import com.unknown.paldak.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    
	@Autowired
	private ProductMapper mapper;

	@Override
	public void register(ProductVO board) {
		log.info("register... " + board);
		mapper.insertSelectKey(board);
		
	}

	@Override
	public ProductVO get(Long bno) {
		log.info("get..." + bno);	
		return mapper.read(bno);
	}

	@Override
	public boolean modify(ProductVO board) {
		return mapper.update(board)==1;
	}

	@Override
	public Boolean remove(Long bno) {
		log.info("remove ... " + bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<ProductVO> getList(Criteria cri) {
		System.out.println("**///////************************");
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}
