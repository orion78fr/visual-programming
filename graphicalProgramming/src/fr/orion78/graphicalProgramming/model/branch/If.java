package fr.orion78.graphicalProgramming.model.branch;

import java.util.List;

import fr.orion78.graphicalProgramming.model.Branch;
import fr.orion78.graphicalProgramming.model.Instruction;
import fr.orion78.graphicalProgramming.model.Program;
import fr.orion78.graphicalProgramming.model.exceptions.NullBranchBodyException;
import fr.orion78.graphicalProgramming.model.exceptions.NullInstructionException;

public class If extends Branch{
	private List<Instruction> ifthen;
	private List<Instruction> ifelse;
	
	public If(Instruction condition, List<Instruction> ifthen){
		this(condition, ifthen, null);
	}
	
	public If(Instruction condition, List<Instruction> ifthen, List<Instruction> ifelse){
		super(condition);
		if(ifthen == null){
			throw new NullBranchBodyException("The body of the if then is defined null");
		} else {
			this.ifthen = ifthen;
		}
		this.ifelse = ifelse;
	}

	@Override
	public Object execute(Program p) {
		if(evaluateCondition(p)){
			for(Instruction i : ifthen){
				if(i == null){
					throw new NullInstructionException("An instruction in this if then is null");
				} else {
					i.execute(p);
				}
			}
		} else {
			if(this.ifelse != null){
				for(Instruction i : ifelse){
					if(i == null){
						throw new NullInstructionException("An instruction in this if else is null");
					} else {
						i.execute(p);
					}
				}
			}
		}
		return null;
	}

}
