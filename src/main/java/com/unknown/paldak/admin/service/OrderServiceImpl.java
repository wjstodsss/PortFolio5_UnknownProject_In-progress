package com.unknown.paldak.admin.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		/* orderId만들고 OrderDTO객체 orderId에 저장 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = orderVO.getMemberId() + format.format(date);
		orderVO.setOrderId(orderId);

		System.out.println("ppp");
		mapper.insert(orderVO);	
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
	
	public boolean modifyOrderState(OrderVO orderVO) {
		int result = mapper.updateOrderState(orderVO);
		return result==1;
	}

	
}
