package net.lib;


public class Ucgen {

	private Nokta a = new Nokta();
	private Nokta b = new Nokta();
	private Nokta c = new Nokta();
	
	public boolean aCizilsin = false;
	public boolean bCizilsin = false;
	public boolean cCizilsin = false;
	
	public boolean ucgenCizilsin = false;

	public void setA(Nokta nokta) {
		
		a.setLocation(nokta);
	}

	public void setB(Nokta nokta) {
	
		b.setLocation(nokta);
	}
	
	public void setC(Nokta nokta) {
		
		c.setLocation(nokta);
	}
	
	public Nokta getA() {
		
		return a;
	}

	public Nokta getB() {

		return b;
	}
	
	public Nokta getC() {

		return c;
	}

	public void doAdim1(Ucgen ucgen, Nokta nokta) {
		
		// 1. Nokta
		setA(
				new Nokta(
						ucgen.getA().x + nokta.x, 
						ucgen.getA().y + nokta.y)
				);
		
		aCizilsin = true;
		
		// 2. Nokta 
		setB(
				new Nokta(
						ucgen.getB().x + nokta.x, 
						ucgen.getB().y + nokta.y)
				);
		
		bCizilsin = true;
		
		// 3. Nokta 
		setC(
				new Nokta(
						ucgen.getC().x + nokta.x, 
						ucgen.getC().y + nokta.y)
				);
		
		cCizilsin = true;
		
		ucgenCizilsin = true;
	}
}
