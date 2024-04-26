package com.unknown.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unknown.ecommerce.domain.Criteria;
import com.unknown.ecommerce.domain.PageDTO;
import com.unknown.ecommerce.domain.ProductVO;
import com.unknown.ecommerce.service.ProductService;
import com.unknown.ecommerce.util.FileUploadUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/product/*")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final ServletContext servletContext;
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		
		List<ProductVO> list = productService.getList(cri);
//		list.forEach(productVO -> log.info(productVO));
		model.addAttribute("products", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = productService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/product/list";
	}

	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, ProductVO productVO, RedirectAttributes rttr) {
		String imageURL = FileUploadUtil.uploadFiles(uploadFile, servletContext.getRealPath("/upload"));
	    productVO.setProductImageURL(imageURL);
	    
	    
	    productService.register(productVO); // 상품 등록
	    
	    rttr.addFlashAttribute("result", productVO.getProductId());
	    
	    return "redirect:list";
	}


	@GetMapping("/register")
	public String register() {
		return "admin/product/register";
	}

	@GetMapping({ "/get", "/modify" })
	public String get(HttpServletRequest request, @RequestParam("productId") Long productId, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("product", productService.get(productId));
		log.info(productService.get(productId));
		if (request.getRequestURI().endsWith("/get")) {
	        return "admin/product/get";
	    } else {
	        return "admin/product/modify";
	    }
	} 
	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, ProductVO productVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (uploadFile[0].getSize() != 0 ) { 
			String imageURL = FileUploadUtil.uploadFiles(uploadFile, servletContext.getRealPath("/upload"));
		    productVO.setProductImageURL(imageURL);
		    
	    }
	    
	    if (productService.modify(productVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }

	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());

	    return "redirect:list";
	}
	

	@PostMapping("/remove")
	public String remove(@RequestParam("productId") Long productId, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + productId);
		if (productService.remove(productId)) {
			rttr.addFlashAttribute("result", "success");
			log.info("remove..." + productId);
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}

	
	@GetMapping("/upload/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
	    log.info("..*******************************...");
	    // 파일 경로 설정
	    String uploadDirectory = servletContext.getRealPath("/upload");
	    log.info(uploadDirectory);
	    Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
	    log.info(filePath);
	    Resource resource;
	    try {
	        resource = new UrlResource(filePath.toUri());
	        if (resource.exists()) {
	            return ResponseEntity.ok()
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                    .body(resource);
	        }
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    return ResponseEntity.notFound().build();
	}
	
	// 파일 업로드를 처리하는 메서드
	private String uploadFiles(MultipartFile[] uploadFiles) {
	    String uploadPath = servletContext.getRealPath("/upload");
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	    
	    StringBuilder imageURLs = new StringBuilder(); // 업로드된 파일 경로들을 저장할 StringBuilder
	    
	    for (MultipartFile multipartFile : uploadFiles) {
	        String originalFilename = multipartFile.getOriginalFilename();
	        String uploadedFilePath = uploadPath + "/" + originalFilename;
	        
	        try { 
	            multipartFile.transferTo(new File(uploadedFilePath)); // 파일을 업로드
	            imageURLs.append(originalFilename).append(";"); // 업로드된 파일의 경로를 StringBuilder에 추가
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return imageURLs.toString(); // 업로드된 파일들의 경로를 반환
	}

	
}


