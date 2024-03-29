package com.readUtilities;



/**
 * 
 * Handles different user input validations. Class is final to avoid extend.
 * <br><br>
 * Apr 7, 2021
 * @author User1
 * @version 1.0
 *
 */

public final class UserInputCheck {
	/**
	 * 
	 * Private constructor to avoid external instantiation
	 * <br>
	 * Apr 7, 2021
	 */
	private UserInputCheck() {
	}

	/**
	 * Calls the sendMail method of Email.class for sending the generated report.
	 * <br>
	 * Apr 7, 2021
	 *
	 */
	public static void sendTestReportOnEmail() {
		try {
			//Email.sendMail();
		} catch (Exception e) {
			designerOutputForErrorInSendingReport();
		}
	}

	/**
	 * Prints error message if password is not in Base64Encode
	 * <br>
	 * Apr 7, 2021
	 *
	 */
	public static void designerOutputForPasswordError() {
		System.out.println("\n\n");
		System.out.println("-----------------------------------------");
		System.out.println("|                                       |");
		System.out.println("| Please enter password only in Base64  |");
		System.out.println("| and re-run the test                   |");
		System.out.println("|                                       |");
		System.out.println("-----------------------------------------");
		System.out.println("\n\n");
	}

	/**
	 * Prints error message if error occurred while sending report.
	 * <br>
	 * Apr 7, 2021
	 *
	 */
	public static void designerOutputForErrorInSendingReport() {
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("|                                         |");
		System.out.println("| An error occured while sending report.  |");
		System.out.println("| Please check.                        .  |");
		System.out.println("|                                         |");
		System.out.println("-------------------------------------------");
		System.out.println("\n\n");
	}
}