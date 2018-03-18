package com.taotao.service;

import com.taotao.dto.Items;

import java.util.List;


public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItems();
	
	public Items selectItemsById(Integer id);
	//修改
	public void updateItemsById(Items item);
	
	/*public List<Items> selectItemsList();
	//修改
	public void updateItemsById(Items items);
*/


}
