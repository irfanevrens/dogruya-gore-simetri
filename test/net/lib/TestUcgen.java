package net.lib;

import junit.framework.TestCase;

public class TestUcgen extends TestCase {

	public void testSetA() {
		
		Ucgen ucgen = new Ucgen();
		Nokta nokta = new Nokta(100, 120);
		
		ucgen.setA(nokta);
		
		assertEquals(new Nokta(100, 120), ucgen.getA());
	}
	
	public void testSetB() {
		
		Ucgen ucgen = new Ucgen();
		Nokta nokta = new Nokta(60, 20);
		
		ucgen.setB(nokta);
		
		assertEquals(new Nokta(60, 20), ucgen.getB());
	}
	
	public void testSetC() {
		
		Ucgen ucgen = new Ucgen();
		Nokta nokta = new Nokta(40, 20);
		
		ucgen.setC(nokta);
		
		assertEquals(new Nokta(40, 20), ucgen.getC());
	}
}
