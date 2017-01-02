package fr.mad.kassu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.kotcrab.vis.ui.VisUI;

import fr.mad.kassu.asset.AssetManager;
import fr.mad.kassu.screen.Menu;

public class Game extends com.badlogic.gdx.Game {
	public SpriteBatch batch;
	public ShapeRenderer sr;
	public AssetManager am;
	private Array<Disposable> disposables = new Array<>();

	@Override
	public void create() {
		/// init some util object
		batch = new SpriteBatch();
		disposables.add(batch);
		sr = new ShapeRenderer();
		disposables.add(sr);
		/// load VisUI
		VisUI.load();
		/// set menu screen
		setScreen(new Menu(this, VisUI.getSkin()));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose() {
		for (Disposable d : disposables) {
			d.dispose();
		}
	}

	public void add(Disposable... dis) {
		disposables.addAll(dis);
	}
}
