package day22testannotation;
/*
 * 1) Login        -- @BeforeMethod
2) Search       -- @Test
3) Logout       -- @AfterMethod

4) Login        -- @BeforeMethod
5) Advanced search -- @Test
6) Logout       -- @AfterMethod

 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotationdemo1 {
	@BeforeMethod
	void login()
	{
		System.out.println("This is login.. ");
	}
	
	
	@Test(priority=3)
	void search()
	{
		System.out.println("This is search..");
	}
	
	@Test(priority=33)
	void advancedsearch()
	{
		System.out.println("This is adv search..");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("This is logout..");
	}
	
	
	
	
	

}
