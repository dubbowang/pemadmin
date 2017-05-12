package com.qinke.pemadmin.api;

import com.qinke.pemadmin.api.base.BaseService;

public class TestServiceImpl extends BaseService implements TestService {

	@Override
	public String test() {
		return "Hello Word";
	}

}
