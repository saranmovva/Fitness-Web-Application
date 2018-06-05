package edu.ben.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.dao.ProgressDao;

import edu.ben.model.User;
import edu.ben.model.Weight;
import java.util.ArrayList;

/**
 * Servlet implementation class GraphPageServlet
 */
@WebServlet("/GraphPageServlet")
public class GraphPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object id = session.getAttribute("EmailID");
		
		ProgressDao p = new ProgressDao();
		
		System.out.println("graphPage");
		
		ArrayList<Number> wValues = new ArrayList<Number>();
		ArrayList<String> dValues = new ArrayList<String>();
		
		response.setContentType("application/json");
		
		try {
			ArrayList<Weight> weights = p.getWeightsByID(id);
			for(Weight w : weights){
				wValues.add(w.getWeight());
				dValues.add(w.getDate());
			}
//			JSONObject o = new JSONObject();
//			o.put("x", dValues);
//			o.put("y", wValues);
//			PrintWriter out = response.getWriter();
//			out.print(o);
			
			StringBuilder s = new StringBuilder();
			s.append("{x: [");
			for(Number w : wValues){
				s.append(w + ", ");
			}
			s.append("],\n");
			s.append("y: [");
			for(String d : dValues){
				s.append("'" + d + "', ");
			}
			s.append("], " + "type: 'scatter', mode: 'lines'}");
			
			PrintWriter out = response.getWriter();
			
			out.print(s);
			out.flush();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
