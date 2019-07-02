package model.db.user_exam;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserExamBean {

	private String email;	//email 用户邮箱地址
	private String examId;	//exam_id 考试类型编号
	private Float score;	//score 用户考试成绩
	
	public ArrayList<String[]> get(String email) {
		String sql = "select * from `study_abroad`.`user_exam` where "
				+ "email = '" + email + "'";
		LinkedList<UserExamBean> uxbs = (LinkedList<UserExamBean>) new UserExamDAO().query(sql);
		if(uxbs == null) {
			return null;
		}
		ArrayList<String[]> res = new ArrayList<String[]>();
		while(!uxbs.isEmpty()) {
			res.add(new String[] {uxbs.peekFirst().getExamId(), uxbs.pollFirst().getScore() + ""});
		}
		return res;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	
}
