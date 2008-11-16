package net.lib;

import java.awt.Point;

import junit.framework.TestCase;

public class TestOrjin extends TestCase {

	public void testOrjin1() {
		
		Orjin o = new Orjin(100, 150);
		
		assertEquals(o.x, 100);
		assertEquals(o.y, 150);
		
		assertEquals(o.convertFromOrjinalToKoordinat(new Point(110, 170)), new Point(10, -20));
		assertEquals(o.convertFromKoordinatToOrjinal(new Point(-20, -10)), new Point(80, 160));
	}
	
	public void testOrjin2() {
		
		Orjin o = new Orjin(new Orjin(100, 150));
		
		assertEquals(o.x, 100);
		assertEquals(o.y, 150);
		
		assertEquals(o.convertFromOrjinalToKoordinat(new Point(110, 170)), new Point(10, -20));
		assertEquals(o.convertFromKoordinatToOrjinal(new Point(-20, -10)), new Point(80, 160));
	}
	
	public void testToString() {
		
		Orjin orjin = new Orjin(50, 60);
		
		assertEquals("x: 50, y: 60", orjin.toString());
	}
}
