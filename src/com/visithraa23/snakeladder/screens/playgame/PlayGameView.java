package com.visithraa23.snakeladder.screens.playgame;

import java.util.Scanner;

import com.visithraa23.snakeladder.dto.Players;
import com.visithraa23.snakeladder.dto.SnakeLadder;

public class PlayGameView {
	static Scanner sc = new Scanner(System.in);
	PlayGameViewModel playGameViewModel;

	public PlayGameView() {
		playGameViewModel = new PlayGameViewModel(this);
	}

	public void playGame(SnakeLadder snakeLadder) throws InterruptedException {
		System.out.println("\n\t\t\t.........Game Start............");
		System.out.println("Press enter to roll the dice.");
		label1: while (true) {
			for (Players player : snakeLadder.getPlayers()) {
				System.out.println("\n" + player.getName() + " : ");
				Thread.sleep(2000);
				sc.nextLine();
				int dice = playGameViewModel.rollDice();
				int count=0;
				while(dice==6) {
					count++;
					dice+=playGameViewModel.rollDice();
					if(count==3) {
						dice=player.getPosition();
						break;
					}
				}
				Boolean checkGame = playGameViewModel.updatePosition(dice, player, snakeLadder);
				if (checkGame == false) {
					System.out.println(player.getName() + " wins the Game!....");
					break label1;
				}
			}
		}
	}

	public void printOut(String output) {
		System.out.println(output);
	}

}
