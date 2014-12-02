package fr.orion78.graphicalProgramming;

import java.util.ArrayList;
import java.util.List;

import fr.orion78.graphicalProgramming.model.FunctionDef;
import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Program;
import fr.orion78.graphicalProgramming.model.Type;
import fr.orion78.graphicalProgramming.model.exceptions.ExecutionException;
import fr.orion78.graphicalProgramming.model.operators.FunctionCall;
import fr.orion78.graphicalProgramming.model.types.String;

public class MainTest {
	public static void main(java.lang.String[] args) {
		Type str = new String("George");
		Instruction printf = new FunctionCall("printf", "Hello Mister ", str);
		
		List<Instruction> ops = new ArrayList<Instruction>();
		ops.add(printf);
		
		FunctionDef main = new FunctionDef("main", ops);
		
		List<FunctionDef> funcs = new ArrayList<FunctionDef>();
		funcs.add(main);
		
		Program p = new Program(funcs);
		try {
			p.execute();
		} catch (ExecutionException e){
			System.out.println("Exception d'execution " + e.getMessage() + "\n");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("/!\\ Exception Java /!\\\n");
			e.printStackTrace();
		}
	}
}
