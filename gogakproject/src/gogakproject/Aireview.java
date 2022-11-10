package gogakproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Aireview extends JFrame {
	
	private MainFrame mainframe = null;
	private ViewFrame viewframe = null;
	private MyActionListener myac = null;
	
	private int windowMode;
	
	public void change() {
		if(this.windowMode == 0) {
			getContentPane().removeAll();
			getContentPane().add(viewframe);
			revalidate();
			repaint();
			this.windowMode = 1;
		}else if(this.windowMode == 1){
			getContentPane().removeAll();
			getContentPane().add(mainframe);
			revalidate();
			repaint();
			this.windowMode = 0;
		}
	}
	
	public Aireview() {
		super("에어리뷰");
//		System.out.println(this.getSize());
		this.setSize(1200,800);
		this.myac = new MyActionListener(this);
		this.mainframe = new MainFrame(this,myac);
		this.viewframe = new ViewFrame(this,myac);
		this.windowMode = 0;
		
		
		this.add(this.mainframe);
	}
	
	public static void main(String[] args) {
		JFrame fr = new Aireview();
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new MyDatabase();
	}
}
