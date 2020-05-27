public class Execute {
	static String Foperand;//= "00000000000000000000000000000000";
	static String Soperand;//="00000000000000000000000000000000";
	static Operation operation;
	static String ALUresult;//="00000000000000000000000000000000";
	static boolean zero;
	static int pc;
	static String ADD_SHIFTED_INPUT;
	static String addresult ;
	static String writeReg ; 
	public static void main(String[] args) {

	
		writeReg = InstructionDecode.rsMuxrd(IDEX.rdOUT, IDEX.rtOUT, IDEX.RegDstOUT);

		
		pc = IDEX.pc4OUT;
	//	System.out.println(" "+IDEX.ImmediateOUT);
		ADD_SHIFTED_INPUT = ShiftLeft(IDEX.ImmediateOUT);
		ADD();
		
		AluControl(IDEX.ImmediateOUT.substring(26, 32), IDEX.ALUOpOUT);
		MUX(IDEX.ALUSrcOUT);
		Foperand = IDEX.readData1OUT;
		ALU();
//
//		System.out.println("REadDATA 2 "+Soperand);
//
//		
//		System.out.println("Zero flag: "+zero);
////		System.out.println("branch Add :"+);
		System.out.println("--------- ------- ------- ----------------");
		System.out.println("Execute");
	//	System.out.println(ToString());

	}

	public static void ALU() {
	//	System.out.println(Foperand);
		int f1 = Integer.parseInt(Foperand, 2);
		int f2 = Integer.parseInt(Soperand, 2);
		int r = 0;
		switch (operation) {
		case ADD:
			r = f1 + f2;
			break;
		case SUB:
			r = f1 - f2;
			break;
		case OR:
			r = f1 ^ f2;
			break;
		case NOR:
			r = ~(f1 ^ f2);
			;
			break;
		case SLT:
			if (f1 < f2) {
				r = 1;
			} else
				r = 0;
			break;

		}
		if (r == 0) {
			zero = true;
		} else {
			zero = false;
		}

		ALUresult = Integer.toBinaryString(r);
	//	System.out.println("ALU RERASRSADA "+ALUresult);

	}

	public static void MUX(boolean ALUSRC) {
		if (ALUSRC) {
			Soperand = IDEX.ImmediateOUT;
		} else {
			Soperand = IDEX.readData2OUT;

		}
	}

	public static void AluControl(String func, String ALUOp) {
		if (ALUOp.equals("00"))
			operation = Operation.ADD;
		else if (ALUOp.equals("01"))
			operation = Operation.SUB;
		else if (ALUOp.equals("10")) { // R type
			if (func.equals("100000")) {
				operation = Operation.ADD;
			}
			if (func.equals("100010")) {
				operation = Operation.SUB;
			}
			if (func.equals("100101")) {
				operation = Operation.OR;
			}
			if (func.equals("100111")) {
				operation = Operation.NOR;
			}
			if (func.equals("101010")) {
				operation = Operation.SLT;
			}
		}

	}

	public static void ADD() {
		int temp = Integer.parseInt(ADD_SHIFTED_INPUT, 2);
		addresult = String.format("%32s",Integer.toBinaryString(pc*4 + temp)).replace(' ', '0');
		 

				
	}

	public static String ShiftLeft(String inst) {
		int decimal = Integer.parseInt(inst, 2);
		return Integer.toBinaryString(decimal << 2);
	}
	public static String ToString() {
		return "EXMEM [readData2=" + EXMEM.readData2 + ", ALU_Result=" + EXMEM.ALU_Result
				+ ", Add_Result=" + EXMEM.Add_Result + ", zero=" + zero + ", MUX="
				+ EXMEM.MUX + ", JumpAdd=" + EXMEM.JumpAdd + ", Jump=" + EXMEM.Jump + ", Branch="
				+ EXMEM.Branch + ", MemRead=" + EXMEM.MemRead + ", MemtoReg=" + EXMEM.MemtoReg
				+ ", Memwrite=" +EXMEM. Memwrite + ", RegWrite=" + EXMEM.RegWrite
				+ ", JumpOUT=" + EXMEM.JumpOUT + ", BranchOUT=" + EXMEM.BranchOUT
				+ ", MemReadOUT=" + EXMEM.MemReadOUT + ", MemtoRegOUT=" + EXMEM.MemtoRegOUT
				+ ", MemwriteOUT=" + EXMEM.MemwriteOUT + ", RegWriteOUT="
				+ EXMEM.RegWriteOUT + ", JumpAddOUT=" + EXMEM.JumpAddOUT
				+ ", readData2OUT=" + EXMEM.readData2OUT + ", ALU_ResultOUT="
				+ EXMEM.ALU_ResultOUT + ", Add_ResultOUT=" + EXMEM.Add_ResultOUT
				+ ", zeroOUT=" +EXMEM. zeroOUT + ", MUXOUT=" + EXMEM.MUXOUT + "]";
	}

	// public static int ALuMuxPC (int pcRes ,int AluResult, boolean input ){
	// if (input )return AluResult;
	// else return pcRes;
	// }
	// public static int JumpaluMAx (int Jumpadd, int muxoutput, boolean
	// inputJump){
	// if (inputJump)return Jumpadd;
	// else return muxoutput;
	//
	// }

}
