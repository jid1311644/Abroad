package model.db.user_college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class UserCollegeDAO  extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserCollegeDAO.query sql:" + sql);
		LinkedList<UserCollegeBean> userCollegeBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserCollegeBean userCollegeBean = new UserCollegeBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "email":
						userCollegeBean.setEmail(rs.getString(i + 1));
						break;
					case "college_id":
						userCollegeBean.setCollegeId(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				userCollegeBeans.add(userCollegeBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return userCollegeBeans;
		} catch(SQLException e) {
			System.out.println("Error UserCollegeDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserCollegeDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserCollegeDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserCollegeDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserCollegeDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserCollegeDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserCollegeDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
}