package com.game;

import java.awt.Color;

import com.Settings;
import com.game.entities.TestEntity;
import com.game.world.World;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.graphics.screen.Screen;
import com.heat.engine.input.Mouse;

/**
 * Game class.
 * 
 * @author Pontus Wirsching
 * @since 2015-05-15
 */
public class GameScreen extends Screen {

	private Camera camera;
	
	World world;
	
	public GameScreen() {
		super("GAME");

		camera = new Camera(Settings.CAMERA_VIEWPORT_WIDTH, Settings.CAMERA_VIEWPORT_HEIGHT);
		Mouse.fit(camera);

		world = new World("worlds/overworld.xml", "textures/overworld");
		
	}

	@Override
	public void draw(float delta) {

		world.draw(camera);
		
	}

	@Override
	public void resize(float width, float height) {
		camera.adaptTo(Settings.CAMERA_VIEWPORT_WIDTH, Settings.CAMERA_VIEWPORT_HEIGHT);
	}

}
