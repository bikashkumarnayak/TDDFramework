package com.Email;

import java.util.Base64;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;




import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.propertyfile.PropetyFile;
import com.readUtilities.ReportPath;

/**
 * Email class is responsible for setting up the mail server. Its also responsible for sending the generated Test Report via email.
 * 
 * April 07, 2021
 * @author User1
 * @version 1.0
 * 
 *
 */
/*public final class Email {
	static String encodedPassword;
	static String receiversEmailID;
	static String emailId;
	static String report;
	static String reportName;

	static {
		try {
			encodedPassword = PropetyFile.get(ConfigProperty.EMAILPASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			receiversEmailID = PropetyFile.get(ConfigProperty.RECEIVERSEMAILID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			emailId = PropetyFile.get(ConfigProperty.EMAILID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			report = ReportPath.getReportPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reportName = report.split("/")[report.split("/").length - 1];


	}

	/**
	 * Private constructor to avoid external instantiation
	 */
	/*private Email() {
	}

	public static void sendMail() throws Exception {
		try {
			if (PropetyFile.get(ConfigProperty.SENDMAILAFTEREXECUTION)
					.equalsIgnoreCase(Config.getYes())) {

				Properties props = System.getProperties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.ssl.checkserveridentity", true);

				if (PropetyFile.get(ConfigProperty.SENDMAILUSING).equalsIgnoreCase("Gmail")) {
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "465");
				} else if (PropetyFile.get(ConfigProperty.SENDMAILUSING).equalsIgnoreCase("Outlook")) {
					props.put("mail.smtp.host", "smtp.live.com");
					props.put("mail.smtp.port", "587");
				}

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						try {
							String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword.getBytes()));
							return new PasswordAuthentication(emailId, decodedPassword);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
				});
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(emailId));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiversEmailID));
				message.setSubject("Test Execution Report - " + reportName);

				BodyPart body = new MimeBodyPart();
				body.setText("Hi,\nPlease find attached QA test report for "
						+ PropetyFile.get(ConfigProperty.ENVIRONMENT) + ".\nThanks & regards\n"
						+ PropetyFile.get(ConfigProperty.TESTERNAME));
				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(report);
				mimeBodyPart.setDataHandler(new DataHandler(source));
				mimeBodyPart.setFileName(reportName);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(body);
				multipart.addBodyPart(mimeBodyPart);
				message.setContent(multipart);
				Transport.send(message);
				System.out.println("\n\n");
				System.out.println("----------------------------");
				System.out.println("|                          |");
				System.out.println("| Report sent successfully |");
				System.out.println("|                          |");
				System.out.println("----------------------------");
				System.out.println("\n\n");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}*/