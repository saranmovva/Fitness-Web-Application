package edu.ben.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import edu.ben.dao.UserDao;
import edu.ben.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("LoginEmail");
		String password = request.getParameter("LoginPassword");
		UserDao usr = new UserDao();

		try {
			User temp = usr.getUserByEmail(email);
			if (temp != null) {
				if (isUser(temp.getPassword(), password)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("User", temp);
					session.setAttribute("EmailID", email);
					WeightUpdateServlet.updateSessionWeights(request);
					response.sendRedirect("Dashboard.jsp");
				} else {
					request.setAttribute("loginEmail", email);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("loginEmail", email);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public boolean isUser(String actualPassword, String enteredPassword) {
		return actualPassword.equals(enteredPassword);
	}

}
