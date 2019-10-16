package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQLmanagers.SQLManager;
import Ultils.Sinhvien;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_EDIT = "edit";
	private static final String ACTION_DELETE = "delete";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SQLManager manager = new SQLManager();
		List<Sinhvien> hs = manager.getAllData();

		String action = request.getParameter("action");

		System.out.println("action" + action);
		if (action == null) {
			request.setAttribute("list", hs);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if (action != null && action.equalsIgnoreCase(ACTION_DELETE)) {
//			return; 
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				if (manager.delete(id)) {
//					response.setHeader("REFRESH", "0");
					response.getWriter().append("Delete thanh cong");
					request.r
				}else {
					response.getWriter().append("Delete thất bại");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} else if (action != null && action.equalsIgnoreCase(ACTION_EDIT)) {
			request.getRequestDispatcher("Edit").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

	}

}
