package model;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ants implements AcceptVisit,MoveVisitable,PowerVisitable,Runnable{
 private  int PositionX;
 private  int PositionY;
 private int AntSizeh;
 private int AntSizew;
 private boolean CloseBug;
 private  boolean FollowAnts;
 private String Queen;
 private	int BugPosX = 0 ;
 private	int BugPosY = 0 ;
 private	int targetX;
 private	int targetY;
private int OldX;
private int OldY;
private Ants AntClosest;
private Ants AntCloseBug;
private Image Sprite ;
private ArrayList<Ants> MainAnts = null;
private static int Power = 3;
private boolean Lose ;
private JPanel gamePanel;

public String getQueen() {return this.Queen;}
public void setPanel(JPanel Current)
{
	gamePanel = Current;
}

	public void setList(ArrayList<Ants> thisAnts)
	{
		MainAnts = thisAnts;
	}
	public Ants() {
		// TODO Auto-generated constructor stub
		PositionX = 0;
		PositionY = 0 ; 
		AntSizeh = 0 ;
		AntSizew = 0 ; 
		Queen =" ";
		 BugPosX = 0 ;
		 BugPosY = 0 ;
		 targetX  = 0 ; 
		 targetY = 0 ;
		 CloseBug = false;
		 FollowAnts = false;
		 OldX = 0 ;
		 OldY = 0;
		 Lose = false;
		 loadLeft();
		 
	}
	
	private void loadLeft()
	{
  		ImageIcon ant = new ImageIcon("Sprites/Ant1L.gif");
  		Sprite = ant.getImage();
  		AntSizeh = Sprite.getHeight(null);
  		AntSizew = Sprite.getWidth(null);
  		
	}
	
	private void loadRight()
	{
  		ImageIcon ant = new ImageIcon("Sprites/Ant1R.gif");
  		Sprite = ant.getImage();
  		AntSizeh = Sprite.getHeight(null);
  		AntSizew = Sprite.getWidth(null);
  		
	}
	
	private void loadUp()
	{
  		ImageIcon ant = new ImageIcon("Sprites/Ant1U.gif");
  		Sprite = ant.getImage();
  		AntSizeh = Sprite.getHeight(null);
  		AntSizew = Sprite.getWidth(null);
  		
	}
	private void loadDown()
	{
  		ImageIcon ant = new ImageIcon("Sprites/Ant1D.gif");
  		Sprite = ant.getImage();
  		AntSizeh = Sprite.getHeight(null);
  		AntSizew = Sprite.getWidth(null);
  		
	}
	
	public boolean getCloseBug()
	{
		return CloseBug;
	}
	/*
	 * used to  to see if the ant has found a bug
	 */
	public void CheckRange(ArrayList<Ants> Antt)
	{
	if(Antt != null)
	{
     for(Ants Ant  : Antt) {
	 if(this != Ant && this.GetQueen() == Ant.GetQueen())
	 {
		 if(Ant.getCloseBug())
		 {
			 targetX = Ant.getXposition();
			 targetY = Ant.getYposition();
			 FollowAnts = true;
		 }else
		 {
			 FollowAnts= false;	 
		 }
	 }
     }
	}
}
	public int getHeight()
	{
		return AntSizeh;
	}
	
	public int getWidth()
	{
		return AntSizew;
	}
	public Image getImage()
	{
		return Sprite;
	}
	public void SetTarget(int intX ,int intY)
	{
		if(!CloseBug)
		{
			 targetX = intX;
			 targetY = intY;
		}
	
	}
	
	
	
	
	public void MoveAnt()
	{
		 OldX = PositionX ;
		 OldY = PositionY;
		if(CloseBug)
	{
			if(PositionX > targetX)
			{ PositionX += 2;
			 this.loadRight();
			}
			if(PositionX < targetX) {PositionX -= 2;
			this.loadLeft();}
			if(PositionY > targetY) {PositionY += 2;
			this.loadDown();}
			if(PositionY < targetY) {PositionY -= 2;
			this.loadUp();}
			
		}else
		{
			if(PositionX > targetX) {PositionX += 1;
			this.loadRight();}
			else if(PositionX < targetX) {PositionX -= 1;
			this.loadLeft();}
			else if(PositionY > targetY) {PositionY += 1;
			this.loadDown();}
			else if(PositionY < targetY) {PositionY -= 1;
			this.loadUp();}	
		}
	}
	
	
	
	public void CheckRange()
	{
		if(BugPosX >= PositionX && BugPosY >= PositionY)
		{
			if((BugPosX - PositionX)  <= 5 && (BugPosY - PositionY)  <= 5)
			{
				CloseBug = true;
			}
			
		}else if((BugPosX >= PositionX && BugPosY < PositionY ))
		{
			if((BugPosX - PositionX)  <= 5 || (PositionY - BugPosY)  <= 5)
			{
				CloseBug = true;
			}
		}else if((BugPosX < PositionX && BugPosY >= PositionY ))
		{
			if(( PositionX - BugPosX)  <= 5 && (BugPosY - PositionY)  <= 5)
			{
				CloseBug = true;
			}	
		}else if(BugPosX < PositionX && BugPosY < PositionY)
		{
			if(( PositionX - BugPosX)  <= 5 && ( PositionY - BugPosY)  <= 5)
			{
				CloseBug = true;
			}	
		}else
		{
			CloseBug = false;
		}
	}
    private int CalculateTotal(Ants Ant)
    {
    int Total = 0 ;
    int intX = 0 ;
    int intY = 0;
    if(Ant.getXposition() > this.getXposition())
    {
    	intX =Ant.getXposition()-this.getXposition();
    }else
    {
    intX =this.getXposition()-Ant.getXposition();
    }
    
    if(Ant.getYposition() > this.getYposition())
    {
    	intY =Ant.getYposition()-this.getYposition();
    }else
    {
    intX = this.getYposition()-Ant.getYposition();
    }
    Total =intX + intY;
    if(Total <= 5) {
    	AntClosest = Ant;
    	Total += 200000; //to avoid setting the wrong target
    }
    
    	return Total;
    }
	public void UpdateBugPos(Point A)
	{
		BugPosX = A.x;
		BugPosY = A.y;
	}
	
	public void SetAntTarget(ArrayList<Ants> ant)
	{
	Ants AntTest = ant.get(0);
	int intTotal = CalculateTotal(AntTest);
	if(ant != null )
	{
	for(Ants b : ant)
	{
	  if(b != AntClosest && b != this)
	  {
		int localTotal = CalculateTotal(b);
		if(localTotal < intTotal)
		{
			AntTest = b;
			intTotal = localTotal;
		}
	  }
	}
	if(!FollowAnts)
	{
		targetX = AntTest.getXposition();
		targetY = AntTest.getYposition();
	}
	}
	}
	
	public void SetX(int X) {this.PositionX = X;}
	public void SetY(int Y) {this.PositionY = Y;}
	
	@Override
	public void accept(GameVisitor visit) {
		// TODO Auto-generated method stub
		visit.draw(this);

	}
     public void ChangePosition(int intX,int intY)
     {
    	 PositionY += intY;
    	 PositionX += intX;
     }
     String GetQueen()
     {
    	 return Queen;
     }
     public void SetQueen(String Queen)
     {
    	 this.Queen = Queen;
     }
	
	public int getXposition() {
		
		return PositionX;
	}

	
	public int getYposition() {
		return  PositionY;
	}

	@Override
	public void MoveObject(MovementVisitor a) {
		a.Move(this);
		
	}


	@Override
	public void Power(FightVisitor fight) {
	  fight.Fight(this);
		
	}

	@Override
	public void Lose() {
		
     Power --;
     if(Power == 0)
     {
    	 Lose = true;
     }
		
	}
	@Override
	public void run() {
		
		while(true)
		{
		CheckRange();
		this.CheckRange(this.MainAnts);
		this.SetAntTarget(this.MainAnts);
		MoveAnt();
		gamePanel.repaint();
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException ex)
		{
		ex.printStackTrace();	
		}
		}
		
		
		
	}



}
