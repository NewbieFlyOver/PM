package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.pm.dsis.mm.mapper.UserMemberMapper;
import com.taotao.dto.Items;
import com.taotao.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 查询商品信息
 * @author lx
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	//查询商品列表
	public List<Items> selectItems(){
		PageHelper.startPage(2, 2);
		return itemsMapper.selectItems();
	}
	
	//根据id查询
	public Items selectItemsById(Integer id){
		return itemsMapper.selectItemsById(id);
	}
	//修改
	@Transactional
	public void updateItemsById(Items item){
		//用于测试事务
		/*if(true){
			throw new MessageException("自定义异常！");
		}*/
		itemsMapper.updateItemsById(item);
		//int i= 1/0;
	}
	/*public List<Items> selectItemsList(){
	return itemsMapper.selectByExampleWithBLOBs(null);
}
	//修改
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}*/
}
