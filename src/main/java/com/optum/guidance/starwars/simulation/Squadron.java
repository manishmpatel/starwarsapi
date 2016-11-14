package com.optum.guidance.starwars.simulation;

import java.util.ArrayList;

public class Squadron {

	private ArrayList<XWingFighter> xWings;
	
	public void init(int numberOfxWings) {
		xWings = new ArrayList<XWingFighter>();
		while (xWings.size() < numberOfxWings) {
			xWings.add(new XWingFighter());
			
		}
		
	}

	public ArrayList<XWingFighter> getxWings() {
		return xWings;
	}

	public void setxWings(ArrayList<XWingFighter> xWings) {
		this.xWings = xWings;
	}
}
