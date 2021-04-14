package edu.CS542Project;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicSingleton {
    private static MusicSingleton instance = null;  // it can help memorize the data we have just created.
    private Clip clip = null;

    private MusicSingleton(){
        try {
            // Open an audio input stream.
            File soundFile = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\resources\\music.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            //this.clip = clip;
            // Open audio clip and load samples from the audio input stream.
            this.clip = clip;
            clip.open(audioIn);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);

            //clip.start();
            //clip.loop(Clip.LOOP_CONTINUOUSLY  );
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public synchronized static MusicSingleton getIntance(){  //static allows us to create in instance without creating an object
        if(instance == null){
            instance = new MusicSingleton();
        }
        return instance;
    }

    public void play(){
        if(clip == null)return;
        stop();
        //clip.setFramePosition(0);
        clip.start();
    }

    public void stop(){
        if(clip == null) {
            System.out.println("Music null in stop");
            clip.stop();
        }else{
            if(clip.isRunning())
            {
                clip.stop();
            }
            else
            {
                System.out.println("Music in stop");
            }
        }


    }

    public void close(){
        stop();
        if(clip == null) {
            System.out.println("Music null in close");
            clip.close();
        }else {
            clip.close();
        }
    }
}
