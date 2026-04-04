package day23Dependency;

import org.testng.annotations.Test;

public class SignUptest {
	//comes under regression
	
	@Test(priority=1,groups= {"regression"})

	void signupemail()
	{
		System.out.println("This is by email");
	}
	
	@Test(priority=2,groups= {"regression"})
    void signface()
    {
		System.out.println("This is by facebook");
    }
	
	@Test(priority=3,groups= {"regression"})
    void signuptwitter()
    {
		System.out.println("This is by twitter");
    }

}
