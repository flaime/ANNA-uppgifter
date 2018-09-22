package kassasystem;

import java.util.*;
import java.util.Map;

public class testar {

	public static void main(String[]args){

		HashMap<String, Integer> talsamling = new HashMap<>();

		talsamling.put("ett", 1);
		talsamling.put("två",2);
		talsamling.put("tre",3);
		talsamling.put("fyra",4);
		talsamling.put("fem", 5);

//		loopa igenom

		for(Map.Entry<String, Integer> t : talsamling.entrySet()) {
			System.out.println(t.getValue() + " = " + t.getKey());

		}
		System.out.println("-----");

		skrivUt(talsamling);

		HashMap<String, ArrayList<Integer>> samlingssamling = new HashMap<>();

		Integer[] ettor = {1,1,1,1};
		samlingssamling.put("ettor", new ArrayList<Integer>(Arrays.asList(ettor)));

		Integer[] tvåor = {2,2,2,2};
		samlingssamling.put("tvåor", new ArrayList<Integer>(Arrays.asList(tvåor)));

		Integer[] treor = {3,3,3,3};
		samlingssamling.put("treor", new ArrayList<Integer>(Arrays.asList(treor)));


		Iterator<Map.Entry<String, ArrayList<Integer>>> iter = samlingssamling.entrySet().iterator();

		while(iter.hasNext()){
			Map.Entry<String, ArrayList<Integer>> entry = iter.next();
			String str = entry.getKey();
			for(int i : entry.getValue()){
				System.out.println(i + str);
			}
//			int val = entry.getValue();
		}


//		Iterera igenom


	}
	public static void skrivUt(HashMap<String, Integer> talsamling){

		Iterator<Map.Entry<String, Integer>> iter = talsamling.entrySet().iterator();

		while(iter.hasNext()){
			Map.Entry<String, Integer> entry = iter.next();
			int tal = entry.getValue();
			String nyckel = entry.getKey();
			System.out.println(tal);
		}
	}
}
