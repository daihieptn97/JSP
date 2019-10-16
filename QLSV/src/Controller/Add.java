package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQLmanagers.SQLManager;
import Ultils.Sinhvien;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLManager sqlManager;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add() {
	
		super();
		// TODO Auto-generated constructor stub
		sqlManager = new SQLManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("WEB-INF/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Sinhvien sv = new Sinhvien(Integer.parseInt(request.getParameter("tuoi")), request.getParameter("ten"),
				request.getParameter("msv"));
		
		if (sqlManager.insert(sv)) {
			response.getWriter().append("Thêm thành công");
			response.setHeader("REFRESH", "1");
		}else {
			response.getWriter().append("thêm thất bại");
		}

//		doGet(request, response);
	}

}
