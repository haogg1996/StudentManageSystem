<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String name;
String part;
if(session.getAttribute("part")==null){
	System.out.print("null");
}
part=(String)session.getAttribute("part");
name=(String)session.getAttribute("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>学生管理系统</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>

<body onload="show_menu(1);">

<div class="header">
	<div class="header_img"></div>
	<div class="header_text">学生管理系统</div>
</div>

<div class="left" id="LeftBox">

	<div class="left_box">
		<div class="left_box_r"></div>
		<div class="left_box_l"></div>
		<% 
		String stringName=null,stringM1=null,stringM2=null;
		if("stud".equals(part)){
			stringName="学生："+name;
			stringM1="选课情况";
			stringM2="个人信息";
		}%>
		<div class="left_box_text"><%=stringName %></div>
	</div>

	<div class="left_big_box">

		<div class="left_big_top">
			<div class="left_big_top_r"></div>
			<div class="left_big_top_l"></div>
			<div class="left_big_top_text">管理菜单</div>
        </div>

	    <div class="left_big_down">

		    <div class="left_menu_one">
		      <span id="O1" class="left_menu_one_img"><%=stringM1 %></span></a></div>
		    <div class="left_menu_one">
		      <span id="O2" class="left_menu_one_img"><%=stringM2 %></span></a></div>

		</div>
		
	</div>

	<div class="left_box">
		<div class="left_exit_r"></div>
		<div class="left_box_l"></div>
		<div class="left_exit_text"><a href="welcome.html" target="frm">返回首页</a></div>
	</div>

	<div class="left_box">
		<div class="left_exit_r"></div>
		<div class="left_box_l"></div>
		<div class="left_exit_text"><a href="#">安全退出</a></div>
	</div>

</div>

<div class="rrcc" id="RightBox">

	

	<div class="right">
        <iframe name="frm" frameborder="0" marginheight="0" marginwidth="0" width="100%" height="100%" style="overflow:hidden;" src="welcome.html"></iframe>
    </div>

</div>

</body>
</html>
