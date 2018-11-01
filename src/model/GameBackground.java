package model;

import java.awt.Image;

public abstract class GameBackground {

protected Image Background;
protected int intHeight;
protected int intWidth;

public Image GetImage()
{
	return Background;
}

public void ChangeBackground(Image ABack)
{
	this.Background = ABack;
}

public  int GetBackWidth()
{
	return Background.getWidth(null);
}

public int GetBackHeight()
{
	return Background.getHeight(null);
}
}
