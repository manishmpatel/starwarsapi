package com.optum.guidance.starwars.simulation;

public class DeathStar {

	int defense;
	int maxDefense;
	
	public DeathStar(int defense) {
		super();
		this.defense = defense;
		this.maxDefense = defense;
	}



	public int getMaxDefense() {
		return maxDefense;
	}



	public void setMaxDefense(int maxDefense) {
		this.maxDefense = maxDefense;
	}



	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		this.maxDefense = defense;
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
	
	public void attack(Squadron s) {
		// take damage
		
		for (XWingFighter f : s.getxWings()) {
			boolean b = takeDamage(f);
			if (b)
			defense = defense - f.fire();
		}
		
		System.out.println("DeathStar has taken "+ (maxDefense - defense)  + " damage");
	}
	
	public boolean takeDamage( XWingFighter f) {
		double fighterRoll = Math.random();
	
		// fighter has an ? percentage of doing damage
		
		if (fighterRoll <= f.chanceToHit)
		 return true;
		else
		return false;
	}
	
	
}
