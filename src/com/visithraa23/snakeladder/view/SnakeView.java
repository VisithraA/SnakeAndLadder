package com.visithraa23.snakeladder.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.visithraa23.snakeladder.dto.Players;
import com.visithraa23.snakeladder.dto.SnakeLadder;
import com.visithraa23.snakeladder.viewModel.SnakeViewModel;

public class SnakeView {
	static Scanner sc = new Scanner(System.in);
	SnakeViewModel snakeViewModel;

	public SnakeView() {
		snakeViewModel = new SnakeViewModel(this);
	}

	public void getInput() throws InterruptedException {
		SnakeView snakeView = new SnakeView();
		System.out.print("Enter the Size of Board : ");
		int size = sc.nextInt();
		int boardSize = size * size;
		System.out.println();

		System.out.print("Enter the Number of Snakes : ");
		int snakeCount = sc.nextInt();
		Map<Integer, Integer> snakes = new HashMap();
		for (int i = 0; i < snakeCount; i++) {
			System.out.print("Enter the snake " + (i + 1) + " head and tail : ");
			snakes.put(sc.nextInt(), sc.nextInt());
		}
		System.out.println();

		System.out.print("Enter the Number of Ladders : ");
		int ladderCount = sc.nextInt();
		Map<Integer, Integer> ladders = new HashMap();
		for (int i = 0; i < ladderCount; i++) {
			System.out.print("Enter the ladder " + (i + 1) + " bottom and top : ");
			ladders.put(sc.nextInt(), sc.nextInt());
		}
		System.out.println();

		System.out.println("Enter the  no of Players and Names : ");
		int playersCount = sc.nextInt();
		List<Players> players = new ArrayList<>();
		for (int i = 0; i < playersCount; i++) {
			System.out.print("Enter Player" + (i + 1) + " : ");
			players.add(new Players(sc.next()));
		}
		sc.nextLine();
		System.out.println();

		SnakeLadder snakeLadder = new SnakeLadder(boardSize, snakes, ladders, players);
		System.out.println("\n\t\t\t.........Game Start............");
		System.out.println("Press enter to roll the dice.");
		snakeView.playGame(snakeLadder);

	}

	private void playGame(SnakeLadder snakeLadder) throws InterruptedException {
		label1: while (true) {
			for (Players player : snakeLadder.getPlayers()) {
				System.out.println("\n" + player.getName() + " : ");
				Thread.sleep(2000);
				sc.nextLine();
				int dice = snakeViewModel.rollDice();
				Boolean checkGame = snakeViewModel.updatePosition(dice, player, snakeLadder);
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
