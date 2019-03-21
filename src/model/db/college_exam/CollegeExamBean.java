package model.db.college_exam;

public class CollegeExamBean {

	private String collegeId;	//college_id 院校编号
	private String examId;		//exam_id 考试类型编号
	private Float passScore;	//pass_score 最低分要求
	
	
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public Float getPassScore() {
		return passScore;
	}
	public void setPassScore(Float passScore) {
		this.passScore = passScore;
	}
	
}
