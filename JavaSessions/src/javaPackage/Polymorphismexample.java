package javaPackage;

public class Polymorphismexample {

	void info() {
		System.out.println("Method1");
	}
	void info(String name) {
		System.out.println(name);
		
	}
	public static void main(String[] args) {
	
		Polymorphismexample ref=new Polymorphismexample();
		ref.info();
		ref.info("Krithick");
	}

}
