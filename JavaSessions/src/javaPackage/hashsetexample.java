package javaPackage;


import java.util.HashSet;

public class hashsetexample {

	public static void main(String[] args) {
		HashSet <String>a=new HashSet<String>();
		a.add("text");
		a.add("String");
		a.add("Integer");
		a.add("text");
		for(String b:a) {
			System.out.println(b);
		}

	}

}
