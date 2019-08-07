package com.newsoft.spring.vo;

public class Authority_listVO {

	private String AUTHORITY;
	private String DESCRIPTION;

	public Authority_listVO() {
	}

	public Authority_listVO(String aUTHORITY, String dESCRIPTION) {
		AUTHORITY = aUTHORITY;
		DESCRIPTION = dESCRIPTION;
	}

	public String getAUTHORITY() {
		return AUTHORITY;
	}

	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

}
