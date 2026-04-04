package day22testannotation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoft {
	
	
	//@Test
	void test_hard()
	{
		System.out.println("Testingnnn...");
		System.out.println("Testingnnn...");

		Assert.assertEquals(1,2);
		
		System.out.println("Test...");
		System.out.println("Test...");


	}
	@Test
	void test_soft()
	{
		System.out.println("Testingnnn...");
		System.out.println("Testingnnn...");

		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1,2);
		
		System.out.println("Test...");
		System.out.println("Test...");
		
		sa.assertAll(); //mandatory step in soft assertion
	}

}
