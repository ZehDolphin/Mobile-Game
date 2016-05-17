package com.game.entities;

import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.graphics.image.Texture;

public class Static extends Entity {

	private Texture texture;
	
	public float rotation = 0.0f;
	
	public Static(float x, float y, float width, float height, Texture texture) {
		this.texture = texture;
		setBounds(x, y, width, height);
	}

	@Override
	public void draw(Camera camera) {

		if (texture != null)
			camera.drawTexture(texture, getX(), getY(), getWidth(), getHeight(), rotation);
		else
			super.draw(camera);
	}

}
