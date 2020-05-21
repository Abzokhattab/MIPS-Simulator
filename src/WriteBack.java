public class WriteBack {
	static String WBresult;


	public static void main(String[] args) {
		BringResult();
		InstructionDecode.write(WBresult);
	//	System.out.println("WriteBack result : "+WBresult);
	}
	
	public static void BringResult() {
		if ( MEMWB.MemtoRegOUT ) {
			WBresult = MEMWB.ReadDataOUT;
		} else {
			WBresult = MEMWB.ALU_ResultOUT;
		}
	}

}
