package com.cg.obs.dao;

public interface QueryMapper
{
	public static final String LOGIN_VALIDATION="SELECT * FROM user_table WHERE user_Id=?";
	public static final String CREATE_ACCOUNT="INSERT INTO accountmaster VALUES(account_id.nextval,?,?,sysdate)";
	public static final String GET_CURR_ACCID="SELECT account_id.currval FROM DUAL";	
	public static final String CREATE_ACCOUNT_CUSTOMER="INSERT INTO customer VALUES(?,?,?,?,?,?)";	
	public static final String CREATE_ACCOUNT_USER_TABLE="INSERT INTO user_table VALUES(?,user_id.nextval,?,?,?,?)";
	public static final String SET_LOCK_STATUS="UPDATE user_table SET lock_status=? WHERE user_id=?";
	public static final String DISPLAY_ALL_TRANSACTIONS="SELECT * FROM transactions WHERE dateoftransaction>=? and dateoftransaction<=? ORDER BY dateoftransaction DESC";
	public static final String DISPLAY_DAILY_TRANSACTIONS="SELECT * FROM transactions WHERE dateoftransaction=?";
	
	public static final String MINI_STATEMENT="SELECT * FROM transactions WHERE account_no=? ORDER BY dateoftransaction DESC fetch first 10 rows only";
	public static final String DETAILED_STATEMENT="SELECT * FROM transactions WHERE account_no=? and (dateoftransaction>=? and dateoftransaction<=?) ORDER BY dateoftransaction DESC";
	public static final String GET_DATA_FOR_UPDATE="SELECT address,mobile_num FROM transactions WHERE account_id=?";
	public static final String ADD_CHEQUE_REQUEST="INSERT INTO ServiceTracker VALUES(service_id.nextval,?,?,?,?)";
	public static final String GET_SERVICE_STATUS="SELECT service_status FROM service_tracker WHERE service_id=?";
	public static final String GET_SERVICE_STATUS_BY_ACC="SELECT service_id,service_status FROM service_tracker WHERE account_id=?";
	public static final String GET_ACCOUNTS="SELECT account_id FROM user_table FROM user_id=?";

	//Fund Transfer to self	
	public static final String ADD_TRANSFER="INSERT INTO fund_transfer VALUES(fund_transfer_id.nextval,?,?,?,?)";
	public static final String UPDATE_BALANCE="UPDATE accountmaster SET account_balance=? WHERE account_id=?";
	
	public static final String ADD_PAYEE="INSERT INTO payeetable VALUES(?,?,?)";
	public static final String GET_PAYEE="SELECT * FROM payeetable WHERE account_id=?";
	public static final String CHANGE_PWD="UPDATE user_table SET login_password=? WHERE user_id=?";
	public static final String RESET_PWD="SELECT secret_question FROM user_table WHERE user_id=?";
	public static final String GET_BALANCE = "SELECT account_balance FROM AccountMaster WHERE account_id=?";
	public static final String GET_PWD_BY_ID="SELECT login_password FROM user_table WHERE account_id=?";
	public static final String GET_PAYEE_BY_NAME="SELECT * FROM payeetable WHERE nick_name=?";
	public static final String FETCH_DATA="SELECT * FROM customer WHERE user_id=?";

	
	
}
