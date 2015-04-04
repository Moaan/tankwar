/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import CombatGame.GameEvents;
import CombatGame.MobileGameObject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Moaan
 */
public class RandomObjectGenerator extends TankWar implements MobileGameObject {     //Acts like the EnemyArmy class of Wingman

    Image healthBonusImage = getSprite("Resources/powerupHealth.png");
    Image attackBonusImage = getSprite("Resources/powerupBullets.png");
    Image attackBonusImage2 = getSprite("Resources/powerupBullets2.png");
    ArrayList<PowerUp> powerUps = new ArrayList();
    ArrayList<MagicWall> allWalls = new ArrayList();

    RandomObjectGenerator() {
        for (int i = 0; i < borderY / 32; i++) {
            allWalls.add(new MagicWall(borderX / 2, i * (borderY / 32)));
            allWalls.add(new MagicWall((borderX / 2) - 32, i * (borderY / 32)));
            allWalls.add(new MagicWall((borderX / 2) + 32, i * (borderY / 32)));
        }
    }

    @Override
    public void move() {
        //  does not really apply here.
    }

    @Override
    public void draw(Graphics g, ImageObserver obs) {
        for (int i = 0; i < powerUps.size(); i++) {
            if (!powerUps.get(i).update()) {
                powerUps.get(i).draw(g, obs);
            } else {
                powerUps.remove(i);
            }
        }

        for (int i = 0; i < allWalls.size(); i++) {
            allWalls.get(i).update();
            allWalls.get(i).draw(g, obs);
        }
    }

    public boolean collision(int oX, int oY, int oW, int oH) {
        for (int i = 0; i < allWalls.size(); i++) {
            if (allWalls.get(i).collision(oX, oY, oW, oH)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable obj, Object event) {
        GameEvents gameE = (GameEvents) event;
        if (gameE.eventType == 3) {
            if ((int) gameE.event == 0) {
                powerUps.add(new PowerUp(healthBonusImage, 100, 100, 0, true));
                powerUps.add(new PowerUp(attackBonusImage, borderX - 100, borderY - 100, 1, false));
            }
            if ((int) gameE.event == 1) {
                powerUps.add(new PowerUp(attackBonusImage2, 700, borderY - 100, 2, false));
                powerUps.add(new PowerUp(healthBonusImage, borderX - 700, 100, 0, true));
            }
            if ((int) gameE.event == 2) {
                powerUps.add(new PowerUp(healthBonusImage, 400, borderY / 2, 0, true));
                powerUps.add(new PowerUp(attackBonusImage, borderX - 400, borderY / 2, 1, false));
            }
            if ((int) gameE.event == 3) {
                powerUps.add(new PowerUp(attackBonusImage2, 500, borderY / 3, 2, false));
                powerUps.add(new PowerUp(healthBonusImage, borderX - 500, borderY / 3, 0, true));
            }
        }
    }
}
