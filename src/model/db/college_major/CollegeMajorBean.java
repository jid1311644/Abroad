package model.db.college_major;

public class CollegeMajorBean {
	
	private String collegeId;	//college_id 院校编号
	private String majorId;		//majoe_id 专业编号
	private String degree;		//degree : A、B、M、D
	
	
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

}
