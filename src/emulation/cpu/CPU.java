package emulation.cpu;

import emulation.memory.Memory;

public class CPU {
	private int programCounter, stackPointer;
	private PSWRegister registerPSW;
	private RegisterPair registerBC, registerDE, registerHL;
	private boolean interruptDisabled, cpuOn, screenOn;
	private Opcodes ops;
	private Memory mem;
	private Disassembler disassembler;
	
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
	
	public String disassemble() {
		disassembler.setCounter(programCounter);
		return disassembler.run(mem.read(programCounter));
	}
	
	public int clock() {
		int opcode = this.getNext();
		ops.run(opcode);
		return opcode;
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
	
	public Disassembler getDisassembler() {
		return disassembler;
	}
}