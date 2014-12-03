package fr.orion78.graphicalProgramming.model.types;

import fr.orion78.graphicalProgramming.model.Type;

public class Boolean extends Type {
	public static Boolean FALSE = new Boolean(false);
	
	public Boolean(boolean b){
		super(b);
	}
}
