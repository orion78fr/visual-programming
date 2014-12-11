package fr.orion78.graphicalProgramming.model.operators;

import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Type;

public abstract class BinaryOperator extends Instruction{
	private Type left;
	private Type right;
	
	protected BinaryOperator(Type left, Type right){
		this.left = left;
		this.right = right;
	}

	public Type getLeft() {
		return this.left;
	}

	public Type getRight() {
		return this.right;
	}
}
