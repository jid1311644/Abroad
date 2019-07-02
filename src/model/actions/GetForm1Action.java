package model.actions;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

import model.db.major_type.MajorTypeBean;

public class GetForm1Action extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("action:getArts ");
		HashMap<Integer, MajorTypeBean> res = new MajorTypeBean().getArts();
		if(res.isEmpty()) {
			System.out.println("error");
			return ERROR;
		}
		else {
			System.out.println("success");
			return SUCCESS;
		}
	}

}
