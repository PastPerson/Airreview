package gogakproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.ListSelectionModel;

public class MainFrame extends JPanel{
	private Aireview a;
	private int Sortmode;
	private MyActionListener myac;
	private JTextField textField;
	private JButton btn_Search;
	private JList airport_list;
	private JScrollPane p;
	
	@Override
	public void paint(Graphics g) {
		p.setBounds(0,23,290,a.getHeight() - 60);
		textField.setBounds(290,3,a.getWidth()-370,20);
		if(textField.getWidth() < 0) {
			btn_Search.setBounds(290,3,60,20);
		}else {
			btn_Search.setBounds(textField.getX() + textField.getWidth(),3,60,20);
		}
		super.paint(g);
	}
	
	public MainFrame(Aireview a,MyActionListener ac) {
		
		this.a = a;
		setLayout(null);
		this.myac = ac;
		String [] Sort_List = {"가나다","글자 길이순","그외 등등"};
		String [] Search_List = {"영문공항명","한글공항명","그외 등등"};
		
		JLabel text = new JLabel("정렬");
		text.setBounds(0,3,50,20);
		add(text);
		
		JComboBox Box_Sort = new JComboBox(Sort_List);
		Box_Sort.setBounds(30,3,100,20);
		add(Box_Sort);
		
		JLabel text2 = new  JLabel("검색 조건");
		text2.setBounds(130,3,70,20);
		add(text2);
		
		JComboBox btn_SearchCondition = new JComboBox(Search_List);
		btn_SearchCondition.setBounds(190,3,100,20);
		add(btn_SearchCondition);
		
		textField = new JTextField();
		textField.setBounds(290,3,a.getWidth()-300,20);
		textField.setColumns(10);
		add(textField);
		
		btn_Search = new JButton("검색");
		btn_Search.setBounds(textField.getX() + textField.getWidth(),3,60,20);
		add(btn_Search);
		
		try {
			airport_list = new JList(a.getdb().getData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		airport_list.setBounds(0,23,290,a.getHeight() - 23);
		airport_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		p = new JScrollPane(airport_list);
		p.setBounds(0,23,290,a.getHeight() - 60);
		p.setViewportView(airport_list);
		add(p);
		//add(airport_list);
	}
}