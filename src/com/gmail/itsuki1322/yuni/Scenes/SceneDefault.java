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
	
	double updateEstimate(double observed)
	{
		double mean = 5;
		double m2 = 0;
		int count = 1;
		
		double delta = observed - mean;
		count += 1;
		mean += delta / count;
		m2 += delta * (observed - mean);
		double stddev = Math.sqrt(m2 / (count-1));
		return mean + 1 * stddev;
	}
	
	void spinLock(double time)
	{
		double start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start) < time);
	}
	
	void preciseSleep(double time)
	{
		double estimate = 0;
		while (time > estimate)
		{
			double start = System.currentTimeMillis();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double observed = System.currentTimeMillis() - start;
			time -= observed;
			estimate = updateEstimate(observed);
		}
		spinLock(time);
	}
	
	public void run() 
	{
		gameObject.requestFocus();
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning)
		{
			tick();
			render();
			preciseSleep(1000/120);
			frames++;
			if (System.currentTimeMillis() - timer > 1000)
			{
				fps = frames;
				timer += 1000;
				frames = 0;
			}
		}
	}
}
