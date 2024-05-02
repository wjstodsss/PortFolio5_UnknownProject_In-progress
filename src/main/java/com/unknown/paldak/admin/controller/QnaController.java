package com.unknown.paldak.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.common.domain.PageDTO;

import com.unknown.paldak.admin.domain.QnaVO;
import com.unknown.paldak.admin.service.BaseService;
import com.unknown.paldak.admin.util.FileUploadManager;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/qna/*")
@RequiredArgsConstructor
public class QnaController {

	private final BaseService<QnaVO> qnaService;
	private final FileUploadManager fileUploadManager;
	
	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri);
		
		List<QnaVO> list = qnaService.getList(cri);
		list.forEach(qnaVO -> System.out.println(qnaVO));
		model.addAttribute("qnas", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = qnaService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/qna/list";
	}

	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, QnaVO qnaVO, RedirectAttributes rttr) {
		
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			qnaVO.setQnaImageURL(imageURL);
		}
	    
	    qnaService.register(qnaVO);
	    
	    rttr.addFlashAttribute("result", qnaVO.getQnaId());
	    
	    return "redirect:list";
	}


	@GetMapping("/register")
	public String register() {
		return "admin/qna/register";
	}

	@GetMapping({ "/get", "/modify" })
	public String get(HttpServletRequest request, @RequestParam("qnaId") Long qnaId, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("qna", qnaService.get(qnaId));
		log.info(qnaService.get(qnaId));
		if (request.getRequestURI().endsWith("/get")) {
	        return "admin/qna/get";
	    } else {
	        return "admin/qna/modify";
	    }
	} 
	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, QnaVO qnaVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
		    qnaVO.setQnaImageURL(imageURL);
		    
	    }
	    
	    if (qnaService.modify(qnaVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }

	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());

	    return "redirect:list";
	}
	

	@PostMapping("/remove")
	public String remove(@RequestParam("qnaId") Long qnaId, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + qnaId);
		if (qnaService.remove(qnaId)) {
			rttr.addFlashAttribute("result", "success");
			log.info("remove..." + qnaId);
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}


}