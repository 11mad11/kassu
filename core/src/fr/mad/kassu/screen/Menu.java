package fr.mad.kassu.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import fr.mad.kassu.Game;

public class Menu implements Screen {

	private Stage stage;
	private Table table;
	private TextButton playHost;
	private TextButton playJoin;
	private TextButton exit;

	public Menu(Game game, Skin skin) {
		stage = new Stage();
		table = new Table();
		playHost = new TextButton("Play Host", skin);
		playJoin = new TextButton("Play Join", skin);
		exit = new TextButton("Exit", skin);

		stage.addActor(table);

		table.setFillParent(true);

		table.center().add(playHost).row();
		table.add(playJoin).row();
		table.add(exit).row();

		game.add(stage);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	@Override
	public void pause() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void resume() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
	}

}
