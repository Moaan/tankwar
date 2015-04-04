/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwar;

import CombatGame.IdleGameObject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author Moaan
 */
public class PowerUp extends TankWar {
    Image icon;
    int x, y, damageBoost, width, height;
    boolean healthBoost;
    
    
    PowerUp(Image icon, int x, int y, int damageBoost, boolean healthBoost) {
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.damageBoost = damageBoost;
        this.healthBoost = healthBoost;
        width = icon.getWidth(null);
        height = icon.getWidth(null);
    }

    public boolean update() {
        if(tankL.collision(x, y, width, height)) {
            // boost L
            if(healthBoost) tankL.hp = tankL.MAX_HP;
            tankL.bulletType = damageBoost; // make it equal the damageboost and pass to it different damage values.
            return true;
        } else if(tankR.collision(x, y, width, height)) {
            // boost R
            if(healthBoost) tankR.hp = tankR.MAX_HP;
            tankR.bulletType = damageBoost;
            return true;
        } else {
            return false;
        }
    }

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(icon, x, y, obs);
    }
    
}
