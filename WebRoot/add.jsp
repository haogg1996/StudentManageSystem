<%@page import="com.jh.studentmanagesystem.bean.User"%>
<%@page import="com.jh.studentmanagesystem.bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>个人信息</title>
<link href="css/personalinfo.css" rel="stylesheet" type="text/css" />
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript">
function check(){
	var pwd=document.getElementById("pwd").value;
	var pwd2=document.getElementById("pwd2").value;
	if(pwd==""&&pwd2==""){
		alert("密码不能为空！！");
		return false;
	}
	if(pwd!=pwd2){
	alert("两次密码不一致！");
		return false;
	}else{
		return true;
	}
	}

</script>
</head>
<body>

    <div class="div_top">添加用户</div>

    <div class="div_con">
    
    <form action="InfoManage" method="post" onsubmit="return check()">
        <table width="100%" cellspacing="1" cellpadding="0" border="0" bgcolor="#ccc">
		 	<tr align="center">
		 	<input type="hidden" value="add<%=request.getParameter("part") %>" name="action"/>
              <td width="20%">姓名</td>
              <td width="30%"><input type="text" value="" name="name"/></td>
              <td width="20%">年龄</td>
              <td width="30%"><input type="text" value="" name="age" /></td>
            </tr> 
            <tr align="center">
              <td>密码</td>
              <td><input type="password" value="" id="pwd" name="password"/></td>
              <td>出生日期</td>
              <td> 
                <input type="text" value="" name="birthday" />
              </td>
            </tr>       
            <tr align="center">
              <td>确认密码</td>
              <td><input type="password" value="" id="pwd2"/></td>
              <td>性别</td>
              <td>
              <select name="sex">
                <option value="男">男</option>
                <option value="女">女</option>                
              </select></td>
            </tr>       
               <tr align="center">
              <td>地址</td>
              <td><input type="text" value="" name="address"/></td>
              
              <td>电话号码</td>
              <td>
              <input type="text" value="" name="telephone"/></td>
            </tr> 
        </table>
	
    </div>

    <div class="div_down">
        <input id="btn_submit" type="submit" value="保存信息" style="cursor:hand;" />
        <input id="btn_reset" type="reset" value="重新输入" style="cursor:hand;" />
    </div>
</form>
</body>
</html>
