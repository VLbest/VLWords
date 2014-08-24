package com.vli.dictionaries;

import java.util.LinkedList;
import java.util.Random;

import com.vi.game.Letter;
import com.vli.config.GameConfig;

public class Dictionary {

	private Languages Current_Lang;
	private LinkedList<Letter> letters;
	private Random rnd;
	
	public Dictionary(){
		this.Current_Lang = GameConfig.lang;
		rnd = new Random();
		letters = new LinkedList<Letter>();
		this.setupLetters();
	}

	private void setupLetters() {
		switch (this.Current_Lang) {
		case ENGLISH:
			this.createLettersWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			break;
		case RUSSIAN:
			
			break;
		case FRENCH:
	
	break;

		default:
			break;
		}
	}

	private void createLettersWith(String string) {
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			letters.add(new Letter(c));
		}
	}

	public Letter getRandomLetter() {
		int size = letters.size();
		return this.letters.get(this.rnd.nextInt(size));
	}
}
