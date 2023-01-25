package com.gmail.itsuki1322.yuni.Scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import com.gmail.itsuki1322.yuni.Game.Game;
import com.gmail.itsuki1322.yuni.GameObjects.Ball;
import com.gmail.itsuki1322.yuni.GameObjects.Player;

public class SceneLocalMultiplayer extends SceneDefault implements KeyListener
{
	Player player;
	Player player1;
	Ball ball;
	private Font bit8font;
	public SceneLocalMultiplayer(Game gameObject) 
	{
		super(gameObject);
		gameObject.addKeyListener(this);
		try 
		{
			 bit8font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/8bitfont.ttf"));
		} catch (IOException|FontFormatException e) 
		{
			System.out.println("Um erro ocorreu na hora de carregar a font.");
		}
		
		player = new Player(gameObject.WIDTH-50, 190, gameObject);
		player1 = new Player(32, 190, gameObject);
		ball = new Ball(gameObject.WIDTH/2, gameObject.HEIGHT/2);
		start();
	}
	
	void removeHandlers()
	{
		gameObject.removeKeyListener(this);
	}
	
	void tick()
	{
		player.tick();
		player1.tick();
		ball.tick();
	}
	
	void render()
	{
		BufferStrategy bs = gameObject.getBufferStrategy();
		if(bs == null)
		{
			gameObject.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) layer.getGraphics();
		g.setColor(new Color(19, 19, 19));
		g.fillRect(0, 0, gameObject.WIDTH, gameObject.HEIGHT);
		//Scene Graphics
		player.render(g);
		player1.render(g);
		ball.render(g);
		g.setColor(new Color(0, 248, 248));
		g.setFont(bit8font.deriveFont(40f));
		g.drawString("FPS: "+fps, 10, 40);
		//Scene Graphics
		g.dispose();
		g = (Graphics2D) bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, gameObject.WIDTH, gameObject.HEIGHT, null);
		bs.show();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.upToTrue();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			player1.upToTrue();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.downToTrue();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			player1.downToTrue();
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.upToFalse();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			player1.upToFalse();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.downToFalse();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			player1.downToFalse();
		}
	}
}
