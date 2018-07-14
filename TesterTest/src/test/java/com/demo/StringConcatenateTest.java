package com.demo;

import org.junit.Assert;
import org.junit.Test;



public class StringConcatenateTest {

	@Test
	public void testConcatenate() {
		StringConcatenate s1 = new StringConcatenate();
		Assert.assertEquals("abcdef", s1.concatenate("abc", "def"));
		Assert.assertEquals("abc", s1.concatenate("abc", null));
	}

}
