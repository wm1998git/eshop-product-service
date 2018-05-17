package com.wm.eshop.product.service;

import java.util.List;
import com.wm.eshop.product.model.Brand;

/** 商品品牌Service(每个方法的operationType参数代表：刷数据或高优先级) */
public interface BrandService {

	void add(Brand brand, String operationType);

	void update(Brand brand, String operationType);

	void delete(Long id, String operationType);

	Brand findById(Long id);
	
	List<Brand> findByIds(String ids);
}
