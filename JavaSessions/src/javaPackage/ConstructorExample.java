package javaPackage;

public class ConstructorExample {
	
	void sub() {
		int x=9;
		int y=10;
		int z=x-y;
		System.out.println(z);
	}

	ConstructorExample(){
		int x,y;
	    x=4;y=5;
	    int z=x+y;
	    System.out.println(z);
	}
	
	public static void main(String[] args) {

		ConstructorExample ce=new ConstructorExample();
		ce.sub();
	}

}
