package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class UnbreakableWall extends MotionlessEntity {
	
	private static char charImage = 'a';
	private static Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(0, 0, 16, 16));
	
	public UnbreakableWall() {
		super(sprite, Permeability.BLOCKING);
	}

}
