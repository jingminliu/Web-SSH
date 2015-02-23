package com.cup.cardholder.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.get.card.num.GetBankCardNum;

public class CardNum extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*public static String getCardNum() {
		System.out.println("CardNum: getCardNum(): in!");
		String cardNum="";
		GetBankCardNum gbcn = new GetBankCardNum();
		
		cardNum = gbcn.getCardNum();
		System.out.println("CardNum: getCardNum(): " + cardNum);
		return cardNum;
	}*/
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CardNum: getCardNum(): in!");
		String cardNum="";
		GetBankCardNum gbcn = new GetBankCardNum();
		
		cardNum = gbcn.getCardNum();
		System.out.println("CardNum: getCardNum(): " + cardNum);
		
		response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();  
  
        out.println(cardNum);  
        out.flush();  
        out.close();  
	}
	
	/*public static void main(String[] args) {
		System.out.println("CardNum: getCardNum(): " + CardNum.getCardNum());
	}*/

}
