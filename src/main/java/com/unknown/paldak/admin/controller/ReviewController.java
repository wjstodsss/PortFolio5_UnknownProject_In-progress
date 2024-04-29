package com.unknown.paldak.admin.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.common.domain.PageDTO;
import com.unknown.paldak.admin.domain.ReviewVO;
import com.unknown.paldak.admin.service.ReviewService;
import com.unknown.paldak.admin.util.FileUploadManager;
import com.unknown.paldak.admin.util.UploadPathConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/review/*")
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	private final FileUploadManager fileUploadManager;
	private final UploadPathConfig uploadPathConfig;
	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri);
		
		List<ReviewVO> list = reviewService.getList(cri);
		list.forEach(reviewVO -> System.out.println(reviewVO));
		model.addAttribute("reviews", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = reviewService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/review/list";
	}

	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, ReviewVO reviewVO, RedirectAttributes rttr) {
		
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			reviewVO.setReviewImageURL(imageURL);
		}
	    
	    reviewService.register(reviewVO);
	    
	    rttr.addFlashAttribute("result", reviewVO.getReviewId());
	    
	    return "redirect:list";
	}


	@GetMapping("/register")
	public String register() {
		return "admin/review/register";
	}

	@GetMapping({ "/get", "/modify" })
	public String get(HttpServletRequest request, @RequestParam("reviewId") Long reviewId, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("review", reviewService.get(reviewId));
		log.info(reviewService.get(reviewId));
		if (request.getRequestURI().endsWith("/get")) {
	        return "admin/review/get";
	    } else {
	        return "admin/review/modify";
	    }
	} 
	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, ReviewVO reviewVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
		    reviewVO.setReviewImageURL(imageURL);
		    
	    }
	    
	    if (reviewService.modify(reviewVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }

	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());

	    return "redirect:list";
	}
	

	@PostMapping("/remove")
	public String remove(@RequestParam("reviewId") Long reviewId, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + reviewId);
		if (reviewService.remove(reviewId)) {
			rttr.addFlashAttribute("result", "success");
			log.info("remove..." + reviewId);
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}

	
	@GetMapping("/upload/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {  
	    String uploadDirectory = uploadPathConfig.getUploadPath();
	    Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
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