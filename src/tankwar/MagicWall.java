package tankwar;

import CombatGame.IdleGameObject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author Moaan
 */
public class MagicWall extends TankWar implements IdleGameObject {

    Image wallImage = getSprite("Resources/Wall2.png");
    int x, y, width, height, invisibleTime, timeCounter;
    boolean isVisible;

    MagicWall(int x, int y) {
        this.x = x;
        this.y = y;
        width = wallImage.getWidth(null);
        height = wallImage.getHeight(null);
        isVisible = true;
        invisibleTime = 600;
        timeCounter = 0;
    }

    @Override
    public void update() {
        if (isVisible) {
            for (int i = 0; i < tankLBullets.size(); i++) {
                if (tankLBullets.get(i).collision(x + 20, y, width - 20, height)) {
                    isVisible = false;
                    explosionSound_2.play();
                }
            }
            for (int i = 0; i < tankRBullets.size(); i++) {
                if (tankRBullets.get(i).collision(x + 20, y, width - 20, height)) {
                    isVisible = false;
                    explosionSound_2.play();
                }
            }
        } else {
            timeCounter++;
            if ((timeCounter >= invisibleTime) && (!Enemy[1].collision(x, y, width, height)) && (!Enemy[2].collision(x, y, width, height))) {
                isVisible = true;
                timeCounter = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g, ImageObserver obs) {
        if (isVisible) {
            g.drawImage(wallImage, x, y, observer);
        }
    }

    public boolean collision(int oX, int oY, int oW, int oH) {
        if (isVisible) {
            if ((oY + oH > this.y) && (oY < this.y + height)) {
                if ((oX + oW > this.x) && (oX < this.x + width)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
