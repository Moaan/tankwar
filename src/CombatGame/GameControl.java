package CombatGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Moaan
 */
public class GameControl extends KeyAdapter {

    GameEvents gE;

    public GameControl(GameEvents gE) {
        this.gE = gE;
    }

    public void keyPressed(KeyEvent p) {
        gE.setValue(p, 1);
    }
    
    public void keyReleased(KeyEvent r) {
        gE.setValue(r, 0);
    }
}
