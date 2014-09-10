package com.vli.game.elements;

import com.vli.game.behaviors.Drawable;

import android.graphics.Rect;

public abstract class GraphicalElement implements Drawable{
	
	protected Rect bounds;
	
	public GraphicalElement(){
		this.bounds = new Rect();
	}

}
