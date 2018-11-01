package File;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JPanel;

import model.FileFormat;

public class FileHandler {
	
	
	public void SaveGame(ui.SaveGame thisGame)
	{
		ObjectOutputStream SavetoFile = null;
		try
		{
		FileOutputStream Save = new FileOutputStream("Data/ArmyAnts.dat");
		BufferedOutputStream bFout = new BufferedOutputStream(Save);
		
		 SavetoFile = new ObjectOutputStream(bFout);
		SavetoFile.writeObject(thisGame);
		
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
		if(SavetoFile != null)
		{
		try
		{
		SavetoFile.close();	
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		}
		}
		
	}
	
	public ui.SaveGame ResumeGame()
	{
	ui.SaveGame thisPanel = null;
	ObjectInputStream resume = null;
	try
	{
		FileInputStream newFile = new FileInputStream("Data/ArmyAnts.dat");
		if(newFile.available() == 0) {return null;}
		BufferedInputStream read = new BufferedInputStream(newFile);
		resume = new ObjectInputStream(read);
    Object objF = resume.readObject();
    
    if(objF instanceof ui.SaveGame)
    {
    thisPanel =(ui.SaveGame)objF;	
    }
		
	}catch(IOException | ClassNotFoundException ex)
	{
	ex.printStackTrace();	
	}
	
		
	return thisPanel;
	}
	
	public FileFormat ReadInitialGameState(File FileName)
	{
		FileFormat GameStart = new FileFormat();
		Scanner ScanStart = null;
		
		if(!FileName.exists()) {
			System.out.println("FileNotFound");
			return null;}
		
		try
		{
			ScanStart = new Scanner(FileName);
			String GameLine = ScanStart.nextLine();
			@SuppressWarnings("unused")
			String RubbishBin = " ";
			StringTokenizer GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			int Groups =Integer.parseInt((GameToken.nextToken()));
			GameStart.setGroups(Groups);
			GameLine = ScanStart.nextLine();
			GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			String Queens = GameToken.nextToken();
			StringTokenizer QueenToken = new StringTokenizer(Queens," ");
			ArrayList<String> QueenList = new ArrayList<String>();
			while(QueenToken.hasMoreTokens())
			{
			QueenList.add(QueenToken.nextToken()) ;	
			}
			GameStart.setQueens(QueenList);
			GameLine = ScanStart.nextLine();
			GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			int AntsCount =Integer.parseInt((GameToken.nextToken()));
			GameStart.setCount(AntsCount);
			GameLine = ScanStart.nextLine();
			GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			int Plants =Integer.parseInt((GameToken.nextToken()));
			GameStart.setPlants(Plants);
			GameLine = ScanStart.nextLine();
			GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			StringTokenizer GameSize = new StringTokenizer(GameToken.nextToken()," ");
			int Width = Integer.parseInt(GameSize.nextToken());
			int Height = Integer.parseInt(GameSize.nextToken());
			GameStart.setWidth(Width);
			GameStart.setHeight(Height);
			GameLine = ScanStart.nextLine();
			GameToken = new StringTokenizer(GameLine,"=");
			RubbishBin += GameToken.nextToken();
			StringTokenizer GamePoints = new StringTokenizer(GameToken.nextToken()," ");
			int X = Integer.parseInt(GamePoints.nextToken());
			int Y = Integer.parseInt(GamePoints.nextToken());
			GameStart.setX(X);
			GameStart.setY(Y);	
		
			
		}catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
		
		
		return GameStart;
	}

}
