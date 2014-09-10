package com.vli.activities;

import com.vli.game.GameConfig;
import com.vli.game.VLWordsGame;
import com.vli.support.LOG;
import com.vli.views.GameView;
import com.vli.vlwords.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class GameActivity extends Activity{
	
	private VLWordsGame game;
	private GameConfig config;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.game_layout);
        
        this.config = new GameConfig();
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        this.config.setScreen_Height(metrics.heightPixels);
        this.config.setScreen_Width(metrics.widthPixels);
        
        this.game = new VLWordsGame(config, this);
        this.game.setView(findViewById(R.id.game_view));
        
        this.game.startGame();
    }
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}
