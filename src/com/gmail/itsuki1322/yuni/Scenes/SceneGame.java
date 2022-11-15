package com.gmail.itsuki1322.yuni.Scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import com.gmail.itsuki1322.yuni.Game.Game;
public class SceneGame extends SceneDefault implements KeyListener
{

	public SceneGame(Game gameObject) 
	{
		super(gameObject);
		gameObject.addKeyListener(this);
		start();
	}
	
	void tick()
	{
		
	}
	
	void render()
	{
		BufferStrategy bs = gameObject.getBufferStrategy();
		if(bs == null)
		{
			gameObject.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		g.setColor(new Color(200, 19, 19));
		g.fillRect(0, 0, gameObject.WIDTH, gameObject.HEIGHT);
		g.dispose();
		//Scene Graphics
		
		//Scene Graphics
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, gameObject.WIDTH, gameObject.HEIGHT, null);
		bs.show();
	}

	void removeHandlers()
	{
		gameObject.removeKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			removeHandlers();
			stop();
			new SceneTitle(gameObject);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

