package com.vi.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class Sprite {
	
	protected Rect bounds;
	protected Drawable image;
	protected int movingSpeed;
	protected Paint paint;
	protected Paint textPaint;
	
	public Sprite(){
		this.bounds = new Rect();
		this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		this.textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	}
	
	public Drawable getImage() {
		return image;
	}
	
	public void setImage(Drawable image) {
		this.image = image;
	}
	
	public int getMovingSpeed() {
		return movingSpeed;
	}

	public void setMovingSpeed(int movingSpeed) {
		this.movingSpeed = movingSpeed;
	}
	
	public abstract void doDraw(Canvas canvas);
	
}
