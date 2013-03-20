package com.enigmacurry.duderunner;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.enigmacurry.duderunner.screens.GameScreen;


public class DudeRunner extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new GameScreen());

	}

}
