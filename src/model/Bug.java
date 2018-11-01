package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bug implements AcceptVisit,AbstractSubject{

	private int PositionX;
	private int PositionY;
	private int PlantCount;
	private int TotalPlants;
	private int OldX;
	private int OldY;
	private static int Power = 5;
	private int NearAntX;
	private int NearAntY;
	private boolean  Lose;
	private boolean Win;
	private Point BugPoint = new Point();
	private Image Sprite;
	private int bugWidth ;
	private ArrayList<AbstractPlantObserver> Pal= new ArrayList<AbstractPlantObserver>();
	private int bugHeight;
	
	private void setImage()
	{
	ImageIcon thisGame = new ImageIcon("Sprites/Bug.png");
	Sprite = thisGame.getImage();
	bugWidth = Sprite.getWidth(null);
	bugHeight = Sprite.getHeight(null);
	}
	
	public int getHeight() {return bugHeight;}
	public int getWidth() {return bugWidth;}
	public Image getImage() {return Sprite;}
	public Point BugPoints() {return BugPoint;}
	
	
	public Bug() {
		 PositionX = 0 ;
		 PositionY = 0 ;
		 PlantCount = 0 ;
		 NearAntX = 0;
		 NearAntY = 0;
		 OldX = 0 ;
		 Lose = false;
		 Win = false;
		 BugPoint.x = 0 ;
		 BugPoint.y = 0;
		OldY = 0;
		setImage();
		
		
	}
	public void SetPlayerPos(int intX, int intY)
	{
		PositionX = intX;
		PositionY = intY;
		setPoint();
	}
	
	public void setTotalPlants(int total)
	{
	 TotalPlants = total;	
	}
	public void EatPlant()
	{
	PlantCount++;	
	}
	
	public void CheckWin()
	{
	if(PlantCount == TotalPlants)
		Win = true;
	}
	
	public void NotifyBodies(ArrayList<Plants> Plant,ArrayList<Ants> Ant)
	{
	for(Plants Plan : Plant)
	{
		Plan.Update(BugPoint);
	}
	
	
	for(Ants A : Ant)
	{
		A.UpdateBugPos(BugPoint);
	}
	}
	private void setPoint()
	{
		BugPoint.x = PositionX;
		BugPoint.y = PositionY;
	}
	public void SetNearest(ArrayList<Ants> Antss)
	{
		for(Ants Ant : Antss)
		{
		if(Ant.getCloseBug())
		{
		NearAntX = Ant.getXposition();
		NearAntY = Ant.getYposition();
		}
		}
	}
	//reset the state
	public void SetNearest()
	{
		NearAntX = 0;
		NearAntY = 0;
	}
   int getPreviosXPos()
   {
   if(OldX != 0)
	   {
		return OldX;   
	   }
	   return PositionX;
   }
   
   int getPreviosYPos()
   {
	   if(OldY != 0)
	   {
		   return OldY;
	   }
	   return PositionY;
   }
	 void IncrementCount()
	 {
		 PlantCount++;
	 }
	 
	 
	@Override
	public void accept(GameVisitor visit) {	
visit.draw(this);
	}


	public int getXposition() {
	
		return  PositionX;
	}

	
	public int getYposition() {
		return  PositionY;
	}
	

	

	public void MoveUp()
	{
		OldY = PositionY;
		PositionY++;
		setPoint();
	}
	public void MoveDown()
	{
		OldY = PositionY;
		PositionY--;
		setPoint();
	}
	public void MoveLeft()
	{
		OldX = PositionX;
		PositionX--;
		setPoint();
	
	}
	public void MoveRight()
	{
		OldX = PositionX;
		PositionX++;
		setPoint();	
	}
	public void MoveTopRight()
	{
		OldX = PositionX;
		OldY = PositionY;
		PositionY--;
		PositionX++;
		setPoint();	
	}
	public void MoveBottomRight()
	{
		OldX = PositionX;
		OldY = PositionY;
		PositionY++;
		PositionX++;
		setPoint();	
	}
	
	public void MoveTopLeft()
	{
		OldX = PositionX;
		OldY = PositionY;
		PositionY--;
		PositionX--;
		setPoint();	
	}
	
	public void MoveBottomLeft()
	{
		OldX = PositionX;
		OldY = PositionY;
		PositionY++;
		PositionX--;
		setPoint();	
	}
	
	
	public void KeyPressed(KeyEvent key)
	{
	
	 int Results = key.getKeyCode();
	 switch(Results)
	 {
	 case KeyEvent.VK_LEFT:
	
	 {
		this.MoveLeft();
		System.out.println("4 pressed");
		break;
	 }case KeyEvent.VK_RIGHT:
	 case KeyEvent.VK_6:
	 case KeyEvent.VK_D:
	 {
		 this.MoveRight();
		 break;
	 }case KeyEvent.VK_UP:
	  case KeyEvent.VK_8:
	  case KeyEvent.VK_W:
	 {
		 this.MoveUp();
		 break;
	 }case KeyEvent.VK_DOWN:
	 case KeyEvent.VK_2:
	 case KeyEvent.VK_S:
	 {
		 this.MoveDown();
		 break;
	 }case KeyEvent.VK_7:
	 case KeyEvent.VK_Q:
	 {
		 this.MoveTopLeft();
		 break;
	 }case KeyEvent.VK_1:
	 case KeyEvent.VK_Z:
	 {
		 this.MoveBottomLeft();
		 break;
	 }
	 case KeyEvent.VK_9:
	 case KeyEvent.VK_E:
	 {
		 this.MoveTopRight();
		 break;
	 }
	 case KeyEvent.VK_3:
	 case KeyEvent.VK_C:
	 {
		 this.MoveBottomRight();
		 break;
	 }
	 }
	}
	
	
	 public void ResetOld()
	 {
		 OldX = 0;
		 OldY = 0;
	 }

	@Override
	public void dettach(AbstractPlantObserver Pal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(ArrayList<AbstractPlantObserver> Pal) {
		this.Pal = Pal;	
	}

	@Override
	public void NotifyPlants() {
	
		
	}

	@Override
	public Object getUpdate(AbstractPlantObserver obj) {
		// TODO Auto-generated method stub
		return null;
	}


}
