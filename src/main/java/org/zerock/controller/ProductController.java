package org.zerock.controller;

import java.io.File;
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
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ProductVO;
import org.zerock.service.ProductService;


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
		list.forEach(productVO -> log.info(productVO));
		model.addAttribute("products", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = productService.getTotal(cri);
        log.info(total);
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/product/list";
	}


	@PostMapping("/register")
	public String register(MultipartFile[] uploadFile, Model model, ProductVO productVO, RedirectAttributes rttr) {
	    String uploadPath = servletContext.getRealPath("/upload");
	    log.info(uploadPath);
	    
	    // 업로드 디렉토리 생성
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	    
	    for (MultipartFile multipartFile : uploadFile) {
	        log.info("---------------------------------");
	        log.info("upload File Name : " + multipartFile.getOriginalFilename());
	        log.info("upload File Size : " + multipartFile.getSize());

	     // 실제로 파일을 저장하기 위한 File 객체 생성
	        File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());
	        productVO.setProductImageURL(multipartFile.getOriginalFilename());
	        try { // 파일을 지정된 경로에 저장
	            multipartFile.transferTo(saveFile);
	        } catch (Exception e) { // 파일 저장 중 예외 발생 시 에러 메시지 출력
	            e.printStackTrace();
	        }
	    }
	    
	    log.info("register... " + productVO);
	    productService.register(productVO);

	    rttr.addFlashAttribute("result", productVO.getProductId());
	    log.info(productVO.getProductId());
	   
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
		System.out.println(productVO.getProductImageURL());
		System.out.println(uploadFile[0].getSize());
		if (uploadFile[0].getSize() != 0 ) { // uploadFile이 null이 아닌 경우에만 실행
	        String uploadPath = servletContext.getRealPath("/upload");
	        log.info(uploadPath);

	        // 업로드 디렉토리 생성
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        
	        for (MultipartFile multipartFile : uploadFile) {
	        	
	            log.info("---------------------------------");
	            log.info("upload File Name : " + multipartFile.getOriginalFilename());
	            log.info("upload File Size : " + multipartFile.getSize());

	            // 실제로 파일을 저장하기 위한 File 객체 생성
	            File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());
	            productVO.setProductImageURL(multipartFile.getOriginalFilename());
	            try { // 파일을 지정된 경로에 저장
	                multipartFile.transferTo(saveFile);
	            } catch (Exception e) { // 파일 저장 중 예외 발생 시 에러 메시지 출력
	                e.printStackTrace();
	            }
	        }
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
	    log.info(".....................................................");
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
	
	

}
