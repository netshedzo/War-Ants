package model;

import java.util.ArrayList;

public interface AbstractSubject {
	public void dettach(AbstractPlantObserver Pal);
	public void attach(ArrayList<AbstractPlantObserver> Pal);
	public void NotifyPlants();
	public Object getUpdate(AbstractPlantObserver obj);

}
