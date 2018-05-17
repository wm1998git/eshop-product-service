package com.wm.eshop.product.service;

import com.wm.eshop.product.model.ProductIntro;

/** 商品介绍Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface ProductIntroService {

	void add(ProductIntro productIntro, String operationType);

	void update(ProductIntro productIntro, String operationType);

	void delete(Long id, String operationType);

	ProductIntro findById(Long id);

}
