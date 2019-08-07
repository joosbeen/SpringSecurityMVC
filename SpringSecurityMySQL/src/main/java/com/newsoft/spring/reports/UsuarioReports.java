package com.newsoft.spring.reports;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.newsoft.spring.reports.util.Templates;
import com.newsoft.spring.vo.UsuarioVO;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

public class UsuarioReports {

	private static final Logger logger = Logger.getLogger(UsuarioReports.class.getName());

	private List<UsuarioVO> users = new ArrayList<UsuarioVO>();
	private String path;
	private String titulo;

	public UsuarioReports() {
	}

	public UsuarioReports(String path, List<UsuarioVO> users, String titulo) {
		this.users = users;
		this.path = path;
		this.titulo = titulo;
	}

	public void generarPDF() {

		try {
			build().toPdf(Exporters.pdfExporter(getPath()));
		} catch (DRException e) {
			logger.error("ERROR:" + e);
		}

	}

	public void generarEXCEL() {
		try {
			build().toXlsx(Exporters.xlsxExporter(getPath()));
		} catch (DRException e) {
			logger.error("ERROR:" + e);
		}

	}

	private JasperReportBuilder build() {

		return report().title(Templates.createTitleComponent(getTitulo()), cmp.subreport(createSubreport()))
				.pageFooter(Templates.footerComponent);

	}

	private JasperReportBuilder createSubreport() {
		JasperReportBuilder report = report();
		try {
			report.setTemplate(Templates.reportTemplate)
					.title(cmp.text("subtitulo").setStyle(Templates.bold12CenteredStyle))
					.columns(col.column("USERNAME", "username", type.stringType()),
							col.column("NOMBRE", "nombre", type.stringType()),
							col.column("APELLIDOS", "apellidos", type.stringType()),
							col.column("ESTADO", "estado", type.stringType()),
							col.column("FECHA NACIMIENTO", "nacimiento", type.stringType()),
							col.column("SEXO", "sexo", type.stringType()),
							col.column("CORREO", "correo", type.stringType()))
					.setDataSource(createSubreportDataSource());
		} catch (Exception e) {
			logger.error("ERROR:" + e);
		}
		return report;
	}

	private JRDataSource createSubreportDataSource() {
		DRDataSource dataSource = new DRDataSource("username", "nombre", "apellidos", "estado", "nacimiento", "sexo",
				"correo");

		for (UsuarioVO usuarioVO : getUsers()) {

			String estado = "Inactivo";
			String sexo = "HOMBRE";

			if (usuarioVO.isENABLED()) {
				estado = "Activo";
			}
			if (usuarioVO.getSEXO().equals("M")) {
				sexo = "MUJER";
			}

			dataSource.add(usuarioVO.getUSERNAME(), usuarioVO.getNOMBRE(), usuarioVO.getAPELLIDOS(), estado,
					usuarioVO.getFECHA_NACIMIENTO().toString(), sexo, usuarioVO.getCORREO_ELECTRONICO_PPAL());
		}
		return dataSource;
	}

	private List<UsuarioVO> getUsers() {
		return users;
	}

	public void setUsers(List<UsuarioVO> users) {
		this.users = users;
	}

	private String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
