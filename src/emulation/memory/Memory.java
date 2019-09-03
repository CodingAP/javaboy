package emulation.memory;

public class Memory {
	private int[] memory = new int[64 * 1024];
	
	public Memory() {
		for (int i = 0; i < memory.length; i++) {
			memory[i] = 0;
		}
	}
	
	public int read(int addr) {
		if (addr >= 0x0000 && addr < 0xFFFF) {
			return memory[addr];
		}
		return 0;
	}
	
	public void write(int addr, int data) {
		if (addr >= 0x0000 && addr < 0xFFFF) {
			memory[addr] = data;
		}
	}
	
	public void loadToROM(String program) {
		this.loadToROM(program, 0);
	}
	
	public void loadToROM(String program, int start) {
		String[] bytes = program.split(" ");
		start /= 2;
		for (int i = start; i < start + bytes.length; i++) {
            memory[i * 2] = Integer.parseInt(bytes[i - start].substring(0, 2), 16);
            memory[i * 2 + 1] = Integer.parseInt(bytes[i - start].substring(2), 16);
        }
	}
	
	public int[] getMemory() {
		return memory;
	}
}