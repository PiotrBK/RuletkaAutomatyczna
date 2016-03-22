package com.blinddealercasino;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Sound implements Runnable {


	Boolean graMuzyka;
	
	
	public Sound(){
		
	}
	
	public void setGraMuzyka(Boolean wartosc){
		graMuzyka = wartosc;
	}

	public void run() {
		while (graMuzyka == true){
				int i =1;
				try{
					InputStream in = new FileInputStream("sound"+Integer.toString(i)+".wav");					
					AudioStream as = new AudioStream(in);
				
					AudioPlayer.player.start(as);
					
					
					
				//} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				//} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
		
				}
			}
		
		}
	}



