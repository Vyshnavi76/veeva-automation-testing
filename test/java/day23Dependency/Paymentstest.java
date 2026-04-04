package day23Dependency;

import org.testng.annotations.Test;

public class Paymentstest {
	//both sanity and regression

	@Test(priority=1,groups= {"sanity","regression","fun"})
	void paybyrupee()
	{
		System.out.println("In rupees");
	}

	@Test(priority=2,groups= {"sanity","regression","fun"})
	void payDoller()
	{
		System.out.println("In dollar.");
	}

}
