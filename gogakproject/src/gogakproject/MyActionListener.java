package gogakproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	private Aireview a;
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		switch(cmd) {
		case "검색":
			System.out.println("검색중");
			break;
		case "화면 전환":
			a.change();
			break;
		}
	}
	
	public MyActionListener(Aireview a) {
		super();
		this.a = a;
	}
}
