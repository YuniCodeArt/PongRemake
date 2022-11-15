package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.gmail.itsuki1322.yuni.Game.Game;

public class StartButton extends Rectangle
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game gameObject;
	private Font bit8font;
	public Color buttonColor;
	public boolean clickable = false;
	private int calculatePercentage(int percent, int value)
	{
		int percentage = (int)(value*(percent/100.0f));
		
		return percentage;
		
	}	
	public StartButton(Game gameObject, Font bit8font)
	{
		super(0, 0, 200, 40);
		this.gameObject = gameObject;
		this.bit8font = bit8font; 
		buttonColor = new Color(248, 248, 248);
		this.x = gameObject.WIDTH/2-width/2;
		this.y = gameObject.HEIGHT/2+height/2+50;
	}
	
	public void render(Graphics g)
	{
		g.setColor(buttonColor);
		g.fillRoundRect(gameObject.WIDTH/2-width/2, gameObject.HEIGHT/2+height/2+50, width, height, 10, 10);
		g.setColor(new Color(19, 19, 19));
		g.fillRoundRect(
				((gameObject.WIDTH/2)-(calculatePercentage(95, width)/2)),
				gameObject.HEIGHT/2+calculatePercentage(95, height)/2+2+50,
				calculatePercentage(95, width),
				calculatePercentage(95, height),
				10, 10);
		g.setColor(buttonColor);
		g.setFont(bit8font.deriveFont(45f));
		g.drawString("PLAY", gameObject.WIDTH/2-65, gameObject.HEIGHT/2+height/2+85);
	}
}
