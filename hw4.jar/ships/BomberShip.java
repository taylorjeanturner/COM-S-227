package ships;

import projectiles.Bomb;
import projectiles.Projectile;
import utils.Position;

/**
 * Class to create a bomber ship, an invader ship which drops small bombs
 * 
 * @author Taylor Turner
 *
 */

public class BomberShip extends InvaderShip {
	public static final double EXPLOSION_RADIUS = 10;

	/**
	 * Constructs a BomberShip
	 * 
	 * @param p     The initial position
	 * @param armor The initial armor level
	 */
	public BomberShip(Position p, int armor) {
		super(p, armor);
	}

	/**
	 * Drops a single bomb
	 * 
	 * @return An array containing a single bomb
	 */
	public Projectile[] fire() {
		if (!canFire()) {
			return null;
		}
		Bomb b = new Bomb(super.pos, 0.0, -1 * PROJECTILE_SPEED, Projectile.GRAVITY, EXPLOSION_RADIUS);
		Projectile[] bomb = new Projectile[1];
		bomb[0] = b;
		return bomb;

	}

	@Override
	public String imgPath() {
		return "res/monster2.png";
	}

	@Override
	public int getPoints() {
		return 100;
	}
}
