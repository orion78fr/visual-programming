package fr.orion78.graphicalProgramming.model;

import fr.orion78.graphicalProgramming.model.exceptions.ExecutionException;

public abstract class Instruction {
	public abstract Object execute(Program p) throws ExecutionException;
}
