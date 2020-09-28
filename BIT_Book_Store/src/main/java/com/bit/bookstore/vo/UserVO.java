package com.bit.bookstore.vo;

import java.util.Date;

public class UserVO {
	private String id;
	private String pwd;
	private String user_name;
	private String nickname;
	private String phone_number1;
	private int sms_receive;
	private String phone_number2;
	private int birthday_year;
	private int birthday_month;
	private int birthday_day;
	private int zip_code;
	private String street_addr;
	private String remaining_addr;
	private String email;
	private int email_receive;
	private int point;
	private int rate_idx;
	private int purchase_cnt;
	private int purchase_6month;
	private Date signup_date;
	private int absence;
	private int coupon_cnt;
	
	public UserVO() {
		super();
	}

	

	public UserVO(String id, String pwd, String user_name, String nickname, String phone_number1, int sms_receive,
			String phone_number2, int birthday_year, int birthday_month, int birthday_day, int zip_code,
			String street_addr, String remaining_addr, String email, int email_receive, int point, int rate_idx,
			int purchase_cnt, int purchase_6month, Date signup_date, int absence, int coupon_cnt) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.user_name = user_name;
		this.nickname = nickname;
		this.phone_number1 = phone_number1;
		this.sms_receive = sms_receive;
		this.phone_number2 = phone_number2;
		this.birthday_year = birthday_year;
		this.birthday_month = birthday_month;
		this.birthday_day = birthday_day;
		this.zip_code = zip_code;
		this.street_addr = street_addr;
		this.remaining_addr = remaining_addr;
		this.email = email;
		this.email_receive = email_receive;
		this.point = point;
		this.rate_idx = rate_idx;
		this.purchase_cnt = purchase_cnt;
		this.purchase_6month = purchase_6month;
		this.signup_date = signup_date;
		this.absence = absence;
		this.coupon_cnt = coupon_cnt;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone_number1() {
		return phone_number1;
	}

	public void setPhone_number1(String phone_number1) {
		this.phone_number1 = phone_number1;
	}

	public int getSms_receive() {
		return sms_receive;
	}

	public void setSms_receive(int sms_receive) {
		this.sms_receive = sms_receive;
	}

	public String getPhone_number2() {
		return phone_number2;
	}

	public void setPhone_number2(String phone_number2) {
		this.phone_number2 = phone_number2;
	}

	public int getBirthday_year() {
		return birthday_year;
	}

	public void setBirthday_year(int birthday_year) {
		this.birthday_year = birthday_year;
	}

	public int getBirthday_month() {
		return birthday_month;
	}

	public void setBirthday_month(int birthday_month) {
		this.birthday_month = birthday_month;
	}

	public int getBirthday_day() {
		return birthday_day;
	}

	public void setBirthday_day(int birthday_day) {
		this.birthday_day = birthday_day;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getStreet_addr() {
		return street_addr;
	}

	public void setStreet_addr(String street_addr) {
		this.street_addr = street_addr;
	}

	public String getRemaining_addr() {
		return remaining_addr;
	}

	public void setRemaining_addr(String remaining_addr) {
		this.remaining_addr = remaining_addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmail_receive() {
		return email_receive;
	}

	public void setEmail_receive(int email_receive) {
		this.email_receive = email_receive;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRate_idx() {
		return rate_idx;
	}

	public void setRate_idx(int rate_idx) {
		this.rate_idx = rate_idx;
	}

	public int getPurchase_cnt() {
		return purchase_cnt;
	}

	public void setPurchase_cnt(int purchase_cnt) {
		this.purchase_cnt = purchase_cnt;
	}

	public int getPurchase_6month() {
		return purchase_6month;
	}

	public void setPurchase_6month(int purchase_6month) {
		this.purchase_6month = purchase_6month;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}



	public int getCoupon_cnt() {
		return coupon_cnt;
	}



	public void setCoupon_cnt(int coupon_cnt) {
		this.coupon_cnt = coupon_cnt;
	}



	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", user_name=" + user_name + ", nickname=" + nickname
				+ ", phone_number1=" + phone_number1 + ", sms_receive=" + sms_receive + ", phone_number2="
				+ phone_number2 + ", birthday_year=" + birthday_year + ", birthday_month=" + birthday_month
				+ ", birthday_day=" + birthday_day + ", zip_code=" + zip_code + ", street_addr=" + street_addr
				+ ", remaining_addr=" + remaining_addr + ", email=" + email + ", email_receive=" + email_receive
				+ ", point=" + point + ", rate_idx=" + rate_idx + ", purchase_cnt=" + purchase_cnt
				+ ", purchase_6month=" + purchase_6month + ", signup_date=" + signup_date + ", absence=" + absence
				+ ", coupon_cnt=" + coupon_cnt + "]";
	}



	

	
	
	
	
}
