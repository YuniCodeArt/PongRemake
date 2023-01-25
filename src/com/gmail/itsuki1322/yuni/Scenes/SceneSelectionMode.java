package com.gmail.itsuki1322.yuni.Scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import com.gmail.itsuki1322.yuni.Game.Game;
import com.gmail.itsuki1322.yuni.GameObjects.LocalMultiplayerButton;
import com.gmail.itsuki1322.yuni.GameObjects.OnlineMultiplayerButton;
import com.gmail.itsuki1322.yuni.GameObjects.SelectTheModeText;
public class SceneSelectionMode extends SceneDefault implements MouseListener, MouseMotionListener
{

	private LocalMultiplayerButton localMultiplayerButton;
	private OnlineMultiplayerButton onlineMultiplayerButton;
	private SelectTheModeText selectTheModeText;
	private Font bit8font;
	public SceneSelectionMode(Game gameObject) 
	{
		super(gameObject);
		gameObject.addMouseListener(this);
		gameObject.addMouseMotionListener(this);
		try 
		{
			 bit8font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/8bitfont.ttf"));
		} catch (IOException|FontFormatException e) 
		{
			System.out.println("Um erro ocorreu na hora de carregar a font.");
		}
		
		localMultiplayerButton = new LocalMultiplayerButton(gameObject, bit8font);
		onlineMultiplayerButton = new OnlineMultiplayerButton(gameObject, bit8font);
		selectTheModeText = new SelectTheModeText(gameObject, bit8font);
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
		
		Graphics2D g = (Graphics2D) layer.getGraphics();
		g.setColor(new Color(19, 19, 19));
		g.fillRect(0, 0, gameObject.WIDTH, gameObject.HEIGHT);
		//Scene Graphics
		localMultiplayerButton.render(g);
		onlineMultiplayerButton.render(g);
		selectTheModeText.render(g);
		g.setColor(new Color(248, 248, 248));
		g.setFont(bit8font.deriveFont(40f));
		g.drawString("FPS: "+fps, 10, 40);
		//Scene Graphics
		g.dispose();
		g = (Graphics2D) bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, gameObject.WIDTH, gameObject.HEIGHT, null);
		bs.show();
	}

	void removeHandlers()
	{
		gameObject.removeMouseListener(this);
		gameObject.removeMouseMotionListener(this);
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
		//Verify Local Multiplayer Button is clickable
		if (localMultiplayerButton == null)
		{
			return;
		}
		if (mouseX > localMultiplayerButton.getMinX() && mouseX < localMultiplayerButton.getMaxX() && 
				mouseY > localMultiplayerButton.getMinY() && mouseY < localMultiplayerButton.getMaxY())
	    {
			localMultiplayerButton.buttonColor = new Color(100, 100, 100);
			localMultiplayerButton.clickable = true;
	    }
		else if(!(mouseX > localMultiplayerButton.getMinX() && mouseX < localMultiplayerButton.getMaxX() && 
				mouseY > localMultiplayerButton.getMinY() && mouseY < localMultiplayerButton.getMaxY()) && localMultiplayerButton.clickable == true)
		{
			localMultiplayerButton.buttonColor = new Color(248, 248, 248);
			localMultiplayerButton.clickable = false;
		}
		//Verify Online Multiplayer Button is clickable
		if (onlineMultiplayerButton == null)
		{
			return;
		}
		if (mouseX > onlineMultiplayerButton.getMinX() && mouseX < onlineMultiplayerButton.getMaxX() && 
				mouseY > onlineMultiplayerButton.getMinY() && mouseY < onlineMultiplayerButton.getMaxY())
	    {
			onlineMultiplayerButton.buttonColor = new Color(100, 100, 100);
			onlineMultiplayerButton.clickable = true;
	    }
		else if(!(mouseX > onlineMultiplayerButton.getMinX() && mouseX < onlineMultiplayerButton.getMaxX() && 
				mouseY > onlineMultiplayerButton.getMinY() && mouseY < onlineMultiplayerButton.getMaxY()) && onlineMultiplayerButton.clickable == true)
		{
			onlineMultiplayerButton.buttonColor = new Color(248, 248, 248);
			onlineMultiplayerButton.clickable = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (localMultiplayerButton == null)
		{
			return;
		}
		
		if (localMultiplayerButton.clickable == true && e.getButton() == 1)
		{
			removeHandlers();
			stop();
			new SceneLocalMultiplayer(gameObject);
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

