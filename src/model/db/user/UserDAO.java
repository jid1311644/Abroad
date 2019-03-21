package model.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class UserDAO extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.query sql:" + sql);
		LinkedList<UserBean> userBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserBean userbean = new UserBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "email":
						userbean.setEmail(rs.getString(i + 1));
						break;
					case "password":
						userbean.setPassword(rs.getString(i + 1));
						break;
					case "gender":
						userbean.setGender(rs.getBoolean(i + 1));
						break;
					case "address":
						userbean.setAddress(rs.getString(i + 1));
						break;
					case "college":
						userbean.setCollege(rs.getString(i + 1));
						break;
					case "gpa":
						userbean.setGpa(rs.getFloat(i + 1));
						break;
					case "education":
						userbean.setEducation(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				userBeans.add(userbean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return userBeans;
		} catch(SQLException e) {
			System.out.println("Error UserDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
}
