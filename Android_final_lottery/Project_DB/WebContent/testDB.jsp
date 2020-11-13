<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>
<%
	//캐쉬 제거?
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires",0);
	
	request.setCharacterEncoding("UTF-8");
	String num1 = request.getParameter("num1") == null?"":request.getParameter("num1").trim();
	
	QueryBean.getConnection();
	
	
	ArrayList resArr = new ArrayList();
	
	try{
		resArr = QueryBean.getNumberInfo(num1);
		
	} catch(SQLException e){
		out.print(e.toString());
	}
	finally{
		QueryBean.closeConnection();
	}
	
	out.println("{");
	out.println("\"datas\":[");
	
	if(resArr.size() ==0){
		out.println("]");
		out.println("}");
	}
	else{
		out.print("{");
		out.print("\"NUM1\":\""  		+ (String)resArr.get(0) + "\", ");
		out.print("\"NUM2\":\""		+ (String)resArr.get(1) + "\", ");
		out.print("\"NUM3\":\""	 	+ (String)resArr.get(2) + "\", ");
		out.print("\"NUM4\":\""		+ (String)resArr.get(3) + "\", ");
		out.print("\"NUM5\":  \"" + (String)resArr.get(4) + "\"");
		out.print("\"NUM6\":  \"" + (String)resArr.get(5) + "\"");
		out.print("\"WRITETIME\":  \"" + (String)resArr.get(6) + "\"");
		out.print("}");
		
		for(int i=6; i<resArr.size(); i+=6){
			out.print(",");
			out.print("{");
			out.print("\"NUM1\":\""		+ (String)resArr.get(i) + "\", ");
			out.print("\"NUM2\":\""		+ (String)resArr.get(i+1) + "\", ");
			out.print("\"NUM3\":\""		+ (String)resArr.get(i+2) + "\", ");
			out.print("\"NUM4\":\""		+ (String)resArr.get(i+3) + "\", ");
			out.print("\"NUM5\":\""		+ (String)resArr.get(i+4) + "\" ");
			out.print("\"NUM6\":\""		+ (String)resArr.get(i+5) + "\" ");
			out.print("\"WRITETIME\":\""		+ (String)resArr.get(i+6) + "\" ");
			out.print("}");
		}
		out.println("]");
		out.println("}");
	}

%>
