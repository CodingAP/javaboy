package emulation.cpu;

import emulation.memory.Memory;

public class CPU {
	private int programCounter, stackPointer;
	private PSWRegister registerPSW;
	private RegisterPair registerBC, registerDE, registerHL;
	private boolean interruptDisabled, cpuOn, screenOn;
	private Opcodes ops;
	public Disassembler disassembler;
	private Memory mem;
	
	public CPU() {
		registerPSW = new PSWRegister();
		registerBC = new RegisterPair();
		registerDE = new RegisterPair();
		registerHL = new RegisterPair();
		programCounter = 0;
		stackPointer = 0;
		interruptDisabled = false;
		cpuOn = true;
		screenOn = true;
		
		ops = new Opcodes(this);
		disassembler = new Disassembler(this);
	}
	
	public int clock() {
		int opcode = this.getNext();
		ops.run(opcode);
		return opcode;
	}
	
	public String disassemble() {
		return this.disassemble(0x0000, 0xffff);
	}
	
	public String disassemble(int start) {
		return this.disassemble(start, 0xffff);
	}
	
	public String disassemble(int start, int end) {
		String result = "";
		for (int i = start; i < start + end; i++) {
            
        }
		return result;
	}
	
	public int getNext() {
		int data = mem.read(programCounter);
		programCounter++;
		return data;
	}
	
	public void attachMemory(Memory mem) {
		this.mem = mem;
	}
	
	public Memory getMemory() {
		return mem;
	}

	public int getProgramCounter() {
		return programCounter;
	}

	public void setProgramCounter(int programCounter) {
		this.programCounter = programCounter;
	}

	public int getStackPointer() {
		return stackPointer;
	}

	public void setStackPointer(int stackPointer) {
		this.stackPointer = stackPointer;
	}

	public PSWRegister getRegisterPSW() {
		return registerPSW;
	}

	public RegisterPair getRegisterBC() {
		return registerBC;
	}

	public RegisterPair getRegisterDE() {
		return registerDE;
	}

	public RegisterPair getRegisterHL() {
		return registerHL;
	}

	public boolean isInterruptDisabled() {
		return interruptDisabled;
	}

	public void setInterruptDisabled(boolean interruptDisabled) {
		this.interruptDisabled = interruptDisabled;
	}

	public boolean isCpuOn() {
		return cpuOn;
	}

	public void setCpuOn(boolean cpuOn) {
		this.cpuOn = cpuOn;
	}

	public boolean isScreenOn() {
		return screenOn;
	}

	public void setScreenOn(boolean screenOn) {
		this.screenOn = screenOn;
	}
}