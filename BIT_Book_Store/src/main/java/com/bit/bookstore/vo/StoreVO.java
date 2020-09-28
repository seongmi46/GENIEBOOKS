package com.bit.bookstore.vo;

public class StoreVO {
	private String store_code;
	private String store_pwd;
	private int zip_code;
	private String street_addr;
	private String remaining_addr;
	private String email;
	private String store_phone_number;
	private String store_name;
	
	public StoreVO() {
		super();
	}

	public String getStore_code() {
		return store_code;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getStore_pwd() {
		return store_pwd;
	}

	public void setStore_pwd(String store_pwd) {
		this.store_pwd = store_pwd;
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

	public String getStore_phone_number() {
		return store_phone_number;
	}

	public void setStore_phone_number(String store_phone_number) {
		this.store_phone_number = store_phone_number;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	@Override
	public String toString() {
		return "StoreVO [store_code=" + store_code + ", store_pwd=" + store_pwd + ", zip_code=" + zip_code
				+ ", street_addr=" + street_addr + ", remaining_addr=" + remaining_addr + ", email=" + email
				+ ", store_phone_number=" + store_phone_number + ", store_name=" + store_name + "]";
	}
	
	
	
}
