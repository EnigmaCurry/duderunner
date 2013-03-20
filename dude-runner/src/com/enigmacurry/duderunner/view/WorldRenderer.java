package com.enigmacurry.duderunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import com.enigmacurry.duderunner.model.Block;
import com.enigmacurry.duderunner.model.Dude;
import com.enigmacurry.duderunner.model.World;

public class WorldRenderer {

	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;

	private World world;
	private OrthographicCamera camera;

	ShapeRenderer debugRenderer = new ShapeRenderer();

	private Texture dudeTexture;
	private Texture blockTexture;

	private SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis;
	private float ppuY; // pixels per unit on the Y axis;

	public void setSize(int w, int h) {
		width = w;
		height = h;
		ppuX = (float) width / CAMERA_WIDTH;
		ppuY = (float) height / CAMERA_HEIGHT;
		//Gdx.app.debug("Resize Event:", String.format(
		//		"{width: %d, height: %d, ppuX: %f, ppuY: %f}", width, height,
		//		ppuX, ppuY));
		Block block2 = world.getBlocks().get(1);
		//Gdx.app.debug("block2", String.format("width: %f, height: %f", Block.getSize() * ppuX, Block.getSize() * ppuY));
	}

	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.camera.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		loadTextures();
	}

	private void loadTextures() {
		dudeTexture = new Texture(Gdx.files.internal("images/block.png"));
		blockTexture = new Texture(Gdx.files.internal("images/block2.png"));
	}

	public void render() {
		spriteBatch.begin();
		drawBlocks();
		drawDude();
		spriteBatch.end();
		if (debug)
			drawDebug();
	}

	private void drawDude() {
		Dude dude = world.getDude();
		spriteBatch.draw(dudeTexture, dude.getPosition().x * ppuX,
				dude.getPosition().y * ppuY, Dude.getSize() * ppuX,
				Dude.getSize() * ppuY);
	}

	private void drawBlocks() {
		for (Block block : world.getBlocks()) {
			spriteBatch.draw(blockTexture, block.getPosition().x * ppuX,
					block.getPosition().y * ppuY, Block.getSize() * ppuX,
					Block.getSize() * ppuY);
		}
	}

	private void drawDebug() {
		// render blocks
		debugRenderer.setProjectionMatrix(camera.combined);
		debugRenderer.begin(ShapeType.Filled);
		for (Block block : world.getBlocks()) {
			Rectangle rect = block.getBounds();
			float x1 = block.getPosition().x + rect.x;
			float y1 = block.getPosition().y + rect.y;
			debugRenderer.setColor(new Color(1, 0, 0, 1));
			debugRenderer.rect(x1, y1, rect.width, rect.height);
		}
		// render Dude
		Dude dude = world.getDude();
		Rectangle rect = dude.getBounds();
		float x1 = dude.getPosition().x + rect.x;
		float y1 = dude.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
}
