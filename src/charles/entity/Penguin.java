/**
 *
 * Name:        Joseph Roque
 * Course:      ICS4UO
 * Teacher:     Mr. Byers
 * Created:     December 24, 2012
 *
 * Application: The Adventures of Charles
 * Class:       Penguin
 *
 * Purpose:     Defines the values related to the enemy Penguin
 *
 **/

package charles.entity;

import java.awt.Image;

import charles.game.Engine;
import charles.game.GameConstants;
import charles.resources.Art;

public class Penguin extends Enemy {
    public Penguin(Engine engine, int x, int y) {
	super(engine, x, y, 20, 30, GameConstants.ENEMY_PENGUIN, 60, 20, 36, 14);
	//Calls the super class' constructor with these values
	
	//This enemy cannot jump
	this.jumpHeight = 0;
	this.canJump = false;
	this.speed = 2;
    }
    
    public Image getImage() {
	//Checks if the enemy has been damaged
	int damDisplace = (damageCounter > 0) ? (damageCounter % 10) / 5 * height: 0;
	
	//Returns a moving image if the enemy is walking or a faded image if it is hurt
	//Uses these conditions to calculate where it will load its image from
	if (dx != 0)
	    return (Image) (Art.enemySide2.getSubimage(direction * (width * 3) + (frame / 5 + 1) * width + 168, damDisplace, width, height));
	else
	    return (Image) (Art.enemySide2.getSubimage(direction * (width * 3) + 168, damDisplace, width, height));
    }
    
    int randomizeCoinValue(int id) {
	 //Randomizes how much a coin drop is worth, then returns it
	switch(id) {
	    case 237: return (int)(Math.random() * 8 + 18);
	    default: return 0;
	}
    }
}
