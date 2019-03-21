package model.db.major;

public class MajorBean {
	
	private String majorId;	//major_id 专业编号
	private String name;	//name 专业名称
	private String info;	//info 专业简介
	private String type;	//type 专业所属类型
	private Integer hot;	//hot 专业热度
	
	
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}

}
