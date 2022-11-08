package gogakproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gogakproject.MainFrame.MyActionListener;

public class MainFrame extends JPanel{
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	private JScrollPane jScrollPane1;
	private JTextField textField;
	private JTextArea textArea;
	private Aireview a;
	
	public MainFrame(Aireview a) {
		this.a = a;
		setLayout(null);
		
		btn1 = new JButton("정렬");
		btn1.setSize(70,20);
		btn1.setLocation(10,10);
		add(btn1);
		
		btn2 = new JButton("검색 조건");
		btn2.setSize(70,20);
		btn2.setLocation(90,10);
		add(btn2);
		
		btn3 = new JButton("검색");
		btn3.setSize(70,20);
		btn3.setLocation(680,10);
		add(btn3);
		
		btn4 = new JButton("화면 전환");
		btn4.setSize(100,20);
		btn4.setLocation(680,630);
		add(btn4);
		
		textField = new JTextField();
		textField.setBounds(170, 10,500,20);
		add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		
		jScrollPane1 = new JScrollPane(textArea);
		jScrollPane1.setSize(100,600);
		jScrollPane1.setLocation(30,50);
		add(jScrollPane1);
			
		btn4.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			a.change("ViewFrame");
		}
		
	}
}