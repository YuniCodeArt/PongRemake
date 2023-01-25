package com.gmail.itsuki1322.yuni.Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.gmail.itsuki1322.yuni.Scenes.SceneTitle;

public class Game extends Canvas
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int WIDTH = 720, HEIGHT = 480;
	public JFrame frame;
	public Game()
	{
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initFrame();
	}
	public static void main(String[] args)
	{
		Game game = new Game();
		new SceneTitle(game);
	}
	
	
	private void initFrame()
	{
		frame = new JFrame("Pong by Yuni!");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
