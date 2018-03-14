package com.offcn.dao;

import com.offcn.model.Mobile;
import com.sun.tools.javac.util.List;

public interface MobileDao {
	
	List<Mobile> getAllMobile();
	
	void saveMobile(Mobile mobile);
}
