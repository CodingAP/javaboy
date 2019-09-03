package emulation.cpu;

public class PSWRegister {
	private int registerA, statusFlags;
	public static final int CARRY_FLAG = (1 << 4), SUBTRACT_FLAG = (1 << 5), HALF_CARRY_FLAG = (1 << 6), ZERO_FLAG = (1 << 7);
	
	public PSWRegister() {
		registerA = 0;
		statusFlags = 0;
	}
	
	public int getRegisterA() {
		return registerA;
	}
	
	public int getStatusFlags() {
		return statusFlags;
	}
	
	public int getRegister() {
		return (registerA << 8) | statusFlags;
	}
	
	public void setRegisterA(int value) {
		registerA = value;
	}
	
	public void setStatusFlags(int value) {
		statusFlags = value;
	}
	
	public void setRegister(int value) {
		registerA = (value >> 8);
		statusFlags = value;
	}
	
	public boolean getFlag(int flag) {
		int flagState = statusFlags & flag;
		return (flagState == 1) ? true : false;
	}
	
	public void setFlag(int flag, boolean on) {
		if (on) {
			statusFlags |= flag;
		} else {
			statusFlags &= ~flag;
		}
	}
}