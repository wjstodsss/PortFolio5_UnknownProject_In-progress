package com.unknown.paldak.admin.mapper;

import com.unknown.paldak.admin.domain.TableHeadVO;

public interface TableHeadMapper extends BaseMapper<TableHeadVO> {
	TableHeadVO getTableHead(String id);
}