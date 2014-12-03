package fr.orion78.graphicalProgramming.model;

import java.util.List;

import fr.orion78.graphicalProgramming.model.exceptions.NullInstructionException;

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

	public Object execute(Program p) {
		Object res = null;
		for(Instruction op : ops){
			if(op == null){
				throw new NullInstructionException("An instruction in this function is null");
			}
			res = op.execute(p);
		}
		return res;
	}
}
