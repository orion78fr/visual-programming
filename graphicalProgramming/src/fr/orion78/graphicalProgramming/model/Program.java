package fr.orion78.graphicalProgramming.model;

import java.util.HashMap;
import java.util.List;

import fr.orion78.graphicalProgramming.model.exceptions.DuplicateFuncNameException;
import fr.orion78.graphicalProgramming.model.exceptions.NoMainFuncFoundException;
import fr.orion78.graphicalProgramming.model.exceptions.NullFuncDefException;

public class Program {
	private HashMap<String, FunctionDef> funcs = new HashMap<String, FunctionDef>();
	
	public Program(List<FunctionDef> funcs) {
		for(FunctionDef func : funcs){
			if(func == null){
				throw new NullFuncDefException("A function passed to object program is null");
			}
			if(this.funcs.put(func.getFunctionName(), func) != null){
				throw new DuplicateFuncNameException("Two function has been defined with the name \"" + func.getFunctionName() + "\"");
			}
		}
	}

	public void execute() {
		FunctionDef main = funcs.get("main");
		if(main == null){
			throw new NoMainFuncFoundException("Main function not found in program");
		} else {
			main.execute(this);
		}
	}
	
	public FunctionDef getFuncByName(String name){
		return this.funcs.get(name);
	}
}
