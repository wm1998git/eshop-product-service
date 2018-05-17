package com.wm.eshop.product.service;

import com.wm.eshop.product.model.ProductProperty;

/** 商品属性Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface ProductPropertyService {

	void add(ProductProperty productProperty, String operationType);

	void update(ProductProperty productProperty, String operationType);

	void delete(Long id, String operationType);

	ProductProperty findById(Long id);

	ProductProperty findByProductId(Long productId);

}
