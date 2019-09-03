package emulation.cpu;

public class RegisterPair {
	private int register1, register2;
	
	public RegisterPair() {
		register1 = 0;
		register2 = 0;
	}
	
	public int getRegister1() {
		return register1;
	}
	
	public int getRegister2() {
		return register2;
	}
	
	public int getRegister() {
		return (register1 << 8) | register2;
	}
	
	public void setRegister1(int value) {
		register1 = value;
	}
	
	public void setRegister2(int value) {
		register2 = value;
	}
	
	public void setRegister(int value) {
		register1 = (value >> 8);
		register2 = value & 0xff;
	}
}