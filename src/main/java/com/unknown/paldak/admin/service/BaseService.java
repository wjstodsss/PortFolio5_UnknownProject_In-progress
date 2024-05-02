package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;

public interface BaseService<T> {
  public void register(T t);
  
  public T get(Long id);
  
  public boolean modify(T t);
  
  public Boolean remove(Long id);
  
  public List<T> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
