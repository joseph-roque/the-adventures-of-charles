package charles.entity;

import java.awt.Image;

import charles.game.GameConstants;
import charles.game.Engine;
import charles.resources.Art;

public class WheeledRobot extends Enemy {
    public WheeledRobot(Engine engine, int x, int y) {
	//Calls the super class' constructor with these values
	super(engine, x, y, 16, 61, GameConstants.ENEMY_ROBOT_WHEELED, 240, 102, 108, 70);
    }
    
    public Image getImage() {
	//Checks if the enemy has been damaged
	int damDisplace = (damageCounter > 0) ? (damageCounter % 10) / 5 * height: 0;
	
	//Returns a moving image if the enemy is walking or a faded image if it is hurt
	//Uses these conditions to calculate where it will load its image from
	if (dy != 0 || jumping)
	    return (Image) (Art.enemySide3.getSubimage(direction * (width * 4) + width * 3 + 496, damDisplace + 180, width, height));
	else if (dx != 0)
	    return (Image) (Art.enemySide3.getSubimage(direction * (width * 4) + (frame / 5 + 1) * width + 496, damDisplace + 180, width, height));
	else
	    return (Image) (Art.enemySide3.getSubimage(direction * (width * 4) + 496, damDisplace + 180, width, height));
    }
    
    public int randomizeCoinValue(int id) {
	//Randomizes how much a coin drop is worth, then returns it
	switch(id) {
	    case 239: return (int)(Math.random() * 28 + 68);
	    default: return 0;
	}
    }
}
