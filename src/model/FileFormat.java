package model;

import java.util.ArrayList;

public class FileFormat {
	int Groups ; 
	ArrayList<String> QueenNames;
	int AntsCount ;
	int width ;
	int height ;
	int Plants;
	int Posx ;
	int Posy;
	
	 public void setGroups(int Group) {Groups = Group;}
	 public void setQueens(ArrayList<String> QueenName) {QueenNames = QueenName;}
	 public void setCount(int Count) {AntsCount =Count;}
	 public void setWidth(int width) {this.width = width;}
	 public void setPlants(int Plant) {Plants = Plant;}
	 public void setHeight(int height) {this.height = height;}
	 public void setX(int X) {Posx = X;}
	 public void setY(int Y) {Posy = Y;}
	 public int getGroups() {return Groups;}
	 public ArrayList<String> Queens() {return QueenNames;}
	 public int getWidth() {return width;}
	 public int getHeight() {return height;}
	 public int getCount() {return AntsCount;}
	 public int getPlants() {return Plants;}
	 public ArrayList<String> getQueen(){return QueenNames;}
	 public int getX() {return Posx;}
	 public int getY() {return Posy;}
	

}
