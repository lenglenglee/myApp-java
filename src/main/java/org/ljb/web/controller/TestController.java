package org.ljb.web.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/cTest.do")
	@ResponseBody
	public String  Test(){
		return "hello";
	}
	

}
