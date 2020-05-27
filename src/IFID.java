
public class IFID {
	static int  pc4 ; 
	static String inst ;//= "00000000000000000000000000000000";
	static int pc4OUT; 
	static String instOUT;// = "00000000000000000000000000000000";

	static String p  ; 
	static String pOUT;
	
	
	public static void main (String[] args){
		pc4OUT=pc4;
		instOUT=inst;
		pOUT=p ;
		
		pc4 =	InstructionFetch.pc;
		inst =InstructionFetch.inst;
		p=InstructionFetch.p;
		if (p !=null )//|| pOUT!=null){
		{
			
			System.out.println("Fetch");
			Main.res+="\n"+(ToString());
	System.out.println(ToString());}
		}
	public static String ToString(){
		return ("Next PC :"+String.format("%32s",Integer.toBinaryString( IFID.pc4*4 )).replace(' ', '0')+"\n"
				+"Instruction : "+IFID.inst+"\n"
				);
				
		
	}
}