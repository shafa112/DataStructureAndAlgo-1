package com.demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Note this class uses junit5
@RunWith(Parameterized.class)
public class MyClassTestWithParametrizedFields {

	//@Parameter(0) Add junit 5 dependency for this class to run
    public int m1;
    //@Parameter(1)
    public int m2;
    //@Parameter(2)
    public int result;
    
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
		return Arrays.asList(data);
	}
	    
	@Test
	public void multiply() {
		 MyClass tester = new MyClass();
	     Assert.assertEquals("Result", result, tester.multiply(m1, m2));
		
	}

}
