package com.unknown.paldak.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
@WebAppConfiguration
public class ProductControllerTests {
	@Autowired
	private WebApplicationContext ctx; // 웹 애플리케션 컨텍스트 주입

	private MockMvc mockMvc;

	@Before // mockMvc 객체를 초기화
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/admin/product/list")) // 요청 URL
				.andReturn() // 요청반환
				.getModelAndView() // 모델과 뷰반환
				.getModelMap()); // 모델맵 객체 반환
	}

	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/admin/product/list") // 요청 URL
				.param("pageNum", "1")
				.param("amount", "10"))
				.andReturn() // 요청반환
				.getModelAndView() // 모델과 뷰반환
				.getModelMap()); // 모델맵 객체 반환
	}
	
//	@Test
//	public void testResister() throws Exception {
//		String resultPage = mockMvc
//				.perform(MockMvcRequestBuilders.post("/admin/product/register").param("productName", "test")
//						.param("content", "content....").param("writer", "writer...."))
//				.andReturn().getModelAndView().getViewName();
//
//		log.info(resultPage);
//
//	}

//	@Test
//	public void testGet() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/admin/product/get").param("productId", "10124")).andReturn()
//				.getModelAndView().getModelMap());
//
//	}
//
	@Test
	public void testModify() throws Exception {
	    // 테스트할 파일 생성
	    MockMultipartFile file = new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());

	    String resultPage = mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/product/modify")
	            .file(file)
	            .param("productName", "수정된 텍스트 새글 제목10")
	            .param("productDescription", "수정된 텍스트 새글 제목10")
	            .param("productPrice", "1000")
	            .param("productCategory", "1000")
	            .param("productBrand", "nike")
	            .param("productImageURL", "수정된 텍스트 새글 제목10")
	            .param("productId", "10124"))
	            .andReturn().getModelAndView().getViewName();

	    log.info(resultPage);
	}
	
	
	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/admin/product/remove").param("productId", "10126"))
				.andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		
				
	}
	

}
