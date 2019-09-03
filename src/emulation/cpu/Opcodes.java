package emulation.cpu;

import emulation.Utils;

public class Opcodes {
	private CPU cpu;
	
	public Opcodes(CPU cpu) {
		this.cpu = cpu;
	}
	
	public void run(int opcode) {
		switch (opcode) {
			case 0x00: this.nop(); break;
			case 0x3e: this.ldn("A"); break;
			case 0x06: this.ldn("B"); break;
			case 0x0e: this.ldn("C"); break;
			case 0x16: this.ldn("D"); break;
			case 0x1e: this.ldn("E"); break;
			case 0x26: this.ldn("H"); break;
			case 0x2e: this.ldn("L"); break;
			case 0x7f: this.ldrr("A", "A"); break;
			case 0x78: this.ldrr("A", "B"); break;
			case 0x79: this.ldrr("A", "C"); break;
			case 0x7a: this.ldrr("A", "D"); break;
			case 0x7b: this.ldrr("A", "E"); break;
			case 0x7c: this.ldrr("A", "H"); break;
			case 0x7d: this.ldrr("A", "L"); break;
			case 0x7e: this.ldrr("A", "(HL)"); break;
			case 0x47: this.ldrr("B", "A"); break;
			case 0x40: this.ldrr("B", "B"); break;
			case 0x41: this.ldrr("B", "C"); break;
			case 0x42: this.ldrr("B", "D"); break;
			case 0x43: this.ldrr("B", "E"); break;
			case 0x44: this.ldrr("B", "H"); break;
			case 0x45: this.ldrr("B", "L"); break;
			case 0x46: this.ldrr("B", "(HL)"); break;
			case 0x4f: this.ldrr("C", "A"); break;
			case 0x48: this.ldrr("C", "B"); break;
			case 0x49: this.ldrr("C", "C"); break;
			case 0x4a: this.ldrr("C", "D"); break;
			case 0x4b: this.ldrr("C", "E"); break;
			case 0x4c: this.ldrr("C", "H"); break;
			case 0x4d: this.ldrr("C", "L"); break;
			case 0x4e: this.ldrr("C", "(HL)"); break;
			case 0x57: this.ldrr("D", "A"); break;
			case 0x50: this.ldrr("D", "B"); break;
			case 0x51: this.ldrr("D", "C"); break;
			case 0x52: this.ldrr("D", "D"); break;
			case 0x53: this.ldrr("D", "E"); break;
			case 0x54: this.ldrr("D", "H"); break;
			case 0x55: this.ldrr("D", "L"); break;
			case 0x56: this.ldrr("D", "(HL)"); break;
			case 0x5f: this.ldrr("E", "A"); break;
			case 0x58: this.ldrr("E", "B"); break;
			case 0x59: this.ldrr("E", "C"); break;
			case 0x5a: this.ldrr("E", "D"); break;
			case 0x5b: this.ldrr("E", "E"); break;
			case 0x5c: this.ldrr("E", "H"); break;
			case 0x5d: this.ldrr("E", "L"); break;
			case 0x5e: this.ldrr("E", "(HL)"); break;
			case 0x67: this.ldrr("H", "A"); break;
			case 0x60: this.ldrr("H", "B"); break;
			case 0x61: this.ldrr("H", "C"); break; //6F: LD H, C - Load Register C to Register H - Page 66
			case 0x62: this.ldrr("H", "D"); break;
			case 0x63: this.ldrr("H", "E"); break;
			case 0x64: this.ldrr("H", "H"); break;
			case 0x65: this.ldrr("H", "L"); break;
			case 0x66: this.ldrr("H", "(HL)"); break;
			case 0x6f: this.ldrr("L", "A"); break;
			case 0x68: this.ldrr("L", "B"); break;
			case 0x69: this.ldrr("L", "C"); break;
			case 0x6a: this.ldrr("L", "D"); break;
			case 0x6b: this.ldrr("L", "E"); break;
			case 0x6c: this.ldrr("L", "H"); break;
			case 0x6d: this.ldrr("L", "L"); break;
			case 0x6e: this.ldrr("L", "(HL)"); break;
			case 0x77: this.ldrr("(HL)", "A"); break;
			case 0x70: this.ldrr("(HL)", "B"); break;
			case 0x71: this.ldrr("(HL)", "C"); break;
			case 0x72: this.ldrr("(HL)", "D"); break;
			case 0x73: this.ldrr("(HL)", "E"); break;
			case 0x74: this.ldrr("(HL)", "H"); break;
			case 0x75: this.ldrr("(HL)", "L"); break;
			case 0x36: this.ldrr("(HL)", "n"); break;
			case 0x0a: this.ldrr("A", "(BC)"); break;
			case 0x1a: this.ldrr("A", "(DE)"); break;
			case 0xfa: this.ldrr("A", "(nn)"); break;
			case 0x02: this.ldrr("(BC)", "A"); break;
			case 0x12: this.ldrr("(DE)", "A"); break;
			case 0xea: this.ldrr("(nn)", "A"); break;
			case 0xf2: this.ldalp("C"); break;
			case 0xe2: this.ldlpa("C"); break;
			case 0xe0: this.ldalp("n"); break;
			case 0xf0: this.ldlpa("n"); break;
			case 0x3a: this.ldd("A", "(HL)"); break;
			case 0x32: this.ldd("(HL)", "A"); break;
			case 0x2a: this.ldi("A", "(HL)"); break;
			case 0x22: this.ldi("(HL)", "A"); break;
			case 0x01: this.ldrr("BC", "nn"); break;
			case 0x11: this.ldrr("DE", "nn"); break;
			case 0x21: this.ldrr("HL", "nn"); break;
			case 0x31: this.ldrr("SP", "nn"); break;
			case 0xf9: this.ldrr("SP", "HL"); break;
			case 0xf8: this.ldhl(); break;
			case 0x08: this.ldrr("SP", "nn"); break;
			case 0xf5: this.push("AF"); break;
			case 0xc5: this.push("BC"); break;
			case 0xd5: this.push("DE"); break;
			case 0xe5: this.push("HL"); break;
			case 0xf1: this.pop("AF"); break;
			case 0xc1: this.pop("BC"); break;
			case 0xd1: this.pop("DE"); break;
			case 0xe1: this.pop("HL"); break;
			case 0x87: this.add("A"); break;
			case 0x80: this.add("B"); break;
			case 0x81: this.add("C"); break;
			case 0x82: this.add("D"); break;
			case 0x83: this.add("E"); break;
			case 0x84: this.add("H"); break;
			case 0x85: this.add("L"); break;
			case 0x86: this.add("(HL)"); break;
			case 0xc6: this.add("n"); break;
			case 0x8f: this.add("A", true); break;
			case 0x88: this.add("B", true); break;
			case 0x89: this.add("C", true); break;
			case 0x8a: this.add("D", true); break;
			case 0x8b: this.add("E", true); break;
			case 0x8c: this.add("H", true); break;
			case 0x8d: this.add("L", true); break;
			case 0x8e: this.add("(HL)", true); break;
			case 0xce: this.add("n", true); break;
			case 0x97: this.sub("A"); break;
			case 0x90: this.sub("B"); break;
			case 0x91: this.sub("C"); break;
			case 0x92: this.sub("D"); break;
			case 0x93: this.sub("E"); break;
			case 0x94: this.sub("H"); break;
			case 0x95: this.sub("L"); break;
			case 0x96: this.sub("(HL)"); break;
			case 0xd6: this.sub("n"); break;
			case 0x9f: this.sub("A", true); break;
			case 0x98: this.sub("B", true); break;
			case 0x99: this.sub("C", true); break;
			case 0x9a: this.sub("D", true); break;
			case 0x9b: this.sub("E", true); break;
			case 0x9c: this.sub("H", true); break;
			case 0x9d: this.sub("L", true); break;
			case 0x9e: this.sub("(HL)", true); break;
			case 0xde: this.sub("n", true); break;
			case 0xa7: this.and("A"); break;
			case 0xa0: this.and("B"); break;
			case 0xa1: this.and("C"); break;
			case 0xa2: this.and("D"); break;
			case 0xa3: this.and("E"); break;
			case 0xa4: this.and("H"); break;
			case 0xa5: this.and("L"); break;
			case 0xa6: this.and("(HL)"); break;
			case 0xe6: this.and("n"); break;
			case 0xb7: this.or("A"); break;
			case 0xb0: this.or("B"); break;
			case 0xb1: this.or("C"); break;
			case 0xb2: this.or("D"); break;
			case 0xb3: this.or("E"); break;
			case 0xb4: this.or("H"); break;
			case 0xb5: this.or("L"); break;
			case 0xb6: this.or("(HL)"); break;
			case 0xf6: this.or("n"); break;
			case 0xaf: this.xor("A"); break;
			case 0xa8: this.xor("B"); break;
			case 0xa9: this.xor("C"); break;
			case 0xaa: this.xor("D"); break;
			case 0xab: this.xor("E"); break;
			case 0xac: this.xor("H"); break;
			case 0xad: this.xor("L"); break;
			case 0xae: this.xor("(HL)"); break;
			case 0xee: this.xor("n"); break;
			case 0x3c: this.inc("A"); break;
			case 0x04: this.inc("B"); break;
			case 0x0c: this.inc("C"); break;
			case 0x14: this.inc("D"); break;
			case 0x1c: this.inc("E"); break;
			case 0x24: this.inc("H"); break;
			case 0x2c: this.inc("L"); break;
			case 0x34: this.inc("(HL)"); break;
			case 0x3d: this.dec("A"); break;
			case 0x05: this.dec("B"); break;
			case 0x0d: this.dec("C"); break;
			case 0x15: this.dec("D"); break;
			case 0x1d: this.dec("E"); break;
			case 0x25: this.dec("H"); break;
			case 0x2d: this.dec("L"); break;
			case 0x35: this.dec("(HL)"); break;
			case 0x09: this.add16("BC"); break;
			case 0x19: this.add16("DE"); break;
			case 0x29: this.add16("HL"); break;
			case 0x39: this.add16("SP"); break;
			case 0xe8: this.addsp(); break;
			case 0x03: this.inc16("BC"); break;
			case 0x13: this.inc16("DE"); break;
			case 0x23: this.inc16("HL"); break;
			case 0x33: this.inc16("SP"); break;
			case 0x0b: this.dec16("BC"); break;
			case 0x1b: this.dec16("DE"); break;
			case 0x2b: this.dec16("HL"); break;
			case 0x3b: this.dec16("SP"); break;
			case 0x27: this.daa(); break;
			case 0x2f: this.cpl(); break;
			case 0x3f: this.ccf(); break;
			case 0x37: this.scf(); break;
			case 0x76: this.halt(); break;
			case 0x10: this.stop(); break;
			case 0xf3: this.inte(false); break;
			case 0xfb: this.inte(true); break;
			case 0x07: this.rl("A", false); break;
			case 0x17: this.rl("A", true); break;
			case 0x0f: this.rr("A", false); break;
			case 0x1f: this.rr("A", true); break;
			case 0xc3: this.jp("nn"); break;
			case 0xc2: this.jpc("NZ"); break;
			case 0xca: this.jpc("Z"); break;
			case 0xd2: this.jpc("NC"); break;
			case 0xda: this.jpc("C"); break;
			case 0xe9: this.jp("HL"); break;
			case 0x18: this.jpr(); break;
			case 0x20: this.jprc("NZ"); break;
			case 0x28: this.jprc("Z"); break;
			case 0x30: this.jprc("NC"); break;
			case 0x38: this.jprc("C"); break;
			case 0xcd: this.call(); break;
			case 0xc4: this.callc("NZ"); break;
			case 0xcc: this.callc("Z"); break;
			case 0xd4: this.callc("NC"); break;
			case 0xdc: this.callc("C"); break;
			case 0xc7: this.rst(0x00); break;
			case 0xcf: this.rst(0x08); break;
			case 0xd7: this.rst(0x10); break;
			case 0xdf: this.rst(0x18); break;
			case 0xe7: this.rst(0x20); break;
			case 0xef: this.rst(0x28); break;
			case 0xf7: this.rst(0x30); break;
			case 0xff: this.rst(0x38); break;
			case 0xc9: this.ret(false); break;
			case 0xd9: this.ret(true); break;
			case 0xc0: this.retc("NZ"); break;
			case 0xc8: this.retc("Z"); break;
			case 0xd0: this.retc("NC"); break;
			case 0xd8: this.retc("C"); break;
			case 0xcb: this.c6bit(); break;
			default: this.unknown(opcode); break;
		}
	}
	
	public void unknown(int opcode) {
		System.out.println("Unknown Opcode: " + Utils.toHex(opcode));
	}
	
	public void c6bit() {
		int opcode = cpu.getNext();
		switch (opcode) {
			case 0x37: this.swap("A"); break;
			case 0x30: this.swap("B"); break;
			case 0x31: this.swap("C"); break;
			case 0x32: this.swap("D"); break;
			case 0x33: this.swap("E"); break;
			case 0x34: this.swap("H"); break;
			case 0x35: this.swap("L"); break;
			case 0x36: this.swap("(HL)"); break;
			case 0x07: this.rl("A", false); break;
			case 0x00: this.rl("B", false); break;
			case 0x01: this.rl("C", false); break;
			case 0x02: this.rl("D", false); break;
			case 0x03: this.rl("E", false); break;
			case 0x04: this.rl("H", false); break;
			case 0x05: this.rl("L", false); break;
			case 0x06: this.rl("(HL)", false); break;
			case 0x17: this.rl("A", true); break;
			case 0x10: this.rl("B", true); break;
			case 0x11: this.rl("C", true); break;
			case 0x12: this.rl("D", true); break;
			case 0x13: this.rl("E", true); break;
			case 0x14: this.rl("H", true); break;
			case 0x15: this.rl("L", true); break;
			case 0x16: this.rl("(HL)", true); break;
			case 0x0f: this.rr("A", false); break;
			case 0x08: this.rr("B", false); break;
			case 0x09: this.rr("C", false); break;
			case 0x0a: this.rr("D", false); break;
			case 0x0b: this.rr("E", false); break;
			case 0x0c: this.rr("H", false); break;
			case 0x0d: this.rr("L", false); break;
			case 0x0e: this.rr("(HL)", false); break;
			case 0x1f: this.rr("A", true); break;
			case 0x18: this.rr("B", true); break;
			case 0x19: this.rr("C", true); break;
			case 0x1a: this.rr("D", true); break;
			case 0x1b: this.rr("E", true); break;
			case 0x1c: this.rr("H", true); break;
			case 0x1d: this.rr("L", true); break;
			case 0x1e: this.rr("(HL)", true); break;
			case 0x27: this.sl("A"); break;
			case 0x20: this.sl("B"); break;
			case 0x21: this.sl("C"); break;
			case 0x22: this.sl("D"); break;
			case 0x23: this.sl("E"); break;
			case 0x24: this.sl("H"); break;
			case 0x25: this.sl("L"); break;
			case 0x26: this.sl("(HL)"); break;
			case 0x2f: this.sr("A", false); break;
			case 0x28: this.sr("B", false); break;
			case 0x29: this.sr("C", false); break;
			case 0x2a: this.sr("D", false); break;
			case 0x2b: this.sr("E", false); break;
			case 0x2c: this.sr("H", false); break;
			case 0x2d: this.sr("L", false); break;
			case 0x2e: this.sr("(HL)", false); break;
			case 0x3f: this.sr("A", true); break;
			case 0x38: this.sr("B", true); break;
			case 0x39: this.sr("C", true); break;
			case 0x3a: this.sr("D", true); break;
			case 0x3b: this.sr("E", true); break;
			case 0x3c: this.sr("H", true); break;
			case 0x3d: this.sr("L", true); break;
			case 0x3e: this.sr("(HL)", true); break;
			case 0x47: this.bit(0, "A"); break;
			case 0x40: this.bit(0, "B"); break;
			case 0x41: this.bit(0, "C"); break;
			case 0x42: this.bit(0, "D"); break;
			case 0x43: this.bit(0, "E"); break;
			case 0x44: this.bit(0, "H"); break;
			case 0x45: this.bit(0, "L"); break;
			case 0x46: this.bit(0, "(HL)"); break;
			case 0x4f: this.bit(1, "A"); break;
			case 0x48: this.bit(1, "B"); break;
			case 0x49: this.bit(1, "C"); break;
			case 0x4a: this.bit(1, "D"); break;
			case 0x4b: this.bit(1, "E"); break;
			case 0x4c: this.bit(1, "H"); break;
			case 0x4d: this.bit(1, "L"); break;
			case 0x4e: this.bit(1, "(HL)"); break;
			case 0x57: this.bit(2, "A"); break;
			case 0x50: this.bit(2, "B"); break;
			case 0x51: this.bit(2, "C"); break;
			case 0x52: this.bit(2, "D"); break;
			case 0x53: this.bit(2, "E"); break;
			case 0x54: this.bit(2, "H"); break;
			case 0x55: this.bit(2, "L"); break;
			case 0x56: this.bit(2, "(HL)"); break;
			case 0x5f: this.bit(3, "A"); break;
			case 0x58: this.bit(3, "B"); break;
			case 0x59: this.bit(3, "C"); break;
			case 0x5a: this.bit(3, "D"); break;
			case 0x5b: this.bit(3, "E"); break;
			case 0x5c: this.bit(3, "H"); break;
			case 0x5d: this.bit(3, "L"); break;
			case 0x5e: this.bit(3, "(HL)"); break;
			case 0x67: this.bit(4, "A"); break;
			case 0x60: this.bit(4, "B"); break;
			case 0x61: this.bit(4, "C"); break;
			case 0x62: this.bit(4, "D"); break;
			case 0x63: this.bit(4, "E"); break;
			case 0x64: this.bit(4, "H"); break;
			case 0x65: this.bit(4, "L"); break;
			case 0x66: this.bit(4, "(HL)"); break;
			case 0x6f: this.bit(5, "A"); break;
			case 0x68: this.bit(5, "B"); break;
			case 0x69: this.bit(5, "C"); break;
			case 0x6a: this.bit(5, "D"); break;
			case 0x6b: this.bit(5, "E"); break;
			case 0x6c: this.bit(5, "H"); break;
			case 0x6d: this.bit(5, "L"); break;
			case 0x6e: this.bit(5, "(HL)"); break;
			case 0x77: this.bit(6, "A"); break;
			case 0x70: this.bit(6, "B"); break;
			case 0x71: this.bit(6, "C"); break;
			case 0x72: this.bit(6, "D"); break;
			case 0x73: this.bit(6, "E"); break;
			case 0x74: this.bit(6, "H"); break;
			case 0x75: this.bit(6, "L"); break;
			case 0x76: this.bit(6, "(HL)"); break;
			case 0x7f: this.bit(7, "A"); break;
			case 0x78: this.bit(7, "B"); break;
			case 0x79: this.bit(7, "C"); break;
			case 0x7a: this.bit(7, "D"); break;
			case 0x7b: this.bit(7, "E"); break;
			case 0x7c: this.bit(7, "H"); break;
			case 0x7d: this.bit(7, "L"); break;
			case 0x7e: this.bit(7, "(HL)"); break;
			case 0xc7: this.set(0, "A"); break;
			case 0xc0: this.set(0, "B"); break;
			case 0xc1: this.set(0, "C"); break;
			case 0xc2: this.set(0, "D"); break;
			case 0xc3: this.set(0, "E"); break;
			case 0xc4: this.set(0, "H"); break;
			case 0xc5: this.set(0, "L"); break;
			case 0xc6: this.set(0, "(HL)"); break;
			case 0xcf: this.set(1, "A"); break;
			case 0xc8: this.set(1, "B"); break;
			case 0xc9: this.set(1, "C"); break;
			case 0xca: this.set(1, "D"); break;
			case 0xcb: this.set(1, "E"); break;
			case 0xcc: this.set(1, "H"); break;
			case 0xcd: this.set(1, "L"); break;
			case 0xce: this.set(1, "(HL)"); break;
			case 0xd7: this.set(2, "A"); break;
			case 0xd0: this.set(2, "B"); break;
			case 0xd1: this.set(2, "C"); break;
			case 0xd2: this.set(2, "D"); break;
			case 0xd3: this.set(2, "E"); break;
			case 0xd4: this.set(2, "H"); break;
			case 0xd5: this.set(2, "L"); break;
			case 0xd6: this.set(2, "(HL)"); break;
			case 0xdf: this.set(3, "A"); break;
			case 0xd8: this.set(3, "B"); break;
			case 0xd9: this.set(3, "C"); break;
			case 0xda: this.set(3, "D"); break;
			case 0xdb: this.set(3, "E"); break;
			case 0xdc: this.set(3, "H"); break;
			case 0xdd: this.set(3, "L"); break;
			case 0xde: this.set(3, "(HL)"); break;
			case 0xe7: this.set(4, "A"); break;
			case 0xe0: this.set(4, "B"); break;
			case 0xe1: this.set(4, "C"); break;
			case 0xe2: this.set(4, "D"); break;
			case 0xe3: this.set(4, "E"); break;
			case 0xe4: this.set(4, "H"); break;
			case 0xe5: this.set(4, "L"); break;
			case 0xe6: this.set(4, "(HL)"); break;
			case 0xef: this.set(5, "A"); break;
			case 0xe8: this.set(5, "B"); break;
			case 0xe9: this.set(5, "C"); break;
			case 0xea: this.set(5, "D"); break;
			case 0xeb: this.set(5, "E"); break;
			case 0xec: this.set(5, "H"); break;
			case 0xed: this.set(5, "L"); break;
			case 0xee: this.set(5, "(HL)"); break;
			case 0xf7: this.set(6, "A"); break;
			case 0xf0: this.set(6, "B"); break;
			case 0xf1: this.set(6, "C"); break;
			case 0xf2: this.set(6, "D"); break;
			case 0xf3: this.set(6, "E"); break;
			case 0xf4: this.set(6, "H"); break;
			case 0xf5: this.set(6, "L"); break;
			case 0xf6: this.set(6, "(HL)"); break;
			case 0xff: this.set(7, "A"); break;
			case 0xf8: this.set(7, "B"); break;
			case 0xf9: this.set(7, "C"); break;
			case 0xfa: this.set(7, "D"); break;
			case 0xfb: this.set(7, "E"); break;
			case 0xfc: this.set(7, "H"); break;
			case 0xfd: this.set(7, "L"); break;
			case 0xfe: this.set(7, "(HL)"); break;
			case 0x87: this.res(0, "A"); break;
			case 0x80: this.res(0, "B"); break;
			case 0x81: this.res(0, "C"); break;
			case 0x82: this.res(0, "D"); break;
			case 0x83: this.res(0, "E"); break;
			case 0x84: this.res(0, "H"); break;
			case 0x85: this.res(0, "L"); break;
			case 0x86: this.res(0, "(HL)"); break;
			case 0x8f: this.res(1, "A"); break;
			case 0x88: this.res(1, "B"); break;
			case 0x89: this.res(1, "C"); break;
			case 0x8a: this.res(1, "D"); break;
			case 0x8b: this.res(1, "E"); break;
			case 0x8c: this.res(1, "H"); break;
			case 0x8d: this.res(1, "L"); break;
			case 0x8e: this.res(1, "(HL)"); break;
			case 0x97: this.res(2, "A"); break;
			case 0x90: this.res(2, "B"); break;
			case 0x91: this.res(2, "C"); break;
			case 0x92: this.res(2, "D"); break;
			case 0x93: this.res(2, "E"); break;
			case 0x94: this.res(2, "H"); break;
			case 0x95: this.res(2, "L"); break;
			case 0x96: this.res(2, "(HL)"); break;
			case 0x9f: this.res(3, "A"); break;
			case 0x98: this.res(3, "B"); break;
			case 0x99: this.res(3, "C"); break;
			case 0x9a: this.res(3, "D"); break;
			case 0x9b: this.res(3, "E"); break;
			case 0x9c: this.res(3, "H"); break;
			case 0x9d: this.res(3, "L"); break;
			case 0x9e: this.res(3, "(HL)"); break;
			case 0xa7: this.res(4, "A"); break;
			case 0xa0: this.res(4, "B"); break;
			case 0xa1: this.res(4, "C"); break;
			case 0xa2: this.res(4, "D"); break;
			case 0xa3: this.res(4, "E"); break;
			case 0xa4: this.res(4, "H"); break;
			case 0xa5: this.res(4, "L"); break;
			case 0xa6: this.res(4, "(HL)"); break;
			case 0xaf: this.res(5, "A"); break;
			case 0xa8: this.res(5, "B"); break;
			case 0xa9: this.res(5, "C"); break;
			case 0xaa: this.res(5, "D"); break;
			case 0xab: this.res(5, "E"); break;
			case 0xac: this.res(5, "H"); break;
			case 0xad: this.res(5, "L"); break;
			case 0xae: this.res(5, "(HL)"); break;
			case 0xb7: this.res(6, "A"); break;
			case 0xb0: this.res(6, "B"); break;
			case 0xb1: this.res(6, "C"); break;
			case 0xb2: this.res(6, "D"); break;
			case 0xb3: this.res(6, "E"); break;
			case 0xb4: this.res(6, "H"); break;
			case 0xb5: this.res(6, "L"); break;
			case 0xb6: this.res(6, "(HL)"); break;
			case 0xbf: this.res(7, "A"); break;
			case 0xb8: this.res(7, "B"); break;
			case 0xb9: this.res(7, "C"); break;
			case 0xba: this.res(7, "D"); break;
			case 0xbb: this.res(7, "E"); break;
			case 0xbc: this.res(7, "H"); break;
			case 0xbd: this.res(7, "L"); break;
			case 0xbe: this.res(7, "(HL)"); break;
			default: this.unknown(opcode + 51968); break;
		}
	}
	
	public void ldn(String register) {
		int data = cpu.getNext();
		this.setRegister(register, data);
	}
	
	public void ldrr(String register1, String register2) {
		this.setRegister(register1, this.getRegister(register2));
	}
	
	public void ldalp(String offsetRegister) {
		this.setRegister("A", cpu.getMemory().read(0xff00 + this.getRegister(offsetRegister)));
	}
	
	public void ldlpa(String offsetRegister) {
		cpu.getMemory().write(0xff00 + this.getRegister(offsetRegister), this.getRegister("A"));
	}
	
	public void ldd(String register1, String register2) {
		this.ldrr(register1, register2);
		cpu.getRegisterHL().setRegister(cpu.getRegisterHL().getRegister() - 1);
	}
	
	public void ldi(String register1, String register2) {
		this.ldrr(register1, register2);
		cpu.getRegisterHL().setRegister(cpu.getRegisterHL().getRegister() + 1);
	}
	
	public void ldhl() {
		int sByte = cpu.getNext();
		if ((sByte & 0x80) == 0x80) sByte -= 256;
		
		int address = cpu.getStackPointer() + sByte;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, (address > 0xffff || address < 0x0000));
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, (address & 0xff) + sByte > 0xff);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (address > 0xffff) address -= 0xffff;
		if (address < 0x0000) address += 0xffff;
		
		this.setRegister("HL", address);
	}
	
	public void push(String register) {
		cpu.getMemory().write(cpu.getStackPointer(), this.getRegister(register) >> 8);
		cpu.getMemory().write(cpu.getStackPointer() - 1, this.getRegister(register) & 0xff);
		cpu.setStackPointer(cpu.getStackPointer() - 2);
	}
	
	public void pop(String register) {
		cpu.setStackPointer(cpu.getStackPointer() + 2);
		this.setRegister(register, cpu.getMemory().read((cpu.getStackPointer()) << 8) | (cpu.getStackPointer() - 1 & 0xff));
	}
	
	public void add(String register) {
		this.add(register, false);
	}
	
	public void add(String register, boolean withCarry) {
		int addition = this.getRegister("A") + this.getRegister(register) + ((withCarry) ? 1 : 0);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, addition > 255);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, addition > 15);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, addition == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (addition > 255) addition -= 256;
		
		this.setRegister("A", addition);
	}
	
	public void sub(String register) {
		this.sub(register, false);
	}
	
	public void sub(String register, boolean withBorrow) {
		int subtraction = this.getRegister("A") - this.getRegister(register) + ((withBorrow) ? 1 : 0);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, subtraction > 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, subtraction > 15);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, subtraction == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (subtraction < 0) subtraction += 256;
		
		this.setRegister("A", subtraction);
	}
	
	public void and(String register) {
		int and = this.getRegister("A") & this.getRegister(register);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, true);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, and == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		this.setRegister("A", and);
	}
	
	public void or(String register) {
		int or = this.getRegister("A") | this.getRegister(register);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, or == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		this.setRegister("A", or);
	}
	
	public void xor(String register) {
		int xor = this.getRegister("A") ^ this.getRegister(register);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, xor == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		this.setRegister("A", xor);
	}
	
	public void cp(String register) {
		int compare = this.getRegister("A") - this.getRegister(register);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, compare > 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, compare > 15);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, compare == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
	}
	
	public void inc(String register) {
		int addition = this.getRegister(register) + 1;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, addition > 255);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, addition > 15);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, addition == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (addition > 255) addition -= 256;
		
		this.setRegister(register, addition);
	}
	
	public void dec(String register) {
		int subtraction = this.getRegister(register) - 1;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, subtraction > 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, subtraction > 15);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, subtraction == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (subtraction < 0) subtraction += 256;
		
		this.setRegister(register, subtraction);
	}
	
	public void add16(String register2) {
		int addition = this.getRegister("HL") + this.getRegister(register2);
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, addition > 65525);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, addition > 32767);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, addition == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (addition > 65525) addition -= 65526;
		
		this.setRegister("HL", addition);
	}
	
	public void addsp() {
		int sByte = cpu.getNext();
		if ((sByte & 0x80) == 0x80) sByte -= 256;
		
		int address = cpu.getStackPointer() + sByte;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, (address > 0xffff || address < 0x0000));
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, (address & 0xff) + sByte > 0xff);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (address > 0xffff) address -= 0xffff;
		if (address < 0x0000) address += 0xffff;
		
		this.setRegister("SP", address);
	}
	
	public void inc16(String register) {
		int addition = this.getRegister(register) + 1;
		
		if (addition > 65525) addition -= 65526;
		
		this.setRegister(register, addition);
	}
	
	public void dec16(String register) {
		int subtraction = this.getRegister(register) - 1;
		
		if (subtraction < 0) subtraction += 65526;
		
		this.setRegister(register, subtraction);
	}
	
	public void nop() {
		//Does nothing
	}
	
	public void daa() {
		if (cpu.getRegisterPSW().getFlag(PSWRegister.SUBTRACT_FLAG)) {
			if (cpu.getRegisterPSW().getFlag(PSWRegister.HALF_CARRY_FLAG)) {
				int subtraction = this.getRegister("A") - 6;
				if (subtraction < 0) subtraction += 256;
				this.setRegister("A", subtraction);
			}
			if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) {
				int subtraction = this.getRegister("A") - 96;
				if (subtraction < 0) subtraction += 256;
				this.setRegister("A", subtraction);
			}
		} else {
			if (cpu.getRegisterPSW().getFlag(PSWRegister.HALF_CARRY_FLAG) || (this.getRegister("A") & 0xf) > 9) {
				int addition = this.getRegister("A") + 6;
				this.setRegister("A", addition);
			}
			if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG) || this.getRegister("A") > 9) {
				int addition = this.getRegister("A") - 96;
				this.setRegister("A", addition);
			}
		}
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, this.getRegister("A") > 255);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, this.getRegister("A") == 0);
		
		if (this.getRegister("A") > 255) this.setRegister("A", this.getRegister("A") - 256);
	}
	
	public void halt() {
		cpu.setCpuOn(false);
	}
	
	public void stop() {
		cpu.setCpuOn(false);
		cpu.setScreenOn(false);
	}
	
	public void inte(boolean on) {
		cpu.setInterruptDisabled(on);
	}
	
	public void cpl() {
		int complement = ~this.getRegister("A");
		
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, true);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, true);
		
		this.setRegister("A", complement);
	}
	
	public void ccf() {
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, !cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG));
	}
	
	public void scf() {
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, true);
	}
	
	public void rl(String register, boolean carry) {
		int shifted = this.getRegister(register) << 1;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, (shifted >> 8) != 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, shifted == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (carry) shifted |= (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG) ? 1 : 0);
		
		if (shifted > 255) shifted -= 256;
		
		this.setRegister(register, shifted);
	}
	
	public void rr(String register, boolean carry) {
		int shifted = this.getRegister(register) >> 1;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, (this.getRegister(register) & 1) == 1);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, shifted == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (carry) shifted |= (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG) ? 1 : 0) << 7;
		
		this.setRegister(register, shifted);
	}
	
	public void jp(String register) {
		cpu.setProgramCounter(this.getRegister(register));
	}
	
	public void jpc(String flag) {
		switch (flag) {
			case "NZ": if (!cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.jp("nn"); break;
			case "Z": if (cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.jp("nn"); break;
			case "NC": if (!cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.jp("nn"); break;
			case "C": if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.jp("nn"); break;
		}
	}
	
	public void jpr() {
		int sByte = cpu.getNext();
		if ((sByte & 0x80) == 0x80) sByte -= 256;
		
		cpu.setProgramCounter(cpu.getProgramCounter() + sByte);
	}
	
	public void jprc(String flag) {
		switch (flag) {
			case "NZ": if (!cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.jpr(); break;
			case "Z": if (cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.jpr(); break;
			case "NC": if (!cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.jpr(); break;
			case "C": if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.jpr(); break;
		}
	}
	
	public void call() {
		cpu.getMemory().write(cpu.getStackPointer(), cpu.getProgramCounter() + 1 >> 8);
		cpu.getMemory().write(cpu.getStackPointer() - 1, cpu.getProgramCounter() + 1 & 0xff);
		cpu.setStackPointer(cpu.getStackPointer() - 2);
		
		cpu.setProgramCounter(this.getRegister("nn"));
	}
	
	public void callc(String flag) {
		switch (flag) {
			case "NZ": if (!cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.call(); break;
			case "Z": if (cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.call(); break;
			case "NC": if (!cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.call(); break;
			case "C": if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.call(); break;
		}
	}
	
	public void rst(int offset) {
		cpu.getMemory().write(cpu.getStackPointer(), cpu.getProgramCounter() >> 8);
		cpu.getMemory().write(cpu.getStackPointer() - 1, cpu.getProgramCounter() & 0xff);
		cpu.setStackPointer(cpu.getStackPointer() - 2);
		
		cpu.setProgramCounter(offset);
	}
	
	public void ret(boolean enable) {
		cpu.setStackPointer(cpu.getStackPointer() + 2);
		cpu.setProgramCounter(cpu.getMemory().read((cpu.getStackPointer()) << 8) | (cpu.getStackPointer() - 1 & 0xff));
		
		if (enable) cpu.setInterruptDisabled(!enable);
	}
	
	public void retc(String flag) {
		switch (flag) {
			case "NZ": if (!cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.ret(false); break;
			case "Z": if (cpu.getRegisterPSW().getFlag(PSWRegister.ZERO_FLAG)) this.ret(false); break;
			case "NC": if (!cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.ret(false); break;
			case "C": if (cpu.getRegisterPSW().getFlag(PSWRegister.CARRY_FLAG)) this.ret(false); break;
		}
	}
	
	public void swap(String register) {
		int msb = this.getRegister(register) >> 4;
		int lsb = this.getRegister(register) & 0xf;
		
		int swapped = lsb << 4 | msb;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, swapped == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		this.setRegister(register, swapped);
	}
	
	public void sl(String register) {
		int shifted = this.getRegister(register) << 1;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, shifted >> 8 == 1);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, shifted == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		if (shifted > 255) shifted -= 256;
		
		this.setRegister(register, shifted);
	}
	
	public void sr(String register, boolean msbChange) {
		int shifted = this.getRegister(register) >> 1;
		
		if (!msbChange) shifted |= this.getRegister(register) & 0x80;
		
		cpu.getRegisterPSW().setFlag(PSWRegister.CARRY_FLAG, (this.getRegister(register) & 0x1) == 1);
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, false);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, shifted == 0);
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
		
		this.setRegister(register, shifted);
	}
	
	public void bit(int bit, String register) {
		cpu.getRegisterPSW().setFlag(PSWRegister.HALF_CARRY_FLAG, true);
		cpu.getRegisterPSW().setFlag(PSWRegister.ZERO_FLAG, (this.getRegister(register) & (1 << bit)) != (1 << bit));
		cpu.getRegisterPSW().setFlag(PSWRegister.SUBTRACT_FLAG, false);
	}
	
	public void res(int bit, String register) {
		this.setRegister(register, this.getRegister(register) & ~(1 << bit));
	}

	public void set(int bit, String register) {
		this.setRegister(register, this.getRegister(register) | (1 << bit));
	}
	
	public int getRegister(String register) {
		int lsb = 0, msb = 0;
		switch (register) {
			case "A": return cpu.getRegisterPSW().getRegisterA();
			case "F": return cpu.getRegisterPSW().getStatusFlags();
			case "B": return cpu.getRegisterBC().getRegister1();
			case "C": return cpu.getRegisterBC().getRegister2();
			case "D": return cpu.getRegisterDE().getRegister1();
			case "E": return cpu.getRegisterDE().getRegister2();
			case "H": return cpu.getRegisterHL().getRegister1();
			case "L": return cpu.getRegisterHL().getRegister2();
			case "AF": return cpu.getRegisterPSW().getRegister();
			case "BC": return cpu.getRegisterBC().getRegister();
			case "DE": return cpu.getRegisterDE().getRegister();
			case "HL": return cpu.getRegisterHL().getRegister();
			case "SP": return cpu.getStackPointer();
			case "(BC)": return cpu.getMemory().read(cpu.getRegisterBC().getRegister());
			case "(DE)": return cpu.getMemory().read(cpu.getRegisterDE().getRegister());
			case "(HL)": return cpu.getMemory().read(cpu.getRegisterHL().getRegister());
			case "(nn)": lsb = cpu.getNext(); msb = cpu.getNext(); return cpu.getMemory().read(Utils.covert8to16(lsb, msb));
			case "n": return cpu.getNext();
			case "nn": lsb = cpu.getNext(); msb = cpu.getNext(); return Utils.covert8to16(lsb, msb);
		}
		return -1;
	}
	
	public void setRegister(String register, int data) {
		switch (register) {
			case "A": cpu.getRegisterPSW().setRegisterA(data); break;
			case "F": cpu.getRegisterPSW().setStatusFlags(data); break;
			case "B": cpu.getRegisterBC().setRegister1(data); break;
			case "C": cpu.getRegisterBC().setRegister2(data); break;
			case "D": cpu.getRegisterDE().setRegister1(data); break;
			case "E": cpu.getRegisterDE().setRegister2(data); break;
			case "H": cpu.getRegisterHL().setRegister1(data); break;
			case "L": cpu.getRegisterHL().setRegister2(data); break;
			case "AF": cpu.getRegisterPSW().setRegister(data); break;
			case "BC": cpu.getRegisterBC().setRegister(data); break;
			case "DE": cpu.getRegisterDE().setRegister(data); break;
			case "HL": cpu.getRegisterHL().setRegister(data); break;
			case "SP": cpu.setStackPointer(data); break;
			case "(BC)": cpu.getMemory().write(cpu.getRegisterBC().getRegister(), data); break;
			case "(DE)": cpu.getMemory().write(cpu.getRegisterDE().getRegister(), data); break;
			case "(HL)": cpu.getMemory().write(cpu.getRegisterHL().getRegister(), data); break;
			case "(nn)": int lsb = cpu.getNext(); int msb = cpu.getNext(); cpu.getMemory().write(Utils.covert8to16(lsb, msb), data); break;
		}
	}
}