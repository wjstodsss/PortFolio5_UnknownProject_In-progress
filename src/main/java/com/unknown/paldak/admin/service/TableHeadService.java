package com.unknown.paldak.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.paldak.admin.domain.TableHeadVO;
import com.unknown.paldak.admin.mapper.TableHeadMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@AllArgsConstructor
public class TableHeadService {
    
	@Autowired
	private TableHeadMapper tableHeadMapper;

	
	public String[] getTableHead(String tableHeadId) {
		TableHeadVO tableHead = tableHeadMapper.getTableHead(tableHeadId);
	    if (tableHead != null) {
	        return tableHead.getColumnList().split("/");
	    }
	    return null;
	}
	
}