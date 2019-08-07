package com.newsoft.spring.vo;

public class AuthoritiesVO {

	private String USERNAME;
	private String AUTHORITY;

	public AuthoritiesVO() {
		super();
	}

	public AuthoritiesVO(String uSERNAME, String aUTHORITY) {
		super();
		USERNAME = uSERNAME;
		AUTHORITY = aUTHORITY;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getAUTHORITY() {
		return AUTHORITY;
	}

	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}

	@Override
	public String toString() {
		return "AuthoritiesVO [USERNAME=" + USERNAME + ", AUTHORITY=" + AUTHORITY + "]";
	}

}
