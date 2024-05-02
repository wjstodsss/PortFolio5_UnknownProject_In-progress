package com.unknown.paldak.admin.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;

import com.unknown.paldak.admin.domain.QnaVO;
import com.unknown.paldak.admin.mapper.QnaMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class QnaServiceImpl implements BaseService<QnaVO>{
    
	@Autowired
	private QnaMapper mapper;

	@Override
	public void register(QnaVO qnaVO) {
		log.info("register... " + qnaVO);
		mapper.insertSelectKey(qnaVO);
		
	}

	@Override
	public QnaVO get(Long qnaId) {
		log.info("get..." + qnaId);	
		return mapper.read(qnaId);
	}

	@Override
	public boolean modify(QnaVO qnaVO) {
		return mapper.update(qnaVO)==1;
	}

	@Override
	public Boolean remove(Long qnaId) {
		log.info("remove ... " + qnaId);
		return mapper.delete(qnaId)==1;
	}

	@Override
	public List<QnaVO> getList(Criteria cri) {
		System.out.println(cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}