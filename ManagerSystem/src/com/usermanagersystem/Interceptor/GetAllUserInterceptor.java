package com.usermanagersystem.Interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;

public class GetAllUserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		InterUser interUser=new ImplUser();
		List alluserList=interUser.findAllUsers();
		List alladminList=interUser.findAllAdmins();
		
		invocation.getInvocationContext().getSession().put("alladminList", alladminList);
		invocation.getInvocationContext().getSession().put("alluserList", alluserList);
		
		return invocation.invoke();
	}

}
