package net.lib;

import java.awt.Dimension;

import junit.framework.TestCase;

public class TestKoordinat extends TestCase {

	public void testComponentResized() {
		
		Koordinat koordinat = new Koordinat();
		
		Dimension size = new Dimension(200, 70);
		
		koordinat.ebatlarDegisti(size);
		
		assertEquals(200 - koordinat.getXY1().x, koordinat.getXY2().x);
		assertEquals(70 - koordinat.getXY1().y, koordinat.getXY2().y);
		
		assertEquals((200 - 2 * koordinat.getXY1().x) / 2 + koordinat.getXY1().x, koordinat.getOrjin().x);
		assertEquals((70 - 2 * koordinat.getXY1().y) / 2 + koordinat.getXY1().y, koordinat.getOrjin().y);
	}
	
	public void testGetSolAndUstAndSagAndAlt() {
		
		Koordinat koordinat = new Koordinat();
		
		koordinat.getXY1().setLocation(100, 120);
		koordinat.getXY2().setLocation(90, 60);
		
		assertEquals(100, koordinat.getSol());
		assertEquals(120, koordinat.getUst());
		
		assertEquals(90, koordinat.getSag());
		assertEquals(60, koordinat.getAlt());
	}
	
	public void testGetGenislikAndYukseklik() {
		
		Koordinat koordinat = new Koordinat();
		
		koordinat.getXY1().setLocation(10, 20);
		koordinat.getXY2().setLocation(90, 120);
		
		assertEquals(80, koordinat.getGenislik());
		assertEquals(100, koordinat.getYukseklik());
	}
	
	public void testGetOrjinXAndOrjinY() {
		
		Koordinat koordinat = new Koordinat();
		
		koordinat.getXY1().setLocation(10, 20);
		koordinat.getXY2().setLocation(90, 120);
		
		koordinat.ebatlarDegisti();
		
		assertEquals(50, koordinat.getOrjinX());
		assertEquals(70, koordinat.getOrjinY());
	}
	
	public void testGetGridAdimSayisi() {
		
		Koordinat koordinat = new Koordinat();
		
		koordinat.getXY1().setLocation(20, 80);
		koordinat.getXY2().setLocation(70, 120);
		
		koordinat.ebatlarDegisti();
		
		assertEquals(3, koordinat.getYatayAdimSayisi());
		assertEquals(2, koordinat.getDikeyAdimSayisi());
	}
	
	public void testSetAci() {
		
		Koordinat koordinat = new Koordinat();
		
		koordinat.setAci(new Nokta(0, 0), new Nokta(50, -50));
		
		assertEquals(45.0, koordinat.getAci());
	}
}
