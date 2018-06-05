package edu.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.dao.UserDao;
import edu.ben.model.User;

/**
 * Servlet implementation class BMRServlet
 */
@WebServlet("/BMRServlet")
public class BMRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BMRServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double BMRNumber = Double.parseDouble(request.getParameter("grp1"));

		UserDao temp = new UserDao();
		HttpSession s = request.getSession();
		User u = (User) s.getAttribute("User");
		
		int weight = 0;
		try {
			weight = temp.lastWeight(u.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double height = u.getHeight();
		String gender = u.getGender();
		int age = u.getAge();

		if (gender == "female") {
			Double bmrWomen = Math.floor(
					((655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age)) * BMRNumber.doubleValue()) * 100) / 100;
			request.setAttribute("BMR", bmrWomen);
			getServletContext().getRequestDispatcher("/BMRConfirmation.jsp").forward(request, response);
		} else if (gender == "male") {
			Integer BMRMen = (int) Math
					.ceil((66 + (6.2 * weight) + (12.7 * height) - (6.76 * age)) * BMRNumber.doubleValue());
			request.setAttribute("BMR", BMRMen);
			getServletContext().getRequestDispatcher("/BMRConfirmation.jsp").forward(request, response);
		}
	}

}