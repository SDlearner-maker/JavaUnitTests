package com.personalgroup.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicTests {

	@Test
	public void compare() {
		Basics basicTests = new Basics();
		int value = basicTests.compare(0, 1);
		Assertions.assertEquals(-1, value);

	}
	
	@Test
	@DisplayName("First number is equal to the second")
	public void compare3() {
	    Basics basicTests = new Basics();
	    int value = basicTests.compare(2, 2);
	    Assertions.assertEquals(0, value);
	}
}
