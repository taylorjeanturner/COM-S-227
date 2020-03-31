package lab5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import balloon1.Balloon;

public class BalloonTests {
	@Test
	public void checkRadius() {
		Balloon b = new Balloon(10);
		assertEquals(0, b.getRadius());
	}

	@Test
	public void checkIfPopped() {
		Balloon b = new Balloon(10);
		assertEquals(false, b.isPopped());
	}

	@Test
	public void blowBalloon() {
		Balloon b = new Balloon(10);
		b.blow(5);
		assertEquals(5, b.getRadius());	
	}
	
	@Test
	public void popBalloon() {
		Balloon b = new Balloon(10);
		b.pop();
		assertEquals(true, b.isPopped());
		assertEquals(0, b.getRadius());
	}
	
	@Test
	public void deflateBalloon() {
		Balloon b = new Balloon(10);
		b.blow(10);
		b.deflate();
		assertEquals(false, b.isPopped());
		assertEquals(0, b.getRadius());
	}
	
	@Test
	public void overFill() {
		Balloon b = new Balloon(10);
		b.blow(20);
		assertEquals(true, b.isPopped());
		assertEquals(0, b.getRadius());
	}
	
	@Test
	public void blowPopped() {
		Balloon b = new Balloon(10);
		b.pop();
		b.blow(10);
		assertEquals(0, b.getRadius());
	}
	
	@Test
	public void doubleBlow() {
		Balloon b = new Balloon(10);
		b.blow(5);
		b.blow(5);
		assertEquals(10, b.getRadius());
	}
}
