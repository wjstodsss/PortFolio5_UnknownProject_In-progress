package org.zerock.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unknown.ecommerce.domain.Criteria;
import com.unknown.ecommerce.domain.ProductVO;
import com.unknown.ecommerce.mapper.ProductMapper;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

  @Autowired
  private ProductMapper mapper;
  
  @Test
  public void testGetList() {
	  mapper.getList().forEach(productVO->log.info(productVO));
  }
  
  @Test
  public void testInsert() {
	  Date regDate = new Date(2024, 12, 24); // Deprecated되어 사용을 권장하지 않음
	  Date updateDate = new Date(2024, 12, 25); // Deprecated되어 사용을 권장하지 않음
	  ProductVO productVO = new ProductVO();
	  productVO.setProductName("제품1");
	  productVO.setProductDescription("설명");
	  productVO.setProductPrice((long) 1000);
	  productVO.setProductCategory(1);
	  productVO.setProductBrand("나이스");
	  productVO.setProductImageURL(".핑");
	  productVO.setProductRegdate(regDate);
	  productVO.setProductUpdateDate(updateDate);
	  mapper.insert(productVO);
	  log.info(productVO);
  }
  
  
//  @Test
//  public void testInsertSelectKey() {
//	  ProductVO productVO = new ProductVO();
//	  productVO.setTitle("새로 작성하는 글 select key");
//	  productVO.setContent("새로 작성하는 내용 select key");
//	  productVO.setWriter("newbie");
//	  
//	  mapper.insertSelectKey(productVO);
//	  log.info(productVO);
//	  
//  }
//  
//  
//  @Test
//  public void testRead() {
//	  ProductVO productVO = mapper.read(6L);
//	  log.info(productVO);
//  }
//  
//  @Test
//  public void testDelete() {
// 	  log.info("delete num :" + mapper.delete(7L));
//  }
//  
//  @Test
//  public void testUpdate() {
//	  ProductVO productVO = new ProductVO();
//	  
//	  productVO.setBno(6L);
//	  productVO.setTitle("수정된 제목12");
//	  productVO.setContent("수정된 내용12");
//	  productVO.setWriter("user00");
//	  
//	  int count = mapper.update(productVO);
//	  log.info("update num :" + count);
//  }
//  
//  
//  @Test
//  public void testPageing() {
//	  Criteria cri = new Criteria(2,5);
//	  List<ProductVO> list = mapper.getListWithPaging(cri);
//	  list.forEach(productVO->log.info(productVO));
//  }
//  
}
