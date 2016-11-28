package com.optum.guidance.starwars.simulation;

public class XWingFighter {

	int defense;
	int firePower = 5;
	double chanceToHit = 0.7;  // this gives the xWingfither a 70% change to hit;

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int fire() {
		return firePower;
	}

	public void doDamage(int damage) {
		defense -= damage;
	}

	public boolean isDestroyed() {
		if (defense == 0)
			return true;
		else
			return false;
	}
	
	public void getStatus() {
		
		System.out.println("Defense is :" + defense);
	}

	public int getFirePower() {
		return firePower;
	}

	public void setFirePower(int firePower) {
		this.firePower = firePower;
	}

	public double getChanceToHit() {
		return chanceToHit;
	}

	public void setChanceToHit(double chanceToHit) {
		this.chanceToHit = chanceToHit;
	}
}
