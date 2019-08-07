package com.newsoft.spring.reports.util;

import java.util.Calendar;

public class General {

	public static String getFechaHora() {

		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String hora = Integer.toString(c.get(Calendar.HOUR));
		String min = Integer.toString(c.get(Calendar.MINUTE));
		String sec = Integer.toString(c.get(Calendar.SECOND));

		return (annio + "-" + mes + "-" + dia + "-" + hora + "-" + min + "-" + sec);
	}

}
