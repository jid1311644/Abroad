package model.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import controller.state.State;
import model.db.user.UserBean;

public class LoginAction extends ActionSupport {
	
	private String email;
	private String password;
	private String rePassword;

	public String execute() throws Exception {
		
		switch (ActionContext.getContext().getName()) {
		case "login":
			return executeSignIn(getEmail(), getPassword());
		case "regist":
			return executeSignUp(getEmail(), getPassword(), getRePassword());
		default:
			break;
		}
		return ERROR;
	}

	private String executeSignIn(String email, String password) {
		System.out.print("action:login	");
		if(new UserBean().signIn(email, password)) {
			State.setLogged(true);
			State.setCurrentUser(email);
			System.out.println(SUCCESS);
			return SUCCESS;
		}
		System.out.println(ERROR);
		return ERROR;
	}
	
	private String executeSignUp(String email, String password, String rePassword) {
		System.out.print("action:regist	");
		if(!password.equals(rePassword)) {
			System.out.println(ERROR);
			return ERROR;
		}
		else {
			if(new UserBean().signUp(email, password)) {
				State.setLogged(true);
				State.setCurrentUser(email);
				System.out.println(SUCCESS);
				return SUCCESS;
			}
		}
		System.out.println(ERROR);
		return ERROR;
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

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}


	
}
