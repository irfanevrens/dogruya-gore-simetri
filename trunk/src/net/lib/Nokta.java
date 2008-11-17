package net.lib;

import java.awt.Point;

import net.util.Matematik;

public class Nokta extends Point {

	private static final long serialVersionUID = -1075474207171993445L;

	public Nokta() {
		
		super();
	}
	
	public Nokta(int x, int y) {
	
		super(x, y);
	}

	public Nokta(Nokta nokta) {
		
		super(nokta.x, nokta.y);
	}
	
	public Nokta(Point point) {
		
		super(point);
	}

	public Nokta(double x, double y) {
		
		this.x = (int) x;
		this.y = (int) y;
	}
	
	

	public Nokta getAsKoordinat(Point p) {

		return new Nokta(x - p.x, p.y - y);
	}
	
	public Nokta getAsOrjinal(Point p) {

		return new Nokta(p.x + x, p.y - y);
	}
	
	public void konumDegistir(Nokta n1, Nokta n2) {
		
		setLocation(
				getX() - (n1.getX() - n2.getX()), 
				getY() - (n1.getY() - n2.getY()));
	}
	
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
}
