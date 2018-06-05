package edu.ben.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.model.Weight;
import edu.ben.dao.ProgressDao;

/**
 * Servlet implementation class WeightUpdateServlett
 */
@WebServlet("/WeightUpdateServlet")
public class WeightUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightUpdateServlet() {
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
		Double weight = Double.parseDouble(request.getParameter("WeightValue"));
		String date = request.getParameter("DateValue");
		Weight w = new Weight(weight, date);
		ProgressDao p = new ProgressDao();
		
		HttpSession session = request.getSession();
		
		
		try {
			p.saveWeight(w, session.getAttribute("EmailID"));
			//ArrayList<Number> wValues = new ArrayList<Number>();
			//ArrayList<String> dValues = new ArrayList<String>();
//			StringBuilder weightStr = new StringBuilder();
//			StringBuilder dateStr = new StringBuilder();
//			Object id = session.getAttribute("EmailID");
//			ArrayList<Weight> weights = p.getWeightsByID(id);
//			weightStr.append("[");
//			dateStr.append("[");
//			for(Weight temp : weights){
//				System.out.println("weight added");
//				weightStr.append(temp.getWeight());
//				weightStr.append(", ");
//				//wValues.add(w.getWeight());
//				//dValues.add(w.getDate());
//			}
//			weightStr.append("]");
//			session.setAttribute("WeightStr", weightStr.toString());
//			System.out.println(weightStr.toString());
//			
			//session.setAttribute("Weights", weights);
			
			updateSessionWeights(request);
			
			response.sendRedirect("Dashboard.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateSessionWeights(HttpServletRequest request){
		ProgressDao p = new ProgressDao();
		
		HttpSession session = request.getSession();	
		StringBuilder weightStr = new StringBuilder();
		StringBuilder dateStr = new StringBuilder();
		
		Object id = session.getAttribute("EmailID");
		System.out.println("weights updated for: " + id);
		ArrayList<Weight> weights;
		try {
			weights = p.getWeightsByID(id);
			
			weightStr.append("[");
			dateStr.append("[");
			for(Weight temp : weights){
				weightStr.append(temp.getWeight());
				weightStr.append(", ");
				dateStr.append("'"+temp.getDate()+"'");
				dateStr.append(", ");
			}
			weightStr.append("]");
			dateStr.append("]");
			session.setAttribute("WeightStr", weightStr.toString());
			session.setAttribute("DateStr", dateStr.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
