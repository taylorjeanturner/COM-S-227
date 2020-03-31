package ships;

import utils.Position;

public class ShipTest {
	
	public static void main(String[] args) {
		Position p = new Position(1,1);
		BomberShip s = new BomberShip(p, 0);
		System.out.println(s.canFire());
		s.fire();
		System.out.println(s.getPosition());
		s.translate(1.0, 2.0);
		System.out.println(s.getPosition());
		s.setPosition(3.0, 1.0);
		System.out.println(s.getPosition());
	}

}
