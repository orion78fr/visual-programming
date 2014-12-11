package fr.orion78.graphicalProgramming.model.types;

import fr.orion78.graphicalProgramming.model.Type;

public class String extends Type{	
	public String(java.lang.String str){
		super(str != null ? str : "");
	}
}
