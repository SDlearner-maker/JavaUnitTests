package com.personalgroup.junit;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingTests {

	@Mock
	User user;
	
	@Test
	@DisplayName("Permission assigned successfully")
	public void assignPermissions() {
	    Mocking mocking = new Mocking();
	    mocking.setUser(user);
	    when(user.getRole()).thenReturn("admin"); //should return something

	    Assertions.assertEquals(1, mocking.assignPermission());
	}
	
	@Test
	@DisplayName("Permission denied")
	public void denyPermissions() {
	    Mocking mocking = new Mocking();
	    mocking.setUser(user);
	    when(user.getRole()).thenReturn("random admin"); //should return something

	    Assertions.assertEquals(-1, mocking.assignPermission());
	}
	
	
}
