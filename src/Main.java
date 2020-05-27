import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
	static RegisterFile RegFile = new RegisterFile();
	static String[] mem = new String[1024];
	static String res =""; 
	
	static String [] IM ;
	/// Manual testsssssssss
/*	static String[] IM = { "00100000000010000000000000000101",
			"10001110000010010000000000000000",
			"00000001010010110110000000100000" };
			*/
	static int i =1;
	static LinkedList<String> Inputs=new LinkedList<String>();
	public static void main(String[] args) {

		String r = "";
		
		//check lowercase 
		
		
		
		

		System.out.println(RegFile.toString());

		 i = 0;
//		while (InstructionFetch.p != null || InstructionFetch.firstTime
//				|| IFID.pOUT != null || IDEX.pOUT != null || EXMEM.pOUT != null
//				|| MEMWB.pOUT != null) {
//			// System.out.println("dsasdasd  " + IFID.pOUT + "  " + IDEX.pOUT +
			// "  "
			// + EXMEM.pOUT + "  " + MEMWB.pOUT);
		 res ="";
			System.out.println();
			System.out.println("Cycle: " + i);
			i++;
			if (InstructionFetch.p != null || InstructionFetch.firstTime) {
				InstructionFetch.main(args);
				IFID.main(args);
			} else
				IFID.main(args);

			if (IFID.pOUT != null) {
				InstructionDecode.main(args);

				IDEX.main(args);

			} else
				IDEX.main(args);
			if (IDEX.pOUT != null) {
				Execute.main(args);
				EXMEM.main(args);

			} else
				EXMEM.main(args);
			if (EXMEM.pOUT != null) {
				Memory.main(args);
				MEMWB.main(args);
			} else
				MEMWB.main(args);

			if (MEMWB.pOUT != null)
				WriteBack.main(args);
		}

}


//DELETE COMMENTS BELO

//import java.util.LinkedList;
//import java.util.Scanner;
//import java.util.function.Function;
//
//public class Main {
//	static RegisterFile RegFile = new RegisterFile();
//	static String[] mem = new String[1024];
//	static String res =""; 
//	
//	/// Manual testsssssssss
//	static String[] IM = { "00100000000010000000000000000101",
//			"10001110000010010000000000000000",
// 	"00000001010010110110000000100000","00000001101011100111100000100101","10101110001100100000000000000000","00010010000000000000000011111111" };
//			
//	static int i =0;
//	static LinkedList<String> Inputs=new LinkedList<String>();
//	public static void main(String[] args) {
//
//		String r = "";
//		
//		//check lowercase 
//		
//		
//		
//		
//
//		System.out.println(RegFile.toString());
//
//		 i = 1;
//		while (InstructionFetch.p != null || InstructionFetch.firstTime
//				|| IFID.pOUT != null || IDEX.pOUT != null || EXMEM.pOUT != null
//				|| MEMWB.pOUT != null) {
//		// System.out.println("dsasdasd  " + IFID.pOUT + "  " + IDEX.pOUT +
//			// "  "
//			// + EXMEM.pOUT + "  " + MEMWB.pOUT);
//		 res ="";
//			System.out.println();
//			System.out.println("Cycle: " + i);
//			i++;
//			if (InstructionFetch.p != null || InstructionFetch.firstTime) {
//				InstructionFetch.main(args);
//				IFID.main(args);
//			} else
//				IFID.main(args);
//
//			if (IFID.pOUT != null) {
//				InstructionDecode.main(args);
//
//				IDEX.main(args);
//
//			} else
//				IDEX.main(args);
//			if (IDEX.pOUT != null) {
//				Execute.main(args);
//				EXMEM.main(args);
//
//			} else
//				EXMEM.main(args);
//			if (EXMEM.pOUT != null) {
//				Memory.main(args);
//				MEMWB.main(args);
//			} else
//				MEMWB.main(args);
//
//			if (MEMWB.pOUT != null)
//				WriteBack.main(args);
//		}
//
//}
//}