package net.lib;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.lib");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestDogru.class);
		suite.addTestSuite(TestNokta.class);
		suite.addTestSuite(TestUcgen.class);
		suite.addTestSuite(TestKoordinat.class);
		//$JUnit-END$
		return suite;
	}

}
