package day22testannotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertiondemo
{
	

	@Test
	void test()
	{
		Assert.assertEquals("xya","xya");
		Assert.assertEquals(1,2);

		//all are static methods in it
	}
	
	
}
