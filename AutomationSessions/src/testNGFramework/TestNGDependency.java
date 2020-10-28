package testNGFramework;

import org.testng.annotations.Test;

public class TestNGDependency {


	@Test
	public void f1() {
		System.out.println("printinf F1");
	}
	
	@Test(dependsOnMethods="f3")
	public void f2() {
		System.out.println("printinf F2");
	}
	@Test
	public void f3() {
		System.out.println("printinf F3");
	}
	@Test
	public void f4() {
		System.out.println("printinf F4");
	}
	@Test
	public void f5() {
		System.out.println("printinf F5");
	}
	
}
