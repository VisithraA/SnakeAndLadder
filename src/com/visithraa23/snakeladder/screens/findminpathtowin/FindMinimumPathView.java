package com.visithraa23.snakeladder.screens.findminpathtowin;

import java.util.List;
import java.util.Map;

import com.visithraa23.snakeladder.dto.SnakeLadder;

public class FindMinimumPathView {
	private FindMinimumPathViewModel pathViewModel;

	public FindMinimumPathView() {
		pathViewModel = new FindMinimumPathViewModel(this);
	}

	public void findMinimum(SnakeLadder snakeLadder) {
		List<Integer> list=pathViewModel.findMinimumPath(snakeLadder);
		Map<Integer,Integer> ladders=snakeLadder.getLadders();
		int count=0;
		for(int i=0;i<list.size();i++) {
			if(!ladders.containsKey(list.get(i))) {
				count++;
				System.out.print(list.get(i)+" ");
			}	
		}
		System.out.println("Minimum Steps to Win "+(++count));
	}

	public void printOut(String string) {
		System.out.println(string);
	}
	
//	Enter the Size of Board : 10
//
//	Enter the Number of Snakes : 6
//	Enter the snake 1 head and tail : 96 42
//	Enter the snake 2 head and tail : 37 3
//	Enter the snake 3 head and tail : 47 16
//	Enter the snake 4 head and tail : 29 10
//	Enter the snake 5 head and tail : 94 71
//	Enter the snake 6 head and tail : 75 32
//
//	Enter the Number of Ladders : 6
//	Enter the ladder 1 bottom and top : 41 79
//	Enter the ladder 2 bottom and top : 22 58
//	Enter the ladder 3 bottom and top : 4 56
//	Enter the ladder 4 bottom and top : 14 55
//	Enter the ladder 5 bottom and top : 12 50
//	Enter the ladder 6 bottom and top : 54 88er 2 bottom and top : 58 22

}
