package model.db.address;

import java.util.LinkedList;

public class AddressBean {

	private String addressId;	//address_id 地址编号
	private String country;		//country 国家
	private String province;	//province 省（州、区）
	
	public String getAddress(String addressId) {
		LinkedList<AddressBean> abs = (LinkedList<AddressBean>) new AddressDAO().query(
				"select * from address where address_id = '" + addressId + "'");
		if(abs == null || abs.size() != 1) {
			return null;
		}
		return abs.peek().getCountry() + " , " + abs.pop().getProvince() + " , ";
	}
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
