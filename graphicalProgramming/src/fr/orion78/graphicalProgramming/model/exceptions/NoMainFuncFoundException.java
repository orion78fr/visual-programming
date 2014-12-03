package fr.orion78.graphicalProgramming.model.exceptions;

public class NoMainFuncFoundException extends FuncNotFoundException {
	private static final long serialVersionUID = 1L;

	public NoMainFuncFoundException(String str) {
		super(str);
	}
}
