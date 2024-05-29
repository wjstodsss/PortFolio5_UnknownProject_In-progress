package com.unknown.paldak.admin.mapper;

import com.unknown.paldak.admin.domain.ItemVO;

public interface ItemMapper extends BaseMapper<ItemVO> {
	void updateItemStock(ItemVO itemVO);
}
