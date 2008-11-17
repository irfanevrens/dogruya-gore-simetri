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
	
	public void testCevir() {
		
		Dogru dogru = new Dogru();
		
		dogru.setA(new Nokta(0, -10));
		dogru.setB(new Nokta(0, -60));
		
		dogru.cevir(90);
		
		assertEquals(new Nokta(10, 0), dogru.getA());
		assertEquals(new Nokta(60, 0), dogru.getB());
		
		dogru.cevir(90);
		
		assertEquals(new Nokta(0, 10), dogru.getA());
		assertEquals(new Nokta(0 ,60), dogru.getB());
	}
	
	public void testKonumDegistir() {

		Dogru dogru = new Dogru();
		
		dogru.setA(new Nokta(30, 50));
		dogru.setB(new Nokta(20, 40));
		
		dogru.konumDegistir(new Nokta(-20, -30), new Nokta(-10, 10));
		
		assertEquals(new Nokta(40, 90), dogru.getA());
		assertEquals(new Nokta(30, 80), dogru.getB());
	}
}
