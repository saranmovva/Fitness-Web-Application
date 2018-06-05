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

import edu.ben.dao.UserDao;
import edu.ben.model.User;

/**
 * Servlet implementation class bmiServlet
 */
@WebServlet("/BMIServlet")
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMIServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		UserDao temp = new UserDao();
		
		
		double inches = user.getHeight();
		double weight = 0;
		try {
			weight = temp.lastWeight(user.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double bmi  = (weight * 703) / (inches * inches);
		bmi = (double) Math.round(bmi * 100) / 100;
		String bmiRange = "";
		if(bmi < 18.5){
			bmiRange = "You are underweight";
		}else if(bmi > 18.5 && bmi < 24.9) {
			bmiRange = "You are a normal weight";
		}else if(bmi > 24.9 && bmi < 29.9) {
			bmiRange = "You are overweight";
		}else {
			bmiRange = "You are Obese";
		}
		
		
		request.setAttribute("bmi", bmi);
		request.setAttribute("bmiRange", bmiRange);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/bmiConfirmation.jsp");
		dispatcher.forward(request, response);
	}

}