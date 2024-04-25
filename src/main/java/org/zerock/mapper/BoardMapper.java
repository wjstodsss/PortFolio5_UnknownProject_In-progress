package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ProductVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
   
	
	public List<ProductVO> getList();
	
	public void insert(ProductVO board);
	
	public void insertSelectKey(ProductVO board);
	
	public ProductVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(ProductVO board);
	
	//페이지 정보를 기반으로 게시물 목록을 가져옴
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);  // 전체 데이터 갯수
}
