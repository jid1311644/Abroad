package model.db.user_major;

import java.util.ArrayList;
import java.util.LinkedList;

import controller.state.State;
import model.db.user_college.UserCollegeDAO;

public class UserMajorBean {

	private String email;	//email 用户邮箱地址
	private String majorId;	//major_id 专业编号
	
	public boolean save(String majorId) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `study_abroad`.`user_major` (`email`, `major_id`) VALUES ("
				+ "'" + State.getCurrentUser() + "', "
				+ "'" + majorId + "')";
		return new UserCollegeDAO().insert(sql);
	}
	
	public ArrayList<String> get(String email) {
		String sql = "select major_id from `study_abroad`.`user_major` where "
				+ "email = '" + email + "'";
		LinkedList<UserMajorBean> umbs = (LinkedList<UserMajorBean>) new UserMajorDAO().query(sql);
		if(umbs == null) {
			return null;
		}
		ArrayList<String> res = new ArrayList<String>();
		while(!umbs.isEmpty()) {
			res.add(umbs.poll().getMajorId());
		}
		return res;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	
}
