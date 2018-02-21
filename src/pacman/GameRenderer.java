package pacman;

public class GameRenderer {
	
	GameMap gameMap;
	Pacman pacman; 
	Ghost ghost;
	
	public GameRenderer(GameMap gameMap, Pacman pacman, Ghost ghost){
		this.gameMap = gameMap;
		this.pacman = pacman;
		this.ghost = ghost;
	}
	
	void drawGame() {
		for (int y = 0; y<gameMap.getHeight(); y++){
			for (int x =0; x<gameMap.getWidth(); x++){
				if (gameMap.isWall(y, x)){
					System.out.print("#");
				}else
				if (pacman.isAt(y, x)){
					System.out.print("c");
				}else
				if (ghost.isAt(y, x)){
					System.out.print("X");
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
