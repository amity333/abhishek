package com.cg.obs.dto;
public class UserTable {
	private long account_id;
	private int user_id;
	private String login_password;
	private String secret_question;
	private String transaction_password;
	private char lock_status;
	public UserTable(long account_id, int user_id, String login_password, String secret_question,
			String transaction_password, char lock_status) {
		super();
		this.account_id = account_id;
		this.user_id = user_id;
		this.login_password = login_password;
		this.secret_question = secret_question;
		this.transaction_password = transaction_password;
		this.lock_status = lock_status;
	}
	@Override
	public String toString() {
		return "UserTable [account_id=" + account_id + ", user_id=" + user_id + ", login_password=" + login_password
				+ ", secret_question=" + secret_question + ", transaction_password=" + transaction_password
				+ ", lock_status=" + lock_status + "]";
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getSecret_question() {
		return secret_question;
	}
	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}
	public String getTransaction_password() {
		return transaction_password;
	}
	public void setTransaction_password(String transaction_password) {
		this.transaction_password = transaction_password;
	}
	public char getLock_status() {
		return lock_status;
	}
	public void setLock_status(char lock_status) {
		this.lock_status = lock_status;
	}
}
