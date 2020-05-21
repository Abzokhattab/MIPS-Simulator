public class EXMEM {
	static String readData2 = "00000000000000000000000000000000";
	static String ALU_Result = "00000000000000000000000000000000";
	static String Add_Result = "00000000000000000000000000000000";
	static boolean zero ;
	static String MUX  = "00000";

	static boolean Jump = false;
	static boolean Branch = false;
	static boolean MemRead = false;
	static boolean MemtoReg = false;
	static boolean Memwrite = false;
	static boolean RegWrite = false;


	static boolean JumpOUT = false;
	static boolean BranchOUT = false;
	static boolean MemReadOUT = false;
	static boolean MemtoRegOUT = false;
	static boolean MemwriteOUT = false;
	static boolean RegWriteOUT = false;

	static String readData2OUT = "00000000000000000000000000000000";
	static String ALU_ResultOUT = "00000000000000000000000000000000";
	static String Add_ResultOUT = "00000000000000000000000000000000";
	static boolean zeroOUT ;
	static String MUXOUT  = "00000";

	public static void main(String[] args) {

		readData2OUT=readData2;
		ALU_ResultOUT=ALU_Result;
		Add_ResultOUT=Add_Result;
		zeroOUT=zero;
		MUXOUT=MUX;
		
		JumpOUT=Jump;
		BranchOUT=Branch;
		MemReadOUT=MemRead;
		MemtoRegOUT=MemtoReg;
		MemwriteOUT=Memwrite;
		RegWriteOUT=RegWrite;
		
		

		Jump=IDEX.JumpOUT;
		Branch=IDEX.BranchOUT;
		MemRead=IDEX.MemReadOUT;
		MemtoReg=IDEX.MemtoRegOUT;
		Memwrite=IDEX.MemwriteOUT;
		RegWrite=IDEX.RegWriteOUT;
		
		readData2=IDEX.readData2OUT;
		ALU_Result=Execute.ALUresult;
		zero=Execute.zero;
		Add_Result=Execute.addresult;
		
		/////////////1 MMMMMMMUUUUUUUUUUUXXXXXXXXXX
		
		MUX=InstructionDecode.writeReg;
		
		/////////////////////////////////////
		
		
	}
}
