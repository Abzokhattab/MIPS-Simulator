
public class IFID {
	static int  pc4; 
	static String inst = "00000000000000000000000000000000";
	static int pc4OUT; 
	static String instOUT = "00000000000000000000000000000000";

	
	
	
	
	public static void main (String[] args){
		pc4OUT=pc4;
		instOUT=inst;
		
		pc4 =	InstructionFetch.pc;
		inst =InstructionFetch.inst;
		
	}
}
