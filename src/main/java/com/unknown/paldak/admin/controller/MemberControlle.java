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
import com.unknown.paldak.admin.domain.MemberVO;
import com.unknown.paldak.admin.service.MemberService;
import com.unknown.paldak.admin.util.FileUploadManager;
import com.unknown.paldak.admin.util.UploadPathConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/member/*")
@RequiredArgsConstructor
public class MemberControlle {

	private final MemberService memberService;
	private final FileUploadManager fileUploadManager;
	private final UploadPathConfig uploadPathConfig;
	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri);
		
		List<MemberVO> list = memberService.getList(cri);
		list.forEach(memberVO -> System.out.println(memberVO));
		model.addAttribute("members", list);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 123)); // 레코드 전체갯수, 13page
        int total = memberService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/member/list";
	}

	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, MemberVO memberVO, RedirectAttributes rttr) {
		
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			memberVO.setMemberImageURL(imageURL);
		}
	    
	    memberService.register(memberVO);
	    
	    rttr.addFlashAttribute("result", memberVO.getMemberId());
	    
	    return "redirect:list";
	}


	@GetMapping("/register")
	public String register() {
		return "admin/member/register";
	}

	@GetMapping({ "/get", "/modify" })
	public String get(HttpServletRequest request, @RequestParam("memberId") Long memberId, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("member", memberService.get(memberId));
		log.info(memberService.get(memberId));
		if (request.getRequestURI().endsWith("/get")) {
	        return "admin/member/get";
	    } else {
	        return "admin/member/modify";
	    }
	} 
	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, MemberVO memberVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
		    memberVO.setMemberImageURL(imageURL);
		    
	    }
	    
	    if (memberService.modify(memberVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }

	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());

	    return "redirect:list";
	}
	

	@PostMapping("/remove")
	public String remove(@RequestParam("memberId") Long memberId, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + memberId);
		if (memberService.remove(memberId)) {
			rttr.addFlashAttribute("result", "success");
			log.info("remove..." + memberId);
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