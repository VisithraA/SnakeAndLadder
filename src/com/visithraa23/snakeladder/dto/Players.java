package com.visithraa23.snakeladder.dto;

public class Players {

	private String name;
	private int position;

	public Players(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
