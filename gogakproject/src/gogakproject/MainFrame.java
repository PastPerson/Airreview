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

public class MainFrame extends JPanel{
	private Aireview a;
	private int Sortmode;
	private MyActionListener myac;
	
	
	public MainFrame(Aireview a,MyActionListener ac) {
		
		this.a = a;
		setLayout(null);
		this.myac = ac;
		String [] Sort_List = {"가나다","글자 길이순","그외 등등"};
		String [] Search_List = {"영문공항명","한글공항명","그외 등등"};
		
		System.out.println(a.getSize());
		
		JPanel topMenu = new JPanel();
		topMenu.setLayout(new BoxLayout(topMenu,FlowLayout.LEFT));
		topMenu.setSize(a.getWidth(),20);
		topMenu.setLocation(0,0);
		
		JComboBox Box_Sort = new JComboBox(Sort_List);
		Box_Sort.setSize(100,20);
		
		topMenu.add(new JLabel("정렬"));
		topMenu.add(Box_Sort);
		
		JComboBox btn_SearchCondition = new JComboBox(Search_List);
		btn_SearchCondition.setSize(100,20);
		topMenu.add(new JLabel("검색 조건"));
		topMenu.add(btn_SearchCondition);
		
		JTextField textField = new JTextField();
		textField.setSize(a.getWidth() - 400,20);
		textField.setColumns(10);
		
		topMenu.add(textField);
		
		JButton btn_Search = new JButton("검색");
		btn_Search.setSize(70,20);
		btn_Search.setLocation(710,10);
		topMenu.add(btn_Search);
		
//		topMenu.setBackground(Color.white);
		this.add(topMenu);

		
		JButton btn_ChangeWindow = new JButton("화면 전환");
		btn_ChangeWindow.setSize(100,20);
		btn_ChangeWindow.setLocation(680,630);
		add(btn_ChangeWindow);
		btn_ChangeWindow.addActionListener(this.myac);
		
		
	}
}