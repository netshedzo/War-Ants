package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import File.FileHandler;
import model.FileFormat;

@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	FileFormat thisFile;
	 
	
	
	public GameFrame()
	{
File myFile = new File("src/GameInit4.txt");
FileHandler HandleRead = new FileHandler();
thisFile = HandleRead.ReadInitialGameState(myFile);	


try
{
setSize(thisFile.getWidth(),thisFile.getHeight());
setTitle("Army Ants 1.3");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JMenuBar mainBar = new JMenuBar();
JMenu menu = new JMenu("Game");
JMenuItem Open = new JMenuItem("Start Game");
AntPanel MorePanel = new AntPanel(thisFile);
Open.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				MorePanel.startThread();
				Thread thisThread = new Thread(MorePanel);
				thisThread.start();
			
			}
	
		});
JMenuItem Resume = new JMenuItem("Resume Game");
Resume.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				SaveGame thisin = HandleRead.ResumeGame();
				 thisin.ConvertBack(MorePanel);
				
				
			}
	
		});
JMenuItem SaveGame = new JMenuItem("Save Game");
SaveGame.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaveGame thisin = new SaveGame();
				thisin.ConvertToSave(MorePanel);
			HandleRead.SaveGame(thisin);	
				
			}
	
		}
		);



menu.add(Open);
menu.add(SaveGame);
menu.add(Resume);
mainBar.add(menu);
setJMenuBar(mainBar);
add(MorePanel);

}catch(NullPointerException ex)
{
	ex.printStackTrace();
}


		}
	
	
	


}
