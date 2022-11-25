package gogakproject;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ViewFrame extends JPanel{
	private Aireview a;
	private MyActionListener myac;
	public ViewFrame(Aireview a, MyActionListener ac) {
		this.a = a;
		setLayout(null);
		this.myac = ac;
		JButton btn1 = new JButton("화면 전환");
		btn1.setSize(100,29);
		btn1.setLocation(1050,690);
		add(btn1);
		btn1.addActionListener(myac);
		
		JButton btnNewButton = new JButton("베스트 10");
		btnNewButton.setSize(100,25);
		btnNewButton.setLocation(80,230);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("워스트 10");
		btnNewButton_1.setSize(100,25);
		btnNewButton_1.setLocation(80,280);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("대륙별 인기순위");
		btnNewButton_2.setSize(140,25);
		btnNewButton_2.setLocation(60,330);
		add(btnNewButton_2);
		add(btnNewButton_1);
		
		JLabel graph_screen = new JLabel("Graph_Screen");
		graph_screen.setSize(100, 20);
		graph_screen.setLocation(320, 90);
		add(graph_screen);
		
		JDesktopPane desktopPane = new JDesktopPane();
		add(desktopPane);
		
		JLabel Rank = new JLabel("*순위 조건*");
		Rank.setSize(100,20);
		Rank.setLocation(83,145);
		Rank.setFont(new Font("Serif", Font.BOLD, 21));
		Rank.setFont(getFont().deriveFont(20.0f));
		add(Rank);
		
		JLabel screen = new JLabel("Air-Review");
		screen.setSize(150, 40);
		screen.setLocation(650, 50);
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		screen.setFont(getFont().deriveFont(20.0f));
		add(screen);
		screen.setForeground(Color.BLACK); //글씨 색
	}
		  //도형 및 선 제작
		  public void paintComponent(Graphics g) {
			   super.paintComponent(g);
			   //색 정하기
			   g.setColor(Color.BLACK);
			   //둥근 사각형 제작
			   g.drawRoundRect(30, 110, 200, 500, 20, 20);
			   //직선 제작
			   g.drawLine(30, 200, 230, 200);
			   //둥근 사각형 제작
			   g.drawRoundRect(320, 110, 700, 500, 20, 20);

	}
		
	}
