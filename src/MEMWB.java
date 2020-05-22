public class MEMWB {
	

	static boolean MemtoReg = false;
	static boolean RegWrite = false;
	static int pc ;
	static String ReadData ;//= "00000000000000000000000000000000";
	static String ALU_Result ;//= "00000000000000000000000000000000";
	static String MUX  ;//= "00000";
	static String p ; 
	static String pOUT ; 

	static boolean MemtoRegOUT = false;
	static boolean RegWriteOUT = false;
	static int pcOUT;
	static String ReadDataOUT;// = "00000000000000000000000000000000";
	static String ALU_ResultOUT;// = "00000000000000000000000000000000";
	static String MUXOUT  ;//= "00000";
	public static  void main(String[] args) {
		ALU_ResultOUT=ALU_Result;
		ReadDataOUT=ReadData;
		MUXOUT=MUX;
		pcOUT=pc;
		MemtoRegOUT=MemtoReg;
		RegWriteOUT=RegWrite;
		
		pOUT=p;
		p=EXMEM.pOUT;
		

		MemtoReg=IDEX.MemtoRegOUT;
		RegWrite=IDEX.RegWriteOUT;
		
		ALU_Result=EXMEM.ALU_ResultOUT;
		ReadData=Memory.ReadData;
		MUX=EXMEM.MUXOUT;
		
		pc = EXMEM.pcOUT;
		if (p !=null )//|| pOUT!=null)
	System.out.println(ToString());
		Main.res+="\n"+(ToString());
}
	public static String ToString() {
		return	"ALU result :"+ALU_Result+"\n"
				+"Memory word read "+ReadData
				+"rt/rd fileds :"+MUX+"\n"
				+"WB controls : MemToReg :"+MemtoReg+" ,WriteReg: "+RegWrite;
				
				
				
//				"MEMWB [MemtoReg=" + MemtoReg + ", RegWrite=" + RegWrite
//				+ ", ReadData=" + ReadData + ", ALU_Result=" + ALU_Result
//				+ ", MUX=" + MUX + ", MemtoRegOUT=" + MemtoRegOUT
//				+ ", RegWriteOUT=" + RegWriteOUT + ", ReadDataOUT="
//				+ ReadDataOUT + ", ALU_ResultOUT=" + ALU_ResultOUT
//				+ ", MUXOUT=" + MUXOUT + "]";
	}

}
