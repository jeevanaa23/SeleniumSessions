package javaTraining;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapsExample {

	public static void main(String[] args) {

		Map<String, Integer> newMap=new HashMap<String,Integer>();
		newMap.put("Joey", 32);
		newMap.put("Chandler", 31);
		newMap.put("Monica", 29);
		newMap.put("Rachel", 30);
		
		//System.out.println(newMap.get("Monica"));
		Set<String> key=newMap.keySet();
		for(String keys:key) {
			System.out.println("Key  "+keys+"  Value  "+newMap.get(keys));
		}
		
	}

}
