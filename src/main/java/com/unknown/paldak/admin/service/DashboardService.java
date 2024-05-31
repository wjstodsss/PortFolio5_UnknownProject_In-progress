package com.unknown.paldak.admin.service;

import com.unknown.paldak.admin.domain.DashboardVO;


public interface DashboardService {

   
    DashboardVO getTodayRegistrations();

    DashboardVO getThisMonthRegistrations();
    
    DashboardVO getDailyOrderCount();

    DashboardVO getMonthlyOrderCount();
    
    int getNewItemsCount();
    
    int getTotalItemsCount();
    
    int getReviewCountToday();
    
    int getPendingReviewCount();
    
    int getQnaCountToday();
    
    int getPendingQnaCount();
    
    int getItemsNeedOrderCount();
    
    int getTotalOrdersCount();
    
    int getReceivedItemsCount();
    
    int getWaitingItemsCount();

}
