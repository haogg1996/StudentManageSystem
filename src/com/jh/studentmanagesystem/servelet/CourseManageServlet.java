package com.jh.studentmanagesystem.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.jh.studentmanagesystem.bean.Course;
import com.jh.studentmanagesystem.dao.CourseDAO;

public class CourseManageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CourseManageServlet() {
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
		if ("getlist".equals(action)) {
			CourseDAO dao=new CourseDAO();
			List<Course> courses = dao.selectAll();
			request.setAttribute("courses",courses);
			request.getRequestDispatcher("courseManage.jsp").forward(request, response);
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
		response.setContentType("text/json;charset=UTF-8");
		
		String action=request.getParameter("action");
		if ("delesingle".equals(action)) {
			int id=Integer.valueOf(request.getParameter("id"));
			System.out.println(id);
			CourseDAO dao=new CourseDAO();
			dao.deletCourse(id);
			JSONObject object=new JSONObject();
			try {
				object.put("msg", true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getOutputStream().write(object.toString().getBytes());
		}
		else if ("addcourse".equals(action)) {
			CourseDAO dao=new CourseDAO();
			String coursname=new String(request.getParameter("coursename").getBytes("ISO-8859-1"), "utf-8");
			boolean isInsert=dao.insertBean(new Course(coursname));
			JSONObject object=new JSONObject();
			try {
				object.put("msg", isInsert);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getOutputStream().write(object.toString().getBytes());
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
