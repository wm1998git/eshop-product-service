package com.wm.eshop.product.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.product.model.Brand;

/** 注入【商品-品牌表】的MyBatis Mapper配置 */
@Mapper
public interface BrandMapper {

	@Insert("INSERT INTO brand(name,description) VALUES(#{name},#{description})")
	void add(Brand brand);

	@Update("UPDATE brand SET name=#{name},description=#{description} WHERE id=#{id}")
	void update(Brand brand);

	@Delete("DELETE FROM brand WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM brand WHERE id=#{id}")
	Brand findById(Long id);

	@Select("SELECT * FROM brand WHERE id in (${ids})")
	List<Brand> findByIds(@Param("ids") String ids);
}
