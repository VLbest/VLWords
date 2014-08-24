package com.vi.game;

import java.util.LinkedList;

import com.vli.views.GameView;
import com.vli.vlwords.LOG;

import android.view.MotionEvent;

public class TileListenner {
	
	private GameView tileHolder;
	private LinkedList<Tile> activeTiles;
	private int x;
	private int y; 
	private int last_x;
	private int last_y;
	private Directions side;
	private int speed;
	private int activeColumnID;
	private int activeLineID;
	private boolean isListen;
	
	public TileListenner(GameView gameView) {
		this.activeTiles = new LinkedList<Tile>();
		this.tileHolder = gameView;
		this.isListen = false;
	}

	public void startTracking(MotionEvent event){
		this.resetListener();
		this.x = (int) event.getX();
		this.y = (int) event.getY();
		this.findElementInAction();
	}
	
	private void findElementInAction(){
		this.activeColumnID = (this.y - tileHolder.getMargin()) / tileHolder.getTileSize();
		this.activeLineID = (this.x - tileHolder.getMargin()) / tileHolder.getTileSize();
	}
	
	public void findSlideMotion(MotionEvent event) {
		this.last_x = this.x;
		this.last_y = this.y;
		this.x = (int) event.getX();
		this.y = (int) event.getY();
		this.checkSide();
		this.findActiveTiles();
	}
	
	private void findActiveTiles() {
		LOG.showInfoLog("Looking for active tiles");
		if(this.side == Directions.RIGHT || this.side == Directions.LEFT){
			for(Tile t: this.tileHolder.getTileList()){
				if(t.getLineID() == this.activeLineID){
					this.activeTiles.add(t);
				}
			}
		}else if (this.side == Directions.BOTTOM || this.side == Directions.TOP) {
			for(Tile t: this.tileHolder.getTileList()){
				if(t.getColumnID() == this.activeColumnID){
					this.activeTiles.add(t);
				}
			}
		}
	}

	private void checkSide() {
		if(this.x > this.last_x){
			this.side = Directions.RIGHT;
		}else if (this.x < this.last_x) {
			this.side = Directions.LEFT;
		}else if (this.y > this.last_y) {
			this.side = Directions.BOTTOM;
		}else if (this.y < this.last_y) {
			this.side = Directions.TOP;
		}else {
			this.side = Directions.NONE;
		}
	}
	
	private void resetListener(){
		this.x = -1;
		this.y = -1;
		this.last_x = -1;
		this.last_y = -1;
		this.side = Directions.NONE;
		this.activeColumnID = -1;
		this.activeLineID = -1;
		this.speed = 0;
		this.activeTiles.clear();
	}

	public boolean isListen() {
		return isListen;
	}
	
	public boolean isReady() {
		if(this.isListen == true && this.side != Directions.NONE ){
			return true;
		}
		return false;
	}

	public void setListen(boolean isListen) {
		this.isListen = isListen;
	}
	
	public LinkedList<Tile> getActiveTilesIDs() {
		return activeTiles;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLast_x() {
		return last_x;
	}
	public void setLast_x(int last_x) {
		this.last_x = last_x;
	}
	public int getLast_y() {
		return last_y;
	}
	public void setLast_y(int last_y) {
		this.last_y = last_y;
	}
	public Directions getSide() {
		return side;
	}
	public void setSide(Directions side) {
		this.side = side;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
