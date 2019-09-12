package com.cg.obs.dto;
import java.time.LocalDate;

public class AccountMaster {
	private long account_id;
	private String account_type;
	private int account_balance;
	private LocalDate date;
	
	
	public AccountMaster(int account_id, String account_type, int account_balance, LocalDate date) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.account_balance = account_balance;
		this.date = date;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AccountMaster [account_id=" + account_id + ", account_type=" + account_type + ", account_balance="
				+ account_balance + ", date=" + date + "]";
	}
	
	
}
