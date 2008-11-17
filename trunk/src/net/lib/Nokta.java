package net.lib;

import java.awt.Point;

import net.util.Matematik;

public class Nokta extends Point {

	private static final long serialVersionUID = -1075474207171993445L;

	public Nokta() {
		
		setLocation(0.0, 0.0);
	}
	
	public Nokta(int x, int y) {
	
		setLocation((double) x, (double) y);
	}

	public Nokta(Nokta nokta) {
		
		setLocation(nokta.getX(), nokta.getY());
	}
	
	public Nokta(Point point) {
		
		setLocation(point.getX(), point.getY());
	}

	public Nokta(double x, double y) {
		
		setLocation(x, y);
	}

	public Nokta getAsKoordinat(Point p) {

		return new Nokta(x - p.x, p.y - y);
	}
	
	public Nokta getAsOrjinal(Point p) {

		return new Nokta(p.x + x, p.y - y);
	}
	
	/**
	 * n1 noktasýndan n2'ye taþýnan bir noktanýn ayný yöndeki 
	 * hareketini yapmasý için kullanýlan bir metoddur.
	 * 
	 * @param n1 birinci nokta
	 * @param n2 ikinci nokta
	 */
	public void konumDegistir(Nokta n1, Nokta n2) {
		
		setLocation(
				getX() - (n1.getX() - n2.getX()), 
				getY() - (n1.getY() - n2.getY()));
	}
	
	/**
	 * noktayý aci derece saat yönünün tersinde orjini referans 
	 * alarak dönderir
	 * 
	 * @param aci dönme derecesi
	 */
	public void cevir(double aci) {
		
		setLocation(
				getX() * Matematik.getCos(aci) - getY() * Matematik.getSin(aci), 
				getX() * Matematik.getSin(aci) + getY() * Matematik.getCos(aci));
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}

	public void setXYFromNokta(Nokta nokta) {
		
		setLocation(nokta.getX(), nokta.getY());
	}

	public void xEksenineGoreSimetriAl() {

		setLocation(getX(), -getY());
	}
}
