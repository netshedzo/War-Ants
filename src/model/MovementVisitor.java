package model;

public interface MovementVisitor {
	public void Move(Bug a);
	public void Move(Ants a);

}
