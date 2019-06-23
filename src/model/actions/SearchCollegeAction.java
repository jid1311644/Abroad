package model.actions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.db.college.CollegeBean;

public class SearchCollegeAction extends ActionSupport {
	
	public String execute() throws Exception {
		switch (ActionContext.getContext().getName()) {
		case "search":
			return executeSearchByConditions();
		default:
			break;
		}
		return ERROR;
	}
	
	//根据关键字搜索学校
	public String executeSearchByKey(/* input */) {
		String keyword = "坦";
		LinkedList<CollegeBean> collegeBeans = new CollegeBean().search(keyword);
		//
		if(collegeBeans == null) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	//根据条件搜索学校
	public String executeSearchByConditions(/* input */) {
		HashMap<String, String> conditions = new HashMap<String, String>();
		conditions.put("address", "美国,加利福尼亚州");
		conditions.put("major", "计算机科学");
		conditions.put("scores", "雅思,92.5");
		conditions.put("student_body_size", "0,20000");
		conditions.put("price", "60000");
		conditions.put("campus_setting", "城镇");
		conditions.put("level_of_institution", "4年");
		conditions.put("institution_type", "私立");
		
		LinkedList<CollegeBean> collegeBeans = new CollegeBean().search(conditions);
		
		if(collegeBeans == null || collegeBeans.isEmpty()) {
			return ERROR;
		}
		return SUCCESS;
	}

}
