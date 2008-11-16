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
		
		ucgenCiz(g);
	}
	
    private void ucgenCiz(Graphics g) {
    	
		if (koordinat.getUcgen().aCizilsin) noktaCiz(koordinat.getUcgen().getA(), g, Color.RED);
		if (koordinat.getUcgen().bCizilsin) noktaCiz(koordinat.getUcgen().getB(), g, Color.RED);
		if (koordinat.getUcgen().cCizilsin) noktaCiz(koordinat.getUcgen().getC(), g, Color.RED);
		
		if (koordinat.getUcgen().ucgenCizilsin) ucgenCiz(koordinat.getUcgen(), g, Color.RED);
		
		if (koordinat.getDogru().aCizilsin) noktaCiz(koordinat.getDogru().getA(), g, Color.BLUE);
		if (koordinat.getDogru().bCizilsin) noktaCiz(koordinat.getDogru().getB(), g, Color.BLUE);
		
		if (koordinat.getDogru().dogruCizilsin) dogruCiz(koordinat.getDogru(), g, Color.BLUE);
		
		// Adým 1
		
		if (koordinat.dogruForAdim1.dogruCizilsin) dogruCiz(koordinat.dogruForAdim1, g, Color.ORANGE);
		
		if (koordinat.ucgenForAdim1.ucgenCizilsin) ucgenCiz(koordinat.ucgenForAdim1, g, Color.ORANGE);
		
		// Adým 2
		
		if (koordinat.dogruForAdim2.dogruCizilsin) dogruCiz(koordinat.dogruForAdim2, g, Color.MAGENTA);
	}

	private void dogruCiz(Dogru dogru, Graphics g, Color c) {
		
		g.setColor(c);
		
		noktaCiz(dogru.getA(), g, c);
		noktaCiz(dogru.getB(), g, c);
		
		dogruCiz(dogru.getA(), dogru.getB(), g, c);
	}

	private void ucgenCiz(Ucgen ucgen, Graphics g, Color c) {
		
		g.setColor(c);
		
		noktaCiz(ucgen.getA(), g, c);
		noktaCiz(ucgen.getB(), g, c);
		noktaCiz(ucgen.getC(), g, c);
		
		dogruCiz(ucgen.getA(), ucgen.getB(), g, c);
		dogruCiz(ucgen.getB(), ucgen.getC(), g, c);
		dogruCiz(ucgen.getC(), ucgen.getA(), g, c);
	}

	private void dogruCiz(Nokta n1, Nokta n2, Graphics g, Color c) {
		
		g.setColor(c);
		
		g.drawLine(n1.x, n1.y, n2.x, n2.y);
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
        		nokta.x - 2, 
        		nokta.y - 2, 
        		5, 
        		5);
    }
}
