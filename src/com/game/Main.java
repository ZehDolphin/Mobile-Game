package com.game;

import com.heat.engine.game.Game;

public class Main extends Game {

	public Main() {
		super(1280, 720, "Game shit game!");
		
		start();
	}
	
	@Override
	public void draw() {
		
	}
	

	public static void main(String[] args) {
		new Main();
	}


}
