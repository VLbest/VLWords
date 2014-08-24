package com.vi.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class Letter{

	private char symbol;
	
	public Letter() {
		super();
	}
	
	public Letter(char smb) {
		super();
		this.symbol = smb;
	}
	
	public String getSymbol() {
		return String.valueOf(symbol);
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
