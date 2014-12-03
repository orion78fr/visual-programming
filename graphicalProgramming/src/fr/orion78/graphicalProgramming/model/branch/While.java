package fr.orion78.graphicalProgramming.model.branch;

import java.util.List;

import fr.orion78.graphicalProgramming.model.Branch;
import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Program;
import fr.orion78.graphicalProgramming.model.exceptions.NullBranchBodyException;
import fr.orion78.graphicalProgramming.model.exceptions.NullInstructionException;

public class While extends Branch{
	private List<Instruction> body;
	
	public While(Instruction condition, List<Instruction> body){
		super(condition);
		if(body != null){
			this.body = body;
		} else {
			throw new NullBranchBodyException("The body of the while is defined null");
		}
	}

	@Override
	public Object execute(Program p) {
		while(this.evaluateCondition(p)){
			for(Instruction i : body){
				if(i == null){
					throw new NullInstructionException("An instruction in this for is null");
				} else {
					i.execute(p);
				}
			}
		}
		return null;
	}

}
