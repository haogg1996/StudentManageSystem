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
<script type="text/javascript">
  var xmlhttp;

  function onclickfcun(id){
	  
	  if(confirm("确认删除该课程？删除该课程之后所有选取该课程的选课记录也将被删除！")){
		  if (window.XMLHttpRequest)
		  {
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		  xmlhttp.open("POST", "CourseManage", true);
		  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		  xmlhttp.send("action=delesingle&id="+id);
		  xmlhttp.onreadystatechange=change_state;
		}
		else{
			return false;
		}
	 
  }
  
  function prom() {
      var name = prompt("添加课程", "输入课程名"); 
      if (name!=""&&name!="输入课程名"&&name!=null)
      {
    	  if (window.XMLHttpRequest)
		  {
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		  xmlhttp.open("POST", "CourseManage", true);
		  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		  xmlhttp.send("action=addcourse&coursename="+name);
		  xmlhttp.onreadystatechange=change_state;
      }

  }
  
  function change_state(){
	  if(xmlhttp.readyState==4){
		  if(xmlhttp.status==200){
			  s=xmlhttp.responseText;
			  obj=JSON.parse(s);
			  if(obj.msg){
				  alert("操作成功!");
				  location.reload(true);
			  }else{
				  alert("操作失败!");
			  }
		  }
	  }
  }
</script>
</head>
<body>

    <div class="div_top">课程信息</div>
    
    <div class="div_con">
   
        <table width="100%" cellspacing="1" cellpadding="0" border="0" bgcolor="#cccs">
     
		    <tr align="center">
			<td >课程名ID</td>          
			<td >课程名</td>          
			<td >操作</td>           
		</tr>
		<form action="CourseManage" method="post">
  	<%
	    List<Course> courses=(List<Course>)request.getAttribute("courses");
	    	for(Course course:courses){
	    		out.print("<tr align=\"center\">");
	    		out.print("<td>"+course.getCourseid()+"</td>");
	    		out.print("<td>"+course.getCourseName()+"</td>");
	    		out.print("<td><input type=\"button\" value=\"删除\" onclick=\"onclickfcun('"+course.getCourseid()+"')\" /></td></tr>");
	    	}
	    	
    
    %> 
    
        </table>
    </div>
 	<div class="div_down" align="center">
        <input id="btn_search" type="button" value="添加课程" onclick="prom()" style="cursor:hand;" />
    </div>
    </form>
</body>
</html>
