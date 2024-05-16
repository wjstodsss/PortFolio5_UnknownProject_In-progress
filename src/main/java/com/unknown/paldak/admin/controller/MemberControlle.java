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
import com.unknown.paldak.admin.domain.MemberVO;
import com.unknown.paldak.admin.domain.TableHeadVO;
import com.unknown.paldak.admin.service.BaseService;
import com.unknown.paldak.admin.service.TableHeadService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/member/*")
@RequiredArgsConstructor
public class MemberControlle {

	private final BaseService<MemberVO> memberService;
	private final TableHeadService tableHeadService;


	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri.getPageNum());
		
		String[] tableHead = tableHeadService.getTableHead("1");
		model.addAttribute("tableHead", tableHead);
		
		List<MemberVO> list = memberService.getList(cri);
		list.forEach(memberVO -> System.out.println(memberVO));
		model.addAttribute("members", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = memberService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/member";
	}

	
	@GetMapping("/descList")
	public String descList(Criteria cri, Model model) {
		System.out.println("1");
		System.out.println(cri);
		
		String[] tableHead = tableHeadService.getTableHead("1");
		model.addAttribute("tableHead", tableHead);
		
		List<MemberVO> list = memberService.getDescList(cri);
		list.forEach(memberVO -> System.out.println(memberVO));
		model.addAttribute("members", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = memberService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/member";
	}
	
	@PostMapping("/register")
	public String register(Model model, MemberVO memberVO, RedirectAttributes rttr) {
	   System.out.println("kkkk");
	    memberService.register(memberVO);
	    System.out.println("kkkfsdfsdfsfsdfk");
	    rttr.addFlashAttribute("result", memberVO.getMemberId());
	    
	    return "redirect:descList";
	}

	@GetMapping(value = "/get/{memberId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MemberVO> get(@PathVariable("memberId") Long memberId) {
		return new ResponseEntity<>(memberService.get(memberId), HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO memberVO, @ModelAttribute("cri") Criteria cri, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
	    if (memberService.modify(memberVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());
	    return "redirect:" + currentPath;
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("memberId") Long memberId, @ModelAttribute("cri") Criteria cri, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
		System.out.println("remove..." + memberId);
		if (memberService.remove(memberId)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		System.out.println("remove..." + memberId);
		return "redirect:" + currentPath;
	}
}