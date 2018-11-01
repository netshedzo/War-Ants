package model;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Plants implements AcceptVisit,AbstractPlantObserver {

	int PositionX ;
	int PositionY ;
	int PlantSizeH ;
	int PlantSizeW;
	Image PlantSprite;
    int BugX ;
    int BugY;
    boolean Eat ;
    AbstractSubject subj;
    
    public void SetX(int X) {this.PositionX = X;}
	public void SetY(int Y) {this.PositionY = Y;}
    
    public void Update(Point BugPos)
    {
    	BugX = BugPos.x;
    	BugY =BugPos.y;
    	
    }
    
    private int CalculateTotal()
    {
    int Total = 0 ;
    int intX = 0 ;
    int intY = 0;
    if(getXposition() > BugX)
    {
    	intX =getXposition()-BugX;
    }else
    {
    intX =BugX-getXposition();
    }
    
    if(getYposition() > BugY)
    {
    	intY =getYposition()-BugY;
    }else
    {
    intX = BugY-getYposition();
    }
    Total =intX + intY;
    	return Total;
    }
	
    public void  PlantState()
    {
    int Results = CalculateTotal();
    if(Results <= 2)
    {
    Eat = true;	
    }
    }
    

	public Plants()
	{
		PositionX = 0;
		PositionY = 0;
		setPlant();
		Eat = false;
		
	}
	
	private void setPlant()
	{
	ImageIcon plantA = new ImageIcon("Sprites/Plant.png");
	 PlantSprite = plantA.getImage();
	 PlantSizeH = PlantSprite.getHeight(null);
	 PlantSizeW = PlantSprite.getWidth(null);
	}
	
	public Image getSprite()
	{
		return PlantSprite;
	}
	@Override
	public void accept(GameVisitor visit) {
		// TODO Auto-generated method stub
       visit.draw(this);
	}

	public void changeX(int intX)
	{
		PositionX = intX;
	}
	
	
	public int getXposition() {
		// TODO Auto-generated method stub
		return PositionX;
	}
	
	public void ChangeY(int intY)
	{
		PositionY = intY;
	}


	public int getYposition() {
		// TODO Auto-generated method stub
		return PositionY;
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SetAbstactSubject(AbstractSubject subj) {
		// TODO Auto-generated method stub
		this.subj = subj;
	}

}
