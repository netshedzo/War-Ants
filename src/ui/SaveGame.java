package ui;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveGame implements Serializable {
ArrayList<ObjectStructure> Ants = new ArrayList<ObjectStructure>();
ObjectStructure Bug = new ObjectStructure();
ArrayList<ObjectStructure> Plants = new ArrayList<ObjectStructure>();

public void ConvertToSave(AntPanel GamePanel)
{
for(model.Ants s : GamePanel.Antss)
{
	ObjectStructure thisObj = new ObjectStructure();
	thisObj.PositionX = s.getXposition();
	thisObj.PositionY = s.getYposition();
	thisObj.Queen = s.getQueen();
	Ants.add(thisObj);
}
for(model.Plants a : GamePanel.Plant)
{
	ObjectStructure thisObj = new ObjectStructure();
	thisObj.PositionX = a.getXposition();
	thisObj.PositionY = a.getYposition();
	Plants.add(thisObj);
}

Bug.PositionX = GamePanel.Player.getXposition();
Bug.PositionY = GamePanel.Player.getYposition();

}

public void ConvertBack(AntPanel GamePanel)
{
ArrayList<model.Ants> Antsss = new ArrayList<model.Ants>();
ArrayList<Thread> AntThread = new ArrayList<Thread>();
for(int a =  0; a<this.Ants.size();a++)
{
model.Ants Ant = new model.Ants();
Ant.SetX(this.Ants.get(a).PositionX);
Ant.SetY(this.Ants.get(a).PositionX);
Ant.SetQueen(this.Ants.get(a).Queen);
Thread thisAnt = new Thread(Ant);
AntThread.add(thisAnt);
Antsss.add(Ant);
}
GamePanel.changeAnts(Antsss);
GamePanel.rechangeThread(AntThread);
model.Bug  thisBug = new model.Bug();
thisBug.SetPlayerPos(Bug.PositionX, Bug.PositionY);
GamePanel.setBug(thisBug);
ArrayList<model.Plants> thisPlants = new ArrayList<model.Plants>();
for(int a = 0 ; a<this.Plants.size();a++)
{
model.Plants thisPlaa = new model.Plants();
thisPlaa.SetX(this.Plants.get(a).PositionX);
thisPlaa.SetY(this.Plants.get(a).PositionX);
thisPlants.add(thisPlaa);
}
GamePanel.changePlants(thisPlants);

}

	
	
	

}
