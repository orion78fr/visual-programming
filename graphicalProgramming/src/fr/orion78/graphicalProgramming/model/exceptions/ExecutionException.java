package fr.orion78.graphicalProgramming.model.exceptions;

public abstract class ExecutionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExecutionException(String str){
		super(str);
	}
}
