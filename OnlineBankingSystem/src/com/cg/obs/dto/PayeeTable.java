package com.cg.obs.dto;
public class PayeeTable {
	private long account_id;
	private long payee_account_id;
	private String nick_name;
	@Override
	public String toString() {
		return "PayeeTable [account_id=" + account_id + ", payee_account_id=" + payee_account_id + ", nick_name="
				+ nick_name + "]";
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public long getPayee_account_id() {
		return payee_account_id;
	}
	public void setPayee_account_id(long payee_account_id) {
		this.payee_account_id = payee_account_id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public PayeeTable(long account_id, long payee_account_id, String nick_name) {
		super();
		this.account_id = account_id;
		this.payee_account_id = payee_account_id;
		this.nick_name = nick_name;
	}
}
