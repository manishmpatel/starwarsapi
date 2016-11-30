package com.optum.guidance.unit.testing;

import org.testng.annotations.Test;

import com.optum.guidance.starwars.simulation.Squadron;

public class SquadronTest {
  @Test(groups = "unittest")
  public void create_initial_squadron_of_xWings() {
	  Squadron s = new Squadron();
	  s.init(5);
	  assert s.getxWings().size() == 5;
  }
}
