package com.optum.guidance.starwars.simulation;

import org.testng.annotations.Test;

public class DeathStarTest {

  @Test(groups = "unittest")
  public void doDamage() {
	 DeathStar ds = new DeathStar(100);
	 ds.doDamage(1);
	 int i = ds.getDefense();
	 if (i == 100-1)
		 assert true; 
	 else
	 assert false;
    
  }

  @Test(groups = "functest")
  public void isDestroyed() {
    throw new RuntimeException("Test not implemented");
  }

 
  @Test(groups = "integrationtest")
  public void setDefenseint() {
    throw new RuntimeException("Test not implemented");
  }


}
