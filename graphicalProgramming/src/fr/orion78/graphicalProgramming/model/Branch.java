package fr.orion78.graphicalProgramming.model;

import fr.orion78.graphicalProgramming.model.exceptions.NullBranchConditionException;
import fr.orion78.graphicalProgramming.model.types.Boolean;

public abstract class Branch extends Instruction {
	private Instruction condition;
	
	protected Branch(Instruction condition){
		if(condition == null){
			throw new NullBranchConditionException("A branch have a null instruction as branching condition");
		}
		this.condition = condition;
	}
	
	public boolean evaluateCondition(Program p) {
		return !(condition.execute(p).equals(Boolean.FALSE));
	}
}
