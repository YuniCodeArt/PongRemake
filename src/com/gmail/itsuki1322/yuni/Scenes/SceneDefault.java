package com.gmail.itsuki1322.yuni.Scenes;

import java.awt.image.BufferedImage;

import com.gmail.itsuki1322.yuni.Game.Game;

public class SceneDefault implements Runnable
{

	private boolean isRunning;
	private Thread thread;
	public static int fps;
	protected BufferedImage layer;
	protected Game gameObject;
	
	public SceneDefault(Game gameObject)
	{
		this.gameObject = gameObject;
		layer = new BufferedImage(gameObject.WIDTH, gameObject.HEIGHT, BufferedImage.TYPE_INT_RGB);
	}
	

	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public synchronized void stop()
	{
		isRunning = false;
		try
		{
			thread.join();
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void tick()
	{
		
	}
	
	void render()
	{
		
	}
	
	public void run() 
	{
		gameObject.requestFocus();
		while(isRunning)
		{
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
