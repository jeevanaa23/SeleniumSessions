package javaPackage;

public class methods {

	void add() {
		int x=5;
		int y=3;
		int z=x+y;
		System.out.println(z);
	}
	
	int addition(int p,int q) {
		int r=p+q;
		return r;
		
	}
	
	public static void main(String[] args) {
		int a=10;
		int b=9;
		int  c= a+b;
		System.out.println(c);
		methods m=new methods();
		m.add();
		int result=m.addition(6, 5);
		System.out.println(result);

	}
	

}
