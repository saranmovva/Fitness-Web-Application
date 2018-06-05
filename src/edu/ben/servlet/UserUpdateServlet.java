package edu.ben.servlet;

import java.io.IOException;
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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int age = Integer.parseInt(request.getParameter("Age"));
			double height = Double.parseDouble(request.getParameter("Height"));
			String gender = request.getParameter("Gender");
			UserDao usr = new UserDao();
			HttpSession session = request.getSession();;
			User temp = (User) session.getAttribute("User");
			if(validateData(age,height,gender)){
				try {
					usr.updateUser(temp.getEmail(), age, height, gender);
					temp.setAge(age);
					temp.setHeight(height);
					temp.setGender(gender);
					session.setAttribute("User", temp);
					response.sendRedirect("Dashboard.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else{
				response.sendRedirect("Dashboard.jsp");
			}
	}

	private boolean validateData(int age, double height, String gender){
		if(age > 0 && height > 0 && (gender.equals("Male") || gender.equals("Female") )){
			return true;
		}
		return false;
	}
	
}
