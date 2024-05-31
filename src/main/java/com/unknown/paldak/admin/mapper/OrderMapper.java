package com.unknown.paldak.admin.mapper;

import com.unknown.paldak.admin.domain.OrderVO;

public interface OrderMapper extends BaseMapper<OrderVO> {
	public OrderVO readByStringId(String id);
	public int deleteByStringId(String id);
}

