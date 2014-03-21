package org.ljb.web.controller;
import java.util.HashMap;
import java.util.Map;

import org.ljb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping(value="/cTest.do")
	@ResponseBody
	public String  Test(){
		System.out.println("11111111");
		return service.test();
	}
	

}
