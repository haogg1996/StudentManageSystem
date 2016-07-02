<%@page import="com.jh.studentmanagesystem.bean.User"%>
<%@page import="com.jh.studentmanagesystem.bean.Course"%>
<%@page import="com.jh.studentmanagesystem.bean.Cscourse"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
<link href="css/cscourse.css" rel="stylesheet" type="text/css" />
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body>

   <%
	String part=request.getParameter("part");
	String topString="",btnString="";
	if("stud".equals(part)){
		topString="学生信息管理";
		btnString="添加学生";
	}else if("admin".equals(part)){
		topString="管理员信息管理";
		btnString="添加管理员";
	}
	List<User> users=(List<User>)request.getAttribute("users");
	
%>
        <table width="100%" cellspacing="1" cellpadding="0" border="0" bgcolor="#cccs">
    <div class="div_top"><%=topString %></div>
    
    <div class="div_con">
     
		    <tr align="center">
			<td >用户ID</td>          
			<td >姓名</td>          
			<td >密码</td> 
			<td >电话号码</td>           
		</tr>
		
  	<%
	    	for(User user:users){
	    		out.print("<tr align=\"center\">");
	    		out.print("<td>"+user.getId()+"</td>");
	    		out.print("<td>"+user.getName()+"</td>");
	    		out.print("<td>"+user.getPassword()+"</td>");
	    		out.print("<td>"+user.getTelephone()+"</td>");
	    	}
    
    
    %> 
        </table>
    </div>
 	<div class="div_down" align="center">
       <a href="add.jsp?part=<%=part %>"><input id="btn_search" type="submit" value="<%=btnString %>" style="cursor:hand;" /></a> 
    </div>
</body>
</html>
