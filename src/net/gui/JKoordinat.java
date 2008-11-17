package net.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import net.lib.Dogru;
import net.lib.Koordinat;
import net.lib.Nokta;
import net.lib.Ucgen;
import net.lib.interfaces.IKoordinat;

public class JKoordinat extends JPanel implements IKoordinat {

	private static final long serialVersionUID = 6383402770160044351L;

	private Koordinat koordinat = new Koordinat();
	
	public JKoordinat() {
		
		super(null);
	}
	
	@Override
	public void paint(Graphics g) {
	
		koordinatSifirla(g);
		koordinatCiz(g);
		
		elemanlariCiz(g);
	}

	private void elemanlariCiz(Graphics g) {
    	
		ucgenCiz(koordinat.getUcgen(), g, Color.RED);
		dogruCiz(koordinat.getDogru(), g, Color.BLUE);
		
		// Adým 1
		
		dogruCiz(koordinat.getYeniDogru(), g, Color.ORANGE);
		ucgenCiz(koordinat.getYeniUcgen(), g, Color.MAGENTA);
	}

	private void dogruCiz(Dogru dogru, Graphics g, Color c) {
		
		g.setColor(c);
		
		if (dogru.aCizilsin) 
			noktaCiz(dogru.getA(), g, c);
		if (dogru.bCizilsin) noktaCiz(dogru.getB(), g, c);
		
		if (dogru.dogruCizilsin) dogruCiz(dogru.getA(), dogru.getB(), g, c);
	}

	private void ucgenCiz(Ucgen ucgen, Graphics g, Color c) {
		
		g.setColor(c);
		
		if (ucgen.aCizilsin) noktaCiz(ucgen.getA(), g, c);
		if (ucgen.bCizilsin) noktaCiz(ucgen.getB(), g, c);
		if (ucgen.cCizilsin) noktaCiz(ucgen.getC(), g, c);
		
		if (ucgen.ucgenCizilsin) {
		
			dogruCiz(ucgen.getA(), ucgen.getB(), g, c);
			dogruCiz(ucgen.getB(), ucgen.getC(), g, c);
			dogruCiz(ucgen.getC(), ucgen.getA(), g, c);
		}
	}

	private void dogruCiz(Nokta n1, Nokta n2, Graphics g, Color c) {
		
		g.setColor(c);
		
		g.drawLine(
				n1.getAsOrjinal(koordinat.getOrjin()).x, 
				n1.getAsOrjinal(koordinat.getOrjin()).y, 
				n2.getAsOrjinal(koordinat.getOrjin()).x, 
				n2.getAsOrjinal(koordinat.getOrjin()).y);
	}

	private void koordinatSifirla(Graphics g) {
        
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

	private void koordinatCiz(Graphics g) {
		
		g.setColor(Color.GRAY);
		
		g.drawLine(
				koordinat.getOrjin().x, 
				koordinat.getUst(), 
				koordinat.getOrjin().x, 
				koordinat.getAlt());
		
		g.drawLine(
				koordinat.getXY1().x, 
				koordinat.getOrjin().y, 
				koordinat.getXY2().x, 
				koordinat.getOrjin().y);
		
		g.setColor(Color.GRAY);
		
		for (int i = 1; i <= koordinat.getYatayAdimSayisi(); i++) {
			
			for (int j = 1; j <= koordinat.getDikeyAdimSayisi(); j++) {
			
				g.fillOval(
						koordinat.getOrjinX() - i * koordinat.getGridAraligi(), 
						koordinat.getOrjinY() - j * koordinat.getGridAraligi(), 
						koordinat.getGridNoktaKalinligi(), 
						koordinat.getGridNoktaKalinligi());
				
				g.fillOval(
						koordinat.getOrjinX() + i * koordinat.getGridAraligi(), 
						koordinat.getOrjinY() + j * koordinat.getGridAraligi(), 
						koordinat.getGridNoktaKalinligi(), 
						koordinat.getGridNoktaKalinligi());
				
				g.fillOval(
						koordinat.getOrjinX() - i * koordinat.getGridAraligi(), 
						koordinat.getOrjinY() + j * koordinat.getGridAraligi(), 
						koordinat.getGridNoktaKalinligi(), 
						koordinat.getGridNoktaKalinligi());
				
				g.fillOval(
						koordinat.getOrjinX() + i * koordinat.getGridAraligi(), 
						koordinat.getOrjinY() - j * koordinat.getGridAraligi(), 
						koordinat.getGridNoktaKalinligi(), 
						koordinat.getGridNoktaKalinligi());
			}
		}
		
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
	
    private void noktaCiz(Nokta nokta, Graphics g, Color c) {
        
        g.setColor(c);
        
        g.fillRect(
        		nokta.getAsOrjinal(koordinat.getOrjin()).x - 2, 
        		nokta.getAsOrjinal(koordinat.getOrjin()).y - 2, 
        		5, 
        		5);
    }
}
