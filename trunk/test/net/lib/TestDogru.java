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
	
	public void testDonder() {
		
		Dogru dogru = new Dogru();
		
		dogru.setA(new Nokta(0, 0));
		dogru.setB(new Nokta(0, -60));
		
		dogru.cevir(90);
		
		assertEquals(new Nokta(0, 0), dogru.getA());
		assertEquals(new Nokta(60, 0), dogru.getB());
	}
}
