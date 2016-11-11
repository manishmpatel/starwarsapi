package com.optum.guidance.starwars.simulation;

public class DeathStar {

	int defense;
	
	public DeathStar(int defense) {
		super();
		this.defense = defense;
	}



	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
//use this to show failing test.
	public void doDamage(int damage) {
		defense -= damage;
	}

	public boolean isDestroyed() {
		if (defense == 0)
			return true;
		else
			return false;
	}
}
