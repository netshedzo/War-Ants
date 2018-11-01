package ui;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;

@SuppressWarnings("serial")
public class AntPanel extends JPanel implements Runnable{
	DrawSpritesVisitor thisGame = new DrawSpritesVisitor();
	ArrayList<Ants> Antss = new ArrayList<Ants>() ;
	ArrayList<Plants> Plant = new ArrayList<Plants>();
	Bug Player = new Bug();
	FileFormat thisFomat;
	ArrayList<Thread> AntThread = new ArrayList<Thread>();
	private Timer timer;
    private final int DELAY = 10;
    PressedKey thisKey =new PressedKey();
	
	public void changeAnts(ArrayList<Ants> a)
	{
	this.Antss = a;	
	}
    public void changePlants(ArrayList<Plants> a)
    {
    	this.Plant = a;
    }
    public void setBug(Bug c)
    {
    	this.Player  = c;
    }
    public void rechangeThread(	ArrayList<Thread> AntThread)
    {
    this.AntThread = AntThread;	
    }
	
	public AntPanel(FileFormat thisFormat)
	{
		thisGame.setPanel(this);
		this.thisFomat = thisFormat;
		SetBug();
		makeants();
		makePlants();
		this.addKeyListener(thisKey);
        
	}
	
	private void SetBug()
	{
	Player.SetPlayerPos(thisFomat.getX(),thisFomat.getY());	
	}
	
	private void makePlants()
	{
		Random thisRandom = new Random();
	 for(int c = 0 ; c<thisFomat.getPlants();c++)
	 {
	 Plants thisP = new Plants();
	 thisP.SetX(thisRandom.nextInt(thisFomat.getWidth())-10);
	 thisP.SetY(thisRandom.nextInt(thisFomat.getHeight())/2);
	 Plant.add(thisP);
	 }
	}
	private void makeants()
	{
		Random thisRandom = new Random();
    for(int c = 0 ; c < thisFomat.getQueen().size();c++)
    {
	for(int a = 0 ; a< thisFomat.getCount(); a++)
	{
	 Ants B = new Ants();
	 B.SetQueen(thisFomat.getQueen().get(c));
	 B.SetX(thisRandom.nextInt(thisFomat.getWidth()));
	 B.SetY(thisRandom.nextInt(thisFomat.getHeight()));
	 B.setList(Antss);
	 B.setPanel(this);
	 B.UpdateBugPos(Player.BugPoints());
	 Antss.add(B);
	}
	}
	}
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		thisGame.setGraphics(g);
		Amazon1  amazome = new Amazon1();
		g.drawImage(amazome.GetImage(),0,0,thisFomat.getWidth(),thisFomat.getHeight(),this);
		Toolkit.getDefaultToolkit().sync();
		if(Antss != null)
		{
		for(Ants a : Antss)
		{
		a.accept(thisGame);
		a.setList(Antss);
		 Thread antt = new Thread(a);
		 this.AntThread.add(antt);	
		 
		}
		}
		if(Plant != null)
		{
		for(Plants a : Plant)
		{
			a.accept(thisGame);
			//a.Update(Player.BugPoints());	
		}
		}
		if(Player != null)
		{
		Player.accept(thisGame);	
		}
		
	}
	public void startThread()
	{
		if(this.AntThread != null)
		{
			for(Thread a : AntThread)
			{
			a.start();	
			}
		}
	}

	@Override
	public void run() {
		while(true)
		{
			try
			{
			if(Antss != null)
			{
			for(Ants a : Antss)
			{
			a.setList(Antss); 
			}
			}
			Thread.sleep(2000);
			}catch(InterruptedException ex)
			{
			ex.printStackTrace();	
			}
		}
			
	}
	
 private class PressedKey implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		Player.KeyPressed(arg0);	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		Player.KeyPressed(arg0);
		
	}
	
 }

}
