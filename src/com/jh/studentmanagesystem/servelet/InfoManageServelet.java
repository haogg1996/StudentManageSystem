package com.jh.studentmanagesystem.servelet;

import java.io.IOException;
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String part=(String) request.getSession().getAttribute("part");
		response.setCharacterEncoding("utf-8");
		switch (action) {
		case "updata":
			if ("stud".equals(part)) {
				UserInfoDAO dao=new UserInfoDAO();
				UserInfo userInfo=new UserInfo();
				userInfo.setId(Integer.valueOf(request.getParameter("id")));
				userInfo.setName(request.getParameter("name"));
				userInfo.setPassword(request.getParameter("password"));
				userInfo.setAge(Integer.valueOf(request.getParameter("age")));
				userInfo.setSex(request.getParameter("sex"));
				userInfo.setAddress(request.getParameter("address"));
				userInfo.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
				userInfo.setTelephone(request.getParameter("telephone"));
				dao.updataBean(userInfo);
				response.getWriter().print("修改成功！");
			}else if ("admin".equals(part)) {
				ManageuserDAO dao=new ManageuserDAO();
				Manageuser manageuser=new Manageuser();
				manageuser.setId(Integer.valueOf(request.getParameter("id")));
				manageuser.setName(request.getParameter("name"));
				manageuser.setPassword(request.getParameter("password"));
				manageuser.setAge(Integer.valueOf(request.getParameter("age")));
				manageuser.setSex(request.getParameter("sex"));
				manageuser.setAddress(request.getParameter("address"));
				manageuser.setBirthday(Timestamp.valueOf(request.getParameter("birthday")));
				manageuser.setTelephone(request.getParameter("telephone"));
				dao.updataBean(manageuser);
				response.getWriter().print("修改成功！");
			}
			break;

		default:
			break;
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
