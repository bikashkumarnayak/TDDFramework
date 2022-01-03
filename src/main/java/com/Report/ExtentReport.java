package com.Report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.Enum.CatagaryType;
import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.readUtilities.ReportPath;

import propertyfile.PropetyFile;


public final class ExtentReport {

	private ExtentReport() {

	}
	private static ExtentReports extentReports;
	public static ExtentTest test;
	public static void initReports() throws Exception {
		if (Objects.isNull(extentReports)) {
			/*extentReports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(Config.getReportFolder());
			extentReports.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle(Config.getReportTitle());
			spark.config().setReportName(Config.getReportName());
			spark.config().setEncoding(Config.getUtf8Encoding());
			spark.config().setTimeStampFormat(Config.getDatetimeFormat2());*/

			extentReports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(Config.getextentreportpath()).viewConfigurer()
					.viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
							ViewName.DEVICE, ViewName.AUTHOR })
					.apply();
			extentReports.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle(Config.getReportTitle());
			spark.config().setReportName(Config.getReportName());
			spark.config().setEncoding(Config.getUtf8Encoding());
			spark.config().setTimeStampFormat(Config.getDatetimeFormat2());
			// Setting up information
			try {
				extentReports.setSystemInfo("Name", PropetyFile.get(ConfigProperty.TESTERNAME));
				extentReports.setSystemInfo("Environment", PropetyFile.get(ConfigProperty.ENVIRONMENT));
				extentReports.setSystemInfo("URL", PropetyFile.get(ConfigProperty.URL));
				extentReports.setSystemInfo("OS Platform", Config.getOsPlatform());
				extentReports.setSystemInfo("OS Version", Config.getOsVersion());
				extentReports.setSystemInfo("OS Architecture", Config.getOsArch());
				extentReports.setSystemInfo("Report Path", ReportPath.getReportPath());
				extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
				if (PropetyFile.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase(Config.getYes())) {
					JsonFormatter json = new JsonFormatter(Config.getJsonreport());
					extentReports.createDomainFromJsonArchive(Config.getJsonreport());
					extentReports.attachReporter(json, spark);
				} else
					extentReports.attachReporter(spark);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	public static void flushReport() throws Exception {
		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(Config.getextentreportpath()).toURI());
	}

	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extentReports.createTest(testcasename));
	}
	public static void addAuthors(String[] authors) {
		for (String temp : authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}

	}
	public static void addCategory(CatagaryType[] category) {
		for (CatagaryType temp : category) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
			
		}

	}

}
