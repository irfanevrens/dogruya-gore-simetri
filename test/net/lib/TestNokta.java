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
	
	public void testGetAsKoordinat() {
		
		Nokta nokta = new Nokta(100, 120);
		
		Nokta orjin = new Nokta(60, 50);
		
		assertEquals(new Nokta(40, -70), nokta.getAsKoordinat(orjin));
	}
	
	public void testKonumDegistir() {
		
		Nokta nokta = new Nokta(-70, 40);
		
		nokta.konumDegistir(new Nokta(30, 90), new Nokta(60, 40));
		
		assertEquals(new Nokta(-40, -10), nokta);
	}
	
	public void testCevir() {
		
		Nokta nokta = new Nokta(0, -70);
		
		nokta.cevir(90);
		assertEquals(new Nokta(70, 0), nokta);
		
		nokta.cevir(90);
		assertEquals(new Nokta(0, 70), nokta);
		
		nokta.cevir(90);
		assertEquals(new Nokta(-70, 0), nokta);
	}
	
	public void testXEksenineGoreSimetriAl() {
		
		Nokta nokta = new Nokta(40, 50);
		
		nokta.xEksenineGoreSimetriAl();
		
		assertEquals(new Nokta(40, -50), nokta);
	}
}
