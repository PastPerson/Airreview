package gogakproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gogakproject.ViewFrame.MyActionListener;

public class ViewFrame extends JPanel{
	private JButton btn1;
	private Aireview a;
	
	public ViewFrame(Aireview a) {
		this.a = a;
		setLayout(null);
		
		btn1 = new JButton("화면 전환");
		btn1.setSize(100,20);
		btn1.setLocation(680,630);
		add(btn1);
		btn1.addActionListener(new MyActionListener());
	}
	
/*	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		repaint();
	}*/
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			a.change("MainFrame");
		}
	}
}