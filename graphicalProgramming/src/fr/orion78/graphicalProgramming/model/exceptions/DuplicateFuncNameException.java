package fr.orion78.graphicalProgramming.model.exceptions;

public class DuplicateFuncNameException extends ExecutionException {
	private static final long serialVersionUID = 1L;

	public DuplicateFuncNameException(String str) {
		super(str);
	}
}
