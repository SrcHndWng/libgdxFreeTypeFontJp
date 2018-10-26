package com.mygdx.freetypetontjp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.Color;

public class MyGdxGame extends ApplicationAdapter {
	FreeTypeFontGenerator fontGenerator;
	BitmapFont bitmapFont;
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		FileHandle file = Gdx.files.local("font/NotoSansCJKjp-Bold.otf");
		fontGenerator = new FreeTypeFontGenerator(file);

		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = 32;
		param.color = Color.CYAN;
		param.borderColor = Color.RED;
		param.borderWidth = 2;
        param.shadowColor = Color.BLUE;
        param.shadowOffsetX = 3;
        param.shadowOffsetY = 3;
        param.incremental = true;

		bitmapFont = fontGenerator.generateFont(param);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		bitmapFont.draw(batch, "ABCDabcd\n1234567890\n@+!#$\nあいうえお", 50, 300);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bitmapFont.dispose();
		fontGenerator.dispose();
	}
}
