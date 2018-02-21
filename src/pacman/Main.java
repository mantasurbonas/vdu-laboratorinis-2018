package pacman;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		GameMap gameMap = new GameMap();
		Pacman pacman = new Pacman(10, 10);
		Ghost ghost = new Ghost(10, 7);
		
		GameRenderer renderer = new GameRenderer(gameMap, pacman, ghost);
		GameRules rules = new GameRules(gameMap, pacman, ghost);
		InputProcessor inputProcessor = new InputProcessor(pacman);
		
		while(true){
		
			if (rules.isPacmanEaten())
				rules.gameOver();
			
			rules.movePacman();
			rules.moveGhost();
			
			renderer.drawGame();
			
			int userInput = System.in.read();
			inputProcessor.processUserInput(userInput);
		}
	}

}
