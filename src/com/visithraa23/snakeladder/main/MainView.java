package com.visithraa23.snakeladder.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.visithraa23.snakeladder.dto.Players;
import com.visithraa23.snakeladder.dto.SnakeLadder;
import com.visithraa23.snakeladder.screens.findminpathtowin.FindMinimumPathView;
import com.visithraa23.snakeladder.screens.playgame.PlayGameView;

public class MainView {

	static Scanner sc = new Scanner(System.in);

	public void getInput() throws InterruptedException {
		try {
			System.out.print("Enter the Size of Board : ");
			int size = sc.nextInt();
			int boardSize = size * size;
			System.out.println();

			System.out.print("Enter the Number of Snakes : ");
			int snakeCount = sc.nextInt();
			Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
			for (int i = 0; i < snakeCount; i++) {
				System.out.print("Enter the snake " + (i + 1) + " head and tail : ");
				snakes.put(sc.nextInt(), sc.nextInt());
			}
			System.out.println();

			System.out.print("Enter the Number of Ladders : ");
			int ladderCount = sc.nextInt();
			Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();
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
				players.add(new Players(sc.next(),0));
			}
			sc.nextLine();
			System.out.println();

			SnakeLadder snakeLadder = new SnakeLadder(boardSize, snakes, ladders, players);
			boolean condition = true;
			do {
				System.out.println("\n1.Start Play \n2.Find Minimum Path \n0.Exit");
				int input = sc.nextInt();
				switch (input) {
				case 1:{
					PlayGameView gameView=new PlayGameView();
					gameView.playGame(snakeLadder);
					break;
				}
				case 2:{
					FindMinimumPathView pathView=new FindMinimumPathView();
					pathView.findMinimum(snakeLadder);
					break;
				}	
				case 0: {
					condition = false;
					break;
				}
				default: {
					System.out.println("Enter valid input...");
				}
				}
			} while (condition);
		} catch (InputMismatchException e) {
			System.out.println("Enter Valid Input...");
		}
	}

}
