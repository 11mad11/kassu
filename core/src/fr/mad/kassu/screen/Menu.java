package fr.mad.kassu.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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

		table.center().add(playHost).fillX().row();
		table.add(playJoin).fillX().row();
		table.add(exit).fillX().row();
		
		playHost.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//TODO server
			}
		});
		playJoin.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//TODO client
			}
		});
		exit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();//TODO check if it is a better way
			}
		});
		
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
