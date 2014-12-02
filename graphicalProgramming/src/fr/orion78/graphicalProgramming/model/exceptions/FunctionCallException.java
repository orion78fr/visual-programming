package fr.orion78.graphicalProgramming.model.exceptions;

public class FunctionCallException extends ExecutionException{
	private static final long serialVersionUID = 1L;
	
	public FunctionCallException(String str) {
		super(str);
	}
}
