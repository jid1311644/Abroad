package model.db.major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class MajorDAO  extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("MajorDAO.query sql:" + sql);
		LinkedList<MajorBean> majorBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				MajorBean majorBean = new MajorBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "major_id":
						majorBean.setMajorId(rs.getString(i + 1));
						break;
					case "name":
						majorBean.setName(rs.getString(i + 1));
						break;
					case "info":
						majorBean.setInfo(rs.getString(i + 1));
						break;
					case "type":
						majorBean.setType(rs.getString(i + 1));
						break;
					case "hot":
						majorBean.setHot(rs.getInt(i + 1));
						break;
					default:
						break;
					}
				}
				majorBeans.add(majorBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return majorBeans;
		} catch(SQLException e) {
			System.out.println("Error MajorDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("MajorDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error MajorDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("MajorDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error MajorDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("MajorDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error MajorDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
}