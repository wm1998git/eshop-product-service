package com.wm.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.product.model.ProductIntro;

/** 注入【商品-介绍表】的MyBatis Mapper配置 */
@Mapper
public interface ProductIntroMapper {

	@Insert("INSERT INTO product_intro(content,product_id) VALUES(#{content},#{productId})")
	void add(ProductIntro productIntro);

	@Update("UPDATE product_intro SET content=#{content},product_id=#{productId} WHERE id=#{id}")
	void update(ProductIntro productIntro);

	@Delete("DELETE FROM product_intro WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM product_intro WHERE id=#{id}")
	ProductIntro findById(Long id);

}
