package com.game.entities;

import com.heat.engine.graphics.camera.Camera;

public class TestEntity extends Entity {

	public TestEntity(float x, float y) {
		setX(x);
		setY(y);
		setWidth(32);
		setHeight(48);
	}
	
	@Override
	public void draw(Camera camera) {
		super.draw(camera);

	
	}
	
}
