package edu.ben.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ben.model.User;

public class UserDao extends DBConnector {

	public void changeUserPassword(String newPassword, String email) throws SQLException {
		Connection conn = getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"update fitnessdb.User set password='" + newPassword + "' where email='" + email + "';");
		ps.executeUpdate();
	}

	public User getUserByEmail(String email) throws SQLException {
		Connection conn = getConnection();

		String sql = "select * from fitnessdb.User where email = '" + email + "'";

		PreparedStatement query = conn.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		if (rs.next()) {
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String password = rs.getString("Password");
			String emailReturn = rs.getString("Email");
			Integer age = rs.getInt("Age");
			double height = rs.getDouble("Height");
			String gender = rs.getString("Gender");
			User temp = new User(firstName, lastName, emailReturn, password);
			temp.setAge(age);
			temp.setHeight(height);
			temp.setGender(gender);
			return temp;
		}

		return null;
	}

	public boolean insertUser(User user) throws SQLException {
		Connection conn = getConnection();

		String sql = "select * from fitnessdb.User where Email = '" + user.getEmail() + "'";

		PreparedStatement query = conn.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		if (!rs.next()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO fitnessdb.user(FirstName, LastName, Email, Password, Age, Height, Gender)"
							+ " VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '"
							+ user.getEmail() + "', '" + user.getPassword() + "', '" + user.getAge() + "', '"
							+ user.getHeight() + "', '" + user.getGender() + "')");
			ps.executeUpdate();
			return true;
		}
		return false;

	}

	public ArrayList<User> getAllUser() throws SQLException {
		Connection conn = getConnection();

		String sql = "select * from fitnessdb.User";

		PreparedStatement query = conn.prepareStatement(sql);

		ResultSet rs = query.executeQuery();
		User temp;
		ArrayList<User> results = new ArrayList<User>();
		while (rs.next()) {
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String password = rs.getString("Password");
			String email = rs.getString("Email");
			Integer age = rs.getInt("Age");
			double height = rs.getDouble("Height");
			String gender = rs.getString("Gender");
			temp = new User(firstName, lastName, email, password);
			temp.setAge(age);
			temp.setHeight(height);
			temp.setGender(gender);
			results.add(temp);

		}
		return results;
	}

	public boolean deleteUser(String email) throws SQLException {
		Connection conn = getConnection();

		String sql = "delete from fitnessdb.User where Email='" + email + "'";

		PreparedStatement query = conn.prepareStatement(sql);
		query.executeUpdate();

		sql = "select * from fitnessdb.User where Email = '" + email + "'";

		query = conn.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		if (!rs.next()) {
			return true;
		}
		return false;
	}

	public boolean updateUser(String email, int age, double height, String gender) throws SQLException {
		Connection conn = getConnection();

		String sql = "update fitnessdb.User set Age = " + age + ", Height = " + height + ", Gender = '" + gender
				+ "' where Email = '" + email + "' ";

		PreparedStatement query = conn.prepareStatement(sql);
		query.executeUpdate();

		User test = getUserByEmail(email);
		if (test.getAge() == age && test.getHeight() == height && test.getGender().equals(gender)) {
			return true;
		}
		return false;
	}
	
	public int lastWeight(Object id) throws SQLException {
		Connection conn = getConnection();
		String sql = "select Weight from fitnessdb.Progress where EmailID = '" + id + "' order by Date desc";
		PreparedStatement query = conn.prepareStatement(sql);
		ResultSet rs = query.executeQuery();
		
		if (rs.next()) {
			return rs.getInt("Weight");
		}
		else{
			return -1;
		}
		
	}
}
