package com.org.jjdmn.bank.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


public class LoginVo {
	
	@NotNull
	private String username;
	
	@NotNull
	@Length(min=32)
	private String password;

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginVo{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
