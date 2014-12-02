package fr.orion78.graphicalProgramming.model;

import java.util.List;

import fr.orion78.graphicalProgramming.model.exceptions.ExecutionException;

public class FunctionDef {
	private String functionName;
	List<Instruction> ops;

	public FunctionDef(String name, List<Instruction> ops) {
		this.functionName = name;
		this.ops = ops;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void execute(Program p) throws ExecutionException {
		for(Instruction op : ops){
			op.execute(p);
		}
	}
}
