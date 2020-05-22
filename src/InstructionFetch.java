import javax.sound.midi.Instrument;

public class InstructionFetch {
	static String inst;//="00000000000000000000000000000000"; 
	static int pc; 
	static boolean firstTime =true; 
	static String p ; 

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter pc number");
		// int pc = sc.nextInt();
		String[] IM = Main.IM;
//		
//		if (firstTime){
//			inst = IF(pc, IM);
//			InstructionFetch.pc = InstructionFetch.pc + 1;
           //			firstTime= false; 
//		//	System.out.println("First +"+inst);
//
// 	
//		}else {
		 String ALuMuxPC_Result = Memory.ALuMuxPC( Integer.toBinaryString(pc), EXMEM.Add_ResultOUT,
				Memory.BranchAndZero(EXMEM.zeroOUT, EXMEM.BranchOUT));
		/////////////// jumpppppppppppp
		String JumpAluMux_Result=Memory.JumpAluMux(EXMEM.JumpAddOUT, ALuMuxPC_Result, EXMEM.JumpOUT);
		pc =Integer.parseInt(JumpAluMux_Result, 2);

 try {
		inst = IF(pc, IM);
		
 
		//System.out.println("qweqwewqe +"+inst);
		p= pc+"" ;

 }catch(Exception e){
	 p =  null;
 }

	InstructionFetch.pc = InstructionFetch.pc + 1;
	
	if(firstTime){firstTime=false ;
//	pc--;}
	}
		// System.out.println("IF done and its Instruction = " + inst);
	//	}	
//		System.out.println(ToString());
		
	}

	public static String IF(int pc, String[] im) {
	//	System.out.println(pc);
		String instruction = im[pc];
		return instruction;
	}

	public static String ToString(){
		return ("pc4 :"+IFID.pc4 +"\n"
				+"instruction : "+IFID.inst+"\n"+
				"pc4OUT : "+IFID.pc4OUT+"\n"
				+"instructionOUT : "+IFID.instOUT );
				
		
	}

	
}
