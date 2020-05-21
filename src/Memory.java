public class Memory {
// خلي بالك يسطه 
	static String[] mem = new String[1024];
	static  String address;
	static String WriteData;
	static String ReadData;
	static String ALuMuxPC_Result ; 
	static String	JumpAluMux_Result;
	public static void main(String[] args) {
		address = EXMEM.ALU_ResultOUT;
		DataMem();
		////////////////////////////////////////////// pc not in layer EXmem
		ALuMuxPC_Result = ALuMuxPC( Integer.toBinaryString(IDEX.pc4OUT), EXMEM.Add_ResultOUT,
				BranchAndZero(EXMEM.zero, EXMEM.BranchOUT));
		/////////////// jumpppppppppppp
		JumpAluMux_Result=JumpAluMux(InstructionDecode.jumpAdd, ALuMuxPC_Result, InstructionDecode.cont.Jump);
		
		
		System.out.println("Alu Res: "+EXMEM.ALU_ResultOUT);
		System.out.println("mem read word : "+ReadData  );
		System.out.println();
		System.out.println();

		
	}
	public static boolean BranchAndZero(boolean b, boolean z) {
		return b && z;
	}
	
	public static String ALuMuxPC(String pcRes, String AluResult, boolean input) {
		if (input)
			return AluResult;
		else
			return pcRes;
	}

	public static String JumpAluMux(String JumpAddress, String MuxAddOutput,
			boolean inputJump) {
		if (inputJump)
			return JumpAddress;
		else
			return MuxAddOutput;
	}
	public static void DataMem() {
		int temp = Integer.parseInt(address, 2);
		if (EXMEM.MemwriteOUT ) {
			WriteData=EXMEM.readData2OUT;
			mem[temp] = WriteData;
			ReadData = mem[temp];
		}
		if (EXMEM.MemReadOUT ) {
			ReadData = mem[temp];
		}
	}
}
