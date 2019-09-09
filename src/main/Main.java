package main;

import emulation.Gameboy;

public class Main {
	public static Gameboy emulator = new Gameboy();
	public static GameboyWindow window = new GameboyWindow(emulator);
	
	public static void main(String[] args) {
		window.setMode(GameboyWindow.DIS_MODE);
		while (true) {
			window.update();
		}
	}
}