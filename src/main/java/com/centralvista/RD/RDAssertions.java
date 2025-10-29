package com.centralvista.RD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RDAssertions {

@Test
public void testAssertions()
{
	int a = 15;
    int b = 7;
    String str1 = "Hello";
    String str2 = "World";

    // Asserting equality
    Assert.assertEquals(a + b, 12, "Sum is not as expected");
    System.out.println("First");
    // Asserting true condition
    Assert.assertTrue((a + b) > 0, "Sum is not greater than 0");
    System.out.println("Second");
    // Asserting false condition
    Assert.assertFalse(a == b, "a should not be equal to b");

    // Asserting not null
    Assert.assertNotNull(str1, "String should not be null");

    // Asserting null
    Assert.assertNull(null, "This object should be null");

    // Asserting equality of strings
    Assert.assertEquals(str1, "Hello", "Strings are not equal");

    // Asserting not equal strings
    Assert.assertNotEquals(str1, str2, "Strings should not be equal");
	
	
	
	
}





}
