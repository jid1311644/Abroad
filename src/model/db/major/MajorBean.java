package model.db.major;

import java.util.HashMap;
import java.util.LinkedList;

public class MajorBean {
	
	private String majorId;	//major_id 专业编号
	private String name;	//name 专业名称
	private String info;	//info 专业简介
	private String type;	//type 专业所属类型
	private Integer hot;	//hot 专业热度
	
	public HashMap<String, String> getHotMajors() {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select name, type from major order by hot desc";
		LinkedList<MajorBean> mbs = (LinkedList<MajorBean>) new MajorDAO().query(sql);
		if(mbs == null || mbs.isEmpty()) {
			return null;
		}
		else {
			int count = 0;
			while(!mbs.isEmpty() && count < 10) {
				MajorBean mb = mbs.poll();
				map.put((count++) + "", mb.getName() + " " + mb.getType());
			}
		}
		return map;
	}
	
	public HashMap<String, String> getAllMajors() {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select name from major order by name";
		LinkedList<MajorBean> mbs = (LinkedList<MajorBean>) new MajorDAO().query(sql);
		if(mbs == null || mbs.isEmpty()) {
			return null;
		}
		else {
			int count = 0;
			while(!mbs.isEmpty()) {
				MajorBean mb = mbs.poll();
				map.put((count++) + "", mb.getName());
			}
		}
		return map;
	}
	
	public HashMap<String, String> getMajorDetail(String majorId) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select * from major where major_id = '" + majorId + "'";
		LinkedList<MajorBean> mbs = (LinkedList<MajorBean>) new MajorDAO().query(sql);
		if(mbs == null || mbs.isEmpty()) {
			return null;
		}
		else {
			MajorBean mb = mbs.poll();
			map.put("name", mb.getName());
			map.put("info", mb.getInfo());
			map.put("type", mb.getType());
			map.put("hot", mb.getHot() + "");
		}
		return map;
	}
	
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
