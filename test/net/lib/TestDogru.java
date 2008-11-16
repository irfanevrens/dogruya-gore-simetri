package net.lib;

import junit.framework.TestCase;

public class TestDogru extends TestCase {

	public void testSetA() {
		
		Dogru dogru = new Dogru();
		Nokta nokta = new Nokta(100, 120);
		
		dogru.setA(nokta);
		
		assertEquals(new Nokta(100, 120), dogru.getA());
	}
	
	public void testSetB() {
		
		Dogru dogru = new Dogru();
		Nokta nokta = new Nokta(60, 20);
		
		dogru.setB(nokta);
		
		assertEquals(new Nokta(60, 20), dogru.getB());
	}	
}
