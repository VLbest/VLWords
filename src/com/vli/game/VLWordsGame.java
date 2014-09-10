package com.vli.game;

import java.util.LinkedList;

import com.vli.game.elements.Dictionary;
import com.vli.game.elements.Tile;
import com.vli.support.LOG;
import com.vli.views.GameView;

import android.content.Context;
import android.view.View;

public class VLWordsGame {
	
	private GameConfig config;
	private GameView gameView;
	private Dictionary dictionary;
	
	private int margin;
	private int totalTileNumber;
	private int tileSize;
	
	public VLWordsGame(GameConfig config, Context context) {
		this.config = config;
		this.margin = config.margin;
		this.totalTileNumber = config.tiles_in_x * config.tiles_in_y;
		this.tileSize = (config.getScreen_Width() - (((config.tiles_in_x) * margin)+margin)) / config.tiles_in_y;
		this.dictionary = new Dictionary(config.lang);
	}
	
	public void setView(View v){
		this.gameView = (GameView) v;
		this.gameView.setGame(this);
	}
	
	public LinkedList<Tile> createGrid() {
		LinkedList<Tile> tileList = new LinkedList<Tile>();
		
		int leftOffset = margin;
		int topOffset = margin;
		for(int y = 0; y < config.tiles_in_y; y++){
			for(int x = 0; x < config.tiles_in_x; x++){
				Tile t = new Tile();
				t.setBounds(leftOffset, topOffset, leftOffset + tileSize, topOffset + tileSize);
				t.setColumnID(x);
				t.setLineID(y);
				tileList.add(t);
				leftOffset = leftOffset + tileSize + margin;
				
			}
			leftOffset = margin;
			topOffset = topOffset + tileSize + margin;
		}
		this.postLetters(tileList);
		return tileList;
	}
	
	
	public boolean startGame(){
		try {
			this.gameView.setElementsToRender(this.createGrid());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void postLetters(LinkedList<Tile> tiles) {
		for(Tile t: tiles){
			t.setLetter(this.dictionary.getRandomLetter(), tileSize);
		}
	}
}
