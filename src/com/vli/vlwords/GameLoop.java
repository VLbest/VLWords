package com.vli.vlwords;

import com.vli.views.GameView;

import android.view.View;

public class GameLoop{
	
	private int targetFPS;
	private boolean running;
	private boolean paused;
	private double currentTime;
	private double lastUpdate;
	private double diff;
	private GameView gameView;
	
	public GameLoop(GameView gameView){
		this.targetFPS = 10;
		this.diff = 1000000000/this.targetFPS;
		this.gameView = gameView;
		this.running = true;
		this.paused = false;
	}
	
	public void runViewRendering(){
		Thread gameThread = new Thread(){
			public void run(){
				gameLoop();
			}
		};
		gameThread.start();
	}
	
	private void gameLoop(){
		while(running){
			currentTime = System.nanoTime();
			if(!paused){
				while(currentTime - lastUpdate > diff){
					this.drawGame();
					lastUpdate = currentTime;
				}
			}
		}	
	}
	
	public void drawGame(){
		this.gameView.render();
	}
	
}
