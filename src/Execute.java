public class Execute {
	static String Foperand;
	static String Soperand;
	static Operation operation;
	static String ALUresult;
	static boolean zero;
	static int pc;
	static String ADD_SHIFTED_INPUT;
	static String addresult ;

	public static void main(String[] args) {

		pc = IDEX.pc4OUT;
		ADD_SHIFTED_INPUT = ShiftLeft(IDEX.ImmediateOUT);
		ADD();
		
		AluControl(IDEX.ImmediateOUT.substring(26, 32), IDEX.ALUOpOUT);
		MUX(IDEX.ALUSrcOUT);
		Foperand = IDEX.readData1OUT;
		ALU();

		
		
		System.out.println("Zero flag: "+zero);
//		System.out.println("branch Add :"+);
	}

	public static void ALU() {
		System.out.println(Foperand);
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
		addresult = Integer.toBinaryString(pc + temp);

				
	}

	public static String ShiftLeft(String inst) {
		int decimal = Integer.parseInt(inst, 2);
		return Integer.toBinaryString(decimal << 2);
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
