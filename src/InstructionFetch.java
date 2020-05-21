import javax.sound.midi.Instrument;

public class InstructionFetch {
	static String inst;
	static int pc;

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter pc number");
		// int pc = sc.nextInt();
		String[] IM = { "00000001101011100111100000100101",
				"01010101001010000101010100101011",
				"01010101001010110101110100101011",
				"01000101001110000101010101101011" };
		inst = IF(pc, IM);
		InstructionFetch.pc = InstructionFetch.pc + 1;

		// System.out.println("IF done and its Instruction = " + inst);
		
	}

	public static String IF(int pc, String[] im) {
		String instruction = im[pc];
		return instruction;
	}

}
