package pacman;

public class InputProcessor {

	Pacman pacman;
	
	public InputProcessor(Pacman pacman){
		this.pacman = pacman;
	}
	
	public void processUserInput(int userInput) {
		switch(userInput){
		case 'a': pacman.dX = -1; pacman.dY = 0; break;
		case 'd': pacman.dX =  1; pacman.dY = 0; break;
		case 's': pacman.dX =  0; pacman.dY = 1; break;
		case 'w': pacman.dX =  0; pacman.dY = -1; break;
		case 'q': System.exit(0);
		}
	}

	public void processUserInput(String userInput) {
		switch(userInput){
		case "A": pacman.dX = -1; pacman.dY = 0; break;
		case "D": pacman.dX =  1; pacman.dY = 0; break;
		case "S": pacman.dX =  0; pacman.dY = 1; break;
		case "W": pacman.dX =  0; pacman.dY = -1; break;
		case "Q": System.exit(0);
		}
	}

}
