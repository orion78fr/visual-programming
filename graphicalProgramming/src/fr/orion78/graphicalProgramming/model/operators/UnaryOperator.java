package fr.orion78.graphicalProgramming.model.operators;

import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Type;

public abstract class UnaryOperator extends Instruction{
	private Type right;
	
	protected UnaryOperator(Type right){
		this.right = right;
	}

	public Type getRight() {
		return right;
	}
}
