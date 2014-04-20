package org.ljb.service;

import org.ljb.mapper.testMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
	
	@Autowired
	private testMapper mapper;
	
	public String test(){
		return mapper.getTest();
	}
	

}
