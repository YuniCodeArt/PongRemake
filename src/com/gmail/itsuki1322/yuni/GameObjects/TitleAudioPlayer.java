package com.gmail.itsuki1322.yuni.GameObjects;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TitleAudioPlayer 
{
	Clip clip;
	AudioInputStream audioInputStream;
	
	public TitleAudioPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		InputStream bufferedIn = new BufferedInputStream(getClass().getResourceAsStream(filePath));
		audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
		
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public synchronized void stop()
	{
		clip.stop();
	}
}
