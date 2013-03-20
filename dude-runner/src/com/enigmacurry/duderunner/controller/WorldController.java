package com.enigmacurry.duderunner.controller;

import java.util.HashMap;
import java.util.Map;

import com.enigmacurry.duderunner.model.Dude;
import com.enigmacurry.duderunner.model.Dude.State;
import com.enigmacurry.duderunner.model.World;

public class WorldController {

	enum Keys {
		LEFT, RIGHT
	}
	
	private World world;
	private Dude dude;
	
	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
	}
	
	public WorldController(World world) {
		this.world = world;
		this.dude = world.getDude();
	}
	
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	/** The main update method **/
	public void update(float delta) {
		processInput();
		dude.update(delta);
	}

	/** Change Bob's state and parameters based on input controls **/
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			dude.setFacingLeft(true);
			dude.setState(State.WALKING);
			dude.getVelocity().x = -Dude.getSpeed();
		}
		if (keys.get(Keys.RIGHT)) {
			// left is pressed
			dude.setFacingLeft(false);
			dude.setState(State.WALKING);
			dude.getVelocity().x = Dude.getSpeed();
		}
		// need to check if both or none direction are pressed, then Bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
				(!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT)))) {
			dude.setState(State.IDLE);
			// acceleration is 0 on the x
			dude.getAcceleration().x = 0;
			// horizontal speed is 0
			dude.getVelocity().x = 0;
		}
	}
}
