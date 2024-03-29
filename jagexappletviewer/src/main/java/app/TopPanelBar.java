package app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/g")
public final class TopPanelBar extends Canvas implements MouseListener, MouseMotionListener {

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "b", descriptor = "[I")
	private int[] anIntArray2 = null;

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "c", descriptor = "I")
	private int anInt5 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "e", descriptor = "I")
	private int anInt7 = -1;

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "d", descriptor = "I")
	private int anInt6 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "f", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray2 = new String[10];

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "a", descriptor = "Ljava/awt/event/ActionListener;")
	private ActionListener listener;

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "<init>", descriptor = "(Ljava/awt/event/ActionListener;)V")
	public TopPanelBar(@OriginalArg(0) ActionListener listener) {
		this.listener = listener;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseReleased(@OriginalArg(0) MouseEvent e) {
		this.anInt6 = e.getX();
		// e.getY();

		@Pc(11) int local11 = this.anInt7;
		if (this.anIntArray2 == null) {
			return;
		}

		this.anInt7 = -1;
		for (@Pc(20) int local20 = 0; local20 < this.anIntArray2.length - 1; local20++) {
			if (this.anIntArray2[local20] <= this.anInt6 && this.anInt6 + 10 < this.anIntArray2[local20 + 1]) {
				this.anInt7 = local20;
				break;
			}
		}

		if (local11 != this.anInt7) {
			this.repaint();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mousePressed(@OriginalArg(0) MouseEvent e) {
		this.anInt6 = e.getX();
		// e.getY();

		@Pc(11) int local11 = this.anInt7;
		if (this.anIntArray2 == null) {
			return;
		}

		this.anInt7 = -1;
		for (@Pc(19) int local19 = 0; local19 < this.anIntArray2.length - 1; local19++) {
			if (this.anIntArray2[local19] <= this.anInt6 && this.anInt6 + 10 < this.anIntArray2[local19 + 1]) {
				this.anInt7 = -1;
				this.anInt6 = 0;
				this.repaint();
				this.listener.actionPerformed(new ActionEvent(this, local19, ""));
				break;
			}
		}

		if (this.anInt7 != local11) {
			this.repaint();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics g) {
		@Pc(4) int width = this.getWidth();
		@Pc(7) int height = this.getHeight();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setFont(this.getFont());

		@Pc(23) FontMetrics metrics = g.getFontMetrics();
		@Pc(25) int local25 = 10;
		@Pc(35) int local35 = metrics.getAscent() + (height - metrics.getHeight()) / 2;

		if (this.anIntArray2 == null || this.anInt5 + 1 != this.anIntArray2.length) {
			this.anIntArray2 = new int[this.anInt5 + 1];
		}

		for (@Pc(59) int i = 0; i < this.anInt5; i++) {
			@Pc(69) int local69 = local25;
			this.anIntArray2[i] = local25;
			local25 += metrics.stringWidth(this.aStringArray2[i]);

			if (this.anInt6 >= local69 && local25 > this.anInt6) {
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(this.getForeground());
			}
			g.drawString(this.aStringArray2[i], local69, local35);
			local25 += 10;
		}

		this.anIntArray2[this.anInt5] = local25;
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseExited(@OriginalArg(0) MouseEvent e) {
		this.anInt6 = 0;
		this.anInt7 = -1;
		this.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseMoved(@OriginalArg(0) MouseEvent e) {
		this.anInt6 = e.getX();
		// e.getY();

		@Pc(11) int local11 = this.anInt7;
		if (this.anIntArray2 == null) {
			return;
		}

		this.anInt7 = -1;
		for (@Pc(19) int local19 = 0; local19 < this.anIntArray2.length - 1; local19++) {
			if (this.anInt6 >= this.anIntArray2[local19] && this.anInt6 + 10 < this.anIntArray2[local19 + 1]) {
				this.anInt7 = local19;
				break;
			}
		}

		if (this.anInt7 != local11) {
			this.repaint();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseClicked(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseEntered(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics g) {
		this.paint(g);
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "a", descriptor = "(BLjava/lang/String;)V")
	public void method35(@OriginalArg(1) String arg1) {
		if (this.aStringArray2.length <= this.anInt5) {
			@Pc(17) String[] local17 = new String[this.aStringArray2.length + 5];
			System.arraycopy(this.aStringArray2, 0, local17, 0, this.aStringArray2.length);
			this.aStringArray2 = local17;
		}

		this.aStringArray2[this.anInt5++] = arg1;
	}

	@OriginalMember(owner = "jagexappletviewer!app/g", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseDragged(@OriginalArg(0) MouseEvent e) {
		this.anInt6 = e.getX();
		// e.getY();

		@Pc(11) int local11 = this.anInt7;
		if (this.anIntArray2 == null) {
			return;
		}

		this.anInt7 = -1;
		for (@Pc(20) int local20 = 0; local20 < this.anIntArray2.length - 1; local20++) {
			if (this.anIntArray2[local20] <= this.anInt6 && this.anInt6 + 10 < this.anIntArray2[local20 + 1]) {
				this.anInt7 = local20;
				break;
			}
		}

		if (local11 != this.anInt7) {
			this.repaint();
		}
	}
}
