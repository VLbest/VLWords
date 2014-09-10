package com.vli.game.elements;

import com.vli.game.GameConfig;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class Letter extends GraphicalElement{

	private Paint paint;
	private char symbol;
	private int textSize;
	
	public Letter(char c) {
		super();
		this.paint = new Paint();
		this.paint.setColor(0xFFFFFFFF);
		this.symbol = c;
	}
	
	public String getSymbol() {
		return String.valueOf(symbol);
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public void updatePosition(Rect r){
		this.bounds.left = r.left + GameConfig.letter_margin;
		this.bounds.top = r.top + GameConfig.letter_margin;
		this.bounds.right = r.right - GameConfig.letter_margin;
		this.bounds.bottom = r.bottom - GameConfig.letter_margin;
	}

	@Override
	public boolean draw(Canvas canvas) {
		canvas.drawText(this.getSymbol(), this.bounds.left, this.bounds.bottom, this.paint);
		return false;
	}

	public void setSize(int tileSize) {
		this.textSize = tileSize - (GameConfig.letter_margin * 2);
		this.paint.setTextSize(textSize);
	}

}
