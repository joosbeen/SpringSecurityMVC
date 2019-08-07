package com.newsoft.spring.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class UsuarioVO {

	private int USER_ID;
	private String USERNAME;
	private String PASSWORD;
	private boolean ENABLED;
	private String NOMBRE;
	private String APELLIDOS;
	private Date FECHA_NACIMIENTO;
	private String SEXO;
	private Timestamp FECHA_ALTA;
	private Timestamp FECHA_MODIFICACION;
	private String HUSO_HORARIO;
	private String CORREO_ELECTRONICO_PPAL;
	private boolean TRACKING;

	public UsuarioVO() {
	}

	public UsuarioVO(int uSER_ID, String uSERNAME, String pASSWORD, boolean eNABLED, String nOMBRE, String aPELLIDOS,
			Date fECHA_NACIMIENTO, String sEXO, Timestamp fECHA_ALTA, Timestamp fECHA_MODIFICACION, String hUSO_HORARIO,
			String cORREO_ELECTRONICO_PPAL, boolean tRACKING) {
		super();
		USER_ID = uSER_ID;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		ENABLED = eNABLED;
		NOMBRE = nOMBRE;
		APELLIDOS = aPELLIDOS;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		SEXO = sEXO;
		FECHA_ALTA = fECHA_ALTA;
		FECHA_MODIFICACION = fECHA_MODIFICACION;
		HUSO_HORARIO = hUSO_HORARIO;
		CORREO_ELECTRONICO_PPAL = cORREO_ELECTRONICO_PPAL;
		TRACKING = tRACKING;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public boolean isENABLED() {
		return ENABLED;
	}

	public void setENABLED(boolean eNABLED) {
		ENABLED = eNABLED;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getAPELLIDOS() {
		return APELLIDOS;
	}

	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
	}

	public Date getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}

	public void setFECHA_NACIMIENTO(Date fECHA_NACIMIENTO) {
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
	}

	public String getSEXO() {
		return SEXO;
	}

	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}

	public Timestamp getFECHA_ALTA() {
		return FECHA_ALTA;
	}

	public void setFECHA_ALTA(Timestamp fECHA_ALTA) {
		FECHA_ALTA = fECHA_ALTA;
	}

	public Timestamp getFECHA_MODIFICACION() {
		return FECHA_MODIFICACION;
	}

	public void setFECHA_MODIFICACION(Timestamp fECHA_MODIFICACION) {
		FECHA_MODIFICACION = fECHA_MODIFICACION;
	}

	public String getHUSO_HORARIO() {
		return HUSO_HORARIO;
	}

	public void setHUSO_HORARIO(String hUSO_HORARIO) {
		HUSO_HORARIO = hUSO_HORARIO;
	}

	public String getCORREO_ELECTRONICO_PPAL() {
		return CORREO_ELECTRONICO_PPAL;
	}

	public void setCORREO_ELECTRONICO_PPAL(String cORREO_ELECTRONICO_PPAL) {
		CORREO_ELECTRONICO_PPAL = cORREO_ELECTRONICO_PPAL;
	}

	public boolean isTRACKING() {
		return TRACKING;
	}

	public void setTRACKING(boolean tRACKING) {
		TRACKING = tRACKING;
	}

	@Override
	public String toString() {
		return "UsuarioVO [USER_ID=" + USER_ID + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", ENABLED="
				+ ENABLED + ", NOMBRE=" + NOMBRE + ", APELLIDOS=" + APELLIDOS + ", FECHA_NACIMIENTO=" + FECHA_NACIMIENTO
				+ ", SEXO=" + SEXO + ", FECHA_ALTA=" + FECHA_ALTA + ", FECHA_MODIFICACION=" + FECHA_MODIFICACION
				+ ", HUSO_HORARIO=" + HUSO_HORARIO + ", CORREO_ELECTRONICO_PPAL=" + CORREO_ELECTRONICO_PPAL
				+ ", TRACKING=" + TRACKING + "]";
	}

}
