package com.demo;

//class must have at least one static method that starts with provide
//class must be public
public class DataProvider{
	
	public static Object[] provideMulData() {
		 return new Object[] { 
			        new Object[] { 10, 2, 20 }, 
			        new Object[] { -10, 30, -300 }
			    };
	 }
}