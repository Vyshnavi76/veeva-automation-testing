package day21testn;

import org.testng.annotations.Test;

/*
 * 1.open app
 * 2.login
 * 3.logut
 */

public class Firsttestcase
{ 
	@Test(priority=1)
	void openapp()
	{
		System.out.println("opening application");
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("logging the  application");
	}
	@Test(priority=3)
	void logout()
	{
		System.out.println("log out from application");
	}
	

}
