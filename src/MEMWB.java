public class MEMWB {

	static boolean Jump = false;
	static boolean MemtoReg = false;
	static boolean RegWrite = false;

	static String ReadData = "00000000000000000000000000000000";
	static String ALU_Result = "00000000000000000000000000000000";
	static String MUX  = "00000";


	static boolean JumpOUT = false;
	static boolean MemtoRegOUT = false;
	static boolean RegWriteOUT = false;
	
	static String ReadDataOUT = "00000000000000000000000000000000";
	static String ALU_ResultOUT = "00000000000000000000000000000000";
	static String MUXOUT  = "00000";
	public static void main(String[] args) {
		ALU_ResultOUT=ALU_Result;
		ReadDataOUT=ReadData;
		MUXOUT=MUX;
		
		JumpOUT=Jump;
		MemtoRegOUT=MemtoReg;
		RegWriteOUT=RegWrite;
		
		

		Jump=IDEX.JumpOUT;
		MemtoReg=IDEX.MemtoRegOUT;
		RegWrite=IDEX.RegWriteOUT;
		
		ALU_Result=EXMEM.ALU_ResultOUT;
		ReadData=Memory.ReadData;
		MUX=EXMEM.MUXOUT;
		

		
	}
}
