package gogakproject;

import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class MainFrame extends JPanel{
	private Aireview a;
	private int Sortmode;
	private MyActionListener myac;	
	
	public MainFrame(Aireview a,MyActionListener ac) {
		
		this.a = a;
		setLayout(null);
		this.myac = ac;
		String [] Sort_List = {"가나다","글자 길이순","그외 등등"};
		String [] Search_List = {"영문공항명","한글공항명","코드1","코드2","지역","나라명(영어)","나라명(한글)","도시명"};
		
		MyDatabase md = new MyDatabase();
		
		ArrayList<String> loc = md.getLocData();
		//ArrayList<String> country0 = md.getCountryData(loc.get(0));
		
		
		System.out.println(a.getSize());
		
		JComboBox Box_Sort = new JComboBox(Sort_List);
		Box_Sort.setSize(100,20);
		Box_Sort.setLocation(390, 130);
		
		JTree tree = new JTree();
		tree.setSize(170, 800);
		tree.setBackground(null);
		tree.setLocation(50, 90);
		tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("지역") {
					{
						DefaultMutableTreeNode category;

						category = new DefaultMutableTreeNode(loc.get(0));
						for(int i=0;i <md.getCountryData(loc.get(0)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(0)).get(i)));
						}
						add(category);
						
						category = new DefaultMutableTreeNode(loc.get(1));


						for(int i=0;i <md.getCountryData(loc.get(1)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(1)).get(i)));
						}
						add(category);
					
						category = new DefaultMutableTreeNode(loc.get(2));
						for(int i=0;i <md.getCountryData(loc.get(2)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(2)).get(i)));
						}
						add(category);

						category = new DefaultMutableTreeNode(loc.get(3));
						for(int i=0;i <md.getCountryData(loc.get(3)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(3)).get(i)));
						}
						add(category);

						category = new DefaultMutableTreeNode(loc.get(4));
						for(int i=0;i <md.getCountryData(loc.get(4)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(4)).get(i)));
						}
						add(category);
						category = new DefaultMutableTreeNode(loc.get(5));
						for(int i=0;i <md.getCountryData(loc.get(5)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(5)).get(i)));
						}
						add(category);

						category = new DefaultMutableTreeNode(loc.get(6));
						for(int i=0;i <md.getCountryData(loc.get(6)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(6)).get(i)));
						}
						add(category);

						category = new DefaultMutableTreeNode(loc.get(7));
						for(int i=0;i <md.getCountryData(loc.get(7)).size(); i++) {
							category.add(new DefaultMutableTreeNode(md.getCountryData(loc.get(7)).get(i)));
						}
						add(category);
					}
				}
			));
		add(tree);
		
		JLabel B_Sort = new JLabel("정렬");
		B_Sort.setSize(100, 20);
		B_Sort.setLocation(350, 130);
		add(B_Sort);
		add(Box_Sort);
		
		JLabel search = new JLabel("Search");
		search.setSize(100, 20);
		search.setLocation(250, 60);
		add(search);
		
		JLabel list = new JLabel("지역");
		list.setSize(100, 20);
		list.setLocation(40, 60);
		add(list);
		
		JLabel screen = new JLabel("Screen");
		screen.setSize(100, 20);
		screen.setLocation(250, 180);
		add(screen);
		
		JComboBox btn_SearchCondition = new JComboBox(Search_List);
		btn_SearchCondition.setSize(100,20);
		btn_SearchCondition.setLocation(560, 130);
		
		JLabel S_Sort = new JLabel("검색 조건");
		S_Sort.setSize(100, 20);
		S_Sort.setLocation(500, 130);
		add(S_Sort);
		add(btn_SearchCondition);
		
		JTextField textField = new JTextField();
		textField.setSize(a.getWidth() - 800,20);
		textField.setLocation(270, 100);
		textField.setColumns(10);
		textField.setOpaque(true);
		textField.setBackground(Color.white);
		textField.setForeground(Color.black);
		add(textField);
		
		JButton btn_Search = new JButton("검색");
		btn_Search.setSize(70,20);
		btn_Search.setLocation(1005,100);
		add(btn_Search);
		btn_Search.addActionListener(this.myac);
		
		JButton btn_ChangeWindow = new JButton("화면 전환");
		btn_ChangeWindow.setSize(100,29);
		btn_ChangeWindow.setLocation(1300,890);
		add(btn_ChangeWindow);
		btn_ChangeWindow.addActionListener(this.myac);
		
		
		
		

	}
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);

		   g.setColor(Color.BLACK);
		   g.drawRoundRect(260, 80, 1000, 100, 20, 20);
		   g.drawRoundRect(40, 80, 180, 850, 20, 20);
		   g.drawRoundRect(260, 200, 1000, 730, 20, 20);

}
}
