<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>

<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0	);
	
	request.setCharacterEncoding("UTF-8");
	
	String num1 = request.getParameter("num1") == null ? "" : request.getParameter("num1").trim();
	String num2 = request.getParameter("num2") == null ? "" : request.getParameter("num2").trim();
	String num3 = request.getParameter("num3") == null ? "" : request.getParameter("num3").trim();
	String num4 = request.getParameter("num4") == null ? "" : request.getParameter("num4").trim();
	String num5 = request.getParameter("num5") == null ? "" : request.getParameter("num5").trim();
	String num6 = request.getParameter("num6") == null ? "" : request.getParameter("num6").trim();
	String writeTime = request.getParameter("writeTime") == null ? "" : request.getParameter("writeTime").trim();
	
	System.out.println("num1: " + num1);
	System.out.println("num2: " + num2);
	System.out.println("num3: " + num3);
	System.out.println("num4: " + num4);
	System.out.println("num5: " + num5);
	System.out.println("num6: " + num6);
	
	QueryBean.getConnection();
	//ArrayList resArr = new ArrayList();
	int res=0;
	
	try{
		res = QueryBean.setNumberInfo(num1, num2, num3, num4, num5, num6, writeTime);
	} catch(Exception e){
		out.print(e.toString());
	} finally {
		QueryBean.closeConnection();
	}
	out.print("[");
	out.print("{ ");
	out.print("\"RESULT_OK\": \""+ res + "\" ");
	out.print("} ");
	out.print("]");
	
	System.out.println("res: "+ res);
%>
