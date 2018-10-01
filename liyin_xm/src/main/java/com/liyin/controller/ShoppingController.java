package com.liyin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liyin.entity.Goods;
import com.liyin.entity.Type;
import com.liyin.pager.Pager;
import com.liyin.pager.SystemContext;
import com.liyin.service.ShoppingServiceI;
import com.liyin.util.CookieUtil;
import com.liyin.util.ExcelUtils;
import com.liyin.util.SaveImg;

@Controller
@RequestMapping("shopping")
public class ShoppingController {

	@Resource
	private ShoppingServiceI shoppingServiceImpl;
	@Value("${image.location}")
	private String imgPath;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//首页列表
	@RequestMapping("/list")
	public String list(Model model,String mohu) {
		Pager<Goods> pager = this.shoppingServiceImpl.getShoppingList(mohu);
		model.addAttribute("mohu",mohu );
		model.addAttribute("pager",pager );
		return "shopping";
	}
	//跳转到添加商品
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<Type> types = this.shoppingServiceImpl.getTypeOneList();
		
		model.addAttribute("types",types );
		model.addAttribute("title","添加商品" );
		model.addAttribute("urlPath","add" );
		return "goods";
	}
	//添加商品
	@RequestMapping("/add")
	public String add(Model model,Goods goods,MultipartFile file) {
		String id = UUID.randomUUID().toString();
		goods.setId(id);
		String saveImg = null;
		try {
			saveImg = SaveImg.saveImg(file, "F:\\img");
		} catch (IOException e) {
			e.printStackTrace();
		}
		goods.setImg_path(saveImg);
		String createdate = sdf.format(new Date());
		goods.setCreatedate(createdate);
		try {
			this.shoppingServiceImpl.addGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	//逻辑删除商品
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public boolean deleteGoods(String id) {
		try {
			this.shoppingServiceImpl.deleteGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//跳转到商品修改
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model,String id) {
		Goods goods= this.shoppingServiceImpl.getGoodsById(id);
		List<Type> types = this.shoppingServiceImpl.getTypeOneList();
		Type type3 = this.shoppingServiceImpl.getTypeHuiXian(goods.getTid());
		Type type2 = this.shoppingServiceImpl.getTypeHuiXian(type3.getPid()+"");
		Type type1 = this.shoppingServiceImpl.getTypeHuiXian(type2.getPid()+"");
		goods.setTid(type1.getTid()+"");
		model.addAttribute("types",types );
		model.addAttribute("type2","<option selected>"+type2.getName()+"</option>" );
		model.addAttribute("type3","<option value='"+type3.getTid()+"' selected>"+type3.getName()+"</option>" );
		model.addAttribute("goods",goods );
		model.addAttribute("title","修改页面" );
		model.addAttribute("urlPath","update" );
		return "goods";
	}
	//修改商品
	@RequestMapping("/update")
	public String update(Model model,Goods goods,MultipartFile file) {
		
		Goods goodsById = shoppingServiceImpl.getGoodsById(goods.getId());
		
		String saveImg = null;
		if(file.getSize()!=0) {
			try {
				//删除旧的图片
				//String old_img_path = goodsById.getImg_path();
				//SaveImg.deleteFile(imgPath+old_img_path.substring(1));
				
				saveImg = SaveImg.saveImg(file, "F:\\img");
			} catch (IOException e) {
				e.printStackTrace();
			}
			goodsById.setImg_path(saveImg);
		}
		goodsById.setName(goods.getName());
		goodsById.setGift(goods.getGift());
		goodsById.setTid(goods.getTid());
		goodsById.setMadedate(goods.getMadedate());
		goodsById.setPrice(goods.getPrice());
		try {
			this.shoppingServiceImpl.updateGoods(goodsById);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	//修改上下架状态
	@RequestMapping("/updateStatus")
	@ResponseBody
	public boolean updateStatus(Integer s,String id) {
		try {
			this.shoppingServiceImpl.updateStatus(s,id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//三级联动获取子集
	@RequestMapping("/getChild")
	@ResponseBody
	public List<Type> getChild(Integer tid) {
		return this.shoppingServiceImpl.getChild(tid);
	}
	//查看单个商品
	@RequestMapping("/lookGoods")
	public String lookGoods(String id,Model model) {
		Goods goods = this.shoppingServiceImpl.getGoodsById(id);
		Type type3 = this.shoppingServiceImpl.getTypeHuiXian(goods.getTid());
		Type type2 = this.shoppingServiceImpl.getTypeHuiXian(type3.getPid()+"");
		Type type1 = this.shoppingServiceImpl.getTypeHuiXian(type2.getPid()+"");
		model.addAttribute("title","商品查看页面" );
		goods.setType(type1.getName()+"-"+type2.getName()+"-"+type3.getName());
		model.addAttribute("table", "<script type=\"text/javascript\">$(function(){$(\"#t\").html(\"\");});</script><table class=\"table table-bordered table-hover\"><tr><td>商品名:</td><td>"+goods.getName()+"</td></tr><tr><td>商品图:</td><td><img alt=\"图片仅供参考\" src=\""+goods.getImg_path()+"\" width=\"100px\" height=\"100px\"></td></tr><tr><td>生产日期:</td><td>"+goods.getMadedate()+"</td></tr><tr><td>赠品:</td><td>"+goods.getGift()+"</td></tr><tr><td>商品价格:</td><td>"+goods.getPrice()+"</td></tr><tr><td>分类:</td><td>"+goods.getType()+"</td></tr></table>\r\n");
		return "goods";
	}
	//poi下载/图片
	@RequestMapping("/downLoad")
	public void downLoad(HttpServletResponse res) {
		List<Goods> goods = this.shoppingServiceImpl.getShoppingListAll();
		String[] columnNames = {"编号","分类编号","商品名","商品价格","生产日期","商品创建时间","赠品","分类","删除状态(删除:1/正常:0)","商品图"};
		String[] columns = {"id","tid","name","price","madedate","createdate","gift","type","deletestatus","img_path"};
		ExcelUtils.exportImageExcel(res, goods, columnNames, columns, "商品清单", "商品清单","F:/img");
	}
	//poi上传
	@RequestMapping("/upLoad")
	@ResponseBody
	public boolean upLoad(MultipartFile file) throws Exception {
		System.out.println("-----数组-----"+file.getOriginalFilename());
		try {
			String[][] readexcell = ExcelUtils.readexcell(file, 1);
			for (int i = 0; i < readexcell.length; i++) {
				String randomUUID = UUID.randomUUID()+"";
				//new Goods(id, tid, name, price, img_path, madedate, createdate, status, gift, deletestatus, type)
				this.shoppingServiceImpl.addGoods(new Goods(randomUUID, readexcell[i][1], readexcell[i][2], readexcell[i][3], "", readexcell[i][4], sdf.format(new Date()), "0", readexcell[i][6], "0", ""));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//添加购物车商品---首页列表/购物车列表
	@RequestMapping("/cartAdd")
	@ResponseBody
	public boolean cartAdd(String id,@RequestParam(required=false,name="number",defaultValue="")String number,HttpServletResponse response,HttpServletRequest request) {
		id=id.trim();
		String key= "cart_"+id;
		if(!number.isEmpty()) {
			CookieUtil.addCookie(response,key,number);
		}else {
			Cookie oldCookie = CookieUtil.getCookieByName(request, key);
			if(null!=oldCookie) {
				String num = oldCookie.getValue();
				int i =  Integer.parseInt(num)+1;
				CookieUtil.addCookie(response, key, i+"");
			}else {
				CookieUtil.addCookie(response,key,"1");
			}
		}
		return true;
	}
	//跳转到购物车列表
	@RequestMapping("/toCart")
	public String toCart(HttpServletRequest request) {
		List<Map<String, String>> cargoods = CookieUtil.getCookieCargoods(request);
		List<Goods> cartGoods = new ArrayList<Goods>();
		for (Map<String, String> map : cargoods) {
				Goods goods = this.shoppingServiceImpl.getGoodsById(map.get("id"));
				goods.setNumber(map.get("num"));
				cartGoods.add(goods);
		}
		request.setAttribute("cartGoods", cartGoods);
		return "cart_shopping";
	}
	//删除单个购物车商品
	@RequestMapping("/cartDeleteById")
	@ResponseBody
	public boolean cartDeleteById(String id,HttpServletResponse response,HttpServletRequest request) {
		id=id.trim();
		String key= "cart_"+id;
		CookieUtil.deleteCookie(response, key);
		return true;
	}
	//删除全部购物车商品
	@RequestMapping("/cartDeleteMore")
	@ResponseBody
	public boolean cartDeleteMore(String ids,HttpServletResponse response,HttpServletRequest request) {
		String[] idss = ids.split(",");
		for (String id : idss) {
			cartDeleteById(id, response, request);
		}
		return true;
	}
	
}
