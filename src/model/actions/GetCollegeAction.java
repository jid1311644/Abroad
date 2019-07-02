package model.actions;

import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.db.college.CollegeBean;
import model.db.major.MajorBean;

public class GetCollegeAction extends ActionSupport {
	
	public String execute() throws Exception {
		
		return executeGetOverview();
	}
	
	//学校卡片:name, address, institution_type, acceptance_rate, price
	public String executeGetCard(/* input */) {
		String collegeId = "0020050001";
		HashMap<String, String> res = new CollegeBean().getCard(collegeId);
		if(res == null) {
			return ERROR;
		}
		//
		System.out.println(res.toString());
		return SUCCESS;
	}
	
	//overview:name, address, score(用户评分), info, 
	//tuition_in_state, tuition_out_of_state, average_price, 
	//institution_type, campus_setting, level_of_institution, acceptance_rate
	public String executeGetOverview(/* input */) {
		String collegeId = "0020050001";
		HashMap<String, String> res = new CollegeBean().getOverview(collegeId);
		if(res == null) {
			return ERROR;
		}
		//
		System.out.println(new Gson().toJson(res).toString());
		return SUCCESS;
	}
	
	//tuition:tuition_in_state, tuition_out_of_state, 
	//tuition_room_and_board, tuition_books_and_supplies
	public String executeGetTuition(/* input */) {
		String collegeId = "0020050001";
		HashMap<String, String> res = new CollegeBean().getTuition(collegeId);
		if(res == null) {
			return ERROR;
		}
		//
		System.out.println(res.toString());
		return SUCCESS;
	}
	
	//majors and degree
	public String executeGetMajors(/* input */) {
		String collegeId = "0020050001";
		HashMap<String, String> res = new CollegeBean().getMajors(collegeId);
		if(res == null) {
			return ERROR;
		}
		//
		System.out.println(res.toString());
		return SUCCESS;
	}

}
