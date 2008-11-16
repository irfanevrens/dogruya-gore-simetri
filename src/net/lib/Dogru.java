package net.lib;

import net.util.Matematik;

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
	
	public void doAdim1(Dogru dogru, Nokta nokta) {
		
		// 1. Nokta
		setA(
				new Nokta(
						dogru.getA().x + nokta.x, 
						dogru.getA().y + nokta.y)
				);
		
		aCizilsin = true;
		
		// 2. Nokta
		
		setB(
				new Nokta(
						dogru.getB().x + nokta.x, 
						dogru.getB().y + nokta.y)
				);
		
		bCizilsin = true;
		
		dogruCizilsin = true;
		
	}
	public void doAdim2(Dogru dogru, Nokta orjin, double aci) {

		// 1. Nokta
		
		Nokta tempNokta1 = new Nokta(
				
				(int)(dogru.getA().getAsKoordinat(orjin).x * Matematik.getCos(aci) - dogru.getA().getAsKoordinat(orjin).y * Matematik.getSin(aci)), 
				(int)(dogru.getA().getAsKoordinat(orjin).x * Matematik.getSin(aci) + dogru.getA().getAsKoordinat(orjin).y * Matematik.getCos(aci)));
		
		setA(tempNokta1.getAsOrjinal(orjin));
		
		aCizilsin = true;
		
		// 2. Nokta

		Nokta tempNokta2 = new Nokta(
				
				(int)(dogru.getB().getAsKoordinat(orjin).x * Matematik.getCos(aci) - dogru.getB().getAsKoordinat(orjin).y * Matematik.getSin(aci)), 
				(int)(dogru.getB().getAsKoordinat(orjin).x * Matematik.getSin(aci) + dogru.getB().getAsKoordinat(orjin).y * Matematik.getCos(aci)));
		
		setB(tempNokta2.getAsOrjinal(orjin));
		
		dogruCizilsin = true;
	}
	
	@Override
	public String toString() {
	
		return "A: " + a.toString() + ", B: " + b.toString();
	}
}
