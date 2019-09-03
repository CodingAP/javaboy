package main;

import java.util.Scanner;

import emulation.Gameboy;

public class Main {
	public static Gameboy emulator = new Gameboy();
	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		emulator.run();
	}
	
	public static void getCommand() {
		System.out.print("What do you need to do?: ");
		String command = sc.next();
		if (command == "c") {
		
		} else {
			
			getCommand();
		}
	}
}