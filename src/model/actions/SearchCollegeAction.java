package model.actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.db.college.CollegeBean;
import model.db.college.CollegeDAO;
import random.Random;

public class SearchCollegeAction extends ActionSupport {
	//length=option1&type=option1&price=option2&exam=option1&score=1231
	private String key;
	private String length;
	private String type;
	private String price;
	private String exam;
	private String score;
	
	private static boolean temp = true;
	private static boolean isFirst = true;
	private static HashMap<Integer, CollegeBean> res;
	private static String[] ps = new String[] {"img/harword.jpg", 
			"img/jz.jpg", "img/ms.jpg", "img/pl.jpg", "img/Stanf.jpg", "img/yl.jpg", 
			"img/school1.jpg", "img/school2.png", "img/school3.png", 
			"img/school4.png", "img/school5.png", "img/school6.png", };
	
	//img/harword.jpg img/jz.jpg img/ms.jpg img/pl.jpg img/Stanf.jpg img/yl.jpg
	
	public static void init() {
		String sql = "select * from college order by score limit 6";
		LinkedList<CollegeBean> cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
		res = new HashMap<Integer, CollegeBean>();
		CollegeBean cb;
		int count = 0;
		while(!cbs.isEmpty()) {
			cb = cbs.pollFirst();
			res.put(count++, cb);
		}
	}
	
	public static String random(int i) {
		if(temp) {
			return ps[i];
		}
		else {
			return ps[i + 6];
		}
	}

	public String execute() throws Exception {
		switch (ActionContext.getContext().getName()) {
		case "search":
			System.out.print("action:search ");
			return executeSearchByConditions();
		case "name-search":
			System.out.print("action:name-search ");
			return executeSearchByKey();
		default:
			break;
		}
		return ERROR;
	}
	
	//根据关键字搜索学校
	public String executeSearchByKey(/* input */) {
		LinkedList<CollegeBean> collegeBeans = new CollegeBean().search(getKey());
		//
		if(collegeBeans == null || collegeBeans.isEmpty()) {
			System.out.println("error");
			return ERROR;
		}
		res = new HashMap<Integer, CollegeBean>();
		CollegeBean cb;
		int count = 0;
		while(!collegeBeans.isEmpty()) {
			cb = collegeBeans.pollFirst();
			res.put(count++, cb);
		}
		System.out.println("success");
		System.out.println(res.toString());
		return SUCCESS;
	}
	
	//根据条件搜索学校
	public String executeSearchByConditions(/* input */) {
		HashMap<String, String> conditions = new HashMap<String, String>();
		
		if(getLength() != null) {
			switch (getLength()) {
			case "option1":
				conditions.put("level_of_institution", "4年");
				break;
			case "option2":
				conditions.put("level_of_institution", "3年");
				break;
			case "option3":
				conditions.put("level_of_institution", "2年");
				break;
			default:
				break;
			}
		}
		if(getType() != null) {
			switch (getType()) {
			case "option1":
				conditions.put("institution_type", "公立");
				break;
			case "option2":
				conditions.put("institution_type", "私立");
				break;
			default:
				break;
			}
		}
		if(getPrice() != null) {
			switch (getPrice()) {
			case "option1":
				conditions.put("price", "0,10000");
				break;
			case "option2":
				conditions.put("price", "10000,30000");
				break;
			case "option3":
				conditions.put("price", "30000,50000");
				break;
			case "option4":
				break;
			default:
				break;
			}
		}
		if(getExam() != null && !score.equals("")) {
			switch (getExam()) {
			case "option1":
				conditions.put("scores", "SAT," + getScore());
				break;
			case "option2":
				conditions.put("scores", "ACT," + getScore());
				break;
			default:
				break;
			}
		}
		LinkedList<CollegeBean> collegeBeans = new CollegeBean().search(conditions);
		
		if(collegeBeans == null || collegeBeans.isEmpty()) {
			System.out.println("error");
			return ERROR;
		}
		res = new HashMap<Integer, CollegeBean>();
		CollegeBean cb;
		int count = 0;
		while(!collegeBeans.isEmpty() && count < 16) {
			cb = collegeBeans.pollFirst();
			res.put(count++, cb);
		}
		System.out.println("success");
		System.out.println(res.toString());
		return SUCCESS;
	}
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public static HashMap<Integer, CollegeBean> getRes() {
		return res;
	}
	
	public static void setRes(HashMap<Integer, CollegeBean> data) {
		res = data;
	}

	public static boolean isFirst() {
		return isFirst;
	}

	public static void setFirst(boolean first) {
		isFirst = first;
	}

	public static boolean isTemp() {
		return temp;
	}

	public static void changeTemp() {
		if(temp) {
			temp = false;
		}
		else {
			temp = true;
		}
	}

}
