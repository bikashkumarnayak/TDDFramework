package com.readUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;

import propertyfile.PropetyFile;

public final class ReportPath {

	private static String reportFilePath = "";
	
	private ReportPath() {
	}

	public static String getReportPath() throws Exception {
		if (reportFilePath.isEmpty()) {
			reportFilePath = setReportPath();
		}
		return reportFilePath;
	}

	private static String setReportPath() throws Exception {
		if (PropetyFile.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase(Config.getNo())) {
			return Config.getReportFolder() + "/ExecutionReport_"
					+ new SimpleDateFormat(Config.getDatetimeFormat1()).format(new Date()) + ".html";
		} else if (PropetyFile.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase(Config.getYes())) {
			return Config.getReportFolder() + "/index.html";
		}
		return "";
	}

}