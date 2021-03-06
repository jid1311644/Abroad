package model.db.user_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class UserExamDAO extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserExamDAO.query sql:" + sql);
		LinkedList<UserExamBean> userExamBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserExamBean userExamBean = new UserExamBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "email":
						userExamBean.setEmail(rs.getString(i + 1));
						break;
					case "exam_id":
						userExamBean.setExamId(rs.getString(i + 1));
						break;
					case "score":
						userExamBean.setScore(rs.getFloat(i + 1));
						break;
					default:
						break;
					}
				}
				userExamBeans.add(userExamBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return userExamBeans;
		} catch(SQLException e) {
			System.out.println("Error UserExamDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserExamDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserExamDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserExamDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserExamDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserExamDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error UserExamDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
}
