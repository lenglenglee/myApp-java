package org.ljb.service.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ljb.entity.sys.Menu;
import org.ljb.entity.sys.MenuItem;
import org.ljb.mapper.sys.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {
	@Autowired
	private MenuMapper mapper;
	
	public void addMenuItem(String name,String displayName,Integer parentId,boolean useFlag){
		int flag=1;
		if(!useFlag){
			flag=0;
		}
		Menu item=new Menu(name, displayName, parentId, flag);
		mapper.addMenuItem(item);
		System.out.println("add..11112");
	}
	
	public List<MenuItem> getMenuTreeByUser(int userId){
		List<Menu> menuList = mapper.getMenuByUser(userId);
		List<MenuItem> result=new ArrayList<MenuItem>();
		Map<Integer,MenuItem> itemMap=new HashMap<Integer, MenuItem>(50);
		for(Menu menu:menuList){
			MenuItem item =new MenuItem(menu.getId(),menu.getDisplayName(),menu.getParentid()); 
			itemMap.put(item.getId(), item);
		}
		for(Integer key :itemMap.keySet()){
			MenuItem item = itemMap.get(key);
			if(item.getParentId()!=null){
				itemMap.get(item.getParentId()).addChild(item);
			}else{
				result.add(item);
				System.out.println(item.getId()+":"+item.getName());
			}
		}
		
		return result;
	}
	public List<Menu> getMenuByUser(int userId){
		return mapper.getMenuByUser(userId);
	}
	public String test(){
		return "test";
	}
	


}
