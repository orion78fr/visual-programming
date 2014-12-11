package fr.orion78.graphicalProgramming.model.types;

import java.util.ArrayList;
import java.util.List;

import fr.orion78.graphicalProgramming.model.Type;

public class Array<T> extends Type{
	public Array(List<T> array){
		super(array != null ? array : new ArrayList<T>());
	}
}
