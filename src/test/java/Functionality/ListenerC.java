package Functionality;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerC implements ITestListener {

	public void OnStart(ITestContext Result) {	
		System.out.println("On Start");
	}
	public void OnFinish(ITestContext Result) {
		System.out.println("OnFinish");
	}
	public void OnTestSuccess(ITestResult Result) {
		System.out.println("OnTestSuccess");
	}
	public void OnTestFailure(ITestResult Result) {
		System.out.println("OnTestFailure");
	}
	public void OnTestStart(ITestResult Result) {
		System.out.println("OnTestStart");
	}
}
