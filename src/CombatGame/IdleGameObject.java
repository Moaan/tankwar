package CombatGame;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author Moaan
 */
public interface IdleGameObject {
    void update();
    void draw(Graphics g, ImageObserver obs);
}
