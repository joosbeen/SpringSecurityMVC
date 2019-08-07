package com.newsoft.spring.vo;

public class TypeVO {
	private String users;
	private String type;

	public TypeVO() {

	}

	public TypeVO(String users, String type) {
		super();
		this.users = users;
		this.type = type;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TypeVO [users=" + users + ", type=" + type + "]";
	}

}
