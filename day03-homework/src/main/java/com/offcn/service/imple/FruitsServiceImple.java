package com.offcn.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.FruitsDao;
import com.offcn.model.Fruits;
import com.offcn.service.FruitsService;

@Service
public class FruitsServiceImple implements FruitsService{

	@Autowired
	private FruitsDao fruitsDao;
	
	public void saveFruits(Fruits fruits) {
		// TODO Auto-generated method stub
		fruitsDao.saveFruits(fruits);
	}

}
