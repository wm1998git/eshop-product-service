package com.wm.eshop.product.service;

import com.wm.eshop.product.model.ProductSpecification;

/** 商品规格Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface ProductSpecificationService {

	void add(ProductSpecification productSpecification, String operationType);

	void update(ProductSpecification productSpecification, String operationType);

	void delete(Long id, String operationType);

	ProductSpecification findById(Long id);

	ProductSpecification findByProductId(Long productId);
}
