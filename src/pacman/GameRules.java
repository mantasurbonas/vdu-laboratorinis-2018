package pacman;

public class GameRules {

	private GameMap gameMap;
	private Pacman pacman;
	private Ghost ghost;

	public GameRules(GameMap gameMap, Pacman pacman, Ghost ghost) {
		this.gameMap = gameMap;
		this.pacman = pacman;
		this.ghost = ghost;
	}

	public void moveGhost() {
		Coord next = ghost.getNextPosition();
		if (!gameMap.isWall(next.getY(), next.getX())){
			ghost.setPosition(next);
		}else{
			ghost.dX = -ghost.dX;
			ghost.dY = -ghost.dY;
		}
	}

	public void movePacman() {
		Coord newCoord = pacman.getNextPosition();	
		
		if (!gameMap.isWall(newCoord))
			pacman.setPosition(newCoord);
		
	}

	public boolean isPacmanEaten() {
		return pacman.getPosition().getX() == ghost.getPosition().getX() 
			&& pacman.getPosition().getY() == ghost.getPosition().getY();
	}
	

	public void gameOver() {
		System.out.println("Game over");
		System.exit(0);
	}
}
