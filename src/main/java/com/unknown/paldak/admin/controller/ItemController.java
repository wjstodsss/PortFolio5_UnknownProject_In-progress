package com.unknown.paldak.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.common.domain.PageDTO;
import com.unknown.paldak.admin.common.domain.ReplyVO;
import com.unknown.paldak.admin.domain.ItemVO;
import com.unknown.paldak.admin.service.BaseService;

import com.unknown.paldak.admin.util.FileUploadManager;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("admin/item/*")
@RequiredArgsConstructor
public class ItemController {

	private final BaseService<ItemVO> itemService;
    private final FileUploadManager fileUploadManager;


	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		System.out.println("jlkjlkjl");
		System.out.println(cri.getPageNum()+"1321321");
		
		
		
		List<ItemVO> list = itemService.getList(cri);
		list.forEach(itemVO -> System.out.println(itemVO + "kkkkkkkkkkkkkkkk"));
		model.addAttribute("items", list);
		
	
        int total = itemService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));     
        return "admin/item";
	}

	
	@GetMapping("/descList")
	public String descList(Criteria cri, Model model) {
		System.out.println("1");
		System.out.println(cri);
		System.out.println("cricricricrircicicicicicicici" + cri);
	
		
		List<ItemVO> list = itemService.getDescList(cri);
		list.forEach(itemVO -> System.out.println(itemVO + "zzzzzzzzzzzzzzzz"));
		list.forEach(itemVO -> System.out.println(itemVO));
		model.addAttribute("items", list);
		
		
        int total = itemService.getTotal(cri);
        
        model.addAttribute("pageMaker", new PageDTO(cri, total));
        return "admin/item";
	}
	

	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, ItemVO itemVO, RedirectAttributes rttr) {
        System.out.println("kkkk");
        if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			itemVO.setItemImageURL(imageURL);
		}
        System.out.println("kkkk3");
        System.out.println(itemVO);
	    itemService.register(itemVO);
	    System.out.println("kkkfsdfsdfsfsdfk");
	    rttr.addFlashAttribute("result", itemVO.getItemId());
	    
	    return "redirect:descList";
	}

	@GetMapping(value = "/get/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, Object>> get(@PathVariable("itemId") long itemId) {
	    ItemVO item = itemService.get(itemId);
	    System.out.println(item);
	    Map<String, Object> responseData = new HashMap<>();
	    responseData.put("item", item);

	    // ResponseEntity에 JSON 데이터 반환
	    return new ResponseEntity<>(responseData, HttpStatus.OK);
	}


	
	@PostMapping("/modify")
	public String modify(MultipartFile[] uploadFile, ItemVO itemVO, @ModelAttribute("cri") Criteria cri, ReplyVO replyVO, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
		System.out.println("jh-----------------///////////kjhjk");
        if (!uploadFile[0].isEmpty()) { 
			String imageURL = fileUploadManager.uploadFiles(uploadFile);
			itemVO.setItemImageURL(imageURL);
		}

	    if (itemService.modify(itemVO)) {
	        rttr.addFlashAttribute("result", "success");
	    }
	    
	    rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());
	    return "redirect:" + currentPath;
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("itemId") Long itemId, @ModelAttribute("cri") Criteria cri, @RequestParam("currentPath") String currentPath, RedirectAttributes rttr) {
		
		System.out.println("remove..." + itemId);
		if (itemService.remove(itemId)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		System.out.println("remove..." + itemId);
		return "redirect:" + currentPath;
	}
}