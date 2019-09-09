package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import emulation.Gameboy;
import emulation.Utils;

public class GameboyWindow {
	private Gameboy gameboy;
	private JFrame window;
	private BufferedImage windowBuffer;
	private Graphics graphics;
	private boolean[] keys = new boolean[256];
	private boolean memPressed = false, disPressed = false, isPressed;
	private String mode = "";
	public static final String CPU_MODE = "cpu", DIS_MODE = "disassembler";
	private int startingPosition = 0x0000, disStarting = 0x0000, range = 34;
	private String[] programLines = new String[8192];
	
	public GameboyWindow(Gameboy gameboy) {
		this.gameboy = gameboy;
		
		window = new JFrame("Javaboy: Gameboy Emulator in Java");
		window.setSize(1280, 720);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		windowBuffer = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = windowBuffer.createGraphics();
		
		window.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				keys[e.getKeyCode()] = true;
			}

			@Override
			public void keyReleased(KeyEvent e) {
				keys[e.getKeyCode()] = false;
			}
		});
		
		int index = 0;
		while (index < programLines.length) {
			if (gameboy.cpu.getDisassembler().getCounter() > 64 * 1024) break;
			programLines[index++] = Utils.padHex(Utils.toHex(gameboy.cpu.getDisassembler().getCounter()), 4) + ": " + gameboy.cpu.getDisassembler().run(gameboy.mem.read(gameboy.cpu.getDisassembler().getCounter()));
		}
	}
	
	public void update() {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, window.getWidth(), window.getHeight());
		
		graphics.setColor(Color.BLACK);
		
		if (mode == CPU_MODE) {
			//Obsolete
		} else if (mode == DIS_MODE) {
			graphics.setFont(new Font("Monospaced", Font.PLAIN, 20));
			
			graphics.drawString("Register A: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterPSW().getRegisterA()), 2), 800, 100);
			graphics.drawString("Register F: 0b" + Utils.padHex(Utils.toBinary(gameboy.cpu.getRegisterPSW().getStatusFlags()), 8), 800, 120);
			graphics.drawString("Register B: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterBC().getRegister1()), 2), 800, 140);
			graphics.drawString("Register C: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterBC().getRegister2()), 2), 800, 160);
			graphics.drawString("Register D: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterDE().getRegister1()), 2), 800, 180);
			graphics.drawString("Register E: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterDE().getRegister2()), 2), 800, 200);
			graphics.drawString("Register H: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterHL().getRegister1()), 2), 800, 220);
			graphics.drawString("Register L: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterHL().getRegister2()), 2), 800, 240);
			
			graphics.drawString("Register BC: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterBC().getRegister()), 4), 1020, 150);
			graphics.drawString("Register DE: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterDE().getRegister()), 4), 1020, 190);
			graphics.drawString("Register HL: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getRegisterHL().getRegister()), 4), 1020, 230);
			
			graphics.drawString("Program Counter: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getProgramCounter()), 4), 800, 300);
			graphics.drawString("Stack Pointer: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getStackPointer()), 4), 800, 320);
			
			graphics.drawString("Current Opcode: 0x" + Utils.padHex(Utils.toHex(gameboy.cpu.getMemory().read(gameboy.cpu.getProgramCounter())), 2) + " - " + gameboy.cpu.disassemble(), 800, 400);
			
			for (int i = startingPosition; i < range + startingPosition; i++) {
				String line = Utils.padHex(Utils.toHex(i * 8), 4) + ": ";
				for (int j = 0; j < 8; j++) {
					line += Utils.padHex(Utils.toHex(gameboy.mem.read(i * 8 + j)), 2) + " ";
				}
				graphics.drawString(line, 10, 20 * (i - startingPosition) + 50);
			}
			
			if (keys[KeyEvent.VK_W] && !memPressed) {
				if (startingPosition != 0) startingPosition--;
				memPressed = true;
			} else if (keys[KeyEvent.VK_S] && !memPressed) {
				if (startingPosition != 8192 - range) startingPosition++;
				memPressed = true;
			}
			
			if (keys[KeyEvent.VK_A]) {
				if (startingPosition != 0) startingPosition--;
			} else if (keys[KeyEvent.VK_D] && !memPressed) {
				if (startingPosition != 8192 - range) startingPosition++;
			}
			
			memPressed = getKey(KeyEvent.VK_W) || getKey(KeyEvent.VK_S);
			
			for (int i = disStarting; i < range + disStarting; i++) {
				graphics.drawString(programLines[i], 400, 20 * (i - disStarting) + 50);
			}
			
			if (keys[KeyEvent.VK_UP] && !disPressed) {
				if (disStarting != 0) disStarting--;
				disPressed = true;
			} else if (keys[KeyEvent.VK_DOWN] && !disPressed) {
				if (disStarting != 8192 - range) disStarting++;
				disPressed = true;
			}
			
			if (keys[KeyEvent.VK_LEFT]) {
				if (disStarting != 0) disStarting--;
			} else if (keys[KeyEvent.VK_RIGHT]) {
				if (disStarting != 8192 - range) disStarting++;
			}
			
			disPressed = getKey(KeyEvent.VK_UP) || getKey(KeyEvent.VK_DOWN);
			
			if (getKey(KeyEvent.VK_SPACE) && !isPressed) {
				gameboy.run();
				isPressed = true;
			}
			if (getKey(KeyEvent.VK_Z)) gameboy.run();
			if (getKey(KeyEvent.VK_X) && !isPressed) {
				for (int i = 0; i < 100; i++) gameboy.run();
				isPressed = true;
			}
			isPressed = getKey(KeyEvent.VK_SPACE) || getKey(KeyEvent.VK_X);
		} else {
			graphics.drawString("No mode selected!", window.getWidth() / 2, window.getHeight() / 2);
		}
		
		window.getGraphics().drawImage(windowBuffer, 0, 0, window);
	}
	
	public void setMode(String newMode) {
		mode = newMode;
	}
	
	public boolean getKey(int key) {
		return keys[key];
	}
}