package com.wm.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.product.model.Category;

/** 注入【商品-分类表】的MyBatis Mapper配置 */
@Mapper
public interface CategoryMapper {

	@Insert("INSERT INTO category(name,description) VALUES(#{name},#{description})")
	void add(Category category);

	@Update("UPDATE category SET name=#{name},description=#{description} WHERE id=#{id}")
	void update(Category category);

	@Delete("DELETE FROM category WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM category WHERE id=#{id}")
	Category findById(Long id);

}
