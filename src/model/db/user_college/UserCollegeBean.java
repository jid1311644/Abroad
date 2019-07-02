package model.db.user_college;

import java.util.ArrayList;
import java.util.LinkedList;

import controller.state.State;
import model.db.user_major.UserMajorDAO;

public class UserCollegeBean {
	
	private String email;		//email 用户邮箱地址
	private String collegeId;	//college_id 院校编号
	
	public boolean save(String collegeId) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `study_abroad`.`user_college` (`email`, `college_id`) VALUES ("
				+ "'" + State.getCurrentUser() + "', "
				+ "'" + collegeId + "')";
		return new UserCollegeDAO().insert(sql);
	}
	
	public ArrayList<String> get(String email) {
		String sql = "select college_id from `study_abroad`.`user_college` where "
				+ "email = '" + email + "'";
		LinkedList<UserCollegeBean> ucbs = (LinkedList<UserCollegeBean>) new UserCollegeDAO().query(sql);
		if(ucbs == null) {
			return null;
		}
		ArrayList<String> res = new ArrayList<String>();
		while(!ucbs.isEmpty()) {
			res.add(ucbs.poll().getCollegeId());
		}
		return res;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}


}
