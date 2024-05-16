package com.unknown.paldak.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.common.domain.PageDTO;
import com.unknown.paldak.admin.domain.QnaVO;
import com.unknown.paldak.admin.service.BaseService;
import com.unknown.paldak.admin.service.TableHeadService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/qna/*")
@RequiredArgsConstructor
public class QnaController {

	private final BaseService<QnaVO> qnaService;
	private final TableHeadService tableHeadService;


	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri.getPageNum());
		
		String[] tableHead = tableHeadService.getTableHead("3");
		model.addAttribute("tableHead", tableHead);
		
		List<QnaVO> list = qnaService.getList(cri);
		list.forEach(qnaVO -> System.out.println(qnaVO));
		model.addAttribute("qnas", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = qnaService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/qna/list";
	}

	
	@GetMapping("/descList")
	public String descList(Criteria cri, Model model) {
		System.out.println("1");
		System.out.println(cri);
		
		String[] tableHead = tableHeadService.getTableHead("1");
		model.addAttribute("tableHead", tableHead);
		
		List<QnaVO> list = qnaService.getDescList(cri);
		list.forEach(qnaVO -> System.out.println(qnaVO));
		model.addAttribute("qnas", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = qnaService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/qna/list";
	}
	
	@PostMapping("/register")
	public String register(Model model, QnaVO qnaVO, RedirectAttributes rttr) {
	   System.out.println("kkkk");
	    qnaService.register(qnaVO);
	    System.out.println("kkkfsdfsdfsfsdfk");
	    rttr.addFlashAttribute("result", qnaVO.getQnaId());
	    
	    return "redirect:descList";
	}

	@GetMapping(value = "/get/{qnaId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<QnaVO> get(@PathVariable("qnaId") Long qnaId) {
		return new ResponseEntity<>(qnaService.get(qnaId), HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	public String modify(QnaVO qnaVO, @ModelAttribute("cri") Criteria cri, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
	    if (qnaService.modify(qnaVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());
	    return "redirect:" + currentPath;
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("qnaId") Long qnaId, @ModelAttribute("cri") Criteria cri, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
		System.out.println("remove..." + qnaId);
		if (qnaService.remove(qnaId)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		System.out.println("remove..." + qnaId);
		return "redirect:" + currentPath;
	}
}