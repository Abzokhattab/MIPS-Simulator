public class Control {
	boolean RegDst = false;
	boolean Jump = false;
	boolean Branch = false;
	boolean MemRead = false;
	boolean MemtoReg = false;
	boolean Memwrite = false;
	String ALUOp = "00";
	boolean ALUSrc = false;
	boolean RegWrite = false;

	public void parse(String op) {
		if (op.equals("000000")) {// RTYPE
			this.RegDst = true;
			this.RegWrite = true;// WHAT SHOULD I DO
			this.ALUOp = "10";
		} else if (op.equals("100011")) {// LW
			this.ALUSrc = true;
			this.MemtoReg = true;// Handeled in WriteBack class
			this.MemRead = true;// WHAT SHOULD I DO
			this.RegWrite = true;// WHAT SHOULD I DO
			this.ALUOp = "00";

		} else if (op.equals("101011")) {// SW
			this.ALUOp = "00";
			this.ALUSrc = true;
			this.Memwrite = true;// WHAT SHOULD I DO
			
		} else if (op.equals("000100")) {// BEQ
			this.ALUOp = "01";
			this.Branch = true;
		} else if (op.equals("000010")) {// Jump
			this.Jump = true;
			ALUOp="00";
		}
		else if (op.equals("001000")){
			ALUSrc=true ;
			RegWrite=true; 
			ALUOp="00";
		}

	}

}