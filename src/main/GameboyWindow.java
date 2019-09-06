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
	}
	
	public void update() {		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, window.getWidth(), window.getHeight());
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Monospaced", Font.PLAIN, 25));
		graphics.drawString("Register A: 0x" + Utils.toHex(gameboy.cpu.getRegisterPSW().getRegisterA()), 100, 100);
		graphics.drawString("Register F: 0b" + Utils.toBinary(gameboy.cpu.getRegisterPSW().getStatusFlags()), 100, 130);
		graphics.drawString("Register B: 0x" + Utils.toHex(gameboy.cpu.getRegisterBC().getRegister1()), 100, 160);
		graphics.drawString("Register C: 0x" + Utils.toHex(gameboy.cpu.getRegisterBC().getRegister2()), 100, 190);
		graphics.drawString("Register D: 0x" + Utils.toHex(gameboy.cpu.getRegisterDE().getRegister1()), 100, 220);
		graphics.drawString("Register E: 0x" + Utils.toHex(gameboy.cpu.getRegisterDE().getRegister2()), 100, 250);
		graphics.drawString("Register H: 0x" + Utils.toHex(gameboy.cpu.getRegisterHL().getRegister1()), 100, 280);
		graphics.drawString("Register L: 0x" + Utils.toHex(gameboy.cpu.getRegisterHL().getRegister2()), 100, 310);
		
		graphics.drawString("Register BC: 0x" + Utils.toHex(gameboy.cpu.getRegisterBC().getRegister()), 350, 160);
		graphics.drawString("Register DE: 0x" + Utils.toHex(gameboy.cpu.getRegisterDE().getRegister()), 350, 220);
		graphics.drawString("Register HL: 0x" + Utils.toHex(gameboy.cpu.getRegisterHL().getRegister()), 350, 280);
		
		graphics.drawString("Program Counter: 0x" + Utils.toHex(gameboy.cpu.getProgramCounter()), 100, 350);
		graphics.drawString("Stack Pointer: 0x" + Utils.toHex(gameboy.cpu.getStackPointer()), 100, 380);
		
		graphics.drawString("Current Opcode: 0x" + Utils.toHex(gameboy.cpu.getMemory().read(gameboy.cpu.getProgramCounter())) + " - " + gameboy.cpu.disassemble(), 550, 100);
		
		window.getGraphics().drawImage(windowBuffer, 0, 0, window);
	}
	
	public boolean getKey(int key) {
		return keys[key];
	}
}