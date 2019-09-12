package com.cg.obs.dto;
import java.time.LocalDate;


public class ServiceTracker {
	private int service_id;
	private String service_description;
	private long account_id;
	private LocalDate service_raised_date;
	private String service_status;
	@Override
	public String toString() {
		return "ServiceTracker [service_id=" + service_id + ", service_description=" + service_description
				+ ", account_id=" + account_id + ", service_raised_date=" + service_raised_date + ", service_status="
				+ service_status + "]";
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getService_description() {
		return service_description;
	}
	public void setService_description(String service_description) {
		this.service_description = service_description;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public LocalDate getService_raised_date() {
		return service_raised_date;
	}
	public void setService_raised_date(LocalDate service_raised_date) {
		this.service_raised_date = service_raised_date;
	}
	public String getService_status() {
		return service_status;
	}
	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	public ServiceTracker(int service_id, String service_description, int account_id, LocalDate service_raised_date,
			String service_status) {
		super();
		this.service_id = service_id;
		this.service_description = service_description;
		this.account_id = account_id;
		this.service_raised_date = service_raised_date;
		this.service_status = service_status;
	}
	
}
