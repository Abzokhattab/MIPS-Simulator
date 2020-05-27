public class InstructionDecode {
	static String rs;
	static String rt;
	static String rd;
	static String writeReg;
	static String Readreg1;
	static String Readreg2;
	static String WriteData;
	static String ReadData1;//="00000000000000000000000000000000";
	static String ReadData2;//="00000000000000000000000000000000";
	static Control cont = new Control();
	static String format;
	static String shamt;
	static String func;
	static String address;
	static String Operation;
	static String AluOperation;
	static int pc ;
	static String offsetOimmediate;//="00000000000000000000000000000000";
	static String opcode;
	static String jumpAdd;

	public static void main(String[] args) {
		
		cont = new Control();
		ID(IFID.instOUT);

		cont.parse(opcode);
		pc = IFID.pc4OUT; 
		Readreg1 = rs;
		Readreg2 = rt;
		ReadData1 = (String) ((Register) Main.RegFile.readRegister(Readreg1))
				.getValue();
		ReadData2 = (String) ((Register) Main.RegFile.readRegister(Readreg2))
				.getValue();
	//	System.out.println("REadDATA 2 "+ReadData2);

		extend();
	//	System.out.println(rd+" "+rt +" "+offsetOimmediate);
		String pcdivided = pcDivide(pc*4);
		String s = ShiftLeft(address); 
		jumpAdd = pcdivided + s;

		
	

		
		
//		System.out.println("Next pc : "+pc);
//		System.out.println("Next pc : "+IFID.instOUT);
//		System.out.println("operation : " + Operation);
//		System.out.println("opcode    " + "|" + "rs   " + "|" + "rt   " + "|"
//				+ "Imm" + "       ");
//		System.out.println(opcode + "|" + rs + "|" + rt + "|"
//				+ offsetOimmediate);
		System.out.println("--------- ------- ------- ----------------");
		System.out.println("Decode");
	//	System.out.println(ToString());

//		//
//		System.out.println("Read Data 1: " + ReadData1);
//
//		System.out.println("Read Data 2: " + ReadData2);
//		System.out.println("Sign Extend: "+offsetOimmediate );
//		System.out.println("Rt: " +rt+ "  "+"Rd : "+rd);
//		System.out.println("MemtoReg : "+cont.MemtoReg+", RegWrite: "+cont.RegWrite);
//		System.out.println("Memread : "+cont.MemRead+", MemWrite: "+cont.Memwrite+", Branch: "+cont.Branch);
//		System.out.println("regDst : "+cont.RegDst+", AluOP: "+cont.ALUOp+", AluSRc: "+cont.ALUSrc);
//		
		
	}
	public static String ToString() {
		return "IDEX [readData1=" + IDEX.readData1 + ", readData2=" + IDEX.readData2
				+ ", Immediate=" + IDEX.Immediate + ", rt=" + IDEX.rt + ", rd=" + IDEX.rd
				+ ", JumpAdd=" + IDEX.JumpAdd + ", RegDst=" + IDEX.RegDst + ", Jump="
				+ IDEX.Jump + ", Branch=" + IDEX.Branch + ", MemRead=" + IDEX.MemRead
				+ ", MemtoReg=" + IDEX.MemtoReg + ", Memwrite=" + IDEX.Memwrite
				+ ", ALUOp=" + IDEX.ALUOp + ", ALUSrc=" + IDEX.ALUSrc + ", RegWrite="
				+ IDEX.RegWrite + ", pc4=" + IDEX.pc4 + ", JumpAddOUT=" + IDEX.JumpAddOUT
				+ ", ImmediateOUT=" + IDEX.ImmediateOUT + ", rtOUT=" + IDEX.rtOUT
				+ ", rdOUT=" + IDEX.rdOUT + ", RegDstOUT=" + IDEX.RegDstOUT
				+ ", JumpOUT=" + IDEX.JumpOUT + ", BranchOUT=" + IDEX.BranchOUT
				+ ", MemReadOUT=" + IDEX.MemReadOUT + ", MemtoRegOUT=" + IDEX.MemtoRegOUT
				+ ", MemwriteOUT=" + IDEX.MemwriteOUT + ", ALUOpOUT=" + IDEX.ALUOpOUT
				+ ", ALUSrcOUT=" + IDEX.ALUSrcOUT + ", RegWriteOUT=" + IDEX.RegWriteOUT
				+ ", readData1OUT=" +IDEX. readData1OUT + ", readData2OUT="
				+ IDEX.readData2OUT + ", pc4OUT=" + IDEX.pc4OUT + "]";
	}
	
	public static void extend() {
		if (offsetOimmediate.charAt(0) == '0') {
			for (int i = 0; i < 16; i++) {
				offsetOimmediate = "0" + offsetOimmediate;
			}
		} else {
			for (int i = 0; i < 16; i++) {
				offsetOimmediate = "1" + offsetOimmediate;
			}
		}
	}

	public static void ID(String Instruction) {
//System.out.println(Instruction);
		opcode = Instruction.substring(0, 6);
		rs = Instruction.substring(6, 11);
		rt = Instruction.substring(11, 16);
		rd = Instruction.substring(16, 21);
		offsetOimmediate = Instruction.substring(16, 32);
		address = Instruction.substring(6, 32);
		func = Instruction.substring(26, 32);

		//
		// // R-Format
		// if (Instruction.substring(0, 6).equals("000000")) {
		// rs = Instruction.substring(6, 11);
		// rt = Instruction.substring(11, 16);
		// rd = Instruction.substring(16, 21);
		// Readreg1 = rs;
		// Readreg2 = rt;
		// shamt = Instruction.substring(21, 26);
		// func = Instruction.substring(26, 32);
		// if (func.equals("100000")) {
		// Operation = "add";
		// }
		// if (func.equals("100010")) {
		// Operation = "sub";
		// }
		// if (func.equals("100101")) {
		// Operation = "or";
		// }
		// if (func.equals("100111")) {
		// Operation = "nor";
		// }
		// if (func.equals("101010")) {
		// Operation = "slt";
		// }
		// }
		//
		// // J-Format
		// if (Instruction.substring(0, 6).equals("000010")) {
		// address = Instruction.substring(6, 32);
		// Operation = "j";
		// }
		//
		// // I-Format
		// else {
		// if (Instruction.substring(0, 6).equals("000100")) {
		// // beq
		// rs = Instruction.substring(6, 11);
		// rt = Instruction.substring(11, 16);
		// Readreg1 = rs;
		// Readreg2 = rt;
		//
		// offsetOimmediate = Instruction.substring(16, 32);
		// Operation = "beq";
		// pc = pc + Integer.parseInt(offsetOimmediate, 2);
		// }
		//
		// if (Instruction.substring(0, 6).equals("001000")) {// addi
		// rs = Instruction.substring(6, 11);
		// rt = Instruction.substring(11, 16);
		//
		// Readreg1 = rs;
		// Readreg2 = rt;
		//
		// offsetOimmediate = Instruction.substring(16, 32);
		// Operation = "addi";
		// }
		//
		// if (Instruction.substring(0, 6).equals("100011")) {// lw
		// rs = Instruction.substring(6, 11);
		// rt = Instruction.substring(11, 16);
		//
		// Readreg1 = rs;
		// Readreg2 = rt;
		//
		// offsetOimmediate = Instruction.substring(16, 32);
		// Operation = "lw";
		// }
		//
		// if (Instruction.substring(0, 6).equals("101011")) {// sw
		// rs = Instruction.substring(6, 11);
		// rt = Instruction.substring(11, 16);
		//
		// Readreg1 = rs;
		// Readreg2 = rt;
		//
		// offsetOimmediate = Instruction.substring(16, 32);
		// Operation = "sw";
		//
		// }
		// }
	}

	public static String rsMuxrd(String rd, String rt, boolean RegDst) {
		if (RegDst)
			return rd;
		else
			return rt;
	}

	public static void write(String data) {
		if (MEMWB.RegWriteOUT) {
			InstructionDecode.WriteData = data;
			Main.RegFile.writeRegister(MEMWB.MUXOUT,
					InstructionDecode.WriteData);

		}
	}

	public static String pcDivide(int pc) {
			String p = String.format("%32s", Integer.toBinaryString(pc)).replace(' ', '0');
String temp = "";
		for (int i = 0; i < 4; i++)
		{
			temp = temp + p.charAt(i);
}
		return ( temp);
}

	public static String ShiftLeft(String inst) {
		int decimal = Integer.parseInt(inst, 2);
		String s= String.format("%28s", Integer.toBinaryString(decimal << 2)).replace(' ', '0');
	return s ;}
	/*
	 * public static void WriteregMUX(boolean RegDst, String input1 , String
	 * input2 ){ if (RegDst)
	 * 
	 * }s
	 */

}
