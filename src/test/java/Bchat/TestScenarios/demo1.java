package Bchat.TestScenarios;

import org.testng.annotations.Test;

import Utiles.baseClass;

public class demo1 extends baseClass{

	
	
	@Test(priority = 2)
	public void method3() {
		System.out.println("test case 3");
	}

	@Test(priority = 3)
	public void method4() {
		System.out.println("test case 4");
	}

}
