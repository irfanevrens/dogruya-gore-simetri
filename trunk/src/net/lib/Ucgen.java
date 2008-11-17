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
	
	public void cevir(double aci) {
		
		getA().cevir(aci);
		getB().cevir(aci);
		getC().cevir(aci);
	}

	public void setABCFromUcgen(Ucgen ucgen) {

		getA().setXYFromNokta(ucgen.getA());
		getB().setXYFromNokta(ucgen.getB());
		getC().setXYFromNokta(ucgen.getC());
	}

	public void konumDegistir(Nokta n1, Nokta n2) {
		
		getA().konumDegistir(n1, n2);
		getB().konumDegistir(n1, n2);
		getC().konumDegistir(n1, n2);
	}
}
