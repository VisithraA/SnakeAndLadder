package com.visithraa23.snakeladder.dto;

import java.util.List;
import java.util.Map;

public class SnakeLadder {
	private int boardSize;
	private Map<Integer, Integer> snakes;
	private Map<Integer, Integer> ladders;
	private List<Players> players;

	public SnakeLadder(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders,
			List<Players> players) {
		this.boardSize = boardSize;
		this.snakes = snakes;
		this.ladders = ladders;
		this.players = players;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public List<Players> getPlayers() {
		return players;
	}
	
	
}
