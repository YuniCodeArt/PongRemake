package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.gmail.itsuki1322.yuni.Game.Game;

public class LocalMultiplayerButton extends Rectangle
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font bit8font;
	public Color buttonColor = new Color(248, 248, 248);
	private Game gameObject;
	public boolean clickable = false;
	
	public LocalMultiplayerButton(Game gameObject, Font bit8font)
	{
		super(0, 0, 350, 75);
		this.gameObject = gameObject;
		this.bit8font = bit8font;
		this.x = gameObject.WIDTH/2-width/2;
		this.y = gameObject.HEIGHT/2+height/2-40;
	}
	
	public void deleteButton()
	{
		bit8font = null;
		buttonColor = null;
	}
	
	private int calculatePercentage(int percent, int value)
	{
		int percentage = (int)(value*(percent/100.0f));
		
		return percentage;
	}	
	
	public void render(Graphics g)
	{
		g.setColor(buttonColor);
		g.fillRoundRect(gameObject.WIDTH/2-width/2, gameObject.HEIGHT/2+height/2-40, width, height, 10, 10);
		g.setColor(new Color(19, 19, 19));
		g.fillRoundRect(
				(gameObject.WIDTH/2-calculatePercentage(98, width)/2),
				gameObject.HEIGHT/2+calculatePercentage(95, height)/2+2-38,
				calculatePercentage(95, width+10),
				calculatePercentage(95, height),
				10, 10);
		g.setColor(buttonColor);
		g.setFont(bit8font.deriveFont(45f));
		g.drawString("Local", gameObject.WIDTH/2-calculatePercentage(98, width)/2, gameObject.HEIGHT/2+height/2-5);
		g.drawString("Multiplayer", gameObject.WIDTH/2-calculatePercentage(98, width)/2, gameObject.HEIGHT/2+height/2+25);
	}
}
