package day23Dependency;

import org.testng.annotations.Test;

public class LoginTests {
	//comes under sanity tests
	@Test(priority=1,groups= {"sanity"})
	void loginByEmail()
	{
		System.out.println("This is login by email");
	}
	@Test(priority=2,groups= {"sanity"})

	void loginface()
	{
		System.out.println("This is login by facebook");
	}
	@Test(priority=3,groups= {"sanity"})

	void loginbyTwitter()
	{
		System.out.println("This is login by twitter");
	}

}
