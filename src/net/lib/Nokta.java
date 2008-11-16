package net.lib;

import java.awt.Point;

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

	public Nokta getAsKoordinat(Point p) {

		return new Nokta(x - p.x, p.y - y);
	}
	
	public Nokta getAsOrjinal(Point p) {

		return new Nokta(p.x + x, p.y - y);
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
}
