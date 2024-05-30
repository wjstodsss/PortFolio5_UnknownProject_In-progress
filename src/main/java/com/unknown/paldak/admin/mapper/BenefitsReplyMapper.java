package com.unknown.paldak.admin.mapper;


import com.unknown.paldak.admin.domain.BenefitsReplyVO;

public interface BenefitsReplyMapper extends BaseMapper<BenefitsReplyVO>{
	public BenefitsReplyVO readByBenefitsId(Long benefitsId);
}
