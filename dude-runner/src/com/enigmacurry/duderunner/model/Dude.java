package com.enigmacurry.duderunner.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dude {

	public enum State {
		IDLE, WALKING, JUMPING, DEAD
	}
	
	private static final float SPEED = 2f; //units per second
	static final float JUMP_VELOCITY = 1f;
	static final float SIZE = 0.5f; //Dude is half a unit tall/wide.
	
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	State state = State.IDLE;
	
	boolean facingLeft = true;

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return bounds;
	}
	
	public Dude(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}

	public static float getSize() {
		return SIZE;
	}

	public void update(float delta) {
		position.add(velocity.mul(delta));
		
	}

	public void setFacingLeft(boolean b) {
		facingLeft = b;		
	}

	public static float getSpeed() {
		return SPEED;
	}
	
}
