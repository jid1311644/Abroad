package model.db.user;

import java.util.LinkedList;

import controller.state.State;
import model.db.user_exam.UserExamDAO;

public class UserBean {

	private String email;		//email 邮箱地址 主键
	private String password;	//password 登录密码
	private Boolean gender;		//gender 性别
	private String address;		//address 地址
	private String college;		//college 当前或毕业院校
	private Float gpa;			//gpa 大学期间绩点
	private String education;	//education 目前学历
	
	
	public boolean signIn(String email, String password) {
		String sql = "select password from user where email='" + email + "'";
		LinkedList<UserBean> userBeans = (LinkedList<UserBean>) new UserDAO().query(sql);
		if(userBeans.size() == 1) {
			password = new Encrypt(email, password).encrypt();
			if(userBeans.poll().getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean signUp(String email, String password) {
		password = new Encrypt(email, password).encrypt();
		String sql = "insert into user (`email`,`password`) values('" + email + "','" + password + "')";
		return new UserDAO().insert(sql);
	}

	public boolean modify(String education, String schoolName, String address, 
			String gpa, String testType, String score) {
		String sql = "update user set ";
		if(education != null && !education.equals("")) {
			sql += "education = '" + education + "' , ";
		}
		if(schoolName != null && !schoolName.equals("")) {
			sql += "college = '" + schoolName + "' , ";
		}
		if(address != null && !address.equals("")) {
			sql += "address = '" + address + "' , ";
		}
		if(gpa != null && !gpa.equals("")) {
			sql += "gpa = " + gpa + " , ";
		}

		boolean f1 = true;
		if(sql.endsWith(" , ")) {
			sql = sql.substring(0, sql.length() - 2) + "where email = '" + State.getCurrentUser() + "'";
			f1 = new UserDAO().update(sql);
		}
		
		String sql0 = "";
		if(testType != null && !testType.equals("") && score != null && !score.equals("")) {
			sql0 = "insert into user_exam values('" + State.getCurrentUser() + "' , '" + testType + "' , '" + score + "')";
		}
		boolean f2 = true;
		if(!sql0.equals("")) {
			f2 = new UserExamDAO().insert(sql0);
		}
		
		return f1 && f2;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Float getGpa() {
		return gpa;
	}
	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
}

class Encrypt {

	private String plainText = "";	//明文
	private String cipherText = "";	//密文
	private String name = "";		//密钥
	private LinkedList<String> table = new LinkedList<String>();

	public Encrypt(String name, String psw) {
		this.name = name;
		this.plainText = psw;
		for(int i = (int) 'A'; i <= (int) 'Z'; i++) {
			table.add((char) i + "");
			table.add((char) (i + 32) + "");
		}
		for(int i = 0; i < 10; i++) {
			table.add(i + "");
		}
		table.add("_");
	}
	
	public boolean isUserName() {
		name = name.substring(0, name.indexOf("@"));
		for(int i = 0; i < name.length(); i++) {
			if(table.indexOf(name.charAt(i) + "") == -1) {
				return false;
			}
		}
		return true;
	}
	
	public String encrypt() {
		if(!isUserName()) {
			return null;
		}
		int pl = plainText.length();
		int nl = name.length();
		if(pl % nl != 0){
			for(int i = 0; i < nl - (pl % nl); i++)
				plainText += "_";
		}
		pl = plainText.length();
		int n = pl / nl;
		plainText += " ";
		name += " ";
		String[] t = new String[pl];
		int count = 0;
		int i, j;
		for(i = 0; i < n; i++){
			for(j = 0; j < nl; j++)
				t[count++] = new String(plainText.substring(
						i * nl + j, i * nl + (j + 1)) + name.substring(j, j + 1));
		}
		LinkedList<Integer> A = new LinkedList<>();
		for(i = 0; i < nl; i++)
			A.add(table.indexOf(name.substring(i, i + 1)));
		LinkedList<Integer> B = new LinkedList<Integer>();
		for(i = 0; i < nl; i++)
			B.add(A.get(i));
		sort(A);
		for(j = 0; j < nl; j++){
			A.add(B.indexOf(A.get(j)));
			B.set(B.indexOf(A.get(j)), -1);
		}
		for(j = 0; j < nl; j++)
			A.poll();
		for(i = 0; i < n; i++){
			for(j = 0; j < nl; j++){
				cipherText += t[i * nl + A.get(j)].substring(0, 1);
			}
		}
		return cipherText;
	}
	
	public void sort(LinkedList<Integer> a) {
		int n = a.size();
		for(int j = 0; j < n - 1; j++) {
			for(int i = 0; i < n - 1 - j; i++){
				if(a.get(i) > a.get(i+1)) {
					int t = a.get(i);
					a.set(i, a.get(i + 1));
					a.set(i + 1, t);
				}
			}
		}
	}
}


