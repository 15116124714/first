package com.offcn.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.MobileDao;
import com.offcn.model.Mobile;
import com.offcn.service.MobileService;
import com.sun.tools.javac.util.List;

@Service
public class MobileServiceImple implements MobileService{
	@Autowired
	private MobileDao mobileDao;

	public List<Mobile> getAllMobile() {
		// TODO Auto-generated method stub
		return mobileDao.getAllMobile();
	}

	public void saveMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		mobileDao.saveMobile(mobile);
	}

}
