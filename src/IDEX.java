public class IDEX {
	static String readData1 ;//= "00000000000000000000000000000000";
	static String readData2 ;//= "00000000000000000000000000000000";
	static String Immediate ;//= "00000000000000000000000000000000";
	static String rt ;//= "00000";
	static String rd ;//= "00000";
	static String JumpAdd ;//= "00000000000000000000000000000000";
	static boolean RegDst = false;
	static boolean Jump = false;
	static boolean Branch = false;
	static boolean MemRead = false;
	static boolean MemtoReg = false;
	static boolean Memwrite = false;
	static String ALUOp = "00";
	static boolean ALUSrc = false;
	static boolean RegWrite = false;
	static int pc4 ; 
	static String p ;  
	
	static String JumpAddOUT ;//= "00000000000000000000000000000000";
	static String ImmediateOUT ;//= "00000000000000000000000000000000";
	static String rtOUT ;//= "00000";
	static String rdOUT ;//= "00000";
	static boolean RegDstOUT = false;
	static boolean JumpOUT = false;
	static boolean BranchOUT = false;
	static boolean MemReadOUT = false;
	static boolean MemtoRegOUT = false;
	static boolean MemwriteOUT = false;
	static String ALUOpOUT ;//= "00";
	static boolean ALUSrcOUT = false;
	static boolean RegWriteOUT = false;
	static String readData1OUT;// = "00000000000000000000000000000000";
	static String readData2OUT ;//= "00000000000000000000000000000000";
	static int pc4OUT;
	static String pOUT ; 
	public static  void main(String[] args) {
		JumpAddOUT=JumpAdd;
		ImmediateOUT=Immediate;
		readData1OUT=readData1;
		readData2OUT=readData2;
		rdOUT=rd;
		rtOUT=rt;
		RegDstOUT=RegDst;
		
		pOUT=p;
		
		JumpOUT=Jump;
		BranchOUT=Branch;
		MemReadOUT=MemRead;
		MemtoRegOUT=MemtoReg;
		ALUOpOUT=ALUOp;
		MemwriteOUT=Memwrite;
		ALUSrcOUT=ALUSrc;
		RegWriteOUT=RegWrite;
		pc4OUT=pc4;
		
		
		readData1=InstructionDecode.ReadData1;
		readData2=InstructionDecode.ReadData2;
		Immediate=InstructionDecode.offsetOimmediate;
		rd=InstructionDecode.rd;
		rt=InstructionDecode.rt;
		RegDst=InstructionDecode.cont.RegDst;
		Jump=InstructionDecode.cont.Jump;
		Branch=InstructionDecode.cont.Branch;
		MemRead=InstructionDecode.cont.MemRead;
		MemtoReg=InstructionDecode.cont.MemtoReg;
		ALUOp=InstructionDecode.cont.ALUOp;
		Memwrite=InstructionDecode.cont.Memwrite;
		ALUSrc=InstructionDecode.cont.ALUSrc;
		RegWrite=InstructionDecode.cont.RegWrite;
		pc4=IFID.pc4OUT;
		JumpAdd=InstructionDecode.jumpAdd;
		p =IFID.pOUT;
		
		if (p !=null )//|| pOUT!=null){
		{	

	System.out.println(ToString());	
	Main.res+="\n"+(ToString());
}
	}



	public static String ToString() {
		return "IDEX [readData1=" + readData1 +"\n"+ "readData2=" + readData2+"\n"
				+ "Sign Extend =" + Immediate +"\n"+ "rt=" + rt +"\n"+ "rd=" + rd+"\n"
				+ "WB controls: "+"MemtoReg=" + MemtoReg +",RegWrite: "+RegWrite+"\n"+
				"MEM controls: MemRead: "+ MemRead+", Memwrite=" + Memwrite+", Branch=" + Branch +"\n"
				+"EX controls: RegDST: "+RegDst+",ALUOp: "+ALUOp+",ALUSrc: "+ALUSrc;
			
	}
	

}
