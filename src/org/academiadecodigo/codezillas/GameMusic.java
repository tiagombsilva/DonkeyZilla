package org.academiadecodigo.codezillas;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

class GameMusic {
    private Clip clip;

    void stopMusic() {
        clip.stop();
    }

    void play(String path) {
        URL soundURL;
        AudioInputStream audioInputStream = null;

        try {
            soundURL = Game.class.getResource(path);

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
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

