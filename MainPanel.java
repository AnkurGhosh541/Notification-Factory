package assignment9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends JPanel implements ActionListener {
	private JComboBox<String> cb;
	private JTextField tf;
	private JTextArea messageArea;
	private NotificationFactory notificationFactory;
	
	public MainPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		init();
		notificationFactory = new NotificationFactory();
	}

	private void init() {
		JPanel topPanel = new JPanel(new GridLayout(1, 3, 20, 10));
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		String[] list = new String[] {"SMS", "E-Mail", "Buzzer"};
		cb = new JComboBox<String>(list);
		
		GridBagConstraints c = new GridBagConstraints();
		JPanel p1 = new JPanel(new GridBagLayout());
		JLabel lb = new JLabel("To");
		tf = new JTextField();
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;
		p1.add(lb, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.4;
		p1.add(tf, c);
		
		JButton b = new JButton("Send");
		b.addActionListener(this);
		
		topPanel.add(cb);
		topPanel.add(p1);
		topPanel.add(b);
		
		JPanel messagePanel = new JPanel(new BorderLayout());
		messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JLabel lb2 = new JLabel("Message");
		messageArea = new JTextArea();
		messagePanel.add(lb2, BorderLayout.NORTH);
		messagePanel.add(messageArea, BorderLayout.CENTER);
		
		add(topPanel, BorderLayout.NORTH);
		add(messagePanel, BorderLayout.CENTER);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String type = cb.getItemAt(cb.getSelectedIndex());
		notificationFactory.sendNotification(type, tf.getText(), messageArea.getText());
	}

}
