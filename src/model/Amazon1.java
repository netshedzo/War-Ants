package model;

import javax.swing.ImageIcon;

public class Amazon1 extends GameBackground{
	
	public Amazon1()
	{
		SetBackground();

	}
	
	private void SetBackground()
	{
	ImageIcon thisIcon = new ImageIcon("Sprites/back11.png");
	Background = thisIcon.getImage();
	intHeight = Background.getHeight(null);
	intWidth = Background.getWidth(null);
	}
	

}
