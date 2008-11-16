package net.gui;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class JProgram extends JFrame {

	private static final long serialVersionUID = -6710614541821380596L;
	
	private JKoordinat koordinat;
	
	public JProgram() {
		
		super("Doðruya Göre Simetri");
		
		setLayout(new BorderLayout());
		
		koordinat = new JKoordinat();
		
		koordinat.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				koordinat.mouseClicked(e);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		koordinat.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent e) {
				
				koordinat.ebatlarDegisti();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		add(koordinat);
		pack();
	}
}
