package controller.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	protected String driver;
	protected String url;
	protected String user;
	protected String password;
	
	public BaseDAO() {
		// TODO Auto-generated constructor stub
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/study_abroad?useSSL=false&allowPublicKeyRetrieval=true";
		this.user = "root";
		this.password = "Jellal20143647";
	}
	
	public Connection openDBConnection() {
		Connection c = null;
		try{
			Class.forName(this.driver);
			c = DriverManager.getConnection(this.url, this.user, this.password);
			System.out.println("Success open DB!");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean closeDBConnection(Connection c) {
		if(c == null) {
			return false;
		}
		else {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return true;
		}
	}
	

	public abstract Object query(String sql);
	public abstract boolean insert(String sql);
	public abstract boolean update(String sql);
	public abstract boolean delete(String sql);
	
}
