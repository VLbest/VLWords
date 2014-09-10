package com.vli.views;

import java.util.LinkedList;

import com.vli.game.GameLoop;
import com.vli.game.TileListenner;
import com.vli.game.VLWordsGame;
import com.vli.game.elements.GraphicalElement;
import com.vli.game.elements.Tile;
import com.vli.support.LOG;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
	
	private SurfaceHolder holder;
	private GameLoop gameLoop;
	private VLWordsGame game;
	private LinkedList<Tile> elementsToRender;
	private TileListenner tileListenner;
	
	public GameView(Context context, AttributeSet attrs) {
	    super(context, attrs);
	    this.holder = this.getHolder();
	    this.holder.addCallback(this);
	    this.gameLoop = new GameLoop(this, holder);
	    this.tileListenner = new TileListenner(this);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		this.gameLoop.setRunning(true);
		this.gameLoop.start();
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		this.gameLoop.setSurfaceSize(width, height);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
        this.gameLoop.setRunning(false);
        while (retry) {
            try {
            	this.gameLoop.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
	}
	
	public void setElementsToRender(LinkedList<Tile> tileList){
		if(this.elementsToRender != null){
			this.elementsToRender = tileList;
		}else{
			this.elementsToRender = new LinkedList<Tile>();
			this.elementsToRender = tileList;
		}
	}
	
		
	public LinkedList<Tile> getElementsToRender() {
		return elementsToRender;
	}

	public void renderGameView(Canvas c){
		c.save();
		for(Tile t: this.elementsToRender){
			t.draw(c);
		}
		c.restore();
	}
	
	public void updateGameData(){
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		return true;
	}

	public void setGame(VLWordsGame vlWordsGame) {
		this.game = vlWordsGame;
	}

}
