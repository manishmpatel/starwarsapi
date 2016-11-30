package com.optum.guidance.unit.testing;

import org.testng.annotations.Test;

import com.optum.guidance.starwars.simulation.DeathStar;
import com.optum.guidance.starwars.simulation.Squadron;
import com.optum.guidance.starwars.simulation.XWingFighter;

public class DeathStarTest {

  @Test(groups = "unittest")
  public void test_deathstar_incremental_damage() {
	 DeathStar ds = new DeathStar(100);
	 ds.doDamage(1);
	 int i = ds.getDefense();
	 if (i == 100-1)
		 assert true; 
	 else
	 assert false;
    
  }
  
  @Test(groups = "unittest")
  public void test_deathstar_massive_damage() {
	 DeathStar ds = new DeathStar(100);
	 ds.doDamage(10000);
	 int i = ds.getDefense();
	 if (i == 0)
		 assert true; 
	 else
	 assert false;
    
  }
  @Test
  public void test_deathstar_random_damage() {
	  XWingFighter f = new XWingFighter();
	  DeathStar s = new DeathStar(10000);
	  int numberOfHits = 0;
	  for (int i=1; i<=10; i++) {
		  //attack 10 times
		  boolean b = s.takeDamage(f);
		  System.out.println(b);
		  if (b)
			  numberOfHits++;
		  
		    
	  }
	  if (numberOfHits > 0)
		  assert true;
	  else
		  assert false;
  }
  
  @Test
  public void test_squadron_attack() {
	  Squadron s = new Squadron();
	  s.init(20);
	  DeathStar ds = new DeathStar(10000);
	  ds.attack(s);
	  if (ds.getDefense() <= ds.getMaxDefense())
		  assert true;
	  
  }

  //@Test(groups = "functest")
  public void isDestroyed() {
    throw new RuntimeException("Test not implemented");
  }

 
  //@Test(groups = "integrationtest")
  public void setDefenseint() {
    throw new RuntimeException("Test not implemented");
  }


}
