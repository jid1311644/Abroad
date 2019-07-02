package model.db.major_type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MajorTypeBean {

	private Integer id;
	private String name;
	private String country;
	private Float overall;
	private Float teaching;
	private Float research;
	private Float citations;
	private Float industry;
	private Float outlook;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Float getOverall() {
		return overall;
	}
	public void setOverall(Float overall) {
		this.overall = overall;
	}
	public Float getTeaching() {
		return teaching;
	}
	public void setTeaching(Float teaching) {
		this.teaching = teaching;
	}
	public Float getResearch() {
		return research;
	}
	public void setResearch(Float research) {
		this.research = research;
	}
	public Float getCitations() {
		return citations;
	}
	public void setCitations(Float citations) {
		this.citations = citations;
	}
	public Float getIndustry() {
		return industry;
	}
	public void setIndustry(Float industry) {
		this.industry = industry;
	}
	public Float getOutlook() {
		return outlook;
	}
	public void setOutlook(Float outlook) {
		this.outlook = outlook;
	}
	
	public HashMap<Integer, MajorTypeBean> getArts() {
		HashMap<Integer, MajorTypeBean> arts = new HashMap<Integer, MajorTypeBean>();
		String sql = "select * from arts";
		LinkedList<MajorTypeBean> beans = (LinkedList<MajorTypeBean>) new MajorTypeDAO().query(sql);
		
		MajorTypeBean mtb;
		Iterator<MajorTypeBean> i = beans.iterator();
		while(i.hasNext()) {
			mtb = i.next();
			arts.put(mtb.getId(), mtb);
		}
		return arts;
	}
	
	public HashMap<Integer, MajorTypeBean> getEngineering() {
		HashMap<Integer, MajorTypeBean> es = new HashMap<Integer, MajorTypeBean>();
		String sql = "select * from engineering";
		LinkedList<MajorTypeBean> beans = (LinkedList<MajorTypeBean>) new MajorTypeDAO().query(sql);

		MajorTypeBean mtb;
		Iterator<MajorTypeBean> i = beans.iterator();
		while(i.hasNext()) {
			mtb = i.next();
			es.put(mtb.getId(), mtb);
		}
		return es;
	}
	
	public HashMap<Integer, MajorTypeBean> getSocial() {
		HashMap<Integer, MajorTypeBean> socials = new HashMap<Integer, MajorTypeBean>();
		String sql = "select * from social";
		LinkedList<MajorTypeBean> beans = (LinkedList<MajorTypeBean>) new MajorTypeDAO().query(sql);

		MajorTypeBean mtb;
		Iterator<MajorTypeBean> i = beans.iterator();
		while(i.hasNext()) {
			mtb = i.next();
			socials.put(mtb.getId(), mtb);
		}
		return socials;
	}
	
}
