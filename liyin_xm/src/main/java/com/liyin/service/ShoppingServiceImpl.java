package com.liyin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liyin.entity.Goods;
import com.liyin.entity.Type;
import com.liyin.mapper.ShoppingMapper;
import com.liyin.pager.Pager;
import com.liyin.pager.SystemContext;

@Service
public class ShoppingServiceImpl implements ShoppingServiceI {

	@Resource
	private ShoppingMapper shoppingMapper;

	@Override
	public Pager<Goods> getShoppingList(String mohu) {
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		List<Goods> datas = this.shoppingMapper.getShoppingList(mohu,offset,pagesize);
		int total = this.shoppingMapper.getGoodsTotal(mohu);
		Pager<Goods> pager = new Pager<Goods>();
		pager.setTotal(total);
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public List<Type> getTypeOneList() {
		
		return this.shoppingMapper.getTypeOneList();
	}

	@Override
	public List<Type> getChild(Integer tid) {
		return this.shoppingMapper.getChild(tid);
	}

	@Override
	public void addGoods(Goods goods) throws Exception {
		this.shoppingMapper.addGoods(goods);
	}

	@Override
	public void deleteGoods(String id) throws Exception {
		String[] strings = id.split(",");
		for (String i : strings) {
			this.shoppingMapper.deleteGoods(i);
		}
	}

	@Override
	public Goods getGoodsById(String id) {
		return this.shoppingMapper.getGoodsById(id);
	}

	@Override
	public void updateStatus(Integer s,String id) {
		this.shoppingMapper.updateStatus(s,id);
	}

	@Override
	public Type getTypeHuiXian(String tid) {
		return this.shoppingMapper.getTypeHuiXian(tid);
	}

	@Override
	public void updateGoods(Goods goodsById) {
		this.shoppingMapper.updateGoods(goodsById);
	}

	@Override
	public List<Goods> getShoppingListAll() {
		return this.shoppingMapper.getShoppingListAll();
	}
	
}
