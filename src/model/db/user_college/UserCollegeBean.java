package model.db.user_college;

public class UserCollegeBean {
	
	private String email;		//email 用户邮箱地址
	private String collegeId;	//college_id 院校编号
	
	public boolean save(String collegeId) {
		// TODO Auto-generated method stub
		return false;
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
