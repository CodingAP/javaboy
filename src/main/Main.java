package main;

import java.awt.event.KeyEvent;

import emulation.Gameboy;

public class Main {
	public static Gameboy emulator = new Gameboy();
	public static GameboyWindow window = new GameboyWindow(emulator);
	public static boolean isPressed = false;
	
	
	public static void main(String[] args) {
		while (true) {
			window.update();
			if (window.getKey(KeyEvent.VK_SPACE) && !isPressed) {
				emulator.run();
				isPressed = true;
			}
			if (window.getKey(KeyEvent.VK_W)) emulator.run();
			if (window.getKey(KeyEvent.VK_S) && !isPressed) {
				for (int i = 0; i < 100; i++) emulator.run();
				isPressed = true;
			}
			isPressed = window.getKey(KeyEvent.VK_SPACE) || window.getKey(KeyEvent.VK_SPACE);
		}
	}
}