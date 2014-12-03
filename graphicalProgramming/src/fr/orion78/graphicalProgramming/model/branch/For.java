package fr.orion78.graphicalProgramming.model.branch;

import java.util.List;

import fr.orion78.graphicalProgramming.model.Branch;
import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Program;
import fr.orion78.graphicalProgramming.model.exceptions.NullBranchBodyException;
import fr.orion78.graphicalProgramming.model.exceptions.NullInstructionException;

public class For extends Branch{
	private Instruction init;
	private Instruction iterator;
	private List<Instruction> body;
	
	public For(Instruction init, Instruction condition, Instruction iterator, List<Instruction> body){
		super(condition);
		if(init != null){
			this.init = init;
		} else {
			throw new NullInstructionException("Init instruction of the for is null");
		}
		
		if(iterator != null){
			this.iterator = iterator;
		} else {
			throw new NullInstructionException("Iterator instruction of the for is null");
		}
		
		if(body != null){
			this.body = body;
		} else {
			throw new NullBranchBodyException("The body of the for is defined null");
		}
	}

	@Override
	public Object execute(Program p){
		this.init.execute(p);
		while(this.evaluateCondition(p)){
			for(Instruction i : this.body){
				if(i == null){
					throw new NullInstructionException("An instruction in this for is null");
				} else {
					i.execute(p);
				}
			}
			this.iterator.execute(p);
		}
		return null;
	}

}
