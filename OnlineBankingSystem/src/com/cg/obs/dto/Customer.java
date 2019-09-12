package com.cg.obs.dto;

public class Customer {
	private long account_id;
	private String customer_name;
	private String email;
	private String address;
	private String pancard;
	private long mobile_num;
	
	@Override
	public String toString() {
		return "Customer [account_id=" + account_id + ", customer_name="
				+ customer_name + ", email=" + email + ", address=" + address
				+ ", pancard=" + pancard + ", mobile_num=" + mobile_num + "]";
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public Customer(long account_id, String customer_name, String email, String address, String pancard, long mobile_num) {
		super();
		this.account_id = account_id;
		this.customer_name = customer_name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile_num=mobile_num;
	}
	public long getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(long mobile_num) {
		this.mobile_num = mobile_num;
	}
}
