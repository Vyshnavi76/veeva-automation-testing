package day22testannotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
	@Test
	void testTitle()
	{
		String ex="Opencart";
		String ac="Openshop";
		
		/*if(ex.equals(ac))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
		Assert.assertEquals(ex,ac);
	}

}
