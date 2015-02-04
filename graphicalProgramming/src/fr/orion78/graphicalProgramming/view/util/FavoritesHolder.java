package fr.orion78.graphicalProgramming.view.util;

import java.util.HashMap;

/* This class hold Favorites instances of class (singletons) */
public class FavoritesHolder {
	private static HashMap<Class<?>, Object> hm = new HashMap<Class<?>, Object>();
	
	public static <T> T get(Class<T> key){
		// It's sure that the cast succeed because we make the check in the put
		return key.cast(hm.get(key));
		
	}
	public static <T> void put(Class<T> key, T value){
		if(key == null) throw new NullPointerException("Key is null");
		
		if(hm.containsKey(key)){
			throw new RuntimeException("Two favorite instance of the same class added");
		}
		
		hm.put(key, value);
	}
}