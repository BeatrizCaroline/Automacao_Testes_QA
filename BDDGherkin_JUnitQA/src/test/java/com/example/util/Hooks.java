package com.example.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.pages.BasePage;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	private static WebDriver driver;
	private static ExtentReports extentReport;
	private static Scenario scenario;
	private static ExtentTest extentTest;

	public Hooks() {
		super();
	}

	@BeforeAll
	public static void iniciarRelatorio() {
		new File("target/report/html/img").mkdirs();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report/html/relatorio.html");
		sparkReporter.config().setEncoding("ISO-8859-1");
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("os.name", System.getProperty("os.name"));
	}

	@Before
	public void beforeCenario(Scenario scenario) {
		Hooks.scenario = scenario;
		extentTest = extentReport.createTest("Cenario: " + scenario.getName(), scenario.getName());
		extentTest.assignCategory("feature:" + scenario.getId().replaceAll(";.*", ""));
		Collection<String> tags = scenario.getSourceTagNames();
		for (String tag : tags) {
			extentTest.assignCategory(tag);
		}
		System.out.println("Cenario: " + scenario.getName());
	}

	@After
	public void afterCenario() throws IOException {
		if (scenario.isFailed()) {
			if (driver != null) {
				BasePage basePage = new BasePage();
				basePage.logPrintFail("The test is failed");

				Throwable throwable = logError(scenario);
				extentTest.fail(throwable);
			}
		}
		extentReport.flush();
		if (driver != null) {
			driver.quit();
		}
	}

	private Throwable logError(Scenario scenario) {
		Field field = FieldUtils.getField(Scenario.class, "delegate", true);
		Method getError = null;
		try {
			final TestCaseState testCase = (TestCaseState) field.get(scenario);
			if (getError == null) {
				getError = MethodUtils.getMatchingMethod(testCase.getClass(), "getError");
				getError.setAccessible(true);
			}
			return (Throwable) getError.invoke(testCase);
		} catch (Exception e) {
			System.err.println("error receiving exception" + e);
		}
		return null;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static Scenario getScenario() {
		return scenario;
	}

	public static ExtentReports getExtentReports() {
		return extentReport;
	}

	public static void navigateToURLEdge(String url) {
		String downloadFilepath = System.getProperty("user.dir") + "/target/temp";

		HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
		edgePrefs.put("download.default_directory", downloadFilepath);
		edgePrefs.put("credentials_enable_service", false);

		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", edgePrefs);
		options.addArguments("disable-infobars");
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	public static void navigateToURLedgeMobile(String url) {
		String downloadFilepath = System.getProperty("user.dir") + "/target/temp";
		HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
		edgePrefs.put("download.default_directory", downloadFilepath);
		edgePrefs.put("credentials_enable_service", false);

		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", edgePrefs);
		options.addArguments("disable-infobars");
		options.addArguments("--disable-print-preview");

		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPhone X");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
}