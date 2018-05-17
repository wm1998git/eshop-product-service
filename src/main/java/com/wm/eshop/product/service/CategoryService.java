package com.wm.eshop.product.service;

import com.wm.eshop.product.model.Category;

/** 商品分类Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface CategoryService {

	void add(Category category, String operationType);

	void update(Category category, String operationType);

	void delete(Long id, String operationType);

	Category findById(Long id);

}
