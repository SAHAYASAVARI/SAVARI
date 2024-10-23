package minesweeper;
import java.util.*;

public class Minesweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean playGame = true;
		int play = 2;
		Scanner sc = new Scanner(System.in);
		
		while(playGame) {
			System.out.println("Enter \n 1. Play 2. Quit \n\n");
			play = sc.nextInt();
			
			switch(play) {
				case 1:
					Game.startGame();
					break;
				case 2:
					playGame = false;
					break;
				default:
					System.out.println("Enter Vlaid Option\n");
			}
		}
	}
}
