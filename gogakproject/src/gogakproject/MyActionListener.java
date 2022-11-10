package gogakproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	private Aireview a;
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "화면 전환":
			a.change();
		}
	}
	public MyActionListener(Aireview a) {
		super();
		this.a = a;
	}
}
