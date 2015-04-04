package tankwar;

import CombatGame.Background;
import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;

/**
 *
 * @author Moaan
 */
public class DesertBackground extends TankWar implements Background {

    BufferedImage editableMap;
    Image map = getSprite("Resources/BackgroundFullBig2.png");
    URL url1 = TankWar.class.getResource("Resources/terminator_Theme.wav");
    AudioClip backgroundMusic = newAudioClip(url1);
    Boolean EndOfGameFlag = true;

    public void draw(Graphics2D g, ImageObserver obs) {
        g.drawImage(map, 0, 0, obs);
    }

    @Override
    public void playMusic() {
        backgroundMusic.loop();
    }

    @Override
    public void playGameOverMusic() {
        if (EndOfGameFlag) {
            backgroundMusic.stop();
            EndOfGameFlag = false;
        }
    }
}
