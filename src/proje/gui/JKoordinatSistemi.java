package proje.gui;

import irfan.grafik.Dogru;
import irfan.grafik.Nokta;
import irfan.grafik.Ucgen;
import irfan.grafik.gui.JKoordinat;
import irfan.grafik.interfaces.IKoordinat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import proje.lib.KoordinatSistemi;

public class JKoordinatSistemi extends JKoordinat implements IKoordinat {

	private static final long serialVersionUID = 6383402770160044351L;

	private KoordinatSistemi koordinat = new KoordinatSistemi();
	
	@Override
	public void paint(Graphics g) {
	
		koordinatSifirla(g);
		koordinatCiz(koordinat, g);
		elemanlariCiz(g);
	}

	private void elemanlariCiz(Graphics g) {
    	
		ucgenCiz(koordinat.getUcgen(), g, Color.RED);
		dogruCiz(koordinat.getDogru(), g, Color.BLUE);
		
		ucgenCiz(koordinat.getYeniUcgen(), g, Color.MAGENTA);
		dogruCiz(koordinat.getYeniDogru(), g, Color.ORANGE);		
	}
	
	private void ucgenCiz(Ucgen ucgen, Graphics g, Color c) {
		
		g.setColor(c);
		
		noktaCiz(ucgen.getA(), g, c);
		noktaCiz(ucgen.getB(), g, c);
		noktaCiz(ucgen.getC(), g, c);
		
		if (ucgen.isCizilsin()) {
		
			dogruCiz(ucgen.getA(), ucgen.getB(), g, c);
			dogruCiz(ucgen.getB(), ucgen.getC(), g, c);
			dogruCiz(ucgen.getC(), ucgen.getA(), g, c);
		}
	}

	private void dogruCiz(Dogru dogru, Graphics g, Color c) {
		
		g.setColor(c);
		
		noktaCiz(dogru.getA(), g, c);
		noktaCiz(dogru.getB(), g, c);
		
		if (dogru.isCizilsin()) dogruCiz(dogru.getA(), dogru.getB(), g, c);
	}

	private void dogruCiz(Nokta n1, Nokta n2, Graphics g, Color c) {
		
		g.setColor(c);
		
		g.drawLine(
				n1.getAsOrjinal(koordinat.getOrjin()).x, 
				n1.getAsOrjinal(koordinat.getOrjin()).y, 
				n2.getAsOrjinal(koordinat.getOrjin()).x, 
				n2.getAsOrjinal(koordinat.getOrjin()).y);
	}

    private void noktaCiz(Nokta nokta, Graphics g, Color c) {
        
        g.setColor(c);
        
        if (nokta.isCizilsin()) 
        	g.fillRect(
        			nokta.getAsOrjinal(koordinat.getOrjin()).x - 2, 
        			nokta.getAsOrjinal(koordinat.getOrjin()).y - 2, 
        			5, 
        			5);
    }

	@Override
	public void ebatlarDegisti() {

		koordinat.ebatlarDegisti(getSize());
		
		repaint();
	}

	@Override
	public void ebatlarDegisti(Dimension size) {

	}

	public void mouseClicked(MouseEvent e) {
		
		koordinat.mouseClicked(new Nokta(e.getPoint()));
		
		repaint();
	}
}
