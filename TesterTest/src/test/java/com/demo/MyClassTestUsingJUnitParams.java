package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/*
 
 Dependency to be added for Junit Params
 
 <dependency>
    <groupId>pl.pragmatists</groupId>
    <artifactId>JUnitParams</artifactId>
    <version>1.1.0</version>
 </dependency>

 */

@RunWith(JUnitParamsRunner.class)
public class MyClassTestUsingJUnitParams {
	
	
	@Test
	@Parameters({
		"1,2,2",
		"4,1,4",
		"-1,-2,2"
	})
	public void testMultiply(int x, int y, int expected) {
		MyClass m = new MyClass();
		Assert.assertEquals(expected, m.multiply(x, y));
	}
	
	@Test
	@Parameters(method = "parametersToMultiply")
	public void testMultiplyTwo(int x, int y, int expected) {
		MyClass m = new MyClass();
		Assert.assertEquals(expected, m.multiply(x, y));

	}
	
	@SuppressWarnings("unused")
	private Object[] parametersToMultiply() {
		 return new Object[] { 
			        new Object[] { 1, 2, 2 }, 
			        new Object[] { -10, 30, -300 }
			    };
	}
	
	/*
	 * Note with file parameters we can only pass primitive data types and Strings
	 */
	@Test
	@FileParameters("src/test/resources/test_data.csv")
	public void testMultiplyThree(int x, int y, int expected) {
		MyClass m = new MyClass();
		Assert.assertEquals(expected, m.multiply(x, y));

	}
	
	@Test
	@Parameters(source = DataProvider.class)
	public void testMultiplyFour(int x, int y, int expected) {
		MyClass m = new MyClass();
		Assert.assertEquals(expected, m.multiply(x, y));
	}

}


