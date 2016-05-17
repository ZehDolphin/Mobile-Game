package com.game.entities;

import java.awt.Color;

import com.game.graphics.Drawable;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.math.Rectangle;

public abstract class Entity extends Rectangle implements Drawable {

	private String id = "undefined";
	
	public Entity() {
		super();
		
	}

	public Entity setID(String id) {
		this.id = id;
		return this;
	}
	
	public String getID() {
		return id;
	}
	
	@Override
	public void draw(Camera camera) {
		camera.setColor(Color.RED);
		camera.drawRect(this);
	}
	
}
