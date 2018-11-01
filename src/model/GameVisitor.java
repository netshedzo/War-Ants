package model;

public interface GameVisitor {
	public void draw(Plants a);
	public void draw(Ants a);
	public void draw(Bug a);

}
