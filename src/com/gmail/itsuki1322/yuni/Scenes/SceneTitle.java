package com.gmail.itsuki1322.yuni.Scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gmail.itsuki1322.yuni.Game.Game;
import com.gmail.itsuki1322.yuni.GameObjects.Logo;
import com.gmail.itsuki1322.yuni.GameObjects.StartButton;
import com.gmail.itsuki1322.yuni.GameObjects.TitleAudioPlayer;
public class SceneTitle extends SceneDefault implements KeyListener, MouseListener, MouseMotionListener
{
	private Font bit8font;
	private StartButton startButton;
	private Logo logo;
	private TitleAudioPlayer titlemusic;
	public SceneTitle(Game gameObject)
	{
		super(gameObject);
		gameObject.addKeyListener(this);
		gameObject.addMouseListener(this);
		gameObject.addMouseMotionListener(this);
		try 
		{
			 bit8font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/8bitfont.ttf"));
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(bit8font);
		} catch (IOException|FontFormatException e) 
		{
			System.out.println("Um erro ocorreu");
		}
		startButton = new StartButton(gameObject, bit8font);
		logo = new Logo(gameObject, bit8font);
		try {
			titlemusic = new TitleAudioPlayer("/titlemusic.wav");
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		g.setColor(new Color(19, 19, 19));
		g.fillRect(0, 0, gameObject.WIDTH, gameObject.HEIGHT);
		//Scene Graphics
		logo.render(g);
		startButton.render(g);
		//Scene Graphics
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, gameObject.WIDTH, gameObject.HEIGHT, null);
		bs.show();
	}

	void removeHandlers()
	{
		gameObject.removeKeyListener(this);
		gameObject.removeMouseListener(this);
		gameObject.removeMouseMotionListener(this);
	}
	

	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void keyPressed(KeyEvent e) 
	{
		
	}

	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (startButton == null)
		{
			return;
		}
		if (mouseX > startButton.getMinX() && mouseX < startButton.getMaxX() && 
				mouseY > startButton.getMinY() && mouseY < startButton.getMaxY())
	    {
			startButton.buttonColor = new Color(100, 100, 100);
			startButton.clickable = true;
	    }
		else if(!(mouseX > startButton.getMinX() && mouseX < startButton.getMaxX() && 
				mouseY > startButton.getMinY() && mouseY < startButton.getMaxY()) && startButton.clickable == true)
		{
			startButton.buttonColor = new Color(248, 248, 248);
			startButton.clickable = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		if (startButton.clickable == true && e.getButton() == 1) 
		{
			removeHandlers();
			titlemusic.stop();
			stop();	
			new SceneGame(gameObject);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
