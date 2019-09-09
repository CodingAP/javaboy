package emulation.cpu;

import emulation.Utils;

public class Disassembler {
	private CPU cpu;
	private int counter;
	
	public Disassembler(CPU cpu) {
		this.cpu = cpu;
		counter = 0;
	}
	
	public String run(int opcode) {
		switch (opcode) {
			case 0x00: return this.nop();
			case 0x3e: return this.ldn("A"); 
			case 0x06: return this.ldn("B"); 
			case 0x0e: return this.ldn("C"); 
			case 0x16: return this.ldn("D"); 
			case 0x1e: return this.ldn("E"); 
			case 0x26: return this.ldn("H"); 
			case 0x2e: return this.ldn("L"); 
			case 0x7f: return this.ldrr("A", "A"); 
			case 0x78: return this.ldrr("A", "B"); 
			case 0x79: return this.ldrr("A", "C"); 
			case 0x7a: return this.ldrr("A", "D"); 
			case 0x7b: return this.ldrr("A", "E"); 
			case 0x7c: return this.ldrr("A", "H"); 
			case 0x7d: return this.ldrr("A", "L"); 
			case 0x7e: return this.ldrr("A", "(HL)"); 
			case 0x47: return this.ldrr("B", "A"); 
			case 0x40: return this.ldrr("B", "B"); 
			case 0x41: return this.ldrr("B", "C"); 
			case 0x42: return this.ldrr("B", "D"); 
			case 0x43: return this.ldrr("B", "E"); 
			case 0x44: return this.ldrr("B", "H"); 
			case 0x45: return this.ldrr("B", "L"); 
			case 0x46: return this.ldrr("B", "(HL)"); 
			case 0x4f: return this.ldrr("C", "A"); 
			case 0x48: return this.ldrr("C", "B"); 
			case 0x49: return this.ldrr("C", "C"); 
			case 0x4a: return this.ldrr("C", "D"); 
			case 0x4b: return this.ldrr("C", "E"); 
			case 0x4c: return this.ldrr("C", "H"); 
			case 0x4d: return this.ldrr("C", "L"); 
			case 0x4e: return this.ldrr("C", "(HL)"); 
			case 0x57: return this.ldrr("D", "A"); 
			case 0x50: return this.ldrr("D", "B"); 
			case 0x51: return this.ldrr("D", "C"); 
			case 0x52: return this.ldrr("D", "D"); 
			case 0x53: return this.ldrr("D", "E"); 
			case 0x54: return this.ldrr("D", "H"); 
			case 0x55: return this.ldrr("D", "L"); 
			case 0x56: return this.ldrr("D", "(HL)"); 
			case 0x5f: return this.ldrr("E", "A"); 
			case 0x58: return this.ldrr("E", "B"); 
			case 0x59: return this.ldrr("E", "C"); 
			case 0x5a: return this.ldrr("E", "D"); 
			case 0x5b: return this.ldrr("E", "E"); 
			case 0x5c: return this.ldrr("E", "H"); 
			case 0x5d: return this.ldrr("E", "L"); 
			case 0x5e: return this.ldrr("E", "(HL)"); 
			case 0x67: return this.ldrr("H", "A"); 
			case 0x60: return this.ldrr("H", "B"); 
			case 0x61: return this.ldrr("H", "C");  //6F: LD H, C - Load Register C to Register H - Page 66
			case 0x62: return this.ldrr("H", "D"); 
			case 0x63: return this.ldrr("H", "E"); 
			case 0x64: return this.ldrr("H", "H"); 
			case 0x65: return this.ldrr("H", "L"); 
			case 0x66: return this.ldrr("H", "(HL)"); 
			case 0x6f: return this.ldrr("L", "A"); 
			case 0x68: return this.ldrr("L", "B"); 
			case 0x69: return this.ldrr("L", "C"); 
			case 0x6a: return this.ldrr("L", "D"); 
			case 0x6b: return this.ldrr("L", "E"); 
			case 0x6c: return this.ldrr("L", "H"); 
			case 0x6d: return this.ldrr("L", "L"); 
			case 0x6e: return this.ldrr("L", "(HL)"); 
			case 0x77: return this.ldrr("(HL)", "A"); 
			case 0x70: return this.ldrr("(HL)", "B"); 
			case 0x71: return this.ldrr("(HL)", "C"); 
			case 0x72: return this.ldrr("(HL)", "D"); 
			case 0x73: return this.ldrr("(HL)", "E"); 
			case 0x74: return this.ldrr("(HL)", "H"); 
			case 0x75: return this.ldrr("(HL)", "L"); 
			case 0x36: return this.ldrn("(HL)", "n"); 
			case 0x0a: return this.ldrr("A", "(BC)"); 
			case 0x1a: return this.ldrr("A", "(DE)"); 
			case 0xfa: return this.ldrnn("A", "(nn)"); 
			case 0x02: return this.ldrr("(BC)", "A"); 
			case 0x12: return this.ldrr("(DE)", "A"); 
			case 0xea: return this.ldnnr("(nn)", "A"); 
			case 0xf2: return this.ldalp("C"); 
			case 0xe2: return this.ldlpa("C"); 
			case 0xe0: return this.ldalp("n"); 
			case 0xf0: return this.ldlpa("n"); 
			case 0x3a: return this.ldd("A", "(HL)"); 
			case 0x32: return this.ldd("(HL)", "A"); 
			case 0x2a: return this.ldi("A", "(HL)"); 
			case 0x22: return this.ldi("(HL)", "A"); 
			case 0x01: return this.ldrnn("BC", "nn"); 
			case 0x11: return this.ldrnn("DE", "nn"); 
			case 0x21: return this.ldrnn("HL", "nn"); 
			case 0x31: return this.ldrnn("SP", "nn"); 
			case 0xf9: return this.ldrr("SP", "HL"); 
			case 0xf8: return this.ldhl(); 
			case 0x08: return this.ldrnn("SP", "nn"); 
			case 0xf5: return this.push("AF"); 
			case 0xc5: return this.push("BC"); 
			case 0xd5: return this.push("DE"); 
			case 0xe5: return this.push("HL"); 
			case 0xf1: return this.pop("AF"); 
			case 0xc1: return this.pop("BC"); 
			case 0xd1: return this.pop("DE"); 
			case 0xe1: return this.pop("HL"); 
			case 0x87: return this.add("A"); 
			case 0x80: return this.add("B"); 
			case 0x81: return this.add("C"); 
			case 0x82: return this.add("D"); 
			case 0x83: return this.add("E"); 
			case 0x84: return this.add("H"); 
			case 0x85: return this.add("L"); 
			case 0x86: return this.add("(HL)"); 
			case 0xc6: return this.addn("n"); 
			case 0x8f: return this.add("A", true); 
			case 0x88: return this.add("B", true); 
			case 0x89: return this.add("C", true); 
			case 0x8a: return this.add("D", true); 
			case 0x8b: return this.add("E", true); 
			case 0x8c: return this.add("H", true); 
			case 0x8d: return this.add("L", true); 
			case 0x8e: return this.add("(HL)", true); 
			case 0xce: return this.addn("n", true); 
			case 0x97: return this.sub("A"); 
			case 0x90: return this.sub("B"); 
			case 0x91: return this.sub("C"); 
			case 0x92: return this.sub("D"); 
			case 0x93: return this.sub("E"); 
			case 0x94: return this.sub("H"); 
			case 0x95: return this.sub("L"); 
			case 0x96: return this.sub("(HL)"); 
			case 0xd6: return this.subn("n"); 
			case 0x9f: return this.sub("A", true); 
			case 0x98: return this.sub("B", true); 
			case 0x99: return this.sub("C", true); 
			case 0x9a: return this.sub("D", true); 
			case 0x9b: return this.sub("E", true); 
			case 0x9c: return this.sub("H", true); 
			case 0x9d: return this.sub("L", true); 
			case 0x9e: return this.sub("(HL)", true); 
			case 0xde: return this.subn("n", true); 
			case 0xa7: return this.and("A"); 
			case 0xa0: return this.and("B"); 
			case 0xa1: return this.and("C"); 
			case 0xa2: return this.and("D"); 
			case 0xa3: return this.and("E"); 
			case 0xa4: return this.and("H"); 
			case 0xa5: return this.and("L"); 
			case 0xa6: return this.and("(HL)"); 
			case 0xe6: return this.andn("n"); 
			case 0xb7: return this.or("A"); 
			case 0xb0: return this.or("B"); 
			case 0xb1: return this.or("C"); 
			case 0xb2: return this.or("D"); 
			case 0xb3: return this.or("E"); 
			case 0xb4: return this.or("H"); 
			case 0xb5: return this.or("L"); 
			case 0xb6: return this.or("(HL)"); 
			case 0xf6: return this.orn("n"); 
			case 0xaf: return this.xor("A"); 
			case 0xa8: return this.xor("B"); 
			case 0xa9: return this.xor("C"); 
			case 0xaa: return this.xor("D"); 
			case 0xab: return this.xor("E"); 
			case 0xac: return this.xor("H"); 
			case 0xad: return this.xor("L"); 
			case 0xae: return this.xor("(HL)"); 
			case 0xee: return this.xorn("n"); 
			case 0xbf: return this.cp("A"); 
			case 0xb8: return this.cp("B"); 
			case 0xb9: return this.cp("C"); 
			case 0xba: return this.cp("D"); 
			case 0xbb: return this.cp("E"); 
			case 0xbc: return this.cp("H"); 
			case 0xbd: return this.cp("L"); 
			case 0xbe: return this.cp("(HL)"); 
			case 0xfe: return this.cpn("n"); 
			case 0x3c: return this.inc("A"); 
			case 0x04: return this.inc("B"); 
			case 0x0c: return this.inc("C"); 
			case 0x14: return this.inc("D"); 
			case 0x1c: return this.inc("E"); 
			case 0x24: return this.inc("H"); 
			case 0x2c: return this.inc("L"); 
			case 0x34: return this.inc("(HL)"); 
			case 0x3d: return this.dec("A"); 
			case 0x05: return this.dec("B"); 
			case 0x0d: return this.dec("C"); 
			case 0x15: return this.dec("D"); 
			case 0x1d: return this.dec("E"); 
			case 0x25: return this.dec("H"); 
			case 0x2d: return this.dec("L"); 
			case 0x35: return this.dec("(HL)"); 
			case 0x09: return this.add16("BC"); 
			case 0x19: return this.add16("DE"); 
			case 0x29: return this.add16("HL"); 
			case 0x39: return this.add16("SP"); 
			case 0xe8: return this.addsp(); 
			case 0x03: return this.inc("BC"); 
			case 0x13: return this.inc("DE"); 
			case 0x23: return this.inc("HL"); 
			case 0x33: return this.inc("SP"); 
			case 0x0b: return this.dec("BC"); 
			case 0x1b: return this.dec("DE"); 
			case 0x2b: return this.dec("HL"); 
			case 0x3b: return this.dec("SP"); 
			case 0x27: return this.daa(); 
			case 0x2f: return this.cpl(); 
			case 0x3f: return this.ccf(); 
			case 0x37: return this.scf(); 
			case 0x76: return this.halt(); 
			case 0x10: return this.stop(); 
			case 0xf3: return this.inte(false); 
			case 0xfb: return this.inte(true); 
			case 0x07: return this.rla(false); 
			case 0x17: return this.rla(true); 
			case 0x0f: return this.rra(false); 
			case 0x1f: return this.rra(true); 
			case 0xc3: return this.jpnn(); 
			case 0xc2: return this.jpc("NZ"); 
			case 0xca: return this.jpc("Z"); 
			case 0xd2: return this.jpc("NC"); 
			case 0xda: return this.jpc("C"); 
			case 0xe9: return this.jphl(); 
			case 0x18: return this.jpr(); 
			case 0x20: return this.jprc("NZ"); 
			case 0x28: return this.jprc("Z"); 
			case 0x30: return this.jprc("NC"); 
			case 0x38: return this.jprc("C"); 
			case 0xcd: return this.call(); 
			case 0xc4: return this.callc("NZ"); 
			case 0xcc: return this.callc("Z"); 
			case 0xd4: return this.callc("NC"); 
			case 0xdc: return this.callc("C"); 
			case 0xc7: return this.rst(0x00); 
			case 0xcf: return this.rst(0x08); 
			case 0xd7: return this.rst(0x10); 
			case 0xdf: return this.rst(0x18); 
			case 0xe7: return this.rst(0x20); 
			case 0xef: return this.rst(0x28); 
			case 0xf7: return this.rst(0x30); 
			case 0xff: return this.rst(0x38); 
			case 0xc9: return this.ret(false); 
			case 0xd9: return this.ret(true); 
			case 0xc0: return this.retc("NZ"); 
			case 0xc8: return this.retc("Z"); 
			case 0xd0: return this.retc("NC"); 
			case 0xd8: return this.retc("C"); 
			case 0xcb: return this.c6bit(); 
			default: return this.unknown(); 
		}
	}
	
	public void unknown(int opcode) {
		System.out.println("Unknown Opcode: " + Utils.toHex(opcode));
	}
	
	public String c6bit() {
		counter += 1;
		int opcode = cpu.getMemory().read(counter);
		switch (opcode) {
			case 0x37: return this.swap("A"); 
			case 0x30: return this.swap("B"); 
			case 0x31: return this.swap("C"); 
			case 0x32: return this.swap("D"); 
			case 0x33: return this.swap("E"); 
			case 0x34: return this.swap("H"); 
			case 0x35: return this.swap("L"); 
			case 0x36: return this.swap("(HL)"); 
			case 0x07: return this.rl("A", false); 
			case 0x00: return this.rl("B", false); 
			case 0x01: return this.rl("C", false); 
			case 0x02: return this.rl("D", false); 
			case 0x03: return this.rl("E", false); 
			case 0x04: return this.rl("H", false); 
			case 0x05: return this.rl("L", false); 
			case 0x06: return this.rl("(HL)", false); 
			case 0x17: return this.rl("A", true); 
			case 0x10: return this.rl("B", true); 
			case 0x11: return this.rl("C", true); 
			case 0x12: return this.rl("D", true); 
			case 0x13: return this.rl("E", true); 
			case 0x14: return this.rl("H", true); 
			case 0x15: return this.rl("L", true); 
			case 0x16: return this.rl("(HL)", true); 
			case 0x0f: return this.rr("A", false); 
			case 0x08: return this.rr("B", false); 
			case 0x09: return this.rr("C", false); 
			case 0x0a: return this.rr("D", false); 
			case 0x0b: return this.rr("E", false); 
			case 0x0c: return this.rr("H", false); 
			case 0x0d: return this.rr("L", false); 
			case 0x0e: return this.rr("(HL)", false); 
			case 0x1f: return this.rr("A", true); 
			case 0x18: return this.rr("B", true); 
			case 0x19: return this.rr("C", true); 
			case 0x1a: return this.rr("D", true); 
			case 0x1b: return this.rr("E", true); 
			case 0x1c: return this.rr("H", true); 
			case 0x1d: return this.rr("L", true); 
			case 0x1e: return this.rr("(HL)", true); 
			case 0x27: return this.sl("A"); 
			case 0x20: return this.sl("B"); 
			case 0x21: return this.sl("C"); 
			case 0x22: return this.sl("D"); 
			case 0x23: return this.sl("E"); 
			case 0x24: return this.sl("H"); 
			case 0x25: return this.sl("L"); 
			case 0x26: return this.sl("(HL)"); 
			case 0x2f: return this.sr("A", false); 
			case 0x28: return this.sr("B", false); 
			case 0x29: return this.sr("C", false); 
			case 0x2a: return this.sr("D", false); 
			case 0x2b: return this.sr("E", false); 
			case 0x2c: return this.sr("H", false); 
			case 0x2d: return this.sr("L", false); 
			case 0x2e: return this.sr("(HL)", false); 
			case 0x3f: return this.sr("A", true); 
			case 0x38: return this.sr("B", true); 
			case 0x39: return this.sr("C", true); 
			case 0x3a: return this.sr("D", true); 
			case 0x3b: return this.sr("E", true); 
			case 0x3c: return this.sr("H", true); 
			case 0x3d: return this.sr("L", true); 
			case 0x3e: return this.sr("(HL)", true); 
			case 0x47: return this.bit(0, "A"); 
			case 0x40: return this.bit(0, "B"); 
			case 0x41: return this.bit(0, "C"); 
			case 0x42: return this.bit(0, "D"); 
			case 0x43: return this.bit(0, "E"); 
			case 0x44: return this.bit(0, "H"); 
			case 0x45: return this.bit(0, "L"); 
			case 0x46: return this.bit(0, "(HL)"); 
			case 0x4f: return this.bit(1, "A"); 
			case 0x48: return this.bit(1, "B"); 
			case 0x49: return this.bit(1, "C"); 
			case 0x4a: return this.bit(1, "D"); 
			case 0x4b: return this.bit(1, "E"); 
			case 0x4c: return this.bit(1, "H"); 
			case 0x4d: return this.bit(1, "L"); 
			case 0x4e: return this.bit(1, "(HL)"); 
			case 0x57: return this.bit(2, "A"); 
			case 0x50: return this.bit(2, "B"); 
			case 0x51: return this.bit(2, "C"); 
			case 0x52: return this.bit(2, "D"); 
			case 0x53: return this.bit(2, "E"); 
			case 0x54: return this.bit(2, "H"); 
			case 0x55: return this.bit(2, "L"); 
			case 0x56: return this.bit(2, "(HL)"); 
			case 0x5f: return this.bit(3, "A"); 
			case 0x58: return this.bit(3, "B"); 
			case 0x59: return this.bit(3, "C"); 
			case 0x5a: return this.bit(3, "D"); 
			case 0x5b: return this.bit(3, "E"); 
			case 0x5c: return this.bit(3, "H"); 
			case 0x5d: return this.bit(3, "L"); 
			case 0x5e: return this.bit(3, "(HL)"); 
			case 0x67: return this.bit(4, "A"); 
			case 0x60: return this.bit(4, "B"); 
			case 0x61: return this.bit(4, "C"); 
			case 0x62: return this.bit(4, "D"); 
			case 0x63: return this.bit(4, "E"); 
			case 0x64: return this.bit(4, "H"); 
			case 0x65: return this.bit(4, "L"); 
			case 0x66: return this.bit(4, "(HL)"); 
			case 0x6f: return this.bit(5, "A"); 
			case 0x68: return this.bit(5, "B"); 
			case 0x69: return this.bit(5, "C"); 
			case 0x6a: return this.bit(5, "D"); 
			case 0x6b: return this.bit(5, "E"); 
			case 0x6c: return this.bit(5, "H"); 
			case 0x6d: return this.bit(5, "L"); 
			case 0x6e: return this.bit(5, "(HL)"); 
			case 0x77: return this.bit(6, "A"); 
			case 0x70: return this.bit(6, "B"); 
			case 0x71: return this.bit(6, "C"); 
			case 0x72: return this.bit(6, "D"); 
			case 0x73: return this.bit(6, "E"); 
			case 0x74: return this.bit(6, "H"); 
			case 0x75: return this.bit(6, "L"); 
			case 0x76: return this.bit(6, "(HL)"); 
			case 0x7f: return this.bit(7, "A"); 
			case 0x78: return this.bit(7, "B"); 
			case 0x79: return this.bit(7, "C"); 
			case 0x7a: return this.bit(7, "D"); 
			case 0x7b: return this.bit(7, "E"); 
			case 0x7c: return this.bit(7, "H"); 
			case 0x7d: return this.bit(7, "L"); 
			case 0x7e: return this.bit(7, "(HL)"); 
			case 0xc7: return this.set(0, "A"); 
			case 0xc0: return this.set(0, "B"); 
			case 0xc1: return this.set(0, "C"); 
			case 0xc2: return this.set(0, "D"); 
			case 0xc3: return this.set(0, "E"); 
			case 0xc4: return this.set(0, "H"); 
			case 0xc5: return this.set(0, "L"); 
			case 0xc6: return this.set(0, "(HL)"); 
			case 0xcf: return this.set(1, "A"); 
			case 0xc8: return this.set(1, "B"); 
			case 0xc9: return this.set(1, "C"); 
			case 0xca: return this.set(1, "D"); 
			case 0xcb: return this.set(1, "E"); 
			case 0xcc: return this.set(1, "H"); 
			case 0xcd: return this.set(1, "L"); 
			case 0xce: return this.set(1, "(HL)"); 
			case 0xd7: return this.set(2, "A"); 
			case 0xd0: return this.set(2, "B"); 
			case 0xd1: return this.set(2, "C"); 
			case 0xd2: return this.set(2, "D"); 
			case 0xd3: return this.set(2, "E"); 
			case 0xd4: return this.set(2, "H"); 
			case 0xd5: return this.set(2, "L"); 
			case 0xd6: return this.set(2, "(HL)"); 
			case 0xdf: return this.set(3, "A"); 
			case 0xd8: return this.set(3, "B"); 
			case 0xd9: return this.set(3, "C"); 
			case 0xda: return this.set(3, "D"); 
			case 0xdb: return this.set(3, "E"); 
			case 0xdc: return this.set(3, "H"); 
			case 0xdd: return this.set(3, "L"); 
			case 0xde: return this.set(3, "(HL)"); 
			case 0xe7: return this.set(4, "A"); 
			case 0xe0: return this.set(4, "B"); 
			case 0xe1: return this.set(4, "C"); 
			case 0xe2: return this.set(4, "D"); 
			case 0xe3: return this.set(4, "E"); 
			case 0xe4: return this.set(4, "H"); 
			case 0xe5: return this.set(4, "L"); 
			case 0xe6: return this.set(4, "(HL)"); 
			case 0xef: return this.set(5, "A"); 
			case 0xe8: return this.set(5, "B"); 
			case 0xe9: return this.set(5, "C"); 
			case 0xea: return this.set(5, "D"); 
			case 0xeb: return this.set(5, "E"); 
			case 0xec: return this.set(5, "H"); 
			case 0xed: return this.set(5, "L"); 
			case 0xee: return this.set(5, "(HL)"); 
			case 0xf7: return this.set(6, "A"); 
			case 0xf0: return this.set(6, "B"); 
			case 0xf1: return this.set(6, "C"); 
			case 0xf2: return this.set(6, "D"); 
			case 0xf3: return this.set(6, "E"); 
			case 0xf4: return this.set(6, "H"); 
			case 0xf5: return this.set(6, "L"); 
			case 0xf6: return this.set(6, "(HL)"); 
			case 0xff: return this.set(7, "A"); 
			case 0xf8: return this.set(7, "B"); 
			case 0xf9: return this.set(7, "C"); 
			case 0xfa: return this.set(7, "D"); 
			case 0xfb: return this.set(7, "E"); 
			case 0xfc: return this.set(7, "H"); 
			case 0xfd: return this.set(7, "L"); 
			case 0xfe: return this.set(7, "(HL)"); 
			case 0x87: return this.res(0, "A"); 
			case 0x80: return this.res(0, "B"); 
			case 0x81: return this.res(0, "C"); 
			case 0x82: return this.res(0, "D"); 
			case 0x83: return this.res(0, "E"); 
			case 0x84: return this.res(0, "H"); 
			case 0x85: return this.res(0, "L"); 
			case 0x86: return this.res(0, "(HL)"); 
			case 0x8f: return this.res(1, "A"); 
			case 0x88: return this.res(1, "B"); 
			case 0x89: return this.res(1, "C"); 
			case 0x8a: return this.res(1, "D"); 
			case 0x8b: return this.res(1, "E"); 
			case 0x8c: return this.res(1, "H"); 
			case 0x8d: return this.res(1, "L"); 
			case 0x8e: return this.res(1, "(HL)"); 
			case 0x97: return this.res(2, "A"); 
			case 0x90: return this.res(2, "B"); 
			case 0x91: return this.res(2, "C"); 
			case 0x92: return this.res(2, "D"); 
			case 0x93: return this.res(2, "E"); 
			case 0x94: return this.res(2, "H"); 
			case 0x95: return this.res(2, "L"); 
			case 0x96: return this.res(2, "(HL)"); 
			case 0x9f: return this.res(3, "A"); 
			case 0x98: return this.res(3, "B"); 
			case 0x99: return this.res(3, "C"); 
			case 0x9a: return this.res(3, "D"); 
			case 0x9b: return this.res(3, "E"); 
			case 0x9c: return this.res(3, "H"); 
			case 0x9d: return this.res(3, "L"); 
			case 0x9e: return this.res(3, "(HL)"); 
			case 0xa7: return this.res(4, "A"); 
			case 0xa0: return this.res(4, "B"); 
			case 0xa1: return this.res(4, "C"); 
			case 0xa2: return this.res(4, "D"); 
			case 0xa3: return this.res(4, "E"); 
			case 0xa4: return this.res(4, "H"); 
			case 0xa5: return this.res(4, "L"); 
			case 0xa6: return this.res(4, "(HL)"); 
			case 0xaf: return this.res(5, "A"); 
			case 0xa8: return this.res(5, "B"); 
			case 0xa9: return this.res(5, "C"); 
			case 0xaa: return this.res(5, "D"); 
			case 0xab: return this.res(5, "E"); 
			case 0xac: return this.res(5, "H"); 
			case 0xad: return this.res(5, "L"); 
			case 0xae: return this.res(5, "(HL)"); 
			case 0xb7: return this.res(6, "A"); 
			case 0xb0: return this.res(6, "B"); 
			case 0xb1: return this.res(6, "C"); 
			case 0xb2: return this.res(6, "D"); 
			case 0xb3: return this.res(6, "E"); 
			case 0xb4: return this.res(6, "H"); 
			case 0xb5: return this.res(6, "L"); 
			case 0xb6: return this.res(6, "(HL)"); 
			case 0xbf: return this.res(7, "A"); 
			case 0xb8: return this.res(7, "B"); 
			case 0xb9: return this.res(7, "C"); 
			case 0xba: return this.res(7, "D"); 
			case 0xbb: return this.res(7, "E"); 
			case 0xbc: return this.res(7, "H"); 
			case 0xbd: return this.res(7, "L"); 
			case 0xbe: return this.res(7, "(HL)"); 
			default: return this.unknown(); 
		}
	}
	
	private String unknown() {
		counter += 1;
		return "XXX";
	}
	
	private String nop() {
		counter += 1;
		return "NOP";
	}
	
	private String ldn(String register) {
		counter += 2;
		return String.format("LD %s, #%s", register, Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String ldrr(String register1, String register2) {
		counter += 1;
		return String.format("LD %s, %s", register1, register2);
	}
	
	private String ldrn(String register1, String register2) {
		counter += 2;
		return this.ldn(register1);
	}
	
	private String ldrnn(String register1, String register2) {
		counter += 3;
		return String.format("LD %s, $%s", register1, Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4));
	}
	
	private String ldnnr(String register1, String register2) {
		counter += 3;
		return String.format("LD $%s, %s", Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4), register2);
	}
	
	private String ldalp(String register) {
		counter += 1;
		if (register == "n") {
			counter += 1;
			return String.format("LD A, ($FF00 + #%s)", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
		}
		return "LD A, ($FF00 + C)";
	}
	
	private String ldlpa(String register) {
		counter += 1;
		if (register == "n") {
			counter += 1;
			return String.format("LD ($FF00 + #%s), A", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
		}
		return "LD ($FF00 + C), A";
	}
	
	private String ldd(String register1, String register2) {
		counter += 1;
		if (register1 == "A") return "LD A, (HL-)";
		return "LD (HL-), A";
	}
	
	private String ldi(String register1, String register2) {
		counter += 1;
		if (register1 == "A") return "LD A, (HL+)";
		return "LD (HL+), A";
	}
	
	private String ldhl() {
		counter += 2;
		return String.format("LD HL, SP + #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String push(String register) {
		counter += 1;
		return String.format("PUSH %s", register);
	}
	
	private String pop(String register) {
		counter += 1;
		return String.format("POP %s", register);
	}
	
	private String add(String register) {
		counter += 1;
		return String.format("ADD A, %s", register);
	}
	
	private String add(String register, boolean carry) {
		counter += 1;
		return String.format("ADC A, %s", register);
	}
	
	private String addn(String register) {
		counter += 2;
		return String.format("ADD A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String addn(String register, boolean carry) {
		counter += 2;
		return String.format("ADC A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String sub(String register) {
		counter += 1;
		return String.format("SUB A, %s", register);
	}
	
	private String sub(String register, boolean carry) {
		counter += 1;
		return String.format("SBC A, %s", register);
	}
	
	private String subn(String register) {
		counter += 2;
		return String.format("SUB A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String subn(String register, boolean carry) {
		counter += 2;
		return String.format("SBC A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String and(String register) {
		counter += 1;
		return String.format("AND A, %s", register);
	}
	
	private String andn(String register) {
		counter += 2;
		return String.format("AND A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String or(String register) {
		counter += 1;
		return String.format("OR A, %s", register);
	}
	
	private String orn(String register) {
		counter += 2;
		return String.format("OR A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String xor(String register) {
		counter += 1;
		return String.format("XOR A, %s", register);
	}
	
	private String xorn(String register) {
		counter += 2;
		return String.format("XOR A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String cp(String register) {
		counter += 1;
		return String.format("CP A, %s", register);
	}
	
	private String cpn(String register) {
		counter += 2;
		return String.format("CP A, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String inc(String register) {
		counter += 1;
		return String.format("INC %s", register);
	}
	
	private String dec(String register) {
		counter += 1;
		return String.format("DEC %s", register);
	}
	
	private String add16(String register) {
		counter += 1;
		return String.format("ADD HL, %s", register);
	}
	
	private String addsp() {
		counter += 2;
		return String.format("ADD SP, #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String daa() {
		counter += 1;
		return "DAA";
	}
	
	private String cpl() {
		counter += 1;
		return "CPL";
	}
	
	private String ccf() {
		counter += 1;
		return "CCF";
	}
	
	private String scf() {
		counter += 1;
		return "SCF";
	}
	
	private String halt() {
		counter += 1;
		return "HALT";
	}
	
	private String stop() {
		counter += 1;
		return "STOP";
	}
	
	private String inte(boolean on) {
		counter += 1;
		if (on) return "EI";
		return "DI";
	}
	
	private String rla(boolean carry) {
		counter += 1;
		if (carry) return "RLA";
		return "RLCA";
	}
	
	private String rra(boolean carry) {
		counter += 1;
		if (carry) return "RRA";
		return "RRCA";
	}
	
	private String jpnn() {
		counter += 3;
		return String.format("JP $%s", Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4));
	}
	
	private String jpc(String flag) {
		counter += 3;
		return String.format("JP %s $%s", flag, Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4));
	}
	
	private String jphl() {
		counter += 1;
		return "JP HL";
	}
	
	private String jpr() {
		counter += 2;
		return String.format("JR #%s", Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String jprc(String flag) {
		counter += 2;
		return String.format("JR %s #%s", flag, Utils.padHex(Utils.toHex(cpu.getMemory().read(counter - 1)), 2));
	}
	
	private String call() {
		counter += 3;
		return String.format("CALL $%s", Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4));
	}
	
	private String callc(String flag) {
		counter += 3;
		return String.format("CALL %s $%s", flag, Utils.padHex(Utils.toHex(Utils.covert8to16(cpu.getMemory().read(counter - 2), cpu.getMemory().read(counter - 1))), 4));
	}
	
	private String rst(int vec) {
		counter += 1;
		return String.format("RST $%s", Utils.padHex(Utils.toHex(vec), 4));
	}
	
	private String ret(boolean interrupt) {
		counter += 1;
		if (interrupt) return "RETI";
		return "RET";
	}
	
	private String retc(String flag) {
		counter += 1;
		return String.format("RET %s", flag);
	}
	
	private String swap(String register) {
		counter += 1;
		return String.format("SWAP %s", register);
	}
	
	private String rl(String register, boolean carry) {
		counter += 1;
		if (carry) return String.format("RL %s", register);
		return String.format("RLC %s", register);
	}
	
	private String rr(String register, boolean carry) {
		counter += 1;
		if (carry) return String.format("RR %s", register);
		return String.format("RRC %s", register);
	}
	
	private String sl(String register) {
		counter += 1;
		return String.format("SLA %s", register);
	}
	
	private String sr(String register, boolean msb) {
		counter += 1;
		if (msb) return String.format("SRL %s", register);
		return String.format("SRA %s", register);
	}
	
	private String bit(int bit, String register) {
		counter += 1;
		return String.format("BIT %d %s", bit, register);
	}
	
	private String set(int bit, String register) {
		counter += 1;
		return String.format("SET %d %s", bit, register);
	}
	
	private String res(int bit, String register) {
		counter += 1;
		return String.format("RES %d %s", bit, register);
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int value) {
		counter = value;
	}
}