package CombatGame;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

/**
 * draws the background and any background objects too
 * @author Moaan
 */
public interface Background {
    void draw(Graphics2D g, ImageObserver obs);
    void playMusic();
    void playGameOverMusic();
}
