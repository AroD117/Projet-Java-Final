package entity.motionless;

public class MotionlessEntityFactory {

	private static BrakableSurface breakableSurface = new BrakableSurface();
	private static UnbreakableWall unbreakableWall = new UnbreakableWall();
	private static BrokanSurface brokenSurface = new BrokanSurface();
	private static BrakableSurface exit = new BrakableSurface();
	
	public static MotionlessEntity[] motionlessEntity = {
			breakableSurface, 
			unbreakableWall, 
			brokenSurface, 
			exit, 
	};
	
	public static MotionlessEntity createBreakableWall() {
		return breakableSurface;
	}
	
	public static MotionlessEntity createUnbreakableWall() {
		return unbreakableWall;
	}
	
	public static MotionlessEntity createDugWall() {
		return brokenSurface;
	}
	
	
	public static MotionlessEntity createExit() {
		return breakableSurface;
	}
	
	public static MotionlessEntity getFromDBSymbol(char symbol) {
		
		for(final MotionlessEntity motionlessEntity : motionlessEntity) {
			if(motionlessEntity.getSprite().getCharImage() == symbol) {
				return motionlessEntity;
			}
		}
		return brokenSurface;
	}
}
