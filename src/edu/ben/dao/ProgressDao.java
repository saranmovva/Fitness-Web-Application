package edu.ben.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ben.model.User;
import edu.ben.model.Weight;

public class ProgressDao extends DBConnector {

	public boolean saveWeight(Weight w, Object id) throws SQLException {
		
		Connection conn = getConnection();
	
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO fitnessdb.progress(EmailID, Weight, Date)" + " VALUES ('"
						+ id + "', '" + w.getWeight() + "', '" + w.getDate() + "')");
		ps.executeUpdate();
		return true;
	}
	
	public ArrayList<Weight> getWeightsByID(Object id) throws SQLException {
		ArrayList<Weight> weights = new ArrayList<Weight>();
		
		Connection conn = getConnection();

		String sql = "select * from fitnessdb.Progress where EmailID = '" + id + "' order by Date asc";

		
		PreparedStatement query = conn.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		while (rs.next()) {
			
			Weight w = new Weight(rs.getInt("Weight"), rs.getString("Date"));
			weights.add(w);
		}
		
		
		return weights;
		
	}
	
}
