package com.unknown.paldak.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.MemberVO;
import com.unknown.paldak.admin.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements BaseService<MemberVO>{
    
	@Autowired
	private MemberMapper mapper;

	@Override
	public void register(MemberVO memberVO) {
		log.info("register... " + memberVO);
		
System.out.println("lkjkljl");
		mapper.insertSelectKey(memberVO);
		
	}

	@Override
	public MemberVO get(Long memberId) {
		log.info("get..." + memberId);	
		return mapper.read(memberId);
	}

	@Override
	public boolean modify(MemberVO memberVO) {
		return mapper.update(memberVO)==1;
	}

	@Override
	public boolean remove(Long memberId) {
		log.info("remove ... " + memberId);
		return mapper.delete(memberId)==1;
	}

	@Override
	public List<MemberVO> getList(Criteria cri) {
		System.out.println(cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public List<MemberVO> getDescList(Criteria cri) {
		return mapper.getDescListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}
