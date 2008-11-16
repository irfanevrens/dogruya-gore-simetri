package net.lib;

import java.awt.Point;

import junit.framework.TestCase;

public class TestNokta extends TestCase {

	public void testNokta1() {
		
		Nokta nokta = new Nokta();
		
		nokta.x = 5;
		
		assertEquals(5, nokta.x);
	}
	
	public void testNokta2() {
		
		Nokta nokta = new Nokta(100, 150);
		
		assertEquals(nokta.x, 100);
		assertEquals(nokta.y, 150);
		
		assertEquals(nokta.getAsKoordinat(new Point(110, 170)), new Point(-10, 20));
	}
	
	public void testNokta3() {
		
		Nokta nokta = new Nokta(new Nokta(100, 150));
		
		assertEquals(nokta.x, 100);
		assertEquals(nokta.y, 150);
		
		assertEquals(nokta.getAsKoordinat(new Point(110, 170)), new Point(-10, 20));
	}
	
	public void testGetAsOrjinal() {
		
		Nokta nokta = new Nokta(-50, 30);
		
		Nokta orjin = new Nokta(100, 90);
		
		assertEquals(new Nokta(50, 60), nokta.getAsOrjinal(orjin));
	}
}
