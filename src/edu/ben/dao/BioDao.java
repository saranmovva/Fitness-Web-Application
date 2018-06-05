package edu.ben.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BioDao extends DBConnector {

	public double getUserHeight(String userEmail) throws SQLException {
		Connection conn = getConnection();
		double height = 0;
		int id;
		String sql = "select * from fitnessdb.user where email = '" + userEmail + "'";

		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		if (rs.next()) {
			id = rs.getInt("BioID");

			String sq2 = "select * from fitnessdb.Bio where BioID = '" + id + "'";
			query = conn.prepareStatement(sq2);
			ResultSet r = query.executeQuery();
			if (r.next()) {
				height = r.getDouble("Height");
			}

		}

		return height;
	}

	public int getUserAge(String userEmail) throws SQLException {
		Connection conn = getConnection();
		int age = 0;
		int id;
		String sql = "select * from fitnessdb.user where email = '" + userEmail + "'";

		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		if (rs.next()) {
			id = rs.getInt("BioID");

			String sql2 = "select * from fitnessdb.Bio where BioID = '" + id + "'";
			query = conn.prepareStatement(sql2);
			ResultSet r = query.executeQuery();
			if (r.next()) {
				age = r.getInt("Age");
			}

		}

		return age;
	}

	public String getUserGender(String userEmail) throws SQLException {
		Connection conn = getConnection();
		String gender = null;
		int id;
		String sql = "select * from fitnessdb.user where email = '" + userEmail + "'";

		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		if (rs.next()) {
			id = rs.getInt("BioID");

			String sql2 = "select * from fitnessdb.Bio where BioID = '" + id + "'";
			query = conn.prepareStatement(sql2);
			ResultSet r = query.executeQuery();
			if (r.next()) {
				gender = r.getString("Gender");
			}

		}

		return gender;
	}

	public boolean inserUserBio(String userEmail, double height, int age, String gender) throws SQLException {
		Connection conn = getConnection();
		Integer id = null;
		String sql = "select * from fitnessdb.user where email = '" + userEmail + "'";
		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		if (rs.next()) {
			id = rs.getInt("BioID");
		}
		if(id == null) {
			
		}
		return true;
	}
}
