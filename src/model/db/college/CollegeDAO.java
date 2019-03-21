package model.db.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;

public class CollegeDAO extends BaseDAO {

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("CollegeDAO.query sql:" + sql);
		LinkedList<CollegeBean> collegeBeans = new LinkedList<>();
		try {
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				CollegeBean collegeBean = new CollegeBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "college_id":
						collegeBean.setCollegeId(rs.getString(i + 1));
						break;
					case "name":
						collegeBean.setName(rs.getString(i + 1));
						break;
					case "info":
						collegeBean.setInfo(rs.getString(i + 1));
						break;
					case "address":
						collegeBean.setAddress(rs.getString(i + 1));
						break;
					case "address_detail":
						collegeBean.setAddressDetail(rs.getString(i + 1));
						break;
					case "campus_setting":
						collegeBean.setCampusSetting(rs.getString(i + 1));
						break;
					case "level_of_institution":
						collegeBean.setLevelOfInstitution(rs.getString(i + 1));
						break;
					case "institution_type":
						collegeBean.setInstitutionType(rs.getString(i + 1));
						break;
					case "student_body_size":
						collegeBean.setStudentBodySize(rs.getInt(i + 1));
						break;
					case "requirement_of_language":
						collegeBean.setRequirementOfLanguage(rs.getString(i + 1));
						break;
					case "tuition_in_state":
						collegeBean.setTuitionInState(rs.getInt(i + 1));
						break;
					case "tuition_out_of_state":
						collegeBean.setTuitionOutOfState(rs.getInt(i + 1));
						break;
					case "tuition_room_and_board":
						collegeBean.setTuitionRoomAndBoard(rs.getInt(i + 1));
						break;
					case "tuition_books_and_supplies":
						collegeBean.setTuitionBooksAndSupplies(rs.getInt(i + 1));
						break;
					case "acceptance_rate":
						collegeBean.setAcceptanceRate(rs.getInt(i + 1));
						break;
					case "score":
						collegeBean.setScore(rs.getInt(i + 1));
						break;
						
					default:
						break;
					}
				}
				collegeBeans.add(collegeBean);
			}
			rs.close();
			st.close();
			closeDBConnection(c);
			return collegeBeans;
		} catch(SQLException e) {
			System.out.println("Error CollegeDAO.query!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("CollegeDAO.insert sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error CollegeDAO.insert!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("CollegeDAO.update sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error CollegeDAO.update!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		System.out.println("CollegeDAO.delete sql:" + sql);
		boolean f = true;
		try {
			Connection c = openDBConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			closeDBConnection(c);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error CollegeDAO.delete!");
			e.printStackTrace();
			f = false;
		}
		return f;
	}

}
