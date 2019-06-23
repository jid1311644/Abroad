package model.actions;

import com.opensymphony.xwork2.ActionSupport;

import model.db.user_college.UserCollegeBean;

public class SaveAction extends ActionSupport {

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	private boolean executeSaveCollege(String collegeId) {
		return new UserCollegeBean().save(collegeId);
	}
	
}
