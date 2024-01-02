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

final class TopPanelBar extends Canvas implements MouseListener, MouseMotionListener {
	private ActionListener listener;
	private int[] b = null;
	private int c = 0;
	private int x = 0;
	private int y = 0;
	private int e = -1;
	private String[] f = new String[10];

	public final void mouseReleased(MouseEvent event) {
		boolean var4 = Preferences.dialogVisible;
		this.x = event.getX();
		this.y = event.getY();
		int var2 = this.e;

		if (this.b != null) {
			this.e = -1;
			int var3 = 0;

			while (var3 < -1 + this.b.length) {
				if (this.b[var3] <= this.x && ~(this.x - -10) > ~this.b[1 + var3]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~var2 != ~this.e) {
				this.repaint();
			}
		}
	}

	public final void mousePressed(MouseEvent event) {
		boolean var4 = Preferences.dialogVisible;
		this.x = event.getX();
		this.y = event.getY();
		int var2 = this.e;

		if (this.b != null) {
			this.e = -1;
			int var3 = 0;

			while (-1 + this.b.length > var3) {
				if (this.b[var3] <= this.x && ~(10 + this.x) > ~this.b[var3 + 1]) {
					this.e = -1;
					this.x = 0;
					this.repaint();
					this.listener.actionPerformed(new ActionEvent(this, var3, ""));
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~this.e != ~var2) {
				this.repaint();
			}
		}

	}

	public final void paint(Graphics g) {
		boolean var9 = Preferences.dialogVisible;
		int var2 = this.getWidth();
		int var3 = this.getHeight();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, var2, var3);
		g.setFont(this.getFont());
		FontMetrics metrics = g.getFontMetrics();
		int var5 = 10;
		int var6 = metrics.getAscent() + (var3 - metrics.getHeight()) / 2;
		if (this.b == null || ~(1 + this.c) != ~this.b.length) {
			this.b = new int[this.c + 1];
		}

		int var7 = 0;

		while (~this.c < ~var7) {
			int var8;
			label37:
			{
				var8 = var5;
				this.b[var7] = var5;
				var5 += metrics.stringWidth(this.f[var7]);
				if (~this.x > ~var8 || var5 <= this.x) {
					g.setColor(this.getForeground());
					if (!var9) {
						break label37;
					}
				}

				g.setColor(Color.YELLOW);
			}

			g.drawString(this.f[var7], var8, var6);
			var5 += 10;
			++var7;
			if (var9) {
				break;
			}
		}

		this.b[this.c] = var5;
	}

	public final void mouseExited(MouseEvent event) {
		this.x = 0;
		this.e = -1;
		this.repaint();
	}

	public final void mouseMoved(MouseEvent event) {
		boolean var4 = Preferences.dialogVisible;
		this.x = event.getX();
		this.y = event.getY();
		int var2 = this.e;

		if (this.b != null) {
			this.e = -1;
			int var3 = 0;

			while (var3 < -1 + this.b.length) {
				if (~this.x <= ~this.b[var3] && 10 + this.x < this.b[1 + var3]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~this.e != ~var2) {
				this.repaint();
			}
		}

	}

	public final void mouseClicked(MouseEvent event) {
	}

	public final void mouseEntered(MouseEvent event) {
	}

	public final void update(Graphics g) {
		this.paint(g);
	}

	final void a(byte var1, String var2) {
		if (~this.f.length >= ~this.c) {
			String[] var3 = new String[this.f.length - -5];
			System.arraycopy(this.f, 0, var3, 0, this.f.length);
			this.f = var3;
		}

		this.f[this.c++] = var2;
		if (var1 >= -75) {
			this.e = 122;
		}

	}

	public final void mouseDragged(MouseEvent event) {
		boolean var4 = Preferences.dialogVisible;
		this.x = event.getX();
		this.y = event.getY();
		int var2 = this.e;

		if (null != this.b) {
			this.e = -1;
			int var3 = 0;

			while (~var3 > ~(this.b.length + -1)) {
				if (this.b[var3] <= this.x && ~(10 + this.x) > ~this.b[var3 + 1]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~var2 != ~this.e) {
				this.repaint();
			}
		}

	}

	TopPanelBar(ActionListener listener) {
		this.listener = listener;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
}