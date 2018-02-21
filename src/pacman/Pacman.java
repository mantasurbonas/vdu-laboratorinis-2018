package pacman;

public class Pacman {

	Coord pacmanCoord;
	
	public int dX = 1;
	public int dY = 0;
	
	public Pacman(int y, int x) {
		pacmanCoord = new Coord(y, x);
	}

	public Coord getNextPosition() {
		return new Coord(pacmanCoord.getY() + dY,  pacmanCoord.getX() + dX);
	}

	public void setPosition(Coord newCoord) {
		pacmanCoord.setY(newCoord.getY());
		pacmanCoord.setX(newCoord.getX());
	}

	public Coord getPosition() {
		return pacmanCoord;
	}

	public boolean isAt(int y, int x) {
		return y==pacmanCoord.getY() && x == pacmanCoord.getX();
	}


}
