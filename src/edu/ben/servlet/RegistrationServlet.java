package edu.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.dao.UserDao;
import edu.ben.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String passwordConfirm = request.getParameter("ConfirmPassword");
		UserDao usr = new UserDao();

		if (password.equals(passwordConfirm) && validateEntry(firstName, lastName, email, password)) {
			try {
				if (usr.getUserByEmail(email) != null) {
					request.setAttribute("FirstName", firstName);
					request.setAttribute("LastName", lastName);
					request.setAttribute("Email", email);
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Registration Unsuccessful. Try Again');");
					out.println("location='index.jsp';");
					out.println("</script>");
					out.flush();

				} else {
					usr.insertUser(new User(firstName, lastName, email, password));
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Registration Successful. Try Loggin In');");
					out.println("location='index.jsp';");
					out.println("</script>");
					out.flush();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("FirstName", firstName);
			request.setAttribute("LastName", lastName);
			request.setAttribute("Email", email);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Unsuccessful Try Again');");
			out.println("location='index.jsp';");
			out.println("</script>");
			out.flush();
		}
	}

	private boolean validateEntry(String firstName, String lastName, String email, String password) {
		if (!firstName.contains("[0-9]") && !lastName.contains("[0-9]") && email.contains("@")
				&& password.length() > 5) {
			return true;
		}
		return false;

	}

}
