package com.vli.views;

import java.util.LinkedList;
import java.util.Random;

import com.vi.game.Directions;
import com.vi.game.Tile;
import com.vi.game.TileListenner;
import com.vli.config.GameConfig;
import com.vli.dictionaries.Dictionary;
import com.vli.vlwords.LOG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameView extends View{

	private LinkedList<Tile> tileList;
	private TileListenner tileListenner;
	private int margin;
	private int totalTileNumber;
	private int tileSize;
	protected Canvas canvas;

	public GameView(Context context, AttributeSet attrs) {
	    super(context, attrs);
	}	
	
	public void init() {
		this.tileList = new LinkedList<Tile>();
		this.tileListenner = new TileListenner(this);
		this.margin = GameConfig.MARGIN;
	    this.totalTileNumber = GameConfig.TILES_IN_X * GameConfig.TILES_IN_Y;
	    this.tileSize = (GameConfig.screenWidth - (((GameConfig.TILES_IN_X) * margin)+margin)) / GameConfig.TILES_IN_X;
	    this.canvas = new Canvas();
	    LOG.showInfoLog("Init done: ");
	    LOG.showInfoLog(GameConfig.screenWidth);
	}
	
	public void createGrid() {
		int leftOffset = margin;
		int topOffset = margin;
		for(int y = 0; y < GameConfig.TILES_IN_Y; y++){
			for(int x = 0; x < GameConfig.TILES_IN_X; x++){
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
	}
	
	
	@SuppressLint("WrongCall")
	public void render(){
		LOG.showInfoLog("render...");
		onDraw(canvas);
	}
	
	@Override
	public void draw(Canvas canvas) {
		LOG.showInfoLog("draw...");
		super.draw(canvas);
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		LOG.showInfoLog("drawing");
		//super.onDraw(canvas);
		canvas.save();
		for(Tile t: tileList){
			t.doDraw(canvas);
		}
		canvas.restore();
		
	}

	public void postLetters(Dictionary dictionary) {
		for(Tile t: tileList){
			t.setLetter(dictionary.getRandomLetter());
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();      
		LOG.showInfoLog("Event detected");
		
		if (action == MotionEvent.ACTION_DOWN) {
			LOG.showInfoLog("ACTION_DOWN");	
			this.listen(event);
			this.tileListenner.setListen(true);
            return true;

        } else if (action == MotionEvent.ACTION_UP) {
        	LOG.showInfoLog("ACTION_UP");
        	this.tileListenner.setListen(false);
            return true;
        }
		if(this.tileListenner.getSide() == Directions.NONE){
			LOG.showInfoLog("point 2");
			this.tileListenner.findSlideMotion(event);
		}
		if(this.tileListenner.isReady()){
			LOG.showInfoLog("point 4");
			this.moveTiles(this.tileListenner.getSpeed(), this.tileListenner.getActiveTilesIDs());
		}
		
		return true;
	}

	private void listen(MotionEvent event) {
		if(this.tileListenner.isListen() == false){
			LOG.showInfoLog("point 1");
			this.tileListenner.startTracking(event);
		}
	}

	private void moveTiles(int speed, LinkedList<Tile> activeTiles) {
		LOG.showInfoLog("moving");
		speed = 5;
		for(Tile t : activeTiles){
			t.moveInDirection(this.tileListenner.getSide(), speed);
		}
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getTotalTileNumber() {
		return totalTileNumber;
	}

	public void setTotalTileNumber(int totalTileNumber) {
		this.totalTileNumber = totalTileNumber;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public LinkedList<Tile> getTileList() {
		return tileList;
	}	
}
