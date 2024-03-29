package emulation;

import emulation.cpu.CPU;
import emulation.memory.Memory;

public class Gameboy {
	public CPU cpu = new CPU();
	public Memory mem = new Memory();
	public String bootup = "31fe ffaf 21ff 9f32 cb7c 20fb 2126 ff0e " + 
						   "113e 8032 e20c 3ef3 e232 3e77 773e fce0 " + 
						   "4711 0401 2110 801a cd95 00cd 9600 137b " + 
						   "fe34 20f3 11d8 0006 081a 1322 2305 20f9 " + 
						   "3e19 ea10 9921 2f99 0e0c 3d28 0832 0d20 " + 
						   "f92e 0f18 f367 3e64 57e0 423e 91e0 4004 " + 
						   "1e02 0e0c f044 fe90 20fa 0d20 f71d 20f2 " + 
						   "0e13 247c 1e83 fe62 2806 1ec1 fe64 2006 " + 
						   "7be2 0c3e 87e2 f042 90e0 4215 20d2 0520 " + 
						   "4f16 2018 cb4f 0604 c5cb 1117 c1cb 1117 " + 
						   "0520 f522 2322 23c9 ceed 6666 cc0d 000b " + 
						   "0373 0083 000c 000d 0008 111f 8889 000e " + 
						   "dccc 6ee6 dddd d999 bbbb 6763 6e0e eccc " + 
						   "dddc 999f bbb9 333e 3c42 b9a5 b9a5 423c " + 
						   "2104 0111 a800 1a13 be20 fe23 7dfe 3420 " + 
						   "f506 1978 8623 0520 fb86 20fe 3e01 e050 " +
						   "00c3 0000 ceed 6666 cc0d 000b 0373 0083 " + 
						   "000c 000d 0008 111f 8889 000e dccc 6ee6 " +
						   "dddd d999 bbbb 6763 6e0e eccc dddc 999f " + 
						   "bbb9 333e";
	public String test = "08fe ff21 1000 e521 1100 e100";
	
	public Gameboy() {
		cpu.attachMemory(mem);
		mem.loadToROM(bootup);
		//mem.loadToROM(test);
	}
	
	public void run() {
		cpu.clock();
	}
}