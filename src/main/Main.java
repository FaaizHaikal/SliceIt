package main;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame("Slice It!");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.pack();
		window.setVisible(true);
	}
}
