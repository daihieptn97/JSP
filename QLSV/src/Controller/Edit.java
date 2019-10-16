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
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
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
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		Sinhvien sv = manager.getSinhVienByID(id);

		if (id != -1 && sv != null) {
			request.setAttribute("data", sv);
			request.getRequestDispatcher("WEB-INF/edit.jsp").forward(request, response);
		} else {
			response.getWriter().append("Loi 4040");
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
		SQLManager sqlManager = new SQLManager();
		Sinhvien sv = new Sinhvien(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("tuoi")), request.getParameter("ten"),
				request.getParameter("msv"));

		if (sqlManager.update(sv)) {
			response.getWriter().append("Sửa thành công");
			response.sendRedirect("Home");
		} else {
			response.getWriter().append("Sửa thất bại");
		}

	}

}
