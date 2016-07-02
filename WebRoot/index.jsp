<%@page import="org.hibernate.annotations.Parent"%>
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
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title>学生管理系统</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

    var $ = function (id) {
        return document.getElementById(id);
    }

    function show_menu(num) {
        for (j = 0; j < 100; j++) {
            if (j != num) {
                if ($('Oli' + j)) {
                    $('Oli' + j).style.display = 'none';
                    $('O' + j).style.background = 'url(images/01.gif)';
                }
            }
        }
        if ($('Oli' + num)) {
            if ($('Oli' + num).style.display == 'block') {
                $('Oli' + num).style.display = 'none';
                $('O' + num).style.background = 'url(images/01.gif)';
            } else {
                $('Oli' + num).style.display = 'block';
                $('O' + num).style.background = 'url(images/02.gif)';
            }
        }
    }

    var temp = 0;

    function menu_hide_show() {
        if (temp == 0) {
            document.getElementById('LeftBox').style.display = 'none';
            document.getElementById('RightBox').style.marginLeft = '0';
            document.getElementById('Mobile').style.background = 'url(images/menu_show.gif)';
            temp = 1;
        }
        else {
            document.getElementById('RightBox').style.marginLeft = '222px';
            document.getElementById('LeftBox').style.display = 'block';
            document.getElementById('Mobile').style.background = 'url(images/menu_hide.gif)';
            temp = 0;
        }
    }

</script>
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
		String stringName=null,stringM1=null;
		if("stud".equals(part)){
			stringName="学生："+name;
			stringM1="<a href=\"CscourseManage?action=getCscourse\"  target=\"frm\"><span id=\"O1\" class=\"left_menu_one_img\"></span>选课信息管理</a></div> ";
		}else if("admin".equals(part)){
			stringName="管理员："+name;
			stringM1="<a onclick=\"show_menu(1)\" href=\"javascript:;\"><span id=\"O1\" class"+
					"=\"left_menu_one_img\"></span>帐户管理</a></div><div class=\"left_menu_two\" id"+
					"=\"Oli1\"><ul><li><a href=\"List?part=stud\" target=\"frm\">&middot;学生帐户管理</a></li>"+
					"<li><a href=\"List?part=admin\" target=\"frm\">&middot;管理员帐户管理</a></li></ul></div><div class=\"left_menu_one\">"+
					"<a onclick=\"show_menu(2)\" href=\"javascript:;\"><span id=\"O2\" class"+
					"=\"left_menu_one_img\"></span><li><a href=\"CourseManage?action=getlist\"  target=\"frm\">&middot;  课程信息管理</a></div>";
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
		      <%out.print(stringM1); %>
		    <div class="left_menu_one">
		      <a href="InfoManage?action=getInfo" target="frm"><span id="O2" class="left_menu_one_img"></span>个人信息管理</a></div>
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
		<div class="left_exit_text"><a href="Login?action=longout">安全退出</a></div>
	</div>

</div>

<div class="rrcc" id="RightBox">

	

	<div class="right">
        <iframe name="frm" frameborder="0" marginheight="0" marginwidth="0" width="100%" height="100%" style="overflow:hidden;" src="welcome.html"></iframe>
    </div>

</div>

</body>
</html>
