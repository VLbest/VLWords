package com.vli.game;

import com.vli.game.elements.Languages;

public class GameConfig {
	
	public final static int tiles_in_x = 8;
	public final static int tiles_in_y = 8;
	public final static int margin = 2;
	public final static int letter_margin = 15;
	public static Languages lang = Languages.ENGLISH;
	
	private int screen_Width;
	private int screen_Height;
	
	public GameConfig(){

	}

	public int getScreen_Width() {
		return screen_Width;
	}

	public void setScreen_Width(int screen_Width) {
		this.screen_Width = screen_Width;
	}

	public int getScreen_Height() {
		return screen_Height;
	}

	public void setScreen_Height(int screen_Height) {
		this.screen_Height = screen_Height;
	}
	
	
	
}