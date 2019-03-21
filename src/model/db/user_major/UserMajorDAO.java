package model.db.user_major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class UserMajorDAO extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserMajorDAO.query sql:" + sql);
		LinkedList<UserMajorBean> userMajorBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserMajorBean userMajorBean = new UserMajorBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "email":
						userMajorBean.setEmail(rs.getString(i + 1));
						break;
					case "major_id":
						userMajorBean.setMajorId(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				userMajorBeans.add(userMajorBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return userMajorBeans;
		} catch(SQLException e) {
			System.out.println("Error UserMajorDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserMajorDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserMajorDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserMajorDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserMajorDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserMajorDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserMajorDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
}
