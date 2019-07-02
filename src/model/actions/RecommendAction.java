package model.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import controller.state.State;
import model.db.college.CollegeBean;
import model.db.college.CollegeDAO;
import model.db.college_exam.CollegeExamBean;
import model.db.college_exam.CollegeExamDAO;
import model.db.college_major.CollegeMajorBean;
import model.db.college_major.CollegeMajorDAO;
import model.db.major.MajorBean;
import model.db.major.MajorDAO;
import model.db.user_college.UserCollegeBean;
import model.db.user_exam.UserExamBean;
import model.db.user_major.UserMajorBean;
import random.Random;

class Standard {
	
	public double regionWeight(String[] likeLocate, String locate) {
		for(int i = 0; i < likeLocate.length; i++) {
			if(likeLocate[i].equals(locate)) {
				return 1;
			}
		}
		return 0.3;
	}
	
	public double majorWeight(String[] likeMajor, String[] collegeMajor) {
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < likeMajor.length; i++) {
			set.add(likeMajor[i]);
		}
		int count = 0;
		for(int i = 0; i < collegeMajor.length; i++) {
			if(set.contains(collegeMajor[i])) {
				count++;
			}
		}
		return count / (collegeMajor.length * 1.0);
	}
	
	public double scoreWeight(float score, float collegeScore) {
		double n = 0.9 + Math.abs(20 + score - collegeScore) / (80 * 1.0);
		return 1 / n * Math.sqrt(n);
	}
	
	public double tuitionWeight(int netPrice, int expect) {
		double div;
		if(netPrice > expect) {
			div = Math.pow(netPrice - expect, 1.1);
		}
		else {
			div = Math.pow(expect - netPrice, 0.65);
		}
		return 1 / (0.9 + div / 1000);
	}
	
	public double employWeight(float graduate, float outlook) {
		double b1 = 1 - Math.pow(1 - graduate, 1.4);
		double b2 = 0.3 + Math.pow(outlook / 100, 0.5);
		return b2 / Math.max(0.95, b1);
	}
	
	public double rotateAndRondam(boolean isHomePage) {
		double x = new Random().random(0, 5000, 1)[0] / 100000.0;
		double r = 1 + 0.5 * Math.pow(x, 0.5) + 0.17 * Math.pow(x, 0.33);
		return isHomePage? (0.95 * r) : r;
	}
	
}

public class RecommendAction {
	
	
	
	private HashMap<Integer, String> res;
	
	public void recommend(){
		StringBuilder sql;
		LinkedList<CollegeBean> cbs;
		ArrayList<String> res = new ArrayList<String>();
		
		if(State.getCurrentUser() == null) {
			System.out.println("user is null");
			sql = new StringBuilder("select name from college order by score limit 6");
			cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql.toString());
			if(cbs != null) {
				while(!cbs.isEmpty()) {
					res.add(cbs.pop().getName());
				}
			}
		}
		else {
			ArrayList<String> colleges = new UserCollegeBean().get(State.getCurrentUser());
			String currentUserLikeCollegeLocation = frequencyCollegeLocation(colleges);
			
			ArrayList<String> majors = new UserMajorBean().get(State.getCurrentUser());
			String currentUserLikeMajorType = frequencyMajorType(majors);
			
			ArrayList<String[]> exams = new UserExamBean().get(State.getCurrentUser());
			
			
			if(exams != null && !exams.isEmpty()) {
				System.out.println("exam is not null");
				sql = new StringBuilder("select college_id from college_exam where ");
				String[] ss;
				for(int i = 0; i < exams.size(); i++) {
					ss = exams.get(i);
					sql.append("(exam_id = '" + ss[0] + "' and pass_score <= '" + ss[1] + "') or ");
				}
				sql.deleteCharAt(sql.length() - 1);
				sql.deleteCharAt(sql.length() - 1);
				sql.deleteCharAt(sql.length() - 1);
				sql.append(" order by pass_score limit 6");
				LinkedList<CollegeExamBean> cebs = (LinkedList<CollegeExamBean>) new CollegeExamDAO().query(sql.toString());
				if(cebs != null) {
					
					while(!cebs.isEmpty()) {
						sql = new StringBuilder("select name from college where college_id = '" + cebs.pop().getCollegeId() + "' ");
						cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql.toString());
						if(cbs != null && cbs.size() == 1) {
							res.add(cbs.pop().getName());
						}
					}
				}
			}
			else if(currentUserLikeCollegeLocation != null || currentUserLikeMajorType != null) {
				if(currentUserLikeCollegeLocation != null) {
					System.out.println("like college is not null");
					sql = new StringBuilder("select name from college where address like "
							+ "'" + currentUserLikeCollegeLocation + "%' order by score limit 6");
					cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql.toString());
					if(cbs != null) {
						while(!cbs.isEmpty()) {
							res.add(cbs.pop().getName());
						}
					}
				}
				else {
					System.out.println("like major is not null");
					sql = new StringBuilder("select college_id from college_major where major_id = 'M018' order by degree limit 6");
					LinkedList<CollegeMajorBean> cmbs = (LinkedList<CollegeMajorBean>) new CollegeMajorDAO().query(sql.toString());
					CollegeMajorBean cmb;
					while(!cmbs.isEmpty()) {
						cmb = cmbs.poll();
						sql = new StringBuilder("select name from college where college_id = "
								+ "'" + cmb.getCollegeId() + ";");
						cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql.toString());
						res.add(cbs.pop().getName());
					}
				}
			}
			else {
				System.out.println("user is not null");
				sql = new StringBuilder("select name from college order by score limit 6");
				cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql.toString());
				if(cbs != null) {
					while(!cbs.isEmpty()) {
						res.add(cbs.pop().getName());
					}
				}
			}
		}
		
		setRes(res);
		System.out.println(getRes().toString());
	}
	
	private String frequencyCollegeLocation(ArrayList<String> colleges) {
		String location = null;
		int freq = 0;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql;
		LinkedList<CollegeBean> cbs;
		String lo;
		int f;
		for(int i = 0; i < colleges.size(); i++) {
			sql = "select address from college where college_id = '" + colleges.get(i) + "'";
			cbs = (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
			if(cbs != null && cbs.size() == 1) {
				lo = cbs.poll().getAddress().substring(0, 3);
				if(map.containsKey(lo)) {
					f = map.get(lo);
					f++;
					map.replace(lo, f);
				}
				else {
					f = 1;
					map.put(lo, f);
				}
				if(f > freq) {
					freq = f;
					location = lo;
				}
			}
		}
		return location;
	}

	private String frequencyMajorType(ArrayList<String> majors) {
		String type = null;
		int freq = 0;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql;
		LinkedList<MajorBean> mbs;
		String t;
		int f;
		for(int i = 0; i < majors.size(); i++) {
			sql = "select type from major where major_id = '" + majors.get(i) + "'";
			mbs = (LinkedList<MajorBean>) new MajorDAO().query(sql);
			if(mbs != null && mbs.size() == 1) {
				t = mbs.poll().getType();
				if(map.containsKey(t)) {
					f = map.get(t);
					f++;
					map.replace(t, f);
				}
				else {
					f = 1;
					map.put(t, f);
				}
				if(f > freq) {
					freq = f;
					type = t;
				}
			}
		}
		return type;
	}
	
	public HashMap<Integer, String> getRes() {
		return res;
	}

	public void setRes(ArrayList<String> res) {
		if(res == null || res.isEmpty()) {
			this.res = null;
		}
		else {
			this.res = new HashMap<Integer, String>();
			for(int i = 0; i < res.size(); i++) {
				this.res.put(i, res.get(i));
			}
		}
	}

	public static void main(String[] args) {
		RecommendAction a = new RecommendAction();
		State.setCurrentUser("978062452@qq.com");
		a.recommend();
	}

}
