package net.lib;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.lib");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestUcgen.class);
		suite.addTestSuite(TestOrjin.class);
		//$JUnit-END$
		return suite;
	}

}
