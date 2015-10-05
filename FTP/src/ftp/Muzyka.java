/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ftp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author g41
 */
public class Muzyka {
    
    public static void music() throws IOException
    {
        
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream play = null;
    
    try 
    { 
        InputStream test = new FileInputStream("bell.wav"); 
        BGM = new AudioStream(test); 
        AudioPlayer.player.start(BGM); 

    } 
    catch(FileNotFoundException e){ 
        System.out.print(e.toString()); 
        System.out.print("\n");
    } 
    catch(IOException error) 
    { 
        System.out.print(error.toString()); 
        System.out.print("\n");
    } 
    
    }
}
