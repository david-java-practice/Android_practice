<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>
<%
	//캐쉬 제거?
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	String num1 = request.getParameter("num1") == null ? "" : request.getParameter("num1").trim();
	
	System.out.println("삭제할 ID: "+ num1);
	
	QueryBean.getConnection();
	
	//ArrayList resArr = new ArrayList();
	int res=0;
	
	try{
		res = QueryBean.deleteNumberInfo(num1);
	} catch(Exception e){
		out.print(e.toString());
	} finally	{
		QueryBean.closeConnection();
		
	}
	out.print("[");
	out.print("{ ");
	out.print("\"RESULT_OK\": \""+res+"\" ");
	out.print("} ");
	out.print("]");
	
	System.out.println("res: " + res);
%>
