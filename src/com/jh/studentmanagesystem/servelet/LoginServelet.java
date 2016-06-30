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
		response.setCharacterEncoding("UTF-8");
		String part=request.getParameter("part");
		String name=request.getParameter("TxtUserName");
		int id = 0;
		if ("stud".equals(part)) {
			UserInfoDAO dao=new UserInfoDAO();
			if ((id=dao.selectIdByUser(new UserInfo(name,request.getParameter("TxtPassword"))))<=0) {
				response.getWriter().print("登录失败！");
				return;
			}
		}else if ("admin".equals(part)) {
			ManageuserDAO dao=new ManageuserDAO();
			if ((id=dao.selectIdByManager(new Manageuser(name,request.getParameter("TxtPassword"))))<=0) {
				response.getWriter().print("登录失败！");
				return;
			}
		}
		System.out.println(name);
		request.getSession().setAttribute("part", part);
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("id", id);
		response.sendRedirect("index.jsp");
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
