package ships;

import projectiles.Projectile;
import utils.Position;

/**
 * Class to create a shooter ship, an invader ship which fires single
 * projectiles
 * 
 * @author Taylor Turner
 *
 */

public class ShooterShip extends InvaderShip {
	/**
	 * Constructs a ShooterShip
	 * 
	 * @param p     The initial position
	 * @param armor The initial armor level
	 */
	public ShooterShip(Position p, int armor) {
		super(p, armor);
	}

	/**
	 * Fires a projectile
	 * 
	 * @return An array containing a single projectile
	 */
	public Projectile[] fire() {
		if (!canFire()) {
			return null;
		}
		Projectile[] proj = new Projectile[1];
		proj[0] = new Projectile(this.pos, 0.0, -1 * PROJECTILE_SPEED, Projectile.GRAVITY);
		return proj;
	}

	@Override
	public String imgPath() {
		return "res/monster.png";

	}

	@Override
	public int getPoints() {
		return 50;
	}
}
