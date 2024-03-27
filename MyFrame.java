package assignment9;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		setTitle("TO BE DECLARED");
		setSize(700, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	private void init() {
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		MainPanel mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setVisible(true);
	}
}
