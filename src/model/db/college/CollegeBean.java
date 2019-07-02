package model.db.college;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import model.db.address.AddressBean;
import model.db.address.AddressDAO;
import model.db.college_major.CollegeMajorBean;
import model.db.college_major.CollegeMajorDAO;
import model.db.major.MajorBean;
import model.db.major.MajorDAO;

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
	
	public HashMap<String, String> getCard(String collegeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select college_id, name, address, institution_type, acceptance_rate, "
				+ "tuition_in_state from college where college_id = '" + collegeId + "'";
		LinkedList<CollegeBean> beans = (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
		if(beans == null || beans.isEmpty()) {
			return null;
		}
		else {
			CollegeBean bean = beans.poll();
			map.put("college_id", bean.getCollegeId());
			map.put("name", bean.getName());
			map.put("institution_type", bean.getInstitutionType());
			map.put("acceptance_rate", bean.getAcceptanceRate() + "");
			map.put("price", bean.getTuitionInState() + "");
			sql = "select country, province from address where address_id = '" + bean.getAddress() + "'";
			LinkedList<AddressBean> beans2 = (LinkedList<AddressBean>) new AddressDAO().query(sql);
			if(beans2 == null || beans2.isEmpty()) {
				return null;
			}
			else {
				AddressBean bean2 = beans2.poll();
				map.put("address", bean2.getCountry() + "," + bean2.getProvince());
			}
		}
		return map;
		
	}
	
	public HashMap<String, String> getOverview(String collegeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select college_id, name, address, score, info, "
				+ "institution_type, acceptance_rate, level_of_institution, campus_setting, "
				+ "tuition_in_state, tuition_out_of_state from college where college_id = '" + collegeId + "'";
		LinkedList<CollegeBean> beans = (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
		if(beans == null || beans.isEmpty()) {
			return null;
		}
		else {
			CollegeBean bean = beans.poll();
			map.put("college_id", bean.getCollegeId());
			map.put("name", bean.getName());
			map.put("score", bean.getScore() + "");
			map.put("info", bean.getInfo());
			map.put("institution_type", bean.getInstitutionType());
			map.put("acceptance_rate", bean.getAcceptanceRate() + "");
			map.put("level_of_institution", bean.getLevelOfInstitution());
			map.put("campus_setting", bean.getCampusSetting());
			map.put("tuition_in_state", bean.getTuitionInState() + "");
			map.put("tuition_out_of_state", bean.getTuitionOutOfState() + "");
			map.put("average_price", 
					((bean.getTuitionInState() + bean.getTuitionOutOfState()) / 2) + "");
			sql = "select country, province from address where address_id = '" + bean.getAddress() + "'";
			LinkedList<AddressBean> beans2 = (LinkedList<AddressBean>) new AddressDAO().query(sql);
			if(beans2 == null || beans2.isEmpty()) {
				return null;
			}
			else {
				AddressBean bean2 = beans2.poll();
				map.put("address", bean2.getCountry() + "," + bean2.getProvince());
			}
		}
		return map;
	}
	
	public HashMap<String, String> getTuition(String collegeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select college_id, tuition_in_state, tuition_out_of_state,"
				+ " tuition_room_and_board, tuition_books_and_supplies"
				+ " from college where college_id = '" + collegeId + "'";
		LinkedList<CollegeBean> beans = (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
		if(beans == null || beans.isEmpty()) {
			return null;
		}
		else {
			CollegeBean bean = beans.poll();
			map.put("college_id", bean.getCollegeId());
			map.put("tuition_in_state", bean.getTuitionInState() + "");
			map.put("tuition_out_of_state", bean.getTuitionOutOfState() + "");
			map.put("tuition_room_and_board", bean.getTuitionRoomAndBoard() + "");
			map.put("tuition_books_and_supplies", bean.getTuitionBooksAndSupplies() + "");
		}
		return map;
	}
	
	public HashMap<String, String> getMajors(String collegeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select major_id, degree from college_major where college_id = '" + collegeId + "'";
		LinkedList<CollegeMajorBean> cmbs = (LinkedList<CollegeMajorBean>) new CollegeMajorDAO().query(sql);
		if(cmbs == null || cmbs.isEmpty()) {
			return null;
		}
		else {
			int count = 0;
			while(!cmbs.isEmpty()) {
				CollegeMajorBean cmb = cmbs.poll();
				sql = "select name, type from major where major_id = '" + cmb.getMajorId() + "'";
				LinkedList<MajorBean> mbs = (LinkedList<MajorBean>) new MajorDAO().query(sql);
				if(mbs == null || mbs.isEmpty()) {
					return null;
				}
				else {
					MajorBean mb = mbs.poll();
					map.put(cmb.getMajorId(), mb.getName() + "," + mb.getType() + "," + cmb.getDegree());
					count++;
				}
			}
			map.put("count", count + "");
		}
		return map;
	}

	
	public LinkedList<CollegeBean> search(String keyword){
		String sql = "select * from college "
				+ "where name like '%" + keyword + "%' order by score limit 6";
		return (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
	}
	
	//type
	public LinkedList<CollegeBean> search(HashMap<String, String> conditions){
		String sql = "select * from college where ";
		for(Map.Entry<String, String> e: conditions.entrySet()) {
			if(e.getKey().equals("address")) {
				String[] values = e.getValue().split(",");
				if(values.length == 2) {
					sql += "address = (select address_id from address where"
							+ " country = '" + values[0] + "' and province = '" + values[1] + "')"
							+ " \nand ";
				}
				else {
					sql += "address = (select address_id from address where"
							+ " country = '" + values[0] + "')"
							+ " \nand ";
				}
				sql += "address = (select address_id from address where"
						+ " country = '" + values[0] + "' and province = '" + values[1] + "')"
						+ " \nand ";
			}
			else if(e.getKey().equals("major")) {
				sql += "college_id = (select college_id from college_major where major_id = "
						+ "(select major_id from major where name = '" + e.getValue() + "'))"
						+ " \nand ";
			}
			else if(e.getKey().equals("scores")){
				String[] values = e.getValue().split(",");
				sql += "college_id in (select college_id from college_exam where exam_id = "
						+ "(select exam_id from exam where name = '" + values[0] + "') and "
						+ "pass_score <= " + values[1] + ")"
						+ " \nand ";
			}
			else if(e.getKey().equals("student_body_size")) {
				String[] values = e.getValue().split(",");
				sql += "student_body_size >= " + values[0] + " and "
						+ "student_body_size <= " + values[1]
						+ " \nand ";
			}
			else if(e.getKey().equals("price")) {
				String[] values = e.getValue().split(",");
				sql += "tuition_out_of_state >= " + values[0] + " and "
						+ "tuition_out_of_state <= " + values[1]
						+ " \nand ";
			}
			else {
				sql += e.getKey() + " = '" + e.getValue() + "'"
						+ " \nand ";
			}
		}
		sql = sql.substring(0, sql.length() - 6) + " order by score limit 6";
		return (LinkedList<CollegeBean>) new CollegeDAO().query(sql);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + getCollegeId() + "," + getName() + ")";
	}
	
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
