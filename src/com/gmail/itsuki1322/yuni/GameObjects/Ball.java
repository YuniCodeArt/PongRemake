package com.gmail.itsuki1322.yuni.GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class Ball extends RoundRectangle2D.Double
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ball(double x, double y)
	{
		super(x, y, 16, 16, 100, 100);
		
		x = x - width;
		y = y - height;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(248, 248, 248));
		g.fill(this);
	}
}
