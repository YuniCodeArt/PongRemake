package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gmail.itsuki1322.yuni.Game.Game;

public class Logo 
{
	private Game gameObject;
	private Font bit8font;
	public Logo(Game gameObject, Font bit8font)
	{
		this.gameObject = gameObject;
		this.bit8font = bit8font;
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(248, 248, 248));
		g.setFont(bit8font.deriveFont(200f));
		g.drawString("PONG", gameObject.WIDTH/2-270, gameObject.HEIGHT/2);
	}
	
}
