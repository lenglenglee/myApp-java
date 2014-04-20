package org.ljb.web.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ljb.entity.sys.MenuItem;
import org.ljb.service.sys.MenuService;
import org.ljb.util.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/sys/menu",produces = {"application/json;charset=UTF-8"})

public class MenuController {
	@Autowired
	private MenuService service;
	
	@RequestMapping(value="/addMenuItem.do")
	@ResponseBody
	public String addMenuItem(){
		boolean useFlag=true;
		Integer parentId=null;
		String displayName="测试";
		String name="test";
		service.addMenuItem(name, displayName, parentId, useFlag);
		return service.test();
		
	}
	
	@RequestMapping(value="/getMenuTree.do",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<MenuItem> getMenuTree(@RequestParam Integer userId,HttpServletRequest request, HttpServletResponse response){
		System.out.println(userId);
		List<MenuItem> result = service.getMenuTreeByUser(userId);
		return result;
	}

}
