package net.lib;

import junit.framework.TestCase;

public class TestUcgen extends TestCase {

	public void testUcgen() {
		
		Ucgen ucgen = new Ucgen(new Orjin(100, 120));
		Orjin orjin = new Orjin(100, 120);
		
		assertEquals(ucgen.getOrjin().toString(), orjin.toString());
	}
}
