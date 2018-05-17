package com.wm.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.product.model.Product;

/** 注入【商品-基本信息表】的MyBatis Mapper配置 */
@Mapper
public interface ProductMapper {

	@Insert("INSERT INTO product(name,category_id,brand_id) VALUES(#{name},#{categoryId},#{brandId})")
	void add(Product product);

	@Update("UPDATE product SET name=#{name},category_id=#{categoryId},brand_id=#{brandId} WHERE id=#{id}")
	void update(Product product);

	@Delete("DELETE FROM product WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM product WHERE id=#{id}")
	@Results({ @Result(column = "category_id", property = "categoryId"), @Result(column = "brand_id", property = "brandId") })
	Product findById(Long id);

}
