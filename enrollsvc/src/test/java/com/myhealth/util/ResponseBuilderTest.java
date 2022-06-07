package com.myhealth.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myhealth.bean.IResponse;

import junit.framework.TestCase;

public class ResponseBuilderTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testBuildResponseString() {
		Animal animal = new Animal();
		animal.setGender("M");
		animal.setNumberOfLimbs("4");
		animal.setTwoLegged(true);
		String expected = "{ \"gender\":\"M\",\"numberOfLimbs\":\"4\",\"isTwoLegged\":\"true\" }";		
		ResponseBuilder<Animal> respB = new ResponseBuilder<Animal>();
		assertEquals(expected, respB.buildResponseString(animal));
	}
}
