package model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class JurrassicPark extends GameBackground {
	ArrayList<Image> ParkDinosaurs ;

	public JurrassicPark()
	{
		SetPark();
		ParkDinosaurs = new ArrayList<Image>();
	}
	
	private Image DinosaurSettings()
	{
		ImageIcon viewExtinct = new ImageIcon("ExtinctAnimals/Trax.gif");
		Image DinosaurPick = viewExtinct.getImage();	
		return DinosaurPick;
	}
	
	public void AddDinosaur()
	{
		ParkDinosaurs.add(DinosaurSettings());
	}
	
	public void SetPark()
	{
	ImageIcon ParkBack = new ImageIcon("Back/Jurrassic.png");
	Background = ParkBack.getImage();
	intHeight = Background.getHeight(null);
	intWidth = Background.getWidth(null);
	}
	
	
	
	

}
