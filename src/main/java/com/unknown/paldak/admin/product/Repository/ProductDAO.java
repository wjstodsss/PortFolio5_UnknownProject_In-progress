package com.unknown.paldak.admin.product.Repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.unknown.paldak.admin.common.domain.Criteria;
import com.unknown.paldak.admin.product.domain.ProductVO;

@Repository
public class ProductDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    public ProductDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<ProductVO> getList() {
        return sqlSessionTemplate.selectList("com.unknown.paldak.mapper.ProductMapper.getList");
    }

    public void insert(ProductVO product) {
        sqlSessionTemplate.insert("com.unknown.paldak.mapper.ProductMapper.insert", product);
    }

    public void insertSelectKey(ProductVO product) {
        sqlSessionTemplate.insert("com.unknown.paldak.mapper.ProductMapper.insertSelectKey", product);
    }

    public ProductVO read(Long productId) {
        return sqlSessionTemplate.selectOne("com.unknown.paldak.mapper.ProductMapper.read", productId);
    }

    public int delete(Long productId) {
        return sqlSessionTemplate.delete("com.unknown.paldak.mapper.ProductMapper.delete", productId);
    }

    public int update(ProductVO product) {
        return sqlSessionTemplate.update("com.unknown.paldak.mapper.ProductMapper.update", product);
    }

    public List<ProductVO> getListWithPaging(Criteria cri) {
        return sqlSessionTemplate.selectList("com.unknown.paldak.mapper.ProductMapper.getListWithPaging", cri);
    }

    public int getTotalCount(Criteria cri) {
        return sqlSessionTemplate.selectOne("com.unknown.paldak.mapper.ProductMapper.getTotalCount");
    }
}