package day22testannotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

/*
 * 1) Login        -- @BeforeClass
2) Search       -- @Test
3) Advanced search -- @Test
4) Logout       -- @AfterClass

 */
public class Annotaiondemo2 
{

	@BeforeClass
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
	
	@AfterClass
	void logout()
	{
		System.out.println("This is logout..");
	}
	
	
}
