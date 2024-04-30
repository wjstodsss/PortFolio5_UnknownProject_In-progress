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
import com.unknown.paldak.admin.domain.FaqVO;
import com.unknown.paldak.admin.service.FaqService;
import com.unknown.paldak.admin.util.FileUploadManager;
import com.unknown.paldak.admin.util.UploadPathConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/faq/*")
@RequiredArgsConstructor
public class FaqController {

	private final FaqService faqService;
	private final FileUploadManager fileUploadManager;
	private final UploadPathConfig uploadPathConfig;
	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri);
		
		List<FaqVO> list = faqService.getList(cri);
		list.forEach(faqVO -> System.out.println(faqVO));
		model.addAttribute("faqs", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = faqService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/faq/list";
	}

	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, FaqVO faqVO, RedirectAttributes rttr) {
		
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			faqVO.setFaqImageURL(imageURL);
		}
	    
	    faqService.register(faqVO);
	    
	    rttr.addFlashAttribute("result", faqVO.getFaqId());
	    
	    return "redirect:list";
	}


	@GetMapping("/register")
	public String register() {
		return "admin/faq/register";
	}

	@GetMapping({ "/get", "/modify" })
	public String get(HttpServletRequest request, @RequestParam("faqId") Long faqId, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("faq", faqService.get(faqId));
		log.info(faqService.get(faqId));
		if (request.getRequestURI().endsWith("/get")) {
	        return "admin/faq/get";
	    } else {
	        return "admin/faq/modify";
	    }
	} 
	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, FaqVO faqVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
		    faqVO.setFaqImageURL(imageURL);
		    
	    }
	    
	    if (faqService.modify(faqVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }

	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());

	    return "redirect:list";
	}
	

	@PostMapping("/remove")
	public String remove(@RequestParam("faqId") Long faqId, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + faqId);
		if (faqService.remove(faqId)) {
			rttr.addFlashAttribute("result", "success");
			log.info("remove..." + faqId);
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}


	
}