package fr.orion78.graphicalProgramming.model;

public abstract class Type {
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
