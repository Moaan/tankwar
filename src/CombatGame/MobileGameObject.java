/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CombatGame;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Moaan
 */
public interface MobileGameObject extends Observer { //only userplane and enemy army need implement this
    public void move();
    public void draw(Graphics g, ImageObserver obs);
    public void update(Observable obj, Object arg);
}
