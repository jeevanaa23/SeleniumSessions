package javaPackage;

import java.util.ArrayList;

public class Arraylistexample {

	public static void main(String[] args) {
		ArrayList <String>a=new ArrayList<String>();
		a.add("text");
		a.add("String");
		a.add("Integer");
		a.add("text");
		for(String b:a) {
			System.out.println(b);
		}

	}

}
