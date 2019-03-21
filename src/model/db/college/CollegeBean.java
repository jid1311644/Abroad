package model.db.college;

public class CollegeBean {

	private String collegeId;					//college_id 院校编号
	private String name;						//name 院校名称
	private String info;						//info 院校简介
	private String address;						//address 院校地址精确到省（州、区）
	private String addressDetail;				//address_detail 详细地址
	private String campusSetting;				//campus_setting 位置：城市、城镇、郊区、农村
	private String levelOfInstitution;			//level_of_institution 学制：2年、2～3年、3～4年、4年
	private String institutionType;				//institution_type 院校性质：公立、私立
	private Integer studentBodySize;			//student_body_size 学生规模
	private String requirementOfLanguage;		//requirement_of_language 学校要求语言
	private Integer tuitionInState;				//tuition_in_state 学费
	private Integer tuitionOutOfState;			//tuition_out_of_state 学费
	private Integer tuitionRoomAndBoard;		//tuition_room_and_board 学费
	private Integer tuitionBooksAndSupplies;	//tuition_books_and_supplies 学费
	private Integer acceptanceRate;				//acceptance_rate 通过率
	private Integer score;						//score 学校评分
	
	
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getCampusSetting() {
		return campusSetting;
	}
	public void setCampusSetting(String campusSetting) {
		this.campusSetting = campusSetting;
	}
	public String getLevelOfInstitution() {
		return levelOfInstitution;
	}
	public void setLevelOfInstitution(String levelOfInstitution) {
		this.levelOfInstitution = levelOfInstitution;
	}
	public String getInstitutionType() {
		return institutionType;
	}
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}
	public Integer getStudentBodySize() {
		return studentBodySize;
	}
	public void setStudentBodySize(Integer studentBodySize) {
		this.studentBodySize = studentBodySize;
	}
	public String getRequirementOfLanguage() {
		return requirementOfLanguage;
	}
	public void setRequirementOfLanguage(String requirementOfLanguage) {
		this.requirementOfLanguage = requirementOfLanguage;
	}
	public Integer getTuitionInState() {
		return tuitionInState;
	}
	public void setTuitionInState(Integer tuitionInState) {
		this.tuitionInState = tuitionInState;
	}
	public Integer getTuitionOutOfState() {
		return tuitionOutOfState;
	}
	public void setTuitionOutOfState(Integer tuitionOutOfState) {
		this.tuitionOutOfState = tuitionOutOfState;
	}
	public Integer getTuitionRoomAndBoard() {
		return tuitionRoomAndBoard;
	}
	public void setTuitionRoomAndBoard(Integer tuitionRoomAndBoard) {
		this.tuitionRoomAndBoard = tuitionRoomAndBoard;
	}
	public Integer getTuitionBooksAndSupplies() {
		return tuitionBooksAndSupplies;
	}
	public void setTuitionBooksAndSupplies(Integer tuitionBooksAndSupplies) {
		this.tuitionBooksAndSupplies = tuitionBooksAndSupplies;
	}
	public Integer getAcceptanceRate() {
		return acceptanceRate;
	}
	public void setAcceptanceRate(Integer acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
