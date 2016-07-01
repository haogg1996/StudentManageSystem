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

    <div class="div_top">课程信息</div>
    
    <div class="div_con">
   
        <table width="100%" cellspacing="1" cellpadding="0" border="0" bgcolor="#ccc">
     
		    <tr align="center">
			<td >姓名</td>          
			<td >课程名</td>          
			<td >成绩</td>          
		</tr>
  	<%
	    List<Cscourse> cscourses=(List<Cscourse>)request.getAttribute("cscourses");
	    	for(Cscourse cscourse:cscourses){
	    		Course course=cscourse.getCourse();
	    		out.print("<tr align=\"center\">");
	    		out.print("<td>"+cscourse.getUserInfo().getName()+"</td>");
	    		out.print("<td>"+course.getCourseName()+"</td>");
	    		out.print("<td>"+cscourse.getScores()+"</td>");
	    	}
    
    
    %> 
        </table>

    </div>
 <div class="div_down" align="center">
        <a href="CscourseManage?action=getCourse"><input id="btn_search" type="button" value="添加课程" style="cursor:hand;" /></a>
    </div>
   

</body>
</html>
