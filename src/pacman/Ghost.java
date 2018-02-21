package pacman;

public class Ghost {
	
	Coord coord;
	
	public int dX = 0;
	public int dY = 1;
	
	public Ghost(int y, int x) {
		coord = new Coord(y, x);
	}

	public Coord getNextPosition() {
		return new Coord(coord.getY() + dY,  coord.getX() + dX);
	}

	public void setPosition(Coord newCoord) {
		coord.setY(newCoord.getY());
		coord.setX(newCoord.getX());
	}

	public Coord getPosition() {
		return coord;
	}

	public boolean isAt(int y, int x) {
		return y==coord.getY() && x == coord.getX();
	}

}
