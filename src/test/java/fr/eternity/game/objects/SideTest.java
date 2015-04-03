package fr.eternity.game.objects;

import junit.framework.TestCase;

public class SideTest extends TestCase {

	public void testGetInternalSides() {
		assertEquals(8, Side.getInternalSides().length);
	}

}
