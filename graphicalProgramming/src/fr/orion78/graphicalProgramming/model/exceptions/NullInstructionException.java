package fr.orion78.graphicalProgramming.model.exceptions;

public class NullInstructionException extends ExecutionException {
	private static final long serialVersionUID = 1L;

	public NullInstructionException(String str) {
		super(str);
	}
}
