package com.visithraa23.snakeladder.screens.findminpathtowin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.visithraa23.snakeladder.dto.SnakeLadder;

public class FindMinimumPathViewModel {
	private FindMinimumPathView minimumPathView;

	public FindMinimumPathViewModel(FindMinimumPathView view) {
		minimumPathView = view;
	}

	public List<Integer> findMinimumPath(SnakeLadder snakeLadder) {
		int boardSize = snakeLadder.getBoardSize();

		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(new ArrayList<>());
		int currentPosition, newPosition;
		while (!queue.isEmpty()) {
			List<Integer> curr = queue.poll();
			int last = curr.isEmpty() ? 0 : curr.get(curr.size() - 1);
			if (last == boardSize) {
				return curr;
			}
			for (int i = 1; i <= 6; i++) {
				currentPosition = last + i;
				newPosition = updatePosition(currentPosition, snakeLadder);
				List<Integer> temp = new ArrayList<>(curr);
				temp.add(currentPosition);
				if (currentPosition != newPosition) {
					temp.add(newPosition);
				}
				queue.offer(temp);
			}
		}
		return new ArrayList<Integer>();
	}

	public int updatePosition(int position, SnakeLadder snakeLadder) {
		Map<Integer, Integer> ladders = snakeLadder.getLadders();
		Map<Integer, Integer> snakes = snakeLadder.getSnakes();

		if (snakes.containsKey(position)) {
			return snakes.get(position);
		} else if (ladders.containsKey(position)) {
			return ladders.get(position);
		}
		return position;
	}

}
