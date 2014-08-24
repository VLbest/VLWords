package com.vli.vlwords;

import com.vli.config.GameConfig;
import com.vli.dictionaries.Dictionary;
import com.vli.views.GameView;
import com.vli.views.InfoView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameActivity extends Activity{
	
	private GameView gameView;
	private InfoView infoView;
	private Dictionary dictionary;
	private GameLoop gameLoop;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.game_layout);
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        GameConfig.screenHeight = metrics.heightPixels;
        GameConfig.screenWidth = metrics.widthPixels;
        
        gameView = (GameView)findViewById(R.id.game_view);
        infoView = (InfoView)findViewById(R.id.info_view);
        gameLoop = new GameLoop(gameView);
        
        gameView.setFocusable(true);
        
        dictionary = new Dictionary();
        gameView.init();   
        gameView.createGrid();
        gameView.postLetters(dictionary);
        
        gameLoop.runViewRendering();
    }
}
