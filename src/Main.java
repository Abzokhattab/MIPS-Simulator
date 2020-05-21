public class Main {
	static RegisterFile RegFile = new RegisterFile();

//	Register $s0 = new Register("Saved");
//	Register $s1 = new Register("Saved");
//	Register $s2 = new Register("Saved");
//	Register $s3 = new Register("Saved");
//	Register $s4 = new Register("Saved");
//	Register $s5 = new Register("Saved");
//	Register[] SRegisters = { $s0, $s1, $s2, $s3, $s4, $s5 };
//	Register $t0 = new Register("Temporary");
//	Register $t1 = new Register("Temporary");
//	Register $t2 = new Register("Temporary");
//	Register $t3 = new Register("Temporary");
//	Register $t4 = new Register("Temporary");
//	Register $t5 = new Register("Temporary");
//	Register[] TRegisters = { $t0, $t1, $t2, $t3, $t4, $t5 };
//	static Register $zero = new Register("Zero");

	public static void main(String[] args) {
//		$zero.setRegister("0");
		InstructionFetch.main(args);
		InstructionDecode.main(args);
		Execute.main(args);
		Memory.main(args);
		WriteBack.main(args);
		InstructionFetch.main(args);
		InstructionDecode.main(args);
		Execute.main(args);
		Memory.main(args);
		WriteBack.main(args);
	}
}
