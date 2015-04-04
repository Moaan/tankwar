package CombatGame;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author Moaan
 */
public interface Projectile {
    public boolean collision(int x, int y, int w, int h);
    boolean move();
    public void draw(Graphics g, ImageObserver obs);
}
