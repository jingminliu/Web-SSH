package com.cup.cardholder.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.hbase.client.Result;

import com.cup.cardholder.model.Constant;
import com.cup.cardholder.model.LoginModel;
import com.cup.cardholder.service.HBaseService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usrNm = request.getParameter("usrNm");
		String pwd = request.getParameter("pwd");
		/*String ins = request.getParameter("ins");*/
		String servletFlag="";
		String loginFlag="";
		
		HBaseService hbs = new HBaseService();
		LoginModel model = new LoginModel();
		Result res = hbs.get(Constant.TBL_USER, usrNm, Constant.COLUMNFAMILY);
		model = hbs.getLoginModel(res);
		
		if (model == null) {
			return;
		}
		
		if(pwd.equals(model.getUserPwd()) /*&& ins.equals(model.getInsCd())*/) {
			servletFlag = "1";
			loginFlag = "1";
		} else {
			servletFlag = "1";
			loginFlag = "0";
		}
		
		System.out.println("LoginServlet: servletFlag: " + servletFlag);
		System.out.println("LoginServlet: loginFlag: " + loginFlag);
		
		request.setAttribute("servletFlag", servletFlag);
		request.setAttribute("loginFlag", loginFlag);
		
		request.getRequestDispatcher("/jsp/login.jsp").forward(request,
				response);
	}
}
