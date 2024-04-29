package com.unknown.paldak.admin.service;

import java.util.List;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.NoticeVO;

public interface NoticeService {
  public void register(NoticeVO noticeVO);
  
  public NoticeVO get(Long noticeId);
  
  public boolean modify(NoticeVO noticeVO);
  
  public Boolean remove(Long noticeId);
  
  public List<NoticeVO> getList(Criteria cri);
  
  public int getTotal(Criteria cri);
}
