package gogakproject;

import java.sql.*;
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
		String [] Search_List = {"영문공항명","한글공항명","그외 등등"};
		
		System.out.println(a.getSize());
		
		JComboBox Box_Sort = new JComboBox(Sort_List);
		Box_Sort.setSize(100,20);
		Box_Sort.setLocation(390, 130);
		
		JTree tree = new JTree();
		tree.setSize(100, 600);
		tree.setBackground(null);
		tree.setLocation(50, 90);
		tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("카테고리") {
					{
						DefaultMutableTreeNode category;
						category = new DefaultMutableTreeNode("Tree1");
						category.add(new DefaultMutableTreeNode(""));
						add(category);
						
						category = new DefaultMutableTreeNode("Tree2");
						category.add(new DefaultMutableTreeNode(""));
						add(category);
						
						category = new DefaultMutableTreeNode("Tree3");
						category.add(new DefaultMutableTreeNode(""));
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
		search.setLocation(220, 60);
		add(search);
		
		JLabel list = new JLabel("Category");
		list.setSize(100, 20);
		list.setLocation(40, 60);
		add(list);
		
		JLabel screen = new JLabel("Screen");
		screen.setSize(100, 20);
		screen.setLocation(220, 180);
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
		textField.setSize(a.getWidth() - 600,20);
		textField.setLocation(250, 100);
		textField.setColumns(10);
		textField.setOpaque(true);
		textField.setBackground(Color.white);
		textField.setForeground(Color.black);
		add(textField);
		
		JButton btn_Search = new JButton("검색");
		btn_Search.setSize(70,20);
		btn_Search.setLocation(865,100);
		add(btn_Search);
		
		JButton btn_ChangeWindow = new JButton("화면 전환");
		btn_ChangeWindow.setSize(100,29);
		btn_ChangeWindow.setLocation(1050,690);
		add(btn_ChangeWindow);
		btn_ChangeWindow.addActionListener(this.myac);
		

	}
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);

		   g.setColor(Color.BLACK);
		   g.drawRoundRect(220, 80, 800, 100, 20, 20);
		   g.drawRoundRect(40, 80, 150, 650, 20, 20);
		   g.drawRoundRect(220, 200, 800, 530, 20, 20);

}
}
