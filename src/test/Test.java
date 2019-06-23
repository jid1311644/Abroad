package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

import controller.db.dao.BaseDAO;
import model.actions.GetCollegeAction;
import model.actions.LoginAction;
import model.actions.SearchCollegeAction;
import model.db.college.CollegeBean;
import model.db.college.CollegeDAO;
import model.db.college_exam.CollegeExamDAO;
import model.db.major.MajorBean;
import model.db.major.MajorDAO;
import random.Random;

public class Test {
	
	static TreeMap<String, Integer> id = new TreeMap<String, Integer>();
	public static void addMap(String collegeId) {
		if(id.get(collegeId) == null) {
			id.put(collegeId, 1);
		}
		else {
			int v = id.get(collegeId);
			id.replace(collegeId, v + 1);
		}
	}
	
	public static void addCollege() {
		String read = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("/Users/jellal/Desktop/temp")));
			StringBuilder sb = new StringBuilder(read);
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			read = sb.toString();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
		CollegeDAO cd = new CollegeDAO();
		CollegeExamDAO ced = new CollegeExamDAO();
		
		
		LinkedList<CollegeBean> cbs = (LinkedList<CollegeBean>) cd.query("select college_id from college");
		CollegeBean cb;
		while(!cbs.isEmpty()) {
			cb = cbs.poll();
			addMap(cb.getCollegeId());
		}
		
		System.out.println(id.toString());
		
		read = read.split("\\*\\*\\*\\*\\*")[1];
		String[] cs = read.split("&&&&&");
		for(int i = 0; i < cs.length; i++) {
			String[] c = cs[i].split(" \\| ");
			sql = "INSERT INTO `study_abroad`.`college` ("
					+ "`college_id`, `name`, `info`, `address`, `address_detail`, "
					+ "`campus_setting`, `level_of_institution`, `institution_type`, "
					+ "`student_body_size`, `requirement_of_language`, `tuition_in_state`, "
					+ "`tuition_out_of_state`, `tuition_room_and_board`, "
					+ "`tuition_books_and_supplies`, `acceptance_rate`, `score`) VALUES ("
					+ "'" + c[0] + "', "
					+ "'" + c[1] + "', "
					+ "'" + c[2] + "', "
					+ "'" + c[3] + "', "
					+ "'" + c[4] + "', "
					+ "'" + c[5] + "', "
					+ "'" + c[6] + "', "
					+ "'" + c[7] + "', "
					+ "'" + c[8] + "', "
					+ "'" + c[9] + "', "
					+ "'" + c[10] + "', "
					+ "'" + c[11] + "', "
					+ "'" + c[12] + "', "
					+ "'" + c[13] + "', "
					+ "'" + c[14] + "', "
					+ "'" + c[15] + "');";
//			cd.insert(sql);
			System.out.println(sql);
			addMap(c[0]);
			
			if(!c[16].equals("null")) {
				String[] es = c[16].split("&");
				int k;
				for(int j = 0; j < es.length; j++) {
					
					k = es[j].indexOf(",");
					sql = "INSERT INTO `study_abroad`.`college_exam` ("
							+ "`college_id`, `exam_id`, `pass_score`) VALUES ("
							+ "'" + c[0] + "', "
							+ "'" + es[j].substring(1, k) + "', "
							+ "'" + es[j].substring(k + 1, es[j].length() - 1) + "');";
//					ced.insert(sql);
					System.out.println(sql);
				}
			}
		}
		System.out.println(id.toString());
	}

	public static void addMajor() {
		char[] degree = new char[] {'A', 'B', 'C', 'D'};
		
		ArrayList<String> cs = new ArrayList<String>();
		CollegeDAO cd = new CollegeDAO();
		LinkedList<CollegeBean> cbs = (LinkedList<CollegeBean>) cd.query("select college_id from college");
		CollegeBean cb;
		while(!cbs.isEmpty()) {
			cb = cbs.poll();
			cs.add(cb.getCollegeId());
		}
		
		ArrayList<String> ms = new ArrayList<String>();
		MajorDAO md = new MajorDAO();
		LinkedList<MajorBean> mbs = (LinkedList<MajorBean>) md.query("select major_id from major");
		MajorBean mb;
		while(!mbs.isEmpty()) {
			mb = mbs.poll();
			ms.add(mb.getMajorId());
		}
		
		String sql;
		for(int i = 0; i < cs.size(); i++) {
			for(int j = 0; j < ms.size(); j++) {
				sql = "INSERT INTO `study_abroad`.`college_major` (`college_id`, `major_id`, `degree`) VALUES ("
						+ "'" + cs.get(i) + "', "
						+ "'" + ms.get(j) + "', "
						+ "'" + degree[Random.random(0, 3, 1)[0]] + "')";
				md.insert(sql);
			}
		}
		
	}
	
	public static void main(String[] args) {
//		LoginAction l = new LoginAction();
		
//		SearchCollegeAction sca = new SearchCollegeAction();
//		System.out.println(sca.executeSearchByKey());
//		System.out.println(sca.executeSearchByConditions());
		
//		GetCollegeAction gca = new GetCollegeAction();
//		System.out.println(gca.executeGetCard());
//		System.out.println(gca.executeGetOverview());
//		System.out.println(gca.executeGetTuition());
//		System.out.println(gca.executeGetMajors());
		
		
		addMajor();

		
	}
	
}






