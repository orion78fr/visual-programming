package fr.orion78.graphicalProgramming.model.operators;

import fr.orion78.graphicalProgramming.model.FunctionDef;
import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Program;
import fr.orion78.graphicalProgramming.model.Type;
import fr.orion78.graphicalProgramming.model.exceptions.FuncNotFoundException;
import fr.orion78.graphicalProgramming.model.exceptions.FunctionCallException;

public class FunctionCall extends Instruction{
	private String functionName;
	private Object[] args;
	
	public FunctionCall(String name, Object... args){
		this.functionName = name;
		this.args = args;
	}

	@Override
	public Object execute(Program p)  {
		if(functionName.equals("printf")){
			return printf(p);
		} else {
			FunctionDef func = p.getFuncByName(functionName);
			if(func == null){
				throw new FuncNotFoundException("No function named \"" + functionName + "\" found");
			} else {
				return func.execute(p);
			}
		}
	}
	
	private Object printf(Program p) {
		int max = args.length;
		for(int i = 0; i < max; i++){
			Object t = args[i];
			Object res;
			
			if(t instanceof Instruction){
				res = ((Instruction)t).execute(p);
			} else {
				res = t;
			}
			
			if(res instanceof String){
				System.out.print(res);
			} else if(t instanceof Type) {
				System.out.print(((Type)res).getValue());
			} else {
				throw new FunctionCallException("Unknown object type for arg " + i);
			}
		}
		return null;
	}
}
