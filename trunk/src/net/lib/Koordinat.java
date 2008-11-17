package net.lib;

import java.awt.Dimension;
import java.awt.Point;

import net.lib.interfaces.IKoordinat;

public class Koordinat implements IKoordinat {

	private Dogru dogru = new Dogru();
	private Ucgen ucgen = new Ucgen();
	
	private Dogru yeniDogru = new Dogru();
	private Ucgen yeniUcgen = new Ucgen();
	
	private Nokta orjin = new Nokta();
	
	private Nokta xy1 = new Nokta(10, 10);
	private Nokta xy2 = new Nokta();
	
	private int gridAraligi = 8;
	private int gridNoktaKalinligi = 1;
	
	private int tiklamaSayisi = 1;

	private double aci = 0;
	
	public Koordinat() { }
	
	public Dogru getDogru() { return dogru; }
	public Ucgen getUcgen() { return ucgen; }
	
	public Dogru getYeniDogru() { return yeniDogru; }
	public Ucgen getYeniUcgen() { return yeniUcgen; }
	
	public Nokta getOrjin() { return orjin; }
	
	public Nokta getXY1() { return xy1; }
	public Nokta getXY2() { return xy2; }

	@Override
	public void ebatlarDegisti() {
	
		orjin.setLocation(
				(xy2.x - xy1.x) / 2 + xy1.x, 
				(xy2.y - xy1.y) / 2 + xy1.y);
	}

	@Override
	public void ebatlarDegisti(Dimension size) {

		xy2.setLocation(
				size.width - xy1.x, 
				size.height - xy1.y);
		
		ebatlarDegisti();
	}
	
	public int getSol() { return getXY1().x; }
	public int getUst() { return getXY1().y; }
	public int getSag() { return getXY2().x; }
	public int getAlt() { return getXY2().y; }

	public int getGenislik() { return getXY2().x - getXY1().x; }
	public int getYukseklik() { return getXY2().y - getXY1().y; }

	public int getOrjinX() { return getOrjin().x; }
	public int getOrjinY() { return getOrjin().y; }
	
	public int getGridAraligi() { return gridAraligi; }

	public int getYatayAdimSayisi() { return (getOrjinX() - getSol()) / getGridAraligi(); }
	public int getDikeyAdimSayisi() { return (getOrjinY() - getUst()) / getGridAraligi(); }

	public int getGridNoktaKalinligi() { return gridNoktaKalinligi  ; }

	public void mouseClicked(Nokta nokta) {

		if (isGecerliTiklama(nokta)) tiklandi(nokta);
	}
	
	private void tiklandi(Nokta nokta) {
		
		Nokta noktaKoordinat = nokta.getAsKoordinat(getOrjin());
		
		if (tiklamaSayisi == 1) {
			
			getUcgen().setA(noktaKoordinat);
			getUcgen().aCizilsin = true;
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 2) {
			
			getUcgen().setB(noktaKoordinat);
			getUcgen().bCizilsin = true;
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 3) {
			
			getUcgen().setC(noktaKoordinat);
			getUcgen().cCizilsin = true;
			
			getUcgen().ucgenCizilsin = true;
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 4) {
			
			getDogru().setA(noktaKoordinat);
			getDogru().aCizilsin = true;
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 5) {
			
			getDogru().setB(noktaKoordinat);
			getDogru().bCizilsin = true;
			
			getDogru().dogruCizilsin = true;
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 6) {
			
			getYeniDogru().setABFromDogru(getDogru());
			getYeniDogru().konumDegistir(dogru.getA(), getOrjin());
			
			getYeniUcgen().setABCFromUcgen(getUcgen());
			getYeniUcgen().konumDegistir(dogru.getA(), getOrjin());
			
			tiklamaSayisi++;
		} else if (tiklamaSayisi == 7) {
			
			getYeniDogru().cevir(45.0);
			getYeniUcgen().cevir(45.0);
			
			tiklamaSayisi++;
		}
	}
	
	private boolean isGecerliTiklama(Point point) {
		
		return point.x > getSol() && point.x < getSag() && point.y > getUst() && point.y < getAlt(); 
	}

	public void setAci(double aci) {
		
		this.aci  = aci;
	}

	public double getAci() {

		return aci;
	}
}
