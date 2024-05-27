package com.unknown.paldak.admin.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;

import com.unknown.paldak.admin.domain.ItemVO;
import com.unknown.paldak.admin.mapper.ItemMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ItemServiceImpl implements BaseService<ItemVO>{
    
	@Autowired
	private ItemMapper mapper;

	@Override
	public void register(ItemVO itemVO) {
		log.info("register... " + itemVO);
		mapper.insertSelectKey(itemVO);
	}

	@Override
	public ItemVO get(Long itemId) {

		return mapper.read(itemId);
	}

	@Override
	public boolean modify(ItemVO itemVO) {
		LocalDateTime now = LocalDateTime.now();
		Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		itemVO.setUpdateDate(date);
		return mapper.update(itemVO)==1;
	}

	@Override
	public Boolean remove(Long itemId) {
		log.info("remove ... " + itemId);
		return mapper.delete(itemId)==1;
	}

	@Override
	public List<ItemVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public List<ItemVO> getDescList(Criteria cri) {
		return mapper.getDescListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}
