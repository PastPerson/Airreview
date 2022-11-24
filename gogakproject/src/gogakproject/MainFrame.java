package gogakproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;

public class MainFrame extends JPanel{
	
	private Aireview a;
	private int Sortmode;
	private MyActionListener myac;
	private JComboBox Box_Sort;
	private JComboBox btn_SearchCondition;
	private JLabel B_Sort;
	private JLabel S_Sort;
	private JTextField textField;
	private JButton btn_Search;
	private JButton btn_ChangeWindow;
	private JTree airportTree;
	
	public MainFrame(Aireview a,MyActionListener ac) {
		this.a = a;
		setLayout(null);
		this.myac = ac;
		String [] Sort_List = {"가나다","글자 길이순","그외 등등"};
		String [] Search_List = {"영문공항명","한글공항명","그외 등등"};
		
		Box_Sort = new JComboBox(Sort_List);
		Box_Sort.setBounds(80, 110,100,20);
		
		B_Sort = new JLabel("정렬");
		B_Sort.setBounds(20, 110,100,20);
		add(B_Sort);
		add(Box_Sort);
		
		btn_SearchCondition = new JComboBox(Search_List);
		btn_SearchCondition.setBounds(80, 130,100,20);
		
		S_Sort = new JLabel("검색 조건");
		S_Sort.setBounds(20, 130,100,20);
		add(S_Sort);
		add(btn_SearchCondition);
		
		textField = new JTextField();
		textField.setBounds(250, 45,600,20);
		textField.setColumns(10);		
		add(textField);
		
		btn_Search = new JButton("검색");
		btn_Search.setBounds(865,45,70,20);
		add(btn_Search);
		
		airportTree = new JTree();
		airportTree.setBounds(10,160,200,500);

		btn_ChangeWindow = new JButton("화면 전환");
		btn_ChangeWindow.setBounds(900,650,100,30);
		add(btn_ChangeWindow);
		btn_ChangeWindow.addActionListener(this.myac);
	}
	
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   g.setColor(Color.BLACK);
		   g.drawRoundRect(210, 30, 800, 50, 20, 20);
		   g.drawRoundRect(10, 100, 200, 600, 20, 20);
		   g.drawLine(10, 160, 210, 160);
	}
	
}
