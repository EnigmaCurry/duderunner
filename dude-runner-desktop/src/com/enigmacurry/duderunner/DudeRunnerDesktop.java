package com.enigmacurry.duderunner;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DudeRunnerDesktop {

	public static void main(String[] args){
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Dude Runner";
		cfg.useGL20 = false;
		cfg.width = 1080;
		cfg.height = 768;
		
		new LwjglApplication(new DudeRunner(), cfg);
	}
}
