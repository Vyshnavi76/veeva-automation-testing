package day22testannotation;
import org.testng.annotations.*;
public class Allannotations {
	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is beforesuite");
	}
	
	
	@AfterSuite
	void as()
	{
		System.out.println("This is aftersuite");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is Beforetest method");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is Aftertest method");
	}
	
	@BeforeClass
	void bc()
	{
		System.out.println("This is BeforeClass method");
	}
	
	@AfterClass
	void ac()
	{
		System.out.println("This is AfterClassmethod");
	}

	@BeforeMethod
	void bm()
	{
		System.out.println("This is Before method");
	}
	
	@AfterMethod
	void am()
	{
		System.out.println("This is After method");
	}
	
	@Test(priority=1)
	void tm1()
	{
		System.out.println("This is test1");
	}
	
	@Test
	void tm2()
	{
		System.out.println("This is test2");
	}
}
