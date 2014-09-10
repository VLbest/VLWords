package com.vli.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.vli.support.LOG;
import com.vli.views.GameView;

public class GameLoop extends Thread{
	private int targetFPS;
	private boolean running;
	private boolean paused;
	private double currentTime;
	private double lastUpdate;
	private double diff;
	private GameView view;
	private SurfaceHolder holder;
	private final Object mRunLock;
	
	public GameLoop(GameView gameView, SurfaceHolder holder) {
		this.targetFPS = 30;
		this.diff = 1000000000/this.targetFPS;
		this.running = true;
		this.paused = false;
		this.view = gameView;
		this.holder = holder;
		this.mRunLock = new Object();
	}
	
	
	public void run(){
		while(running){
			Canvas c = null;
			try{
				c = holder.lockCanvas(null);
				synchronized (holder) {
					if(!paused){
						this.view.updateGameData();
					}
					synchronized (mRunLock) {
						if(!paused){
							this.view.renderGameView(c);
						}
					}
				}
			}finally{
				if(c != null){
					holder.unlockCanvasAndPost(c);
				}
			}
		}
	}
	
	public void setRunning(boolean b) {
		synchronized (mRunLock) {
			running = b;
		}
	}


	public void setSurfaceSize(int width, int height) {
		
	}
}
