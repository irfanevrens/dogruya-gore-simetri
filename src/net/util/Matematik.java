package net.util;

public final class Matematik {

	public static double getRadyan(double aci) {
		
		return aci * (Math.PI / 180);
	}
	
	public static double getAci(double radyan) {
		
		return radyan * (180 / Math.PI);
	}
	
	public static double getSin(double aci) {
		
		return Math.sin(getRadyan(aci));
	}
	
	public static double getCos(double aci) {
		
		return Math.cos(getRadyan(aci));
	}
}
