public class Memory {
	static  String address;
	static String WriteData;
	static String ReadData;
	static String ALuMuxPC_Result ; 
	
	static String	JumpAluMux_Result;

	public static void main(String[] args) {
		address = EXMEM.ALU_ResultOUT;
		DataMem();
		////////////////////////////////////////////// pc not in layer EXmem

		
//		System.out.println("Alu Res: "+EXMEM.ALU_ResultOUT);
//		System.out.println("mem read word : "+ReadData  );
//		System.out.println();
//		System.out.println();
		System.out.println("--------- ------- ------- ----------------");
		System.out.println("Memory");
	//	System.out.println(ToString());

		
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
	//	System.out.println(address);
		int temp = Integer.parseInt(address, 2);
		if (EXMEM.MemwriteOUT ) {
			WriteData=EXMEM.readData2OUT;
			Main.mem[temp] = WriteData;
			ReadData = Main.mem[temp];
		}
		if (EXMEM.MemReadOUT ) {
			ReadData = Main.mem[temp];
		}
	}


public static String ToString() {
	return "MEMWB [MemtoReg=" + MEMWB.MemtoReg + ", RegWrite=" + MEMWB.RegWrite
			+ ", ReadData=" + MEMWB.ReadData + ", ALU_Result=" + MEMWB.ALU_Result
			+ ", MUX=" + MEMWB.MUX + ", MemtoRegOUT=" + MEMWB.MemtoRegOUT
			+ ", RegWriteOUT=" + MEMWB.RegWriteOUT + ", ReadDataOUT="
			+ MEMWB.ReadDataOUT + ", ALU_ResultOUT=" + MEMWB.ALU_ResultOUT
			+ ", MUXOUT=" + MEMWB.MUXOUT + "]";
}
}
