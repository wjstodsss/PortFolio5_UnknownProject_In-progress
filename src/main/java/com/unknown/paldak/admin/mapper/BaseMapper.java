package com.unknown.paldak.admin.mapper;


import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;

public interface BaseMapper<T> {
    List<T> getList();

    void insert(T item);

    void insertSelectKey(T item);

    T read(Long id);

    int delete(Long id);

    int update(T item);

    List<T> getListWithPaging(Criteria cri);
    
    List<T> getDescListWithPaging(Criteria cri);
    
    int getTotalCount(Criteria cri);
 
}
