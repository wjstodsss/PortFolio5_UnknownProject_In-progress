package com.unknown.paldak.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.OrderVO;
import com.unknown.paldak.admin.mapper.OrderMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements BaseService<OrderVO>{
    
	@Autowired
	private OrderMapper mapper;

	@Override
	public void register(OrderVO orderVO) {
		System.out.println("ppp");
		mapper.insertSelectKey(orderVO);	
	}

	@Override
	public OrderVO get(Long orderId) {
		return mapper.read(orderId);
	}

	@Override
	public boolean modify(OrderVO orderVO) {
		return mapper.update(orderVO)==1;
	}

	@Override
	public boolean remove(Long orderId) {
		return mapper.delete(orderId)==1;
	}

	@Override
	public List<OrderVO> getList(Criteria cri) {
		System.out.println(cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public List<OrderVO> getDescList(Criteria cri) {
		return mapper.getDescListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	public OrderVO getByStringId(String orderId) {
		return mapper.readByStringId(orderId);
	}
	
	public boolean removeByStringId(String orderId) {
		return mapper.deleteByStringId(orderId)==1;
	}
	
}
