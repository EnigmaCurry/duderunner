package com.enigmacurry.duderunner.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	Array<Block> blocks = new Array<Block>();
	private Dude dude;
	
	public Array<Block> getBlocks(){
		return blocks;
	}

	public Dude getDude() {
		return dude;
	}
	
	public World(){
		createDemoWorld();
	}

	private void createDemoWorld() {
		dude = new Dude(new Vector2(7, 2));
		
		//Hard code some block positions:
		for (int i=0; i<10; i++) {
			blocks.add(new Block(new Vector2(i, 0)));
			blocks.add(new Block(new Vector2(i, 1)));
		}
		
	}

	
}
