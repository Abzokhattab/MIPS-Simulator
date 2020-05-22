public class RegisterFile {

	Register[] registers;
	
	/**
	 * Constructs a new 32-register file
	 */
	public RegisterFile()
	{
		registers = new Register[32];
		int c3= 0; 
		int c4 =0 ;
		int c5=0 ;
		int c6 =0 ;
		int c7 =0 ;

		for(int i = 0; i < 32; ++i){
			registers[i] = new Register(32);
			if (i==0)registers[i].setName("$zero");
			if (i==1)registers[i].setName("$at");
			if (i>=2&&i<=3){registers[i].setName("$v"+c3); c3++;}
			if (i>=4&&i<=7){registers[i].setName("$a"+c4);  c4++;}
			if (i>=8&&i<=15){registers[i].setName("$t"+c5);  c5++;}
			if (i>=16&&i<=23){registers[i].setName("$s"+c6);  c6++;}
			if (i==24){registers[i].setName("t8");}
			if (i==25){registers[i].setName("t9");}
			if (i>=26&&i<=27){registers[i].setName("$k"+c7);  c7++;}
			if (i==28){registers[i].setName("$gp");}
			if (i==29){registers[i].setName("$sp");}
			if (i==30){registers[i].setName("$fp");}
			if (i==31){registers[i].setName("$ra");}




		}
	}
	
	/**
	 * Read the register at the specified index
	 * @param index the index of the register to be read
	 * @return the register at the given index
	 */
	public Register readRegister(String index)
	{
		int decimal=Integer.parseInt(index,2);  

		return registers[decimal];
	}
	
	/**
	 * Write the passed value to the register at the specified index
	 * @param index the index of the register to write at
	 * @param value the value to be written
	 */
	public void writeRegister(String index, String value)
	{
		int decimal=Integer.parseInt(index,2);  
		registers[decimal].setValue(value);
	}
	
	/**
	 * Returns a string representation of the register file
	 */
	public String toString()
	{
		String r = "";
		for(int i = 0; i < 32; ++i)
			r += registers[i].toString() + "\n";
		return r;
	}
	
}