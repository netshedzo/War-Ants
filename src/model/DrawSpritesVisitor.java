package model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class DrawSpritesVisitor  implements GameVisitor{
	private Graphics g = null;
	JPanel thisPanel = null;
	private Bug  thisBug ;
	
	

	public void setPanel(JPanel CurrentPanel)
	{
	this.thisPanel = CurrentPanel;	
	}
	
	public void setGraphics(Graphics g)
	{
		this.g = g;
	}
	public void SetBug(Bug bug)
	{
	thisBug = bug;	
	}

	@Override
	public void draw(Plants a) {
		
    g.drawImage(a.getSprite(),a.getXposition(),a.getYposition(),a.PlantSizeW-60,a.PlantSizeH-100,this.thisPanel);
 
	}

	@Override
	public void draw(Ants a) {
	g.drawImage(a.getImage(),a.getXposition(),a.getYposition(),a.getWidth()/2,a.getHeight()/2,this.thisPanel);

	}

	@Override
	public void draw(Bug a) {
	g.drawImage(a.getImage(),a.getXposition(),a.getYposition(),this.thisPanel);

	}

	
    
     }


