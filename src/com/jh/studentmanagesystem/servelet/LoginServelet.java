package com.jh.studentmanagesystem.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.studentmanagesystem.bean.Manageuser;
import com.jh.studentmanagesystem.bean.UserInfo;
import com.jh.studentmanagesystem.dao.ManageuserDAO;
import com.jh.studentmanagesystem.dao.UserInfoDAO;

public class LoginServelet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServelet() {
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

		doPost(request, response);
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
		response.setCharacterEncoding("GBK");
		String part=request.getParameter("part");
		
		if ("stud".equals(part)) {
			UserInfoDAO dao=new UserInfoDAO();
			if (dao.selectByUser(new UserInfo(request.getParameter("TxtUserName"),request.getParameter("TxtPassword")))) {
				response.getWriter().print("登录成功！");
			}else {
				response.getWriter().print("登录失败！");
			}
		}else if ("admin".equals(part)) {
			ManageuserDAO dao=new ManageuserDAO();
			if (dao.selectByManager(new Manageuser(request.getParameter("TxtUserName"),request.getParameter("TxtPassword")))) {
				response.getWriter().print("登录成功！");
			}else {
				response.getWriter().print("登录失败！");
			}
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
