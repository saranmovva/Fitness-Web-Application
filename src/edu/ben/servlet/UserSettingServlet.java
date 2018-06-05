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
 * Servlet implementation class UserSettingServlet
 */
@WebServlet("/UserSettingServlet")
public class UserSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSettingServlet() {
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

		HttpSession s = request.getSession();
		User u = (User) s.getAttribute("User");
		UserDao ud = new UserDao();
		String currentPassword = u.getPassword();
		Integer currentAge = u.getAge();
		Double currentHeight = u.getHeight();

		if (request.getParameter("password") != "" && request.getParameter("height") != ""
				&& request.getParameter("age") != "") {

			String password = request.getParameter("password");
			double height = Double.parseDouble(request.getParameter("height"));
			int age = Integer.parseInt(request.getParameter("age"));
			if (!(password.length() > 5) && !(currentHeight > 0) && !(currentAge > 0)) {

				request.setAttribute("password", currentPassword);
				request.setAttribute("age", currentAge);
				request.setAttribute("height", currentHeight);
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration Unsuccessful. Try Again');");
				out.println("location='userSettings.jsp';");
				out.println("</script>");
				out.flush();
			} else {
				currentAge = Integer.parseInt(request.getParameter("age"));
				try {
					ud.changeUserPassword(password, u.getEmail());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					ud.updateUser(u.getEmail(), age, height, u.getGender());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				u.setPassword(password);
				u.setAge(age);
				u.setHeight(height);
				HttpSession session = request.getSession();
				session.setAttribute("User", u);
				response.sendRedirect("userSettings.jsp");
			}
		}
	}
}
