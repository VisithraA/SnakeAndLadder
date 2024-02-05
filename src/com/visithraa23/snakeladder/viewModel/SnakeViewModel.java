package com.visithraa23.snakeladder.viewModel;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.visithraa23.snakeladder.dto.Players;
import com.visithraa23.snakeladder.dto.SnakeLadder;
import com.visithraa23.snakeladder.view.SnakeView;

public class SnakeViewModel {
	SnakeView snakeView;

	public SnakeViewModel(SnakeView view) {
		snakeView = view;
	}

	public int rollDice() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public boolean updatePosition(int dice, Players player, SnakeLadder snakeLadder) {
		int boardSize = snakeLadder.getBoardSize();
		Map<Integer, Integer> snakes = snakeLadder.getSnakes();
		Map<Integer, Integer> ladders = snakeLadder.getLadders();
		List<Players> players = snakeLadder.getPlayers();

		int newPosition = dice + player.getPosition();
		if (newPosition <= boardSize) {
			if (snakes.containsKey(newPosition)) {
				snakeView.printOut(player.getName() + " rolled a dice " + dice + " and landed on snake. Moving down to "
						+ snakes.get(newPosition) + "\n");
				player.setPosition(snakes.get(newPosition));
			} else if (ladders.containsKey(newPosition)) {
				snakeView.printOut(player.getName() + " rolled a dice " + dice + " and landed on ladder. Moving up to "
						+ ladders.get(newPosition) + "\n");
				player.setPosition(ladders.get(newPosition));
			} else {
				snakeView.printOut(player.getName() + " rolled a dice " + dice + " and move to " + newPosition + "\n");
				player.setPosition(newPosition);
			}
		} else {
			snakeView.printOut(player.getName() + " rolled a dice " + dice + ". it goes outside the box");
		}

		if (player.getPosition() == boardSize)
			return false;

		return true;
	}
}
