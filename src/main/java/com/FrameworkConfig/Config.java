package com.FrameworkConfig;

import com.Enum.ConfigProperty;

import propertyfile.PropetyFile;

public final class Config {
	
	private Config() {
		
	}
	private final static String RESOURCEPATH=System.getProperty("user.dir");
	private final static String PROJECTMAINPATH=RESOURCEPATH.concat("\\src\\main\\java");
	private final static String CHROMEDRIVERPATH=RESOURCEPATH.concat("\\Driver\\chromedriver.exe");
	private final static String CONFIGPROPERTY=PROJECTMAINPATH.concat("\\com\\data\\Global.Properties");
	private final static int EXPLECITYWAIT=10;
	private final static String EXCEL=PROJECTMAINPATH.concat("\\com\\data\\testdata1.xlsx");
	private final static String EXCEL1=PROJECTMAINPATH.concat("\\com\\data\\TestData.xlsx");
	private final static String CHROME="chrome";
	private final static String FIREFOX="firefox";
	private final static String IE="IE";
	private final static String CHROMEDRIVER="webdriver.chrome.driver";
	private final static String JSONPATH=PROJECTMAINPATH.concat("\\com\\data\\new.json");
	private final static int IMPLICITYWAIT=10;
	private final static int EXPLICITYWAIT=10;
	private final static int MAXRETRYCOUNTER=2;
	private static final String YES = "yes";
	private static final String NO = "no";
	private static final String REPORT_NAME = "Tranzack Test Report";
	private static final String REPORT_TITLE = "Test Report";
	private static final String UTF8_ENCODING = "UTF-8";
	public static final String DATETIME_FORMAT1 = "dd_MM_yyyy_hh_mm_ss";
	private static final String DATETIME_FORMAT2 = "dd/MM/yyyy HH:mm:ss";
	private static final String OS_PLATFORM = System.getProperty("os.name");
	private static final String OS_VERSION = System.getProperty("os.version");
	private static final String OS_ARCH = System.getProperty("os.arch");
	private static final String JSONREPORT="old-report-data.json";
	private static final String REPORT_FOLDER = RESOURCEPATH.concat("/reports-test-output");
	private static String extentreportpath="";
	private static final String SCREENSHOTPATH=RESOURCEPATH.concat("\\Screen");
	private static final String SCREENSHOTFORMAT="\\ScreenShot.png";
	private static final String SHEETSNAME="RUNMANAGER";
	private static final String SHEETSNAME1="DATA";
	private static final String GICODRIVER="webdriver. gecko. driver";
	private static final String GICODRIVERPATH="";
	
	



	public static String getGicodriverpath() {
		return GICODRIVERPATH;
	}
	public static String getGicodriver() {
		return GICODRIVER;
	}
	public static String getSheetsname() {
		return SHEETSNAME;
	}
	public static String getSheetsname1() {
		return SHEETSNAME1;
	}
	public static String getExcel1() {
		return EXCEL1;
	}
	public static String getScreenshotformat() {
		return SCREENSHOTFORMAT;
	}


	public static String getScreenshotpath() {
		return SCREENSHOTPATH;
	}


	public static String getextentreportpath()  {
		if(extentreportpath.isEmpty()) {
			try {
				extentreportpath=getReportFolder();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return extentreportpath;
	}


	public static String getReportFolder() throws Exception {
		
		if(PropetyFile.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase(Config.getYes())) {
			return REPORT_FOLDER+"/"+System.currentTimeMillis()+"index.html";
		}
		else {
			return REPORT_FOLDER+"/"+"index.html";
		}
		
	}

	public static String getJsonreport() {
		return JSONREPORT;
	}

	public static String getOsPlatform() {
		return OS_PLATFORM;
	}

	public static String getOsVersion() {
		return OS_VERSION;
	}

	public static String getOsArch() {
		return OS_ARCH;
	}

	public static String getReportName() {
		return REPORT_NAME;
	}

	public static String getReportTitle() {
		return REPORT_TITLE;
	}

	public static String getUtf8Encoding() {
		return UTF8_ENCODING;
	}

	public static String getDatetimeFormat1() {
		return DATETIME_FORMAT1;
	}

	public static String getDatetimeFormat2() {
		return DATETIME_FORMAT2;
	}

	public static String getYes() {
		return YES;
	}

	public static String getNo() {
		return NO;
	}

	public static int getMaxretrycounter() {
		return MAXRETRYCOUNTER;
	}

	public static int getImplicitywait() {
		return IMPLICITYWAIT;
	}
	public static int getExplicitywait() {
		return EXPLICITYWAIT;
	}

	public static String getJsonpath() {
		return JSONPATH;
	}

	public static String getChromedrive() {
		return CHROMEDRIVER;
	}

	public static String getChrome() {
		return CHROME;
	}

	public static String getFirefox() {
		return FIREFOX;
	}

	public static String getIe() {
		return IE;
	}

	public static String getExcel() {
		return EXCEL;
	}

	public static int getExplecitywait() {
		return EXPLECITYWAIT;
	}

	public static String getConfigproperty() {
		return CONFIGPROPERTY;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

}
