package com.listiner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;




public class AnnotationTransformer implements IAnnotationTransformer {

	
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// @Test(testName = "Login page verification", dataProvider =
		// "InvalidLoginCreds", dataProviderClass = DataProviders.class, description =
		// "Verify if login page is displayed", retryAnalyzer = RetryFailedTests.class)
		annotation.setDataProvider("InvalidLoginCreds");
		annotation.setTestName("Login page verification");
		annotation.setDescription("Verify if login page is displayed");
		// annotation.setDataProviderClass(DataProviders.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}
}
