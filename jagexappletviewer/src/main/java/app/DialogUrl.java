package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class DialogUrl extends WindowAdapter implements ActionListener {
	private Dialog a;

	public final void actionPerformed(ActionEvent var1) {
		this.a.setVisible(false);
	}

	DialogUrl(String var1) {
		super();
		boolean var5 = Preferences.dialogVisible;
		this.a = new Dialog(appletviewer.frame, appletviewer.getLocalization(1555, "information"), true);
		TextArea var2 = new TextArea();
		var2.setText(appletviewer.getLocalization(1555, "copy_paste_url") + ":\n" + var1);
		var2.setEditable(false);
		this.a.add(var2);
		Button var3 = new Button(appletviewer.getLocalization(1555, "ok"));
		var3.addActionListener(this);
		DialogPanel panel = new DialogPanel();
		panel.setLayout(new FlowLayout(1));
		panel.add(var3);
		this.a.addWindowListener(this);
		this.a.add(panel, "South");
		this.a.setResizable(false);
		this.a.setSize(400, 150);
		this.a.setLocationRelativeTo(appletviewer.frame);
		this.a.setVisible(true);
		if (appletviewer.A) {
			Preferences.dialogVisible = !var5;
		}

	}

	public final void windowClosing(WindowEvent var1) {
		this.a.setVisible(false);
	}
}
