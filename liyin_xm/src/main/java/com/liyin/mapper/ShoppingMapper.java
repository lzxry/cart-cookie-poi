package com.liyin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liyin.entity.Goods;
import com.liyin.entity.Type;

public interface ShoppingMapper {
	
	int getGoodsTotal(@Param("mohu")String mohu);

	List<Goods> getShoppingList(@Param("mohu")String mohu, @Param("offset")int offset, @Param("pagesize")int pagesize);
	@Select("SELECT * FROM liyin_type where pid=0")
	List<Type> getTypeOneList();
	@Select("SELECT * FROM liyin_type where pid=${tid}")
	List<Type> getChild(@Param("tid")Integer tid);
	@Insert("INSERT INTO liyin_goods values(#{id},#{name},${price},#{img_path},#{madedate},#{createdate},0,#{gift},0,${tid})")
	void addGoods(Goods goods) throws Exception;
	@Update("UPDATE liyin_goods SET deletestatus=1 WHERE id = #{id}")
	void deleteGoods(@Param("id")String id) throws Exception;
	@Select("SELECT * FROM liyin_goods WHERE id = #{id}")
	Goods getGoodsById(@Param("id")String id);
	@Update("UPDATE liyin_goods SET status=${s} WHERE id = #{id}")
	void updateStatus(@Param("s")Integer s, @Param("id")String id);
	@Select("SELECT * FROM liyin_type where tid=${tid}")
	Type getTypeHuiXian(@Param("tid")String tid);
	@Update("UPDATE liyin_goods SET name=#{name},price=${price},img_path=#{img_path},madedate=#{madedate},gift=#{gift},tid=${tid} WHERE id = #{id}")
	void updateGoods(Goods goodsById);

	List<Goods> getShoppingListAll();

}
