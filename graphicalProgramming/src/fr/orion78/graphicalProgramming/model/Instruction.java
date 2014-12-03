package fr.orion78.graphicalProgramming.model;

public abstract class Instruction {
	private static Instruction nop = new Instruction() {
		@Override
		public Object execute(Program p) {
			return null;
		}
	};
	
	public abstract Object execute(Program p);
	
	public static Instruction getNullInstruction(){
		return Instruction.nop;
	}
}
