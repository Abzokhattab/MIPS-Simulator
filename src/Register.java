
public class Register {

	private String name;
	private int size;
	private String value;
	
	/**
	 * Constructs a new register with the specified number of bits
	 * @param size the size of the register in bits
	 */
	public Register(int size)
	{
		this.value=Integer.toBinaryString(0);
		this.size = size;
	}
	
	/**
	 * Retrieves the bits of the register between left and right indices, inclusive
	 * @param left the index of the leftmost bit to be retrieved
	 * @param right the index of the rightmost bit to be retrieved
	 * @return the segment of bits between left and right
	 */
	/*public int getSegment(int left, int right)
	{
		return (value >> right) & ((1 << left - right + 1)-1); 
	}*/
	
	/**
	 * Returns the value of the register
	 * @return the value of the register
	 */
	public String getValue()
	{
		return value;
	}
	
	/**
	 * Sets the value of the register
	 * @param value the new value of the register
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
	
	/**
	 * Returns the size of the register in bits
	 * @return the size of the register in bits
	 */
	public int getSize()
	{
		return size;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets register to 0
	 */
	public void clear()
	{
		value = "0";
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", value=" + value + "]";
	}
	
	/**
	 * Returns a String representation of the register
	 */
	
}