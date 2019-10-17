package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SQLmanager;
import Ultils.Sach;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SQLmanager sqLmanager = new SQLmanager();
		Sach sach = new Sach();
		sach.setGia(Integer.parseInt(request.getParameter("gia")));
		sach.setTen(request.getParameter("ten"));
		System.out.println(request.getParameter("ten"));
		if(!sqLmanager.insert(sach)) {
			request.setAttribute("error", "Loi ko the them");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Home").forward(request, response);
		}
	}

}
