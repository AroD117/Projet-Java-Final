package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class BrakableSurface extends MotionlessEntity {

	private static char charImage = 'b';
	private static Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(16, 0, 16, 16));
	
	protected BrakableSurface() {
		super(sprite, Permeability.MINEABLE);
	}

}
