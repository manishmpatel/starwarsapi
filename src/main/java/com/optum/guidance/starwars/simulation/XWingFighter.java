package com.optum.guidance.starwars.simulation;

public class XWingFighter {

	int defense;

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void doDamage(int damage) {
		defense = -damage;
	}

	public boolean isDestroyed() {
		if (defense == 0)
			return true;
		else
			return false;
	}
}
