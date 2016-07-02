package com.jh.studentmanagesystem.servelet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.studentmanagesystem.bean.Manageuser;
import com.jh.studentmanagesystem.bean.User;
import com.jh.studentmanagesystem.bean.UserInfo;
import com.jh.studentmanagesystem.dao.ManageuserDAO;
import com.jh.studentmanagesystem.dao.UserInfoDAO;

public class InfoManageServelet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InfoManageServelet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		String part=(String) request.getSession().getAttribute("part");
		User userbean = null;
		int id=(Integer) request.getSession().getAttribute("id");
		if ("getInfo".equals(action)) {
			if ("stud".equals(part)) {
				UserInfoDAO dao=new UserInfoDAO();
				userbean=dao.selectBeanByid(id);
				
			}else if ("admin".equals(part)) {
				ManageuserDAO dao=new ManageuserDAO();
				userbean=dao.selectBeanByid(id);
				
			}
			request.setAttribute("bean", userbean);
			request.getRequestDispatcher("info.jsp").forward(request, response);
		}

		
	}
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	String part;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");  
		String action = request.getParameter("action");
		part=(String) request.getSession().getAttribute("part");
		response.setCharacterEncoding("utf-8");
		switch (action) {
		case "updata":
			updateInfo(request, response);
			break;

		case "addstud":
			UserInfoDAO dao=new UserInfoDAO();
			UserInfo stud=new UserInfo();
			String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			stud.setName(name);
			stud.setPassword(request.getParameter("password"));
			stud.setAge(Integer.valueOf(request.getParameter("age")));
			stud.setSex(sex);
			stud.setAddress(request.getParameter(address));
			stud.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
			stud.setTelephone(request.getParameter("telephone"));
			String responseMsg=(dao.insertBean(stud))?"<h3>添加成功！</h3>":"<h3>添加失败！</h3>";
			response.getWriter().print(responseMsg);
			break;
		case "addadmin":
			ManageuserDAO mDao=new ManageuserDAO();
			Manageuser mStud=new Manageuser();
			String mSex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			mStud.setName(request.getParameter("name"));
			mStud.setPassword(request.getParameter("password"));
			mStud.setAge(Integer.valueOf(request.getParameter("age")));
			mStud.setSex(mSex);
			mStud.setAddress(request.getParameter("address"));
			mStud.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
			mStud.setTelephone(request.getParameter("telephone"));
			String responseMsg1=(mDao.insertBean(mStud))?"<h3>添加成功！</h3>":"<h3>添加失败！</h3>";
			response.getWriter().print(responseMsg1);
			break;
		case "reg":
			UserInfoDAO rdao=new UserInfoDAO();
			UserInfo rtud=new UserInfo();
			String rsex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			String raddress=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String rname=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			rtud.setName(rname);
			rtud.setPassword(request.getParameter("password"));
			rtud.setAge(Integer.valueOf(request.getParameter("age")));
			rtud.setSex(rsex);
			rtud.setAddress(request.getParameter(raddress));
			rtud.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
			rtud.setTelephone(request.getParameter("telephone"));
			String rresponseMsg=(rdao.insertBean(rtud))?"<h3>注册成功！<a href=\"login.html\">点击返回登录界面</a></h3>":"<h3>添加失败！<a href=\"reg.html\">点击返回注册界面</a></h3>";
			response.getWriter().print(rresponseMsg);
			break;
		}
	}
	
	public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//中文解码，解决乱码
		String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		if ("stud".equals(part)) {
			UserInfoDAO dao=new UserInfoDAO();
			UserInfo userInfo=new UserInfo();
			userInfo.setId(Integer.valueOf(request.getParameter("id")));
			userInfo.setName(request.getParameter("name"));
			userInfo.setPassword(request.getParameter("password"));
			userInfo.setAge(Integer.valueOf(request.getParameter("age")));
			userInfo.setSex(sex);
			userInfo.setAddress(request.getParameter("address"));
			userInfo.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
			userInfo.setTelephone(request.getParameter("telephone"));
			dao.updataBean(userInfo);
			response.getWriter().write("<h3>修改成功！</h3>");
		}else if ("admin".equals(part)) {
			ManageuserDAO dao=new ManageuserDAO();
			Manageuser manageuser=new Manageuser();
			manageuser.setId(Integer.valueOf(request.getParameter("id")));
			manageuser.setName(request.getParameter("name"));
			manageuser.setPassword(request.getParameter("password"));
			manageuser.setAge(Integer.valueOf(request.getParameter("age")));
			manageuser.setSex(sex);
			manageuser.setAddress(request.getParameter("address"));
			manageuser.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
			manageuser.setTelephone(request.getParameter("telephone"));
			dao.updataBean(manageuser);
			response.getWriter().write("<h3>修改成功！</h3>");
		}
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
