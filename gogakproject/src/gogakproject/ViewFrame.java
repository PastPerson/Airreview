package gogakproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewFrame extends JPanel{
	private Aireview a;
	private MyActionListener myac;
	public ViewFrame(Aireview a, MyActionListener ac) {
		this.a = a;
		setLayout(null);
		this.myac = ac;
		
	}
}