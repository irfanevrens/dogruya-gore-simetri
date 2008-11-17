package net.lib;

public class Dogru {
	
	private Nokta a = new Nokta();
	private Nokta b = new Nokta();
	
	public Dogru() {}
	
	public boolean aCizilsin = false;
	public boolean bCizilsin = false;
	
	public boolean dogruCizilsin = false;

	public void setA(Nokta nokta) { a.setLocation(nokta); }
	public void setB(Nokta nokta) { b.setLocation(nokta); }
	
	public Nokta getA() { return a; }
	public Nokta getB() { return b; }
	
	public void cevir(double aci) {
		
		getA().cevir(aci);
		getB().cevir(aci);
	}
	
	public void setABFromDogru(Dogru dogru) {
		
		getA().setXYFromNokta(dogru.getA());
		getB().setXYFromNokta(dogru.getB());
	}
	
	public void konumDegistir(Nokta n1, Nokta n2) {
		
		getA().konumDegistir(n1, n2);
		getB().konumDegistir(n1, n2);
	}
	
	@Override
	public String toString() {
	
		return "A: " + a.toString() + ", B: " + b.toString();
	}
}
