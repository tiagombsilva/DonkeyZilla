package org.academiadecodigo.codezillas.music;

import org.academiadecodigo.codezillas.Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


// Change this class to your liking, this is just a base example

public class GameMusic {
    private boolean playing;
    private Clip clip;

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void stopMusic(){
        clip.stop();
    }
    public void startGameMusic() {
        setPlaying(true);
        String pathStr = "resources/Nirvana8bit.wav";
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try {
            soundURL = Game.class.getResource(pathStr);
            if (soundURL == null) {
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
