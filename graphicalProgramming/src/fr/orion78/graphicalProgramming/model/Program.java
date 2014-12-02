package fr.orion78.graphicalProgramming.model;

import java.util.List;

import fr.orion78.graphicalProgramming.model.exceptions.ExecutionException;

public class Program {
	private List<FunctionDef> funcs;

	public Program(List<FunctionDef> funcs) {
		this.funcs = funcs;
	}

	public void execute() throws ExecutionException{
		for(FunctionDef func : funcs){
			if(func.getFunctionName().equals("main")){
				func.execute(this);
			}
		}
	}
}
