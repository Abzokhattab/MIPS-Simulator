public class EXMEM {
	static String readData2 ; //"00000000000000000000000000000000";
	static String ALU_Result ;//= "00000000000000000000000000000000";
	static String Add_Result ;//= "00000000000000000000000000000000";
	static boolean zero ;
	static String MUX ;// = "00000";
	static String JumpAdd ;//= "00000000000000000000000000000000";
	static int pc ;
	
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
	static String p ; 
	static String pOUT ; 
	static String JumpAddOUT ;//= "00000000000000000000000000000000";
	static String readData2OUT ;//= "00000000000000000000000000000000";
	static String ALU_ResultOUT ;//= "00000000000000000000000000000000";
	static String Add_ResultOUT ;//= "00000000000000000000000000000000";
	static boolean zeroOUT ;
	static String MUXOUT ;// = "00000";
	static int pcOUT;
	public static void main(String[] args) {
		pOUT=p;
		p=IDEX.pOUT;
		readData2OUT=readData2;
		ALU_ResultOUT=ALU_Result;
		Add_ResultOUT=Add_Result;
		zeroOUT=zero;
		MUXOUT=MUX;
		JumpAddOUT=JumpAdd;
		
		JumpOUT=Jump;
		BranchOUT=Branch;
		MemReadOUT=MemRead;
		MemtoRegOUT=MemtoReg;
		MemwriteOUT=Memwrite;
		RegWriteOUT=RegWrite;
		pcOUT=pc ; 
		

		Jump=IDEX.JumpOUT;
		Branch=IDEX.BranchOUT;
		MemRead=IDEX.MemReadOUT;
		MemtoReg=IDEX.MemtoRegOUT;
		Memwrite=IDEX.MemwriteOUT;
		RegWrite=IDEX.RegWriteOUT;
		
		JumpAdd=IDEX.JumpAddOUT;
		readData2=IDEX.readData2OUT;
		ALU_Result=Execute.ALUresult;
		zero=Execute.zero;
		Add_Result=Execute.addresult;
		pc= IDEX.pc4OUT;
		/////////////1 MMMMMMMUUUUUUUUUUUXXXXXXXXXX
		
		MUX=Execute.writeReg;
		
		/////////////////////////////////////
		
		if (p !=null )//|| pOUT!=null)
	System.out.println(ToString());
		Main.res+="\n"+(ToString());
}

	public static String ToString() {
		return "zero flag : "+zero+"\n"
				+ "branch address :"+Add_Result+"\n"
				///////////////
				+ "ALU result : "+ALU_Result+"\n"
				+ "register value to write mem :"+MUX+"\n"
				+"rt/rd: "+MUX+"\n"
				+"WB controls: MemToReg: "+MemtoReg+" ,RegWrite: "+RegWrite+"\n"
				+"Mem controls: MemRead: "+MemRead+" ,MemWrite: "+Memwrite+", Branch: "+Branch;
				///////////
			
	}
}
