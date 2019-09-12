package com.cg.obs.dto;
import java.time.LocalDate;

public class FundTransfer {
	private int fundTransfer_id;
	private long account_id;
	private long payee_account_id;
	private LocalDate date_of_transfer;
	private int transfer_amount;
	@Override
	public String toString() {
		return "FundTransfer [fundTransfer_id=" + fundTransfer_id + ", account_id=" + account_id + ", payee_account_id="
				+ payee_account_id + ", date_of_transfer=" + date_of_transfer + ", transfer_amount=" + transfer_amount
				+ "]";
	}
	public int getFundTransfer_id() {
		return fundTransfer_id;
	}
	public void setFundTransfer_id(int fundTransfer_id) {
		this.fundTransfer_id = fundTransfer_id;
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
	public LocalDate getDate_of_transfer() {
		return date_of_transfer;
	}
	public void setDate_of_transfer(LocalDate date_of_transfer) {
		this.date_of_transfer = date_of_transfer;
	}
	public int getTransfer_amount() {
		return transfer_amount;
	}
	public void setTransfer_amount(int transfer_amount) {
		this.transfer_amount = transfer_amount;
	}
	public FundTransfer(int fundTransfer_id, int account_id, int payee_account_id, LocalDate date_of_transfer,
			int transfer_amount) {
		super();
		this.fundTransfer_id = fundTransfer_id;
		this.account_id = account_id;
		this.payee_account_id = payee_account_id;
		this.date_of_transfer = date_of_transfer;
		this.transfer_amount = transfer_amount;
	}
}
