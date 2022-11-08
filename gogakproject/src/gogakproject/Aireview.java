package gogakproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Aireview extends JFrame {
	
	public MainFrame mainframe = null;
	public ViewFrame viewframe = null;
	
	public void change(String name) {
		if(name.equals("MainFrame")) {
			getContentPane().removeAll();
			getContentPane().add(mainframe);
			revalidate();
			repaint();
		}else if(name.equals("ViewFrame")){
			getContentPane().removeAll();
			getContentPane().add(viewframe);
			revalidate();
			repaint();
		}
	}
	
	public Aireview() {
		super("에어리뷰");
		
		this.mainframe = new MainFrame(this);
		this.viewframe = new ViewFrame(this);
		this.add(this.mainframe);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Aireview();
	}
}
