package com.vli.game.elements;


import com.vli.game.behaviors.Mobility;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Tile extends GraphicalElement implements Mobility{

	private Paint paint;
	private Letter letter;
	private int lineID;
	private int columnID;
	
	public Tile(){
		super();
		this.paint = new Paint();
		this.paint.setColor(0xFFFF0000);
		this.paint.setStyle(Style.FILL);
	}
	
	@Override
	public boolean draw(Canvas canvas) {
		try {
			canvas.drawRect(bounds, paint);
			this.letter.updatePosition(bounds);
			this.letter.draw(canvas);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void moveToLeft(int offset) {
		
	}

	@Override
	public void moveToRight(int offset) {
		
	}

	@Override
	public void moveToTop(int offset) {
		
	}

	@Override
	public void moveToBottom(int offset) {
		
	}
	
	public void setBounds(int left, int top, int right, int bottom){
		this.bounds.set(left, top, right, bottom);
	}
	
	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public int getColumnID() {
		return columnID;
	}

	public void setColumnID(int columnID) {
		this.columnID = columnID;
	}

	public void setLetter(Letter randomLetter, int tileSize) {
		this.letter = randomLetter;
		this.letter.setSize(tileSize);
	}
	
	
}
