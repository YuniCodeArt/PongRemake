package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.gmail.itsuki1322.yuni.Game.Game;

public class Player extends Rectangle2D.Double
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean up = false, down = false;
	private int spd = 4;
	private Game gameObject;
	
	public Player(double x, double y, Game gameobject)
	{
		super(x, y, 16, 100);
		x = x - width;
		y = y - height;
		this.gameObject = gameobject;
	}
	
	public void tick()
	{
		if (up == true && !(y < gameObject.HEIGHT-gameObject.HEIGHT))
		{
			y -= spd;
		}
		else if (down == true && !(y > gameObject.HEIGHT-height))
		{
			y += spd;
		}
	}
	
	public void upToTrue()
	{
		up = true;
	}
	
	public void upToFalse()
	{
		up = false;
	}
	
	public void downToTrue()
	{
		down = true;
	}
	
	public void downToFalse()
	{
		down = false;
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(248, 248, 248));
		g.fill(this);
	}
	
}
