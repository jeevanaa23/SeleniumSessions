package testNGFramework;

import org.testng.annotations.Test;

public class Groupingconcept {

	@Test(groups="X")
	public void f1() {
		System.out.println("printinf F1");
	}
	
	@Test(groups="X")
	public void f2() {
		System.out.println("printinf F2");
	}
	@Test(groups="X")
	public void f3() {
		System.out.println("printinf F3");
	}
	@Test(groups="Y")
	public void f4() {
		System.out.println("printinf F4");
	}
	@Test(groups="Y")
	public void f5() {
		System.out.println("printinf F5");
	}
	
}
