package net.lib;

import java.awt.Point;

public class Orjin {

	public int x;
	public int y;

	public Orjin(int x, int y) {
	
		this.x = x;
		this.y = y;
	}

	public Orjin(Orjin orjin) {
		
		this(orjin.x, orjin.y);
	}

	public Point convertFromOrjinalToKoordinat(Point p) {

		return new Point(p.x - x, y - p.y);
	}

	public Point convertFromKoordinatToOrjinal(Point p) {
		
		return new Point(p.x + x, y - p.y);
	}
	
	@Override
	public String toString() {
		
		return "[x: " + x + "], [y: " + y + "]";
	}
}
