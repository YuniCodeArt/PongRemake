package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gmail.itsuki1322.yuni.Game.Game;

public class SelectTheModeText
{
	private Game gameObject;
	private Font bit8font;
	public SelectTheModeText(Game gameObject, Font bit8font)
	{
		this.gameObject = gameObject;
		this.bit8font = bit8font;
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(248, 248, 248));
		g.setFont(bit8font.deriveFont(70f));
		g.drawString("Select The Mode", gameObject.WIDTH/2-325, gameObject.HEIGHT/2-60);
	}
	
	public void deleteLogo()
	{
		bit8font = null;
	}
}
