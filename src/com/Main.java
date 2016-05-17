package com;

import com.game.GameScreen;
import com.heat.engine.game.Game;
import com.heat.engine.graphics.screen.ScreenManager;

public class Main extends Game {

	public static GameScreen game;
	
	private Main() {
		super(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.WINDOW_TITLE);
		
		ScreenManager.add(game = new GameScreen());
		
		enableDebugging(DEBUG_ALL);
		
		ScreenManager.setSelcted("GAME");
		
		start();
	}
	
	@Override
	public void draw() {
		
		ScreenManager.render(getDelta());
		
	}
	

	public static void main(String[] args) {
		new Main();
	}


}
