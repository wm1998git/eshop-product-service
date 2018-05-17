package com.wm.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.product.model.ProductProperty;

/** 注入【商品-属性表】的MyBatis Mapper配置 */
@Mapper
public interface ProductPropertyMapper {

	@Insert("INSERT INTO product_property(name,value,product_id) VALUES(#{name},#{value},#{productId})")
	void add(ProductProperty productProperty);

	@Update("UPDATE product_property SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")
	void update(ProductProperty productProperty);

	@Delete("DELETE FROM product_property WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM product_property WHERE id=#{id}")
	ProductProperty findById(Long id);

	@Select("SELECT * FROM product_property WHERE product_id=#{productId}")
	ProductProperty findByProductId(Long productId);
}
