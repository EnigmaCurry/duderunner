package com.enigmacurry.duderunner.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	private static final float SIZE = 1f; //Blocks are the base unit size.
	
	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	
	public Block(Vector2 pos) {
		this.position = pos;
		this.bounds.height = getSize();
		this.bounds.width = getSize();
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public static float getSize() {
		return SIZE;
	}
}
