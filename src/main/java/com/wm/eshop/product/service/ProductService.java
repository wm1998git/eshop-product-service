package com.wm.eshop.product.service;

import com.wm.eshop.product.model.Product;

/** 商品本身Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface ProductService {

	void add(Product product, String operationType);

	void update(Product product, String operationType);

	void delete(Long id, String operationType);

	Product findById(Long id);

}
