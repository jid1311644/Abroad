package model.db.major_type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class MajorTypeDAO extends BaseDAO {

	public static final int ARTS = 0;
	public static final int ENGINEERING = 1;
	public static final int SOCIAL = 2;

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("MajorTypeDAO.query sql:" + sql);
		LinkedList<MajorTypeBean> majorTypeBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				MajorTypeBean majorTypeBean = new MajorTypeBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "id":
						majorTypeBean.setId(rs.getInt(i + 1));
						break;
					case "name":
						majorTypeBean.setName(rs.getString(i + 1));
						break;
					case "country":
						majorTypeBean.setCountry(rs.getString(i + 1));
						break;
					case "overall":
						majorTypeBean.setOverall(rs.getFloat(i + 1));
						break;
					case "teaching":
						majorTypeBean.setTeaching(rs.getFloat(i + 1));
						break;
					case "research":
						majorTypeBean.setResearch(rs.getFloat(i + 1));
						break;
					case "citations":
						majorTypeBean.setCitations(rs.getFloat(i + 1));
						break;
					case "industry":
						majorTypeBean.setIndustry(rs.getFloat(i + 1));
						break;
					case "outlook":
						majorTypeBean.setOutlook(rs.getFloat(i + 1));
						break;
					default:
						break;
					}
				}
				majorTypeBeans.add(majorTypeBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return majorTypeBeans;
		} catch(SQLException e) {
			System.out.println("Error UserDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

}
