import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class ChatFrame extends JFrame {
	private JScrollPane outputScrollPane;
	private JScrollPane inputScrollPane;
	private JTextArea chatOutput;
	private JTextField chatInput;
	private JButton sendButton;
	
	private void moveCursorToEnd(JTextComponent textComponent) {
		textComponent.setCaretPosition(textComponent.getDocument().getLength());
	}
	
	private void submitInput() {
		chatOutput.append(chatInput.getText() + "\n");
		moveCursorToEnd(chatOutput);
		chatInput.setText("");
		chatInput.requestFocus();
	}
			
	public ChatFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(350, 600));
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(325, 550));
		
		chatOutput = new JTextArea();
		
		outputScrollPane = new JScrollPane(chatOutput);
		//scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		outputScrollPane.setPreferredSize(new Dimension(300, 300));
		
		chatInput = new JTextField();
		chatInput.addKeyListener(new KeyAdapter() {
			/*@Override
			public void keyPressed(KeyEvent event) {
				int keyCode = event.getKeyCode();
				// TODO: Figure out how to detect Ctrl+Enter
				switch (keyCode) {
				case KeyEvent.VK_ENTER: (chatInput).append();
				//						break;
				//case KeyEvent.
				}
			}*/
		});
		
		inputScrollPane = new JScrollPane(chatInput);
		inputScrollPane.setPreferredSize(new Dimension(300, 60));
		
		sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				submitInput();
			}
		});
		panel.add(outputScrollPane);
		panel.add(inputScrollPane);
		panel.add(sendButton);
		
		add(panel);
		
		setVisible(true);
		chatInput.requestFocus();
	}
	
	public void output(String output) {
		chatOutput.append(output + "\n");
		moveCursorToEnd(chatOutput);
		chatInput.requestFocus();
		moveCursorToEnd(chatInput);
	}
}
