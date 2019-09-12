package com.cg.obs.dto;
import java.time.LocalDate;

public class Transactions {
	private int transaction_id;
	private String tran_description;
	private LocalDate dateOfTransaction;
	private String transactionType;
	private double tranAmount;
	private long account_no;
	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", tran_description=" + tran_description
				+ ", dateOfTransaction=" + dateOfTransaction + ", transactionType=" + transactionType + ", tranAmount="
				+ tranAmount + ", account_no=" + account_no + "]";
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTran_description() {
		return tran_description;
	}
	public void setTran_description(String tran_description) {
		this.tran_description = tran_description;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}
	public long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}
	public Transactions(int transaction_id, String tran_description, LocalDate dateOfTransaction,
			String transactionType, double tranAmount, long account_no) {
		super();
		this.transaction_id = transaction_id;
		this.tran_description = tran_description;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.tranAmount = tranAmount;
		this.account_no = account_no;
	}
}
