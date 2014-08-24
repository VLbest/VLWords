package com.vi.game;

import com.vli.vlwords.LOG;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;

public class Tile extends Sprite{

	private Letter letter;
	private int lineID;
	private int columnID;

	private TileStates currrentState;
	
	public Tile (){
		super();
		this.paint.setColor(0xFFFF0000);
		this.paint.setStyle(Style.FILL);
		this.textPaint.setColor(0xFFFFFFFF);
	}
	
	public Letter getLetter() {
		return letter;
	}
	
	public void setLetter(Letter newletter) {
		this.letter = newletter;
	}

	public TileStates getCurrrentState() {
		return currrentState;
	}

	public void setCurrrentState(TileStates newState) {
		this.currrentState = newState;
	}
	
	public void moveInDirection(Directions direction, int speed){
		if(direction == Directions.BOTTOM){
			this.bounds.bottom += this.bounds.bottom + speed;
			this.bounds.top += this.bounds.top + speed;
		}else if (direction == Directions.TOP) {
			this.bounds.bottom += this.bounds.bottom - speed;
			this.bounds.top += this.bounds.top - speed;
		}else if (direction == Directions.LEFT) {
			this.bounds.left += this.bounds.left - speed;
			this.bounds.right += this.bounds.right - speed;
		}else if (direction == Directions.RIGHT) {
			this.bounds.left += this.bounds.left + speed;
			this.bounds.right += this.bounds.right + speed;
		}
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

	@Override
	public void doDraw(Canvas canvas) {
		canvas.drawRect(bounds, paint);
		canvas.drawText(this.letter.getSymbol(), this.bounds.centerX(), this.bounds.centerY(), this.textPaint);
	}
	
}
