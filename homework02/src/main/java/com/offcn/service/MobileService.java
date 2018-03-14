package com.offcn.service;

import com.offcn.model.Mobile;
import com.sun.tools.javac.util.List;

public interface MobileService {
	List<Mobile> getAllMobile();
	
	void saveMobile(Mobile mobile);
}
