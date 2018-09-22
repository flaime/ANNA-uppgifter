package kassasystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class VaroRegister {

	HashMap<String, ArrayList<Vara>> varoIKattegorier = new HashMap<>();

	public void addVara(String kattegori, Vara vara){
		if(varoIKattegorier.containsKey(kattegori)){
			varoIKattegorier.get(kattegori).add(vara);
		}else{
			varoIKattegorier.put(kattegori,new ArrayList<>());
			varoIKattegorier.get(kattegori).add(vara);
		}

	}

	public Collection<Vara> getVaror(String kattegori){
		return varoIKattegorier.get(kattegori);
	}
//
//	public String findLKattegori(Vara vara){
//		//TODO - möjligen eller senare
//	}
//
//	public void remove(Vara vara){
//		//TODO möjoligen eller senare
//	}
//
//	public void remove(String kattegori, Vara vara){
//		//TODO möjoligen eller senare
//	}
//
//	public Collection<Vara> getAllVaror(){
//		//TODO - möjligen eller senare
//	}

	public Collection<String> getAllKattegorier(){
		return varoIKattegorier.keySet();
	}

	public int antalVarukattegorier(){
		return varoIKattegorier.size();
	}
}
