package com.unknown.paldak.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.FaqVO;
import com.unknown.paldak.admin.mapper.FaqMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class FaqServiceImpl implements FaqService{
    
	@Autowired
	private FaqMapper mapper;

	@Override
	public void register(FaqVO faqVO) {
		log.info("register... " + faqVO);
		mapper.insertSelectKey(faqVO);
		
	}

	@Override
	public FaqVO get(Long faqId) {
		log.info("get..." + faqId);	
		return mapper.read(faqId);
	}

	@Override
	public boolean modify(FaqVO faqVO) {
		return mapper.update(faqVO)==1;
	}

	@Override
	public Boolean remove(Long faqId) {
		log.info("remove ... " + faqId);
		return mapper.delete(faqId)==1;
	}

	@Override
	public List<FaqVO> getList(Criteria cri) {
		System.out.println(cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}