package com.jh.studentmanagesystem.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.studentmanagesystem.bean.Course;
import com.jh.studentmanagesystem.bean.Cscourse;
import com.jh.studentmanagesystem.bean.UserInfo;
import com.jh.studentmanagesystem.dao.CourseDAO;
import com.jh.studentmanagesystem.dao.CscourseDAO;
import com.jh.studentmanagesystem.dao.UserInfoDAO;

public class CscourseManageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CscourseManageServlet() {
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
		if ("getCscourse".equals(action)) {
			CscourseDAO dao=new CscourseDAO();
			List<Cscourse> cscourses = dao.selectCscourseByUserId((int)request.getSession().getAttribute("id"));
			request.setAttribute("cscourses", cscourses);
			request.getRequestDispatcher("cscourse.jsp").forward(request, response);
		}
		if ("getCourse".equals(action)) {
			CourseDAO dao=new CourseDAO();
			List<Course> courses = dao.selectAll();
			UserInfoDAO userdao=new UserInfoDAO();
			UserInfo user = userdao.selectBeanByid((int)request.getSession().getAttribute("id"));
			Set cscourses1=user.getCscourses();
			Iterator iterator = cscourses1.iterator();
			while (iterator.hasNext()) {
				Cscourse c= (Cscourse) iterator.next();
				if (courses.contains(c.getCourse())) {
					courses.remove(c.getCourse());
				}
			}
			request.setAttribute("courses", courses);
			request.getRequestDispatcher("selectcourse.jsp").forward(request, response);
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
		response.setContentType("text/html;charset=UTF-8");
		CscourseDAO dao=new CscourseDAO();
		String[] couseides = request.getParameterValues("check");
		for (int i = 0; i < couseides.length; i++) {
			dao.addCscourse((int)request.getSession().getAttribute("id"), Integer.valueOf(couseides[i]));
		}
//		response.getWriter().print("<h3>课程添加成功！</h3>");
		//<script>alert('该数据已经同步完成');</script><script>alert('该数据已经同步完成');</script>
		response.getWriter().print("<script>alert('选课成功！');window.location='CscourseManage?action=getCscourse';</script>");
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
