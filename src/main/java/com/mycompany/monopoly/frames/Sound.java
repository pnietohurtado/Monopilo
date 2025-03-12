/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author pablo
 */
public class Sound {
    
    Clip clip; 
    URL soundURL[] = new URL[1]; 
    
    
    public Sound(){
        soundURL[0] = getClass().getResource("/sonido/Music.wav"); 
    }
    
    
    public void setFile(int i){
        try{
            
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]); 
            
            clip = AudioSystem.getClip(); 
            
            clip.open(ais); 
        }catch(Exception e){
            
        }
    }
    
    public void play(){
        clip.start();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(){
        clip.stop();
    }
    
}
