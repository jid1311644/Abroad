package model.actions;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

import model.db.major.MajorBean;

public class GetMajorsAction extends ActionSupport {
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	private String executeGetHotMajors() {
		HashMap<String, String> res = new MajorBean().getHotMajors();
		if(res == null) {
			return ERROR;
		}
		else {
			return SUCCESS;
		}
	}
	
	private String executeGetAllMajors() {
		HashMap<String, String> res = new MajorBean().getAllMajors();
		if(res == null) {
			return ERROR;
		}
		else {
			return SUCCESS;
		}
	}
	
	private String executeGetMajorDetail(String majorId) {
		HashMap<String, String> res = new MajorBean().getMajorDetail(majorId);
		if(res == null) {
			return ERROR;
		}
		else {
			return SUCCESS;
		}
	}

}
