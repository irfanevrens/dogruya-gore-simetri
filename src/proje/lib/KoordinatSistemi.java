package proje.lib;

import irfan.araclar.Matematik;
import irfan.grafik.Dogru;
import irfan.grafik.Koordinat;
import irfan.grafik.Nokta;
import irfan.grafik.Ucgen;

public class KoordinatSistemi extends Koordinat {

	private Dogru dogru = new Dogru();
	private Ucgen ucgen = new Ucgen();
	
	private Dogru yeniDogru = new Dogru();
	private Ucgen yeniUcgen = new Ucgen();
	
	private double aci = 0.0;
	
	public KoordinatSistemi() { }
	
	public Dogru getDogru() { return dogru; }
	public Ucgen getUcgen() { return ucgen; }
	
	public Dogru getYeniDogru() { return yeniDogru; }
	public Ucgen getYeniUcgen() { return yeniUcgen; }
	
	private void tiklandi(Nokta nokta) {
		
		Nokta noktaKoordinat = nokta.getAsKoordinat(getOrjin());
		
		if (getTiklamaSayisi() == 1) {
			
			ucgen.setA(noktaKoordinat);
			ucgen.getA().setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 2) {
			
			ucgen.setB(noktaKoordinat);
			ucgen.getB().setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 3) {
			
			ucgen.setC(noktaKoordinat);
			ucgen.getC().setCizilsin(true);
			
			ucgen.setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 4) {
			
			dogru.setA(noktaKoordinat);
			
			dogru.getA().setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 5) {
			
			dogru.setB(noktaKoordinat);
			
			dogru.getB().setCizilsin(true);
			
			dogru.setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 6) {
			
			yeniDogru.setABFromDogru(dogru);
			
			yeniDogru.konumDegistir(dogru.getA(), new Nokta(0, 0));
			
			yeniDogru.setCizilsin(true);
			
			yeniDogru.getA().setCizilsin(true);
			yeniDogru.getB().setCizilsin(true);

			yeniDogru.setCizilsin(true);
			
			yeniUcgen.setABCFromUcgen(ucgen);
			yeniUcgen.konumDegistir(dogru.getA(), new Nokta(0, 0));
			
			yeniUcgen.getA().setCizilsin(true);
			yeniUcgen.getB().setCizilsin(true);
			yeniUcgen.getC().setCizilsin(true);		
			
			yeniUcgen.setCizilsin(true);
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 7) {
			
			setAci(dogru.getA(), dogru.getB());
			
			yeniDogru.cevir(getAci());
			yeniUcgen.cevir(getAci());
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 8) {
			
			yeniUcgen.xEksenineGoreSimetriAl();
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 9) {
			
			yeniDogru.cevir(-getAci());
			yeniUcgen.cevir(-getAci());
			
			incTiklamaSayisi();
		} else if (getTiklamaSayisi() == 10) {
			
			yeniDogru.konumDegistir(new Nokta(0, 0), dogru.getA());
			yeniUcgen.konumDegistir(new Nokta(0, 0), dogru.getA());
			
			incTiklamaSayisi();
		}
	}
	
	public void setAci(Nokta n1, Nokta n2) {
		
		aci = -1 * Matematik.getAci(Math.atan((n2.getY() - n1.getY()) / (n2.getX() - n1.getX())));
	}
	
	public double getAci() { return aci; }

	public void mouseClicked(Nokta nokta) {
		
		if (isGecerliTiklama(nokta)) tiklandi(nokta);
	} 
}
