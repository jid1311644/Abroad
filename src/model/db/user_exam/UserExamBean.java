package model.db.user_exam;

public class UserExamBean {

	private String email;	//email 用户邮箱地址
	private String examId;	//exam_id 考试类型编号
	private Float score;	//score 用户考试成绩
	
	
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
