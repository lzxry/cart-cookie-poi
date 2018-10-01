package com.liyin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.liyin.entity.Goods;
import com.liyin.entity.Type;
import com.liyin.pager.Pager;

@Transactional
public interface ShoppingServiceI {

	Pager<Goods> getShoppingList(String mohu);

	List<Type> getTypeOneList();

	List<Type> getChild(Integer tid);

	void addGoods(Goods goods) throws Exception;

	void deleteGoods(String id) throws Exception;

	Goods getGoodsById(String id);

	void updateStatus(Integer s, String id);

	Type getTypeHuiXian(String string);

	void updateGoods(Goods goodsById);

	List<Goods> getShoppingListAll();

}
