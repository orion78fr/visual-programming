package fr.orion78.graphicalProgramming.model;

public abstract class Type {
	private Object value;

	public Object getValue() {
		return value;
	}
	
	protected Type(Object value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object arg) {
		if(arg instanceof Type){
			return this.value.equals(((Type) arg).getValue());
		} else {
			return false;
		}
	}
	
}
