package com.unknown.paldak.admin.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.domain.ItemVO;
import com.unknown.paldak.admin.domain.StockInfoVO;
import com.unknown.paldak.admin.mapper.ItemMapper;
import com.unknown.paldak.admin.mapper.StockInfoMapper;
import com.unknown.paldak.admin.mapper.StockLogMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class StockInfoServiceImpl implements BaseService<StockInfoVO>{
    
	
	private final StockInfoMapper mapper;
	private final StockLogMapper logMapper;
	private final ItemMapper itemMapper;

	@Override
	public void register(StockInfoVO stockInfoVO) {
		mapper.insertSelectKey(stockInfoVO);
	}

	@Override
	public StockInfoVO get(Long itemId) {

		return mapper.read(itemId);
	}

	@Override
	public boolean modify(StockInfoVO stockInfoVO) {
		LocalDateTime now = LocalDateTime.now();
		Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		stockInfoVO.setReceivedDate(date);
		return mapper.update(stockInfoVO)==1;
	}

	@Override
	public boolean remove(Long itemId) {
		log.info("remove ... " + itemId);
		return mapper.delete(itemId)==1;
	}

	@Override
	public List<StockInfoVO> getList(Criteria cri) {
		List<StockInfoVO> result = mapper.getListWithPaging(cri);
		
		return result;
	}
	
	@Override
	public List<StockInfoVO> getDescList(Criteria cri) {
		return mapper.getDescListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	public void stockOrderReg(StockInfoVO stockInfoVO) {
		mapper.insertSelectKey(stockInfoVO);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void receivedReg(StockInfoVO stockInfoVO) {
		// 상품 재고에 입고량을 합하기 위해 별도의 변수에 상품아이디와 입고량을 담아둔다.
		long itemId = stockInfoVO.getItemId();
		long addQyt = stockInfoVO.getReceivedQty();
		
		// 입고량 완료 표시("Y") 바인딩한다.
		stockInfoVO.setIsReceived("Y");
		System.out.println(stockInfoVO);
		
		// 입고내역 DB업데이트를 실행한다.
		mapper.updateByStockOrderId(stockInfoVO);
	
		// 상품의 현재 재고에 추가하기 위해 해당 상품을 조회한후 재고량을 변수에 담는다.
		ItemVO itemVO = itemMapper.read(itemId);
		long currentItemStock = itemVO.getItemStock();
		
		// 입고량을 추가하여 상품에 담고 상품의 새로운 재고량으로 업데이트 한다.
		itemVO.setItemStock(addQyt + currentItemStock);
		itemMapper.updateItemStock(itemVO);
	}
	
	
	public List<StockInfoVO> getLogList(Criteria cri) {
		List<StockInfoVO> result = logMapper.getListWithPaging(cri);
		return result;
	}
	
	
	public List<StockInfoVO> getLogDescList(Criteria cri) {
		return logMapper.getDescListWithPaging(cri);
	}
	
	public int getLogTotal(Criteria cri) {
		return logMapper.getTotalCount(cri);
	}
	
	
}
