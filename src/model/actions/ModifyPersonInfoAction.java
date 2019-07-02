package model.actions;

import com.opensymphony.xwork2.ActionSupport;

import model.db.user.UserBean;

public class ModifyPersonInfoAction extends ActionSupport {
	
	private String education;
	private String schoolName;
	private String address;
	private String gpa;
	private String testType;
	private String score;
	
	public String execute() throws Exception {
		System.out.print("action:modify	");
		if(new UserBean().modify(getEducation(), getSchoolName(), 
				getAddress(), getGpa(), getTestType().toUpperCase(), getScore())) {
			System.out.println(SUCCESS);
			return NONE;
		}
		System.out.println(ERROR);
		return ERROR;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
